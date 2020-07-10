package com.ejemplo;

import java.util.ArrayList;

public class Jugador {

    String nombre;

    private ArrayList<Integer> cartasObtenidas = new ArrayList<>();

    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public boolean soyLaBanca(){
        return nombre.equalsIgnoreCase("banca");
    }

    public void addCarta(int carta){
        cartasObtenidas.add(carta);
    }

    public int getSumatorioCartas(){
        // TODO
        return 0;
    }

    public void reiniciarPartida(){
        cartasObtenidas.clear();
    }

    public boolean haPerdido(){
        // TODO
        return false;
    }
}
