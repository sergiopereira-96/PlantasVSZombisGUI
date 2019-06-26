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
public class Girasol extends Elemento {

    //Atributos
    private int coste;

    //Constructor
    public Girasol() {
        super.setResistencia(1);
        super.setDano(0);
        this.coste = 20;
    }

    //Getter
    public int getCoste() {
        return coste;
    }

    @Override
    public String toString() {
        return "G(" + super.getResistencia() + ")";
    }

}
