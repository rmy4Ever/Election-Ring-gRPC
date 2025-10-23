/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.RegistrationDemo;

/**
 *
 * @author Kevin
 */
import com.mycompany.RegistrationDemo.proto.Neighbor;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * In-memory seed/peer list (no gRPC, just a simple provider).
 * Keeps your project purely P2P while still giving each node
 * a place to discover peers.
 */
public class PeerRegister implements RegisterInterface {

    private final List<Neighbor> peers = new CopyOnWriteArrayList<>();

    @Override
    public void join(Neighbor n) {
        for (Neighbor p : peers) {
            if (p.getId() == n.getId()) return;
            if (p.getHost().equals(n.getHost()) && p.getPort() == n.getPort()) return;
        }
        peers.add(n);
        System.out.printf("[REG] + join: %d @ %s:%d%n", n.getId(), n.getHost(), n.getPort());
    }

    @Override
    public List<Neighbor> list() {
        return new ArrayList<>(peers);
    }
}
