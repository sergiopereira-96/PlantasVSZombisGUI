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
public class ZDeportista extends Elemento{

    //Constructor
    public ZDeportista() {
        super.setResistencia(2);
        super.setDano(1);
    }

    @Override
    public String toString() {
        return "ZD(" + super.getResistencia() + ")";
    }
}
