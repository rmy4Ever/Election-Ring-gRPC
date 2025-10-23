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
import java.util.List;

public interface RegisterInterface {
    void join(Neighbor n);
    List<Neighbor> list();
}
