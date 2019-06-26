/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristina
 */
public class Tablero {

    //Atributos
    private Elemento[][] elementos;     //Almacena todos los elementos (Plantas + Zombis)
    private String dificultad;
    int numTurno;               //TurnosMaxAparecenZombis
    int numZombi;               //NumeroZombisPartida
    int turnoSinZombi;          //NumeroTurnosSinZombis
    int fila, columna;          //FilaColumnaTablero
    int soles = 50;             //SolesIniciales
    int turno = 0;              //TurnoInicial
    int z = 0;                  //AlmacenarIndexZombis (indica cuantos zombis llevas creados)
    int zombisGenerados = 0;    //Indica cuantos zombis han salido
    int contador = 0;           //¿?
    int zombisMatados = 0;      //Indica cuantos zombis han muerto
    int puntos = 0;             //Almacena puntuacion

    //Constructor
    /**
     *
     * @param fila
     * @param columna
     * @param dificultad
     */
    public Tablero(int fila, int columna, String dificultad) {
        elementos = new Elemento[fila][columna];
        this.dificultad = dificultad;
    }

    //Getter - Setter
    public Elemento[][] getElementos() {
        return elementos;
    }

    public int getSoles() {
        return soles;
    }

    /**
     *
     * @param soles
     */
    public void setSoles(int soles) {
        this.soles = soles;
    }

    public int getTurno() {
        return turno;
    }

    /**
     *
     * @param turno
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }

    //Metodos
    public void inicializarJuego() {
        switch (dificultad) {
            case "BAJA":
                numTurno = 30;
                numZombi = 5;
                turnoSinZombi = 10;
                break;
            case "MEDIA":
                numTurno = 30;
                numZombi = 15;
                turnoSinZombi = 7;
                break;
            case "ALTA":
                numTurno = 30;
                numZombi = 25;
                turnoSinZombi = 5;
                break;
            case "IMPOSIBLE":
                numTurno = 30;
                numZombi = 50;
                turnoSinZombi = 5;
                break;
        }

    }

    public void generarSoles() {
        //Recorrer array Elemento[][]
        for (Elemento[] elemento : elementos) {
            for (int j = 0; j < elemento.length; j++) {
                //Si el elemento es un Girasol
                if (elemento[j] instanceof Girasol) {
                    //Fijamos frecuencia para generar soles
                    elemento[j].setFrecuencia(elemento[j].getFrecuencia() + 1);
                    if (elemento[j].getFrecuencia() % 2 == 0) {
                        soles += 10; //Agregamos soles
                    }
                }
            }
        }
    }

    public int controlJuego() {
        //Si el numero de zombis = a los zombis muertos -> GANAS
        if (numZombi == zombisMatados) {
            return 0;
        }
        for (Elemento[] elemento : elementos) {
            //Si el elementos que esta en la columna1 es algun zombi -> PIERDES
            if (elemento[0] instanceof ZComun || elemento[0] instanceof ZCaracubo || elemento[0] instanceof ZDeportista) {
                return 1;
            }
        }
        return 2; //Sino se cumple nada -> SEGUIR JUEGO
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public boolean comprobarTablero(int x, int y) {
        boolean devolver = false;

        if (elementos[x][y] != null) {
            JOptionPane.showMessageDialog(null, "Casilla Ocupada", "ERROR - CASILLA", JOptionPane.ERROR_MESSAGE);
            turno--;
        } else {
            if (y < 6) {
                devolver = true;
            } else {
                JOptionPane.showMessageDialog(null, "Prohibido introducir plantas aqui", "ERROR - ULTIMA COLUMNA", JOptionPane.ERROR_MESSAGE);
                turno--;
            }
        }
        return devolver;
    }

    public int puntos() {
        //Recorres fila
        for (int i = 0; i < 7; i++) {
            //Recorres columna
            for (int j = 0; j < 7; j++) {
                if (elementos[i][j] instanceof Girasol) {
                    puntos = puntos + 20;   //Si es un Girasol +20 puntos
                }
                if (elementos[i][j] instanceof LanzaGuisantes || elementos[i][j] instanceof Nuez) {
                    puntos = puntos + 50; //Si es un LanzaGuisantes o Nuez +50 puntos
                }
            }
        }
        puntos = puntos + soles;
        return puntos;
    }

    /**
     *
     * @param tipo
     * @param x
     * @param y
     */
    public void agregarPlanta(String tipo, int x, int y) {
        switch (tipo) {
            case "G":
                Girasol g = new Girasol();
                if (comprobarTablero(x, y)) {
                    elementos[x][y] = g;
                    soles -= g.getCoste();
                    generarSoles();
                }
                break;
            case "L":
                LanzaGuisantes l = new LanzaGuisantes();
                if (comprobarTablero(x, y)) {
                    elementos[x][y] = l;
                    soles -= l.getCoste();
                    generarSoles();
                }
                break;
            case "N":
                Nuez n = new Nuez();
                if (comprobarTablero(x, y)) {
                    elementos[x][y] = n;
                    soles -= n.getCoste();
                    generarSoles();
                }
        }
    }

