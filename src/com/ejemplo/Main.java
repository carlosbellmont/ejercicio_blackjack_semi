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
            jugador.addCarta(getCarta());
            // Calcular si has perdido - Te has pasado de 21
            if (jugador.haPerdido()){
                System.out.println("Has perdido");
                // preguntar si quieres echar otra partida.
                preguntarSiQuiereSeguirJugando(jugador, banca);
            }

            // La banca pide carta si sus cartas no suman mas de 17
            if (!banca.esElSumatorioMayorQue17()){
                System.out.println("La banca roba carta");
                banca.addCarta(getCarta());
            } else {
                System.out.println("La banca espera");
            }

            // Calcular si la banca ha perdido - Se ha pasado de 21
            if (banca.haPerdido()){
                System.out.println("El jugador ha ganado");
                // finalizar partida y preguntar si quieres echar otra partida.
                preguntarSiQuiereSeguirJugando(jugador, banca);
            }

            if (preguntarSiQuierePlantarse()){

                // La banca pide cartas hasta que gane o pierda.
                // finalizar partida y preguntar si quieres echar otra partida.
            }

        } while (!partidaFinalizada);// Si el jugador no se planta, repetir el proceso

    }


    private static void preguntarSiQuiereSeguirJugando(Jugador jugador, Jugador banca){
        if (pedirEleccionAlUsuario("Introduce 1 para seguir jugando, 2 para salir")){
            jugador.reiniciarCartas();
            banca.reiniciarCartas();
        } else {
            System.exit(0);
        }
    }

    private static boolean preguntarSiQuierePlantarse(){
        if (pedirEleccionAlUsuario("Introduce 1 para seguir jugando, 2 para plantarse")){
            return false;
        } else {
            return true;
        }
    }


    private static boolean pedirEleccionAlUsuario(String mensaje){
        int eleccionDelUsuario;
        do {
            System.out.println(mensaje);
            eleccionDelUsuario = readIntFromKeyboard();
        } while (eleccionDelUsuario == 1 || eleccionDelUsuario == 2);
        if (eleccionDelUsuario == 1){
            return true;
        } else {
            return false;
        }
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
