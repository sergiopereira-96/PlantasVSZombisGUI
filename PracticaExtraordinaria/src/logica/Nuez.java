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
public class Nuez extends Elemento {

    //Atributos
    private int coste;

    //Constructor
    public Nuez() {
        super.setResistencia(10);
        super.setDano(0);
        this.coste = 50;
    }

    //Getter
    public int getCoste() {
        return coste;
    }

    @Override
    public String toString() {
        return "N(" + super.getResistencia() + ")";
    }

}
