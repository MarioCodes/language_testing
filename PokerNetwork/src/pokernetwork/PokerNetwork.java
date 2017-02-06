/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokernetwork;

import java.util.ArrayList;
import juego.Baraja;
import juego.Carta;

/**
 * Proyecto Online juego Oscar -> Poker!.
 * @author Mario Codes Sánchez
 * @since 06/02/2017
 */
public class PokerNetwork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Baraja b = new Baraja();
        ArrayList<Carta> cartas = b.extraerCartas(3);
        
        for(Carta carta: cartas) {
            System.out.println(carta);
        }
        
        System.out.println(b);
    }
    
}