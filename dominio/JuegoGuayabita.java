package com.alejomarquez.guayabita.dominio;


import javax.swing.*;

public class JuegoGuayabita {
    private Jugador[] jugadores;
    private int pote;

    public void iniciarJuego() {
        int numJugadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de jugadores:"));
        int apuestaMinima = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor mínimo de apuesta inicial:"));

        jugadores = new Jugador[numJugadores];
        pote = numJugadores * apuestaMinima;

        for (int i = 0; i < numJugadores; i++) {
            String nombreJugador = JOptionPane.showInputDialog("Nombre del Jugador " + (i + 1) + ":");
            int dineroJugador = Integer.parseInt(JOptionPane.showInputDialog("Dinero para apostar el Jugador " + (i + 1) + ":"));
            jugadores[i] = new Jugador(nombreJugador, apuestaMinima, dineroJugador);
        }

        while (Jugador.juegoContinua(jugadores)) {
            for (Jugador jugador : jugadores) {
                if (jugador.getDinero() > 0) {
                    jugador.jugarTurno();
                }
            }
        }

        JOptionPane.showMessageDialog(null, "El juego ha terminado.");
        for (Jugador jugador : jugadores) {
            JOptionPane.showMessageDialog(null, jugador.getNombre() + " quedó con $" + jugador.getDinero());
        }
    }

    public static void main(String[] args) {
        JuegoGuayabita juego = new JuegoGuayabita();
        juego.iniciarJuego();
    }
}

