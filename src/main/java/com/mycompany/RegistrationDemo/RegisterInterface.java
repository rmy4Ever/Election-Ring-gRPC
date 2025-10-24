/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
*Kevin Bolanavatu - S11198128
*Maria Waqairatavo - S11174090
*Salote Katia - S11196202
*/

package com.mycompany.RegistrationDemo;

import com.mycompany.RegistrationDemo.proto.Neighbor;
import java.util.List;

public interface RegisterInterface {
    void join(Neighbor n);
    List<Neighbor> list();
}
