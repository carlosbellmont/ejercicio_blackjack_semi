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
        int resultado = 0;
        for (Integer carta : cartasObtenidas){
            resultado = resultado + carta;
        }
        return resultado;
    }

    public void reiniciarCartas(){
        cartasObtenidas.clear();
    }

    public boolean haPerdido(){
        return (getSumatorioCartas() > 21);
    }

    public boolean esElSumatorioMayorQue17(){
        return (getSumatorioCartas() > 17);
    }

}
