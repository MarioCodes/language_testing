/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fases;

import entidades.Carta;
import entidades.Juego;
import java.util.ArrayList;
import pokernetwork.Conexion;

/**
 * Fase de Flop.
 * @author Mario Codes Sánchez
 * @since 09/02/2017
 */
public class FaseFlop implements Fase {
    private boolean apostar = false;
    
    @Override
    public void cambioFase(Juego juego) {
        juego.setFase(this);
        System.out.println("Fase de Flop");
    }

    @Override
    public void repartoCartasJugador(Juego juego) {
        Conexion.sendBooleano(false);
    }

    @Override
    public void repartoCartasComunes(Juego juego) {
        ArrayList<Carta> cartas = juego.getCartasComunes();
        Conexion.sendBooleano(true);
        Conexion.repartoCartas(cartas);
        
        if(juego.terminarTurno()) {
            apostar = true;
            System.out.println("Rondas de Apuestas.");
        }
    }

    @Override
    public void apostar(Juego juego) {
        if(!apostar) Conexion.sendBooleano(false);
        else {
            Conexion.sendBooleano(true);
            Conexion.getApuesta(juego);
        }
    }

    @Override
    public String retirarse() {
        Conexion.sendBooleano(false);
        return null;
    }
    
    @Override
    public String toString() {
        return "Flop";
    }
}
