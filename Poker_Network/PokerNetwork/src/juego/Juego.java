/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import estados.Estado;
import java.util.ArrayList;

/**
 * Gestion de la logica del juego.
 * @author Mario Codes Sánchez
 * @since 08/02/2017
 */
public class Juego {
    private Estado estado = null;
    private int numeroJugadores = 0;
    
    private Baraja baraja = null;
    private ArrayList<Carta> CARTAS_MESA = new ArrayList<>();
    private int fichasApuestas = 0;
    
    /**
     * Extraccion de las 3 cartas de la baraja comunes para la mesa.
     */
    private void sacarCartasComunes() {
        CARTAS_MESA.addAll(baraja.extraerCartas(3));
    }
    
    /**
     * Recogemos las cartas de la mesa y ponemos las fichas de apuestas a 0;
     */
    private void recoger() {
        CARTAS_MESA.removeAll(CARTAS_MESA);
        fichasApuestas = 0;
    }
    
    /**
     * Creamos una baraja aleatoria nueva.
     */
    public void rebarajar() {
        recoger();
        this.baraja = new Baraja();
        
        baraja.quemarCartas(3);
        sacarCartasComunes();
        System.out.println("Ronda nueva Comenzada. Cartas de la mesa repartidas.");
    }
    
//    public void sumarApuesta(int fichas) {
//        fichasApuestas += fichas;
//    }

    /**
     * Repartimos las 2 cartas necesarias propias para el jugador.
     * @return ArrayList con las 2 cartas extraidas de la baraja.
     */
    public ArrayList<Carta> repartoManoJugador() {
        ArrayList<Carta> cartas = new ArrayList<>();
        cartas.addAll(baraja.extraerCartas(2));
        return cartas;
    }
    
    @Override
    public String toString() {
        return "Juego en estado: " +this.estado.toString();
    }
    
    /**
     * @return the CARTAS_MESA
     */
    public ArrayList<Carta> getCartasComunes() {
        return CARTAS_MESA;
    }

    /**
     * @return the fichasApuestas
     */
    public int getFichasApuestas() {
        return fichasApuestas;
    }

    /**
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * NO USARLO DIRECTAMENTE. Se debe cambiar mediante una subinterfaz.cambioEstado().
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * @return the numeroJugadores
     */
    public int getNumeroJugadores() {
        return numeroJugadores;
    }
    
    /**
     * Sumar +1 al numero de jugadores.
     */
    public void aniadirJugador() {
        this.numeroJugadores++;
    }
}