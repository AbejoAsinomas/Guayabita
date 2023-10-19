package com.alejomarquez.guayabita.dominio;

import javax.swing.*;

public class Jugador {
    private String nombre;
    private int dinero;
    private int apuestaMinima;
    private int pote;

    public Jugador(String nombre, int apuestaMinima, int poteInicial) {
        this.nombre = nombre;
        this.dinero = poteInicial;
        this.apuestaMinima = apuestaMinima;
        this.pote = poteInicial;
    }

    public void jugarTurno() {
        JOptionPane.showMessageDialog(null, nombre + ", es tu turno. Presiona OK para lanzar el dado.");

        int resultadoDado = (int) (Math.random() * 6) + 1;


        if (resultadoDado == 1) {
            JOptionPane.showConfirmDialog(null,
                    getNombre()
                            + ". Con este dado no puedes apostar...\nPasa el turno",
                    "Lanzamiento", JOptionPane.DEFAULT_OPTION, JOptionPane.NO_OPTION,
                    new ImageIcon(getClass().getResource("uno.png")));
        }
        else if (resultadoDado == 2) {
            dinero = JOptionPane.showConfirmDialog(null,
                    getNombre() + " Este es tu dado\n"
                            + "�Deseas hacer una apuesta?",
                    "Lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                    new ImageIcon(getClass().getResource("dos.png")));
        } else if (resultadoDado == 3) {
            dinero = JOptionPane.showConfirmDialog(null,
                    getNombre() + ". Este es tu dado\n"
                            + "�Deseas hacer una apuesta?",
                    "Lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                    new ImageIcon(getClass().getResource("tres.png")));
        } else if (resultadoDado == 4) {
            dinero = JOptionPane.showConfirmDialog(null,
                    getNombre() + ". Este es tu dado\n"
                            + "�Deseas hacer una apuesta?",
                    "Lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                    new ImageIcon(getClass().getResource("cuatro.png")));

        } else if (resultadoDado == 5) {
            dinero = JOptionPane.showConfirmDialog(null,
                    getNombre() + ". Este es tu dado\n"
                            + "�Deseas hacer una apuesta?",
                    "Lanzamiento", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION,
                    new ImageIcon(getClass().getResource("cinco.png")));
        } else if (resultadoDado == 6) {
            JOptionPane.showConfirmDialog(null,
                    getNombre()
                            + ". Con este dado no puedes apostar...\nPasa el turno",
                    "Lanzamiento", JOptionPane.DEFAULT_OPTION, JOptionPane.NO_OPTION,
                    new ImageIcon(getClass().getResource("seis.png")));


        }
        else {
            String apuestaStr = JOptionPane.showInputDialog("¿Quieres apostar por el pote? (Sí/No)");
            if (apuestaStr != null && apuestaStr.equalsIgnoreCase("Sí")) {
                int montoApostado = ingresarMontoApostado();
                if (montoApostado > 0) {
                    int nuevoResultadoDado = (int) (Math.random() * 6) + 1;

                    JOptionPane.showMessageDialog(null, "Nuevo resultado del dado: " + nuevoResultadoDado);

                    if (nuevoResultadoDado > resultadoDado) {
                        JOptionPane.showMessageDialog(null, "Ganas la apuesta. Recibes $" + montoApostado + " del pote.");
                        ganarApuesta(montoApostado);
                    } else {
                        JOptionPane.showMessageDialog(null, "Pierdes la apuesta. $" + montoApostado + " se agrega al pote.");
                        perderApuesta(montoApostado);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Monto de apuesta inválido.");
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Dinero en el pote: $" + pote);
    }

    private int ingresarMontoApostado() {
        int montoApostado = -1;
        while (montoApostado < apuestaMinima || montoApostado > dinero || montoApostado > pote) {
            montoApostado = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el monto de apuesta (debe ser mayor que 0, menor o igual a tu dinero y al dinero en el pote):"));
        }
        return montoApostado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public void ganarApuesta(int monto) {
        dinero += monto;
        pote -= monto;
    }

    public void perderApuesta(int monto) {
        dinero -= monto;
        pote += monto;
    }

    public static boolean juegoContinua(Jugador[] jugadores) {
        for (Jugador jugador : jugadores) {
            if (jugador.dinero > 0) {
                return true;
            }
        }
        return false;
    }
}


