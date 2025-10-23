/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.RegistrationDemo;

/**
 *
 * @author Kevin
 */

import com.mycompany.RegistrationDemo.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Node implements NodeInterface {

    private final int id;
    private final String host;
    private final int port;

    private final RegisterInterface register;       // optional seed provider (in-proc)
    private final List<Neighbor> seedPeers;         // optional static seeds

    private final ConcurrentMap<Integer, Neighbor> knownPeers = new ConcurrentHashMap<>();

    private volatile Neighbor self;
    private volatile Neighbor successor;            // currently used successor (channel target)
    private volatile Neighbor idealSuccessor;       // “by id” successor (target we pin to)

    // election state
    private final Object electLock = new Object();
    private volatile boolean inElection = false;
    private volatile int currentCandidate = -1;
    private volatile Integer leaderId = null;
    private volatile int lastCoordSeen = -1;

    // bootstrap state
    private final AtomicBoolean ringEstablished = new AtomicBoolean(false);
    private final AtomicBoolean tokenLaunched  = new AtomicBoolean(false);

    private final AtomicBoolean running = new AtomicBoolean(false);
    private Server server;

    private ManagedChannel succCh;
    private PeerServiceGrpc.PeerServiceBlockingStub succStub;

    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(3, r -> {
                Thread t = new Thread(r, "node-bg-" + UUID.randomUUID());
                t.setDaemon(true);
                return t;
            });

    // NEW: keep a handle so we can cancel fallback when we learn the leader
    private ScheduledFuture<?> fallbackFuture;

    public Node(int id, String host, int port, RegisterInterface register, List<Neighbor> seeds) {
        this.id = id;
        this.host = host;
        this.port = port;
        this.register = register;
        this.seedPeers = (seeds == null ? Collections.emptyList() : new ArrayList<>(seeds));
        this.self = Neighbor.newBuilder().setId(id).setHost(host).setPort(port).build();
        this.successor = self;       // until we stabilize
        this.idealSuccessor = self;

        knownPeers.put(id, self);
        if (register != null) register.list().forEach(n -> knownPeers.putIfAbsent(n.getId(), n));
        seedPeers.forEach(n -> knownPeers.putIfAbsent(n.getId(), n));
    }

    // ---------------- NodeInterface ----------------
    @Override public int getId() { return id; }
    @Override public Neighbor getSelf() { return self; }
    @Override public Neighbor getSuccessor() { return successor; }

    @Override
    public void setSuccessor(Neighbor n) {
        if (equalNeighbor(this.successor, n)) return;
        this.successor = n;
        rebuildSuccChannel();
        log("succ  -> %d", n.getId());
    }

    @Override
    public void start() throws Exception {
        server = ServerBuilder.forPort(port)
                .addService(new PeerServiceImpl())
                .build()
                .start();
        running.set(true);
        log("up    :: %d", port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log("shutdown hook -> closing channels");
            shutdown();
        }));

        recomputeIdealSuccessor();

        // periodic peer exchange from register/seeds/peers
        scheduler.scheduleWithFixedDelay(this::pullPex, 800, 1000, TimeUnit.MILLISECONDS);

        // stabilization: always pin to the ideal “by-id” successor (no random jumps)
        scheduler.scheduleWithFixedDelay(this::stabilize, 700, 700, TimeUnit.MILLISECONDS);

        // bootstrap token: only local-min id launches once successor is reachable
        scheduler.scheduleWithFixedDelay(this::maybeStartBootstrap, 1500, 800, TimeUnit.MILLISECONDS);

        // fallback: if ring not established and no leader known after N seconds, start election
        fallbackFuture = scheduler.schedule(this::fallbackElection, 12000, TimeUnit.MILLISECONDS);
    }

    @Override
    public void shutdown() {
        running.set(false);

        if (fallbackFuture != null) fallbackFuture.cancel(false);

        if (succCh != null) {
            try { succCh.shutdownNow().awaitTermination(150, TimeUnit.MILLISECONDS); } catch (InterruptedException ignored) {}
            succCh = null; succStub = null;
        }
        if (server != null) {
            try { server.shutdownNow().awaitTermination(150, TimeUnit.MILLISECONDS); } catch (InterruptedException ignored) {}
            server = null;
        }
        scheduler.shutdownNow();
    }

    // ---------------- Stabilization / PEX ----------------

    private void stabilize() {
        if (!running.get()) return;

        recomputeIdealSuccessor();
        Neighbor ideal = idealSuccessor;

        if (!equalNeighbor(successor, ideal)) {
            setSuccessor(ideal); // pin to ideal successor; never “jump” to arbitrary reachable peers
        }

        if (ideal.getId() == id) return; // single-node view

        // probe successor; keep it even if temporarily down
        if (!isReachable(ideal, 1200)) {
            log("WARN  successor %d unreachable; waiting (ideal)", ideal.getId());
        }
    }

    private void pullPex() {
        if (!running.get()) return;

        if (register != null) register.list().forEach(n -> knownPeers.putIfAbsent(n.getId(), n));
        seedPeers.forEach(n -> knownPeers.putIfAbsent(n.getId(), n));

        // ask a few peers for their lists
        List<Neighbor> snapshot = new ArrayList<>(knownPeers.values());
        for (int i = 0; i < Math.min(3, snapshot.size()); i++) {
            Neighbor peer = snapshot.get(i);
            if (peer.getId() == id) continue;
            try (TempChannel tc = TempChannel.connect(peer.getHost(), peer.getPort(), 1200)) {
                PeerServiceGrpc.PeerServiceBlockingStub stub = tc.stub();
                PeerListReply list = stub.peerList(Empty.newBuilder().build());
                for (Neighbor n : list.getPeersList()) knownPeers.putIfAbsent(n.getId(), n);
            } catch (Exception ignored) {}
        }
        recomputeIdealSuccessor();
    }

    private void maybeStartBootstrap() {
        if (!running.get() || ringEstablished.get() || tokenLaunched.get()) return;

        Neighbor s = successor;
        if (s.getId() == id) return;           // need at least someone else
        if (!isReachable(s, 1000)) return;     // wait until successor is reachable

        // only local-min id (among currently known) launches the token
        int min = knownPeers.keySet().stream().min(Integer::compareTo).orElse(id);
        if (id != min) return;

        if (tokenLaunched.compareAndSet(false, true)) {
            BootToken tok = BootToken.newBuilder()
                    .setOrigin(id)
                    .addVisited(id)
                    .build();
            log("BOOT  start token (origin=%d)", id);
            forwardBootstrap(tok);
        }
    }

    private void fallbackElection() {
        // GUARD: if ring is established OR we already know a leader, do nothing
        if (ringEstablished.get() || leaderId != null) return;
        log("BOOT  fallback -> start election");
        electionStart("bootstrap-timeout");
    }

    // ---------------- Ring math ----------------

    private void recomputeIdealSuccessor() {
        List<Neighbor> peers = new ArrayList<>(knownPeers.values());
        peers.sort(Comparator.comparingInt(Neighbor::getId));
        Neighbor next = null;
        for (Neighbor n : peers) if (n.getId() > id) { next = n; break; }
        if (next == null && peers.size() > 1) {
            for (Neighbor n : peers) { if (n.getId() != id) { next = n; break; } }
        }
        if (next == null) next = self;
        idealSuccessor = next;
    }

    private static boolean equalNeighbor(Neighbor a, Neighbor b) {
        if (a == b) return true;
        if (a == null || b == null) return false;
        return a.getId() == b.getId() &&
               Objects.equals(a.getHost(), b.getHost()) &&
               a.getPort() == b.getPort();
    }

    // ---------------- Elections ----------------

    private void electionStart(String reason) {
        // GUARD: if we already know the leader, ignore late starts
        if (leaderId != null) return;

        Neighbor s = successor;
        if (s.getId() == id) { // alone
            synchronized (electLock) { leaderId = id; inElection = false; }
            log("LEADER -> %d", id);
            return;
        }
        synchronized (electLock) {
            inElection = true;
            currentCandidate = id;
        }
        log("ELC   (%d) reason=%s", id, reason);
        forwardElection(id);
    }

    private void forwardElection(int candidate) {
        Neighbor s = successor;
        if (s.getId() == id) return;
        try {
            ensureSuccStub();
            succStub.election(ElectionMsg.newBuilder().setCandidateId(candidate).build());
        } catch (Exception e) {
            scheduler.schedule(() -> {
                try {
                    ensureSuccStub();
                    succStub.election(ElectionMsg.newBuilder().setCandidateId(candidate).build());
                } catch (Exception ignored) {}
            }, 400, TimeUnit.MILLISECONDS);
        }
    }

    private void forwardCoordinator(int leader) {
        Neighbor s = successor;
        if (s.getId() == id) return;
        try {
            ensureSuccStub();
            succStub.coordinator(CoordinatorMsg.newBuilder().setLeaderId(leader).build());
        } catch (Exception e) {
            scheduler.schedule(() -> {
                try {
                    ensureSuccStub();
                    succStub.coordinator(CoordinatorMsg.newBuilder().setLeaderId(leader).build());
                } catch (Exception ignored) {}
            }, 400, TimeUnit.MILLISECONDS);
        }
    }

    // ---------------- Bootstrap token forwarding ----------------

    private void forwardBootstrap(BootToken token) {
        Neighbor s = successor;
        if (s.getId() == id) return;
        try {
            ensureSuccStub();
            succStub.bootstrap(token);
        } catch (Exception e) {
            scheduler.schedule(() -> {
                try {
                    ensureSuccStub();
                    succStub.bootstrap(token);
                } catch (Exception ignored) {}
            }, 400, TimeUnit.MILLISECONDS);
        }
    }

    // ---------------- gRPC service ----------------

    private final class PeerServiceImpl extends PeerServiceGrpc.PeerServiceImplBase {
        @Override
        public void ping(Empty request, io.grpc.stub.StreamObserver<Empty> resp) {
            resp.onNext(Empty.newBuilder().build());
            resp.onCompleted();
        }

        @Override
        public void getSuccessorFor(LookupRequest request,
                                    io.grpc.stub.StreamObserver<SuccessorReply> resp) {
            resp.onNext(SuccessorReply.newBuilder().setNode(successor).build());
            resp.onCompleted();
        }

        @Override
        public void bootstrap(BootToken request, io.grpc.stub.StreamObserver<Empty> resp) {
            // Add self if not yet visited
            List<Integer> visited = new ArrayList<>(request.getVisitedList());
            boolean added = false;
            if (!visited.contains(id)) {
                visited.add(id);
                added = true;
                log("BOOT  token visit (origin=%d size=%d)", request.getOrigin(), visited.size());
            }

            // If token returned to origin -> ring is established; origin starts election
            if (request.getOrigin() == id && visited.get(0) == id && !added) {
                if (ringEstablished.compareAndSet(false, true)) {
                    // CANCEL FALLBACK at origin when ring closes
                    if (fallbackFuture != null) fallbackFuture.cancel(false);
                    log("BOOT  ring established (token closed)");
                    electionStart("bootstrap-ok");
                }
                resp.onNext(Empty.newBuilder().build());
                resp.onCompleted();
                return;
            }

            // Forward to successor, with updated visited if needed
            BootToken fwd = request;
            if (added) {
                fwd = BootToken.newBuilder().setOrigin(request.getOrigin()).addAllVisited(visited).build();
            }
            forwardBootstrap(fwd);

            resp.onNext(Empty.newBuilder().build());
            resp.onCompleted();
        }

        @Override
        public void election(ElectionMsg request, io.grpc.stub.StreamObserver<Empty> resp) {
            int cand = request.getCandidateId();
            boolean announce = false; int winner = -1;

            synchronized (electLock) {
                if (!inElection) {
                    inElection = true;
                    currentCandidate = cand;
                }
                if (cand == id) { // my id returned -> I’m the max alive
                    leaderId = id;
                    inElection = false;
                    announce = true; winner = id;
                } else if (cand < id && currentCandidate != id) {
                    currentCandidate = id;
                    cand = id;
                } else if (cand > currentCandidate) {
                    currentCandidate = cand;
                }
            }

            if (announce) {
                log("LEADER -> %d", winner);
                forwardCoordinator(winner);
            } else {
                forwardElection(cand);
            }

            resp.onNext(Empty.newBuilder().build());
            resp.onCompleted();
        }

        @Override
        public void coordinator(CoordinatorMsg request, io.grpc.stub.StreamObserver<Empty> resp) {
            int leader = request.getLeaderId();
            boolean forward;

            synchronized (electLock) {
                if (lastCoordSeen == leader) {
                    forward = false; // already forwarded this coordinator round
                } else {
                    leaderId = leader;
                    lastCoordSeen = leader;
                    inElection = false;
                    forward = (successor.getId() != id);
                }
            }

            // *** CRITICAL FIX ***
            // As soon as ANY node learns the leader via Coordinator, the ring is de facto ready
            // for the assignment’s purposes. Mark ringEstablished and cancel fallback.
            if (ringEstablished.compareAndSet(false, true)) {
                if (fallbackFuture != null) fallbackFuture.cancel(false);
            }

            log("COORD -> leader=%d", leader);
            if (forward) forwardCoordinator(leader);

            resp.onNext(Empty.newBuilder().build());
            resp.onCompleted();
        }

        @Override
        public void peerList(Empty request, io.grpc.stub.StreamObserver<PeerListReply> resp) {
            PeerListReply reply = PeerListReply.newBuilder()
                    .addAllPeers(new ArrayList<>(knownPeers.values()))
                    .build();
            resp.onNext(reply);
            resp.onCompleted();
        }
    }

    // ---------------- Channels & logging ----------------

    private void ensureSuccStub() {
        if (succStub != null) return;
        Neighbor s = this.successor;
        if (s.getId() == id) return;
        succCh = ManagedChannelBuilder.forAddress(s.getHost(), s.getPort()).usePlaintext().build();
        succStub = PeerServiceGrpc.newBlockingStub(succCh).withDeadlineAfter(1500, TimeUnit.MILLISECONDS);
    }

    private void rebuildSuccChannel() {
        if (succCh != null) {
            try { succCh.shutdownNow().awaitTermination(120, TimeUnit.MILLISECONDS); } catch (InterruptedException ignored) {}
            succCh = null; succStub = null;
        }
        ensureSuccStub();
    }

    private boolean isReachable(Neighbor n, long deadlineMs) {
        if (n.getId() == id) return true;
        try (TempChannel tc = TempChannel.connect(n.getHost(), n.getPort(), deadlineMs)) {
            tc.stub().ping(Empty.newBuilder().build());
            return true;
        } catch (Exception e) { return false; }
    }

    private void log(String fmt, Object... args) {
        Object[] out = new Object[(args == null ? 0 : args.length) + 1];
        out[0] = id;
        if (args != null && args.length > 0) System.arraycopy(args, 0, out, 1, args.length);
        System.out.printf("[NODE-%d] " + fmt + "%n", out);
    }

    private static final class TempChannel implements AutoCloseable {
        private final ManagedChannel ch;
        private final PeerServiceGrpc.PeerServiceBlockingStub stub;
        private TempChannel(ManagedChannel ch, PeerServiceGrpc.PeerServiceBlockingStub stub) { this.ch = ch; this.stub = stub; }
        static TempChannel connect(String host, int port, long deadlineMs) {
            ManagedChannel ch = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
            PeerServiceGrpc.PeerServiceBlockingStub stub = PeerServiceGrpc.newBlockingStub(ch)
                    .withDeadlineAfter(deadlineMs, TimeUnit.MILLISECONDS);
            return new TempChannel(ch, stub);
        }
        PeerServiceGrpc.PeerServiceBlockingStub stub() { return stub; }
        @Override public void close() {
            try { ch.shutdownNow().awaitTermination(120, TimeUnit.MILLISECONDS); } catch (InterruptedException ignored) {}
        }
    }
}
