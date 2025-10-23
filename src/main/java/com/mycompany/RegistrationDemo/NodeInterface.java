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

public interface NodeInterface {
    int getId();
    Neighbor getSelf();
    Neighbor getSuccessor();
    void setSuccessor(Neighbor n);
    void start() throws Exception;
    void shutdown();
}
