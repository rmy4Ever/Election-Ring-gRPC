/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.RegistrationDemo;

import com.mycompany.RegistrationDemo.proto.Neighbor;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class RegistrationDemo {

    public static void main(String[] args) throws Exception {
        PeerRegister register = new PeerRegister();

        List<Neighbor> peers = List.of(
                n(5,  "localhost", 5001),
                n(11, "localhost", 5002),
                n(2,  "localhost", 5003),
                n(7,  "localhost", 5004),
                n(15, "localhost", 5005),
                n(9,  "localhost", 5006),
                n(3,  "localhost", 5007),
                n(12, "localhost", 5008)
        );

        // publish seeds so nodes discover each other without a central server
        for (Neighbor p : peers) register.join(p);

        // start nodes (stagger a bit)
        List<Node> nodes = new ArrayList<>();
        for (Neighbor p : peers) {
            Node node = new Node(p.getId(), p.getHost(), p.getPort(), register, null);
            node.start();
            nodes.add(node);
            sleep(80);
        }

        // allow time for: stabilize -> bootstrap token -> election -> coordinator flood
        sleep(14000);

        Collections.reverse(nodes);
        for (Node n : nodes) n.shutdown();
    }

    private static Neighbor n(int id, String host, int port) {
        return Neighbor.newBuilder().setId(id).setHost(host).setPort(port).build();
    }
    private static void sleep(long ms) { try { TimeUnit.MILLISECONDS.sleep(ms); } catch (InterruptedException ignored) {} }
}
