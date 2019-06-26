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
public class ZComun extends Elemento {

    //Constructor
    public ZComun() {
        super.setResistencia(5);
        super.setDano(1);
    }

    @Override
    public String toString() {
        return "Z(" + super.getResistencia() + ")";
    }
}
