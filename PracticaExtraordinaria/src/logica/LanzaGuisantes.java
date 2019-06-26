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
public class LanzaGuisantes extends Elemento {

    //Atributos
    private int coste;

    //Constructor
    public LanzaGuisantes() {
        super.setResistencia(3);
        super.setDano(1);
        this.coste = 50;
    }

    //Getter
    public int getCoste() {
        return coste;
    }

    @Override
    public String toString() {
        return "LG(" + super.getResistencia() + ")";
    }

}
