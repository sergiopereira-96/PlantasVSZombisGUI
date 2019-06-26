/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Cristina
 */
public class ZCaracubo extends Elemento {

    //Constructor
    public ZCaracubo() {
        super.setResistencia(8);
        super.setDano(1);
    }

    @Override
    public String toString() {
        return "ZC(" + super.getResistencia() + ")";
    }
}
