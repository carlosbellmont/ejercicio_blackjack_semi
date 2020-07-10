package com.ejemplo;

import java.util.Random;
import java.util.Scanner;

public class Main {

    // Este ejercicio quiere simular el juego un blackjack de modo simplificado
    static boolean salirDelJuego = false;

    public static void main(String[] args) {
        // El usuario recibe una carta.
        // Calcular si has perdido - Te has pasado de 21
        // Si has perdido, finalizar partida y preguntar si quieres echar otra partida.
        // La banca pide carta si sus cartas no suman mas de 17
        // Calcular si la banca ha perdido - Se ha pasado de 21
        // Si la banca ha perido, finalizar partida y preguntar si quieres echar otra partida.

        // Preguntar la jugador si se planta
        // Si el jugador se planta, la banca pide cartas hasta que gane o pierda
        // Decir quien ha ganado, finalizar partida y preguntar si quieres echar otra partida.
        // Si el jugador no se planta, repetir el proceso

        boolean finDelJuego = false;
        Jugador jugador = new Jugador("Carlos");
        Jugador banca = new Jugador("Banca");

        do {
            iniciarPartida(jugador, banca);
        } while (!salirDelJuego);


    }

    private static void iniciarPartida(Jugador jugador, Jugador banca){
        System.out.println("Empezando una nueva partida");
        boolean partidaFinalizada = false;
        do {
            // El usuario recibe una carta.

            // Calcular si has perdido - Te has pasado de 21
            if (jugador.haPerdido()){
                // finalizar partida y preguntar si quieres echar otra partida.
            }
            // La banca pide carta si sus cartas no suman mas de 17

            // Calcular si la banca ha perdido - Se ha pasado de 21

            if (banca.haPerdido()){
                // finalizar partida y preguntar si quieres echar otra partida.
            }

            if (sePlanta()){
                // La banca pide cartas hasta que gane o pierda.
                // finalizar partida y preguntar si quieres echar otra partida.
            }

        } while (!partidaFinalizada);// Si el jugador no se planta, repetir el proceso

    }


    private static boolean sePlanta(){
        // TODO preguntar al usuario en bucle si quiere o no otra carta. Las opciones validas on 1 para si y 2 para no
        return false;
    }


    private static boolean quiereRepetirPartida(){
        // TODO preguntar al usuario en bucle si quiere o no repetir. Las opciones validas on 1 para si y 2 para no
        return false;
    }

    private static boolean calcular(){
        // TODO preguntar al usuario en bucle si quiere o no repetir. Las opciones validas on 1 para si y 2 para no
        return false;
    }

    private static int readIntFromKeyboard(){
        Integer result;
        Scanner keyboardReader = new Scanner(System.in);
        do {
            String selectedOption = keyboardReader.nextLine();
            try {
                result = Integer.parseInt(selectedOption);
            } catch (NumberFormatException e){
                System.out.println("El String introducido no es un número. Introduce un \"int\"");
                result = null;
            }
        } while (result == null);
        keyboardReader.close();
        return result.intValue();
    }


    public static int getCarta(){
        Random rand = new Random();
        int carta = rand.nextInt(11) + 1;
        System.out.println("La carta vale " + carta);
        return carta;
    }
}