    public void agregarZombie() {
        if (turno >= turnoSinZombi) {
            contador++;
            switch (dificultad) {
                case "BAJA":
                    if (turno == 10 || turno == 15 || turno == 20 || turno == 25 || turno == 30) {
                        generarZombi();
                    }
                    break;
                case "MEDIA":
                    //Divisores de 3-5-7-11 > 7
                    if (turno % 3 == 0 || turno % 5 == 0 || turno % 7 == 0 || turno % 11 == 0) {
                        if (zombisGenerados <= numZombi) {
                            generarZombi();
                        }
                    }
                    break;
                case "ALTA":
                    //Se genera un zombi x turno
                    if (zombisGenerados <= numZombi) {
                        generarZombi();
                    }
                    break;
                case "IMPOSIBLE":
                    //Generar 2zombis x turno
                    for (int i = 0; i < 2; i++) {
                        if (zombisGenerados <= numZombi) {
                            generarZombi();
                        }
                    }
                    break;
            }
        }
    }

    public void generarZombi() {
        Random r = new Random();
        zombisGenerados++;
        int filaAleatoria = r.nextInt(elementos.length);
        int tipoZombi = r.nextInt(3);   //Genera un num aleatorio para crear un tipo de zombie

        switch (tipoZombi) {
            case 0:
                ZComun z1 = new ZComun();
                //Si la ultima casilla esta vacia
                if (elementos[filaAleatoria][elementos[0].length - 1] == null) {
                    //Crear el zombi
                    elementos[filaAleatoria][elementos[0].length - 1] = z1;
                } else {
                    //Si no esta vacia, recorre la ultima columna hasta encontrar un hueco vacio
                    while (elementos[filaAleatoria][elementos[0].length - 1] != null) {
                        filaAleatoria = r.nextInt(elementos.length); //Genera un nuevo numero
                        //Crear el zombie cuando la posiscion de elementos[0] sea null
                        elementos[filaAleatoria][elementos[0].length - 1] = z1;
                    }
                }
                break;
            case 1:
                ZCaracubo z2 = new ZCaracubo();
                //Si la ultima casilla esta vacia
                if (elementos[filaAleatoria][elementos[0].length - 1] == null) {
                    //Crear el zombi
                    elementos[filaAleatoria][elementos[0].length - 1] = z2;
                } else {
                    //Si no esta vacia, recorre la ultima columna hasta encontrar un hueco vacio
                    while (elementos[filaAleatoria][elementos[0].length - 1] != null) {
                        filaAleatoria = r.nextInt(elementos.length); //Genera un nuevo numero
                        //Crear el zombie cuando la posiscion de elementos[0] sea null
                        elementos[filaAleatoria][elementos[0].length - 1] = z2;
                    }
                }
                break;
            case 2:
                ZDeportista z3 = new ZDeportista();
                //Si la ultima casilla esta vacia
                if (elementos[filaAleatoria][elementos[0].length - 1] == null) {
                    //Crear el zombi
                    elementos[filaAleatoria][elementos[0].length - 1] = z3;
                } else {
                    //Si no esta vacia, recorre la ultima columna hasta encontrar un hueco vacio
                    while (elementos[filaAleatoria][elementos[0].length - 1] != null) {
                        filaAleatoria = r.nextInt(elementos.length); //Genera un nuevo numero
                        //Crear el zombie cuando la posiscion de elementos[0] sea null
                        elementos[filaAleatoria][elementos[0].length - 1] = z3;
                    }
                }
                break;
        }
    }

    public void quitarVidaZombi() {
        //Recorrer array elementos y "almacenarlo" en elemento
        for (Elemento[] elemento : elementos) {
            for (int j = 0; j < elemento.length; j++) {
                //Si elemento es un lanzaGuisantes -- comparar objetos
                if (elemento[j] instanceof LanzaGuisantes) {
                    int cont = 0;
                    //Comprueba si hay zombis en la fila
                    for (; j < elemento.length; j++) {
                        if ((elemento[j] instanceof ZComun || elemento[j] instanceof ZDeportista || elemento[j] instanceof ZCaracubo) && cont == 0) {
                            elemento[j].setResistencia(elemento[j].getResistencia() - elemento[j].getDano());
                            cont++;
                            //Zombi muerto
                            if (elemento[j].getResistencia() == 0) {
                                zombisMatados++;
                                elemento[j] = null;
                            }
                        }
                    }
                }
            }
        }
    }

    public void avanzaZombi() {
        //Zombi avanza
        for (int i = 0; i < elementos.length; i++) {
            for (int j = 0; j < elementos[i].length; j++) {
                if (elementos[i][j] instanceof ZComun && elementos[i][j - 1] == null) {
                    elementos[i][j].setFrecuencia(elementos[i][j].getFrecuencia() + 1);
                    if (elementos[i][j].getFrecuencia() % 2 == 0) {
                        elementos[i][j - 1] = elementos[i][j];
                        elementos[i][j] = null;
                    }
                }
                if (elementos[i][j] instanceof ZDeportista && elementos[i][j - 1] == null) {
                    elementos[i][j - 1] = elementos[i][j];
                    elementos[i][j] = null;
                }
                if (elementos[i][j] instanceof ZCaracubo && elementos[i][j - 1] == null) {
                    elementos[i][j].setFrecuencia(elementos[i][j].getFrecuencia() + 1);
                    if (elementos[i][j].getFrecuencia() == 4) {
                        elementos[i][j].setFrecuencia(1);
                        elementos[i][j - 1] = elementos[i][j];
                        elementos[i][j] = null;
                    }
                }
            }
        }
        //Comprobar que se quita vida a la planta
        for (int i = 0; i < elementos.length; i++) {
            for (int j = 0; j < elementos[i].length; j++) {
                try {
                    if (((elementos[i][j] instanceof ZComun || elementos[i][j] instanceof ZDeportista || elementos[i][j] instanceof ZCaracubo) && (elementos[i][j - 1] instanceof LanzaGuisantes || elementos[i][j - 1] instanceof Girasol || elementos[i][j - 1] instanceof Nuez))) {
                        elementos[i][j].setFrecuencia(elementos[i][j].getFrecuencia() + 1);
                        if (elementos[i][j].getFrecuencia() % 2 == 0) {
                            elementos[i][j - 1].setResistencia(elementos[i][j - 1].getResistencia() - elementos[i][j].getDano());
                            if (elementos[i][j - 1].getResistencia() == 0) {
                                elementos[i][j - 1] = null;
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e2) {
                    System.out.println("El juego ha acabado. ");
                }
            }
        }
    }
}
