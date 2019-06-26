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
public abstract class Elemento {

    //Atributos
    private int resistencia;
    private int frecuencia;
    private int dano;

    //Constructor
    public Elemento() {
        this.resistencia = resistencia;
        this.frecuencia = 0;
        this.dano = dano;
    }

    //Getter - Setter
    public int getResistencia() {
        return resistencia;
    }

    /**
     *
     * @param resistencia
     */
    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    /**
     *
     * @param frecuencia
     */
    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public int getDano() {
        return dano;
    }

    /**
     *
     * @param dano
     */
    public void setDano(int dano) {
        this.dano = dano;
    }
}
