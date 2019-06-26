/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;

/**
 *
 * @author Cristina
 */
public class Usuario implements Serializable {

    //Atributos
    private String dni;
    private String nombre;
    private int puntos = 0;
    private int puntosTotales = 0;
    private int partidaGanada = 0;
    private int partidaPerdida = 0;
    private int partidaTotal = 0;
    private String dificultad;

    //Constructor
    /**
     *
     * @param nombre
     * @param dni
     * @param dificultad
     */
    public Usuario(String nombre, String dni, String dificultad) {
        this.nombre = nombre;
        this.dni = dni;
        this.dificultad = dificultad;
    }

    //Getter - Setter
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    /**
     *
     * @param puntos
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    /**
     *
     * @param puntosTotales
     */
    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
    }

    public int getPartidaGanada() {
        return partidaGanada;
    }

    /**
     *
     * @param partidaGanada
     */
    public void setPartidaGanada(int partidaGanada) {
        this.partidaGanada = partidaGanada;
    }

    public int getPartidaPerdida() {
        return partidaPerdida;
    }

    /**
     *
     * @param partidaPerdida
     */
    public void setPartidaPerdida(int partidaPerdida) {
        this.partidaPerdida = partidaPerdida;
    }

    public int getPartidaTotal() {
        return partidaTotal;
    }

    public void setPartidaTotal(int partidaTotal) {
        this.partidaTotal = partidaTotal;
    }
    
    

    @Override
    public String toString() {
        return ("- " + nombre + " con DNI: " + dni + " obtuvo " + puntos + " puntos en la partida anterior donde la dificultad fue " + dificultad +
                "\nSu puntuacion total es: " + puntosTotales + ", ha ganado " + partidaGanada + " partidas y perdido " + partidaPerdida + " partidas y lleva un total de " + getPartidaTotal() + " partidas jugadas");
    }
}
