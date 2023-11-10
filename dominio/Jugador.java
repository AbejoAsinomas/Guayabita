package com.alejomarquez.guayabita.dominio;

import javax.swing.*;

public class Jugador {
    private String nombre;
    private int dinero;
    private int apuestaMinima;
    private int pote;

    // Constructor de la clase Jugador
    public Jugador(String nombre, int apuestaMinima, int poteInicial) {
        this.nombre = nombre;
        this.dinero = poteInicial;
        this.apuestaMinima = apuestaMinima;
        this.pote = poteInicial;
    }

    // Método para simular el turno de un jugador
    public void jugarTurno() {
        // Se muestra un mensaje al jugador para que lance un dado
        JOptionPane.showMessageDialog(null, nombre + ", es tu turno. Presiona OK para lanzar el dado.");
        // Se simula el lanzamiento de un dado de seis caras
        int resultadoDado = (int) (Math.random() * 6) + 1;


        if (resultadoDado == 1) {
            // Si el resultado del dado es 1, se muestra un mensaje indicando que no se puede apostar en este caso
            JOptionPane.showConfirmDialog(null,
                    getNombre()
                            + ". Con este dado no puedes apostar...\nPasa el turno",
                    "Lanzamiento", JOptionPane.DEFAULT_OPTION, JOptionPane.NO_OPTION,
                    new ImageIcon(getClass().getResource("uno.png")));
        }
        else if (resultadoDado == 2) {
            // Aquí se muestra un diálogo preguntando si el jugador desea hacer una apuesta
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
            // Si el resultado del dado es 6, se muestra un mensaje indicando que no se puede apostar en este caso
            JOptionPane.showConfirmDialog(null,
                    getNombre()
                            + ". Con este dado no puedes apostar...\nPasa el turno",
                    "Lanzamiento", JOptionPane.DEFAULT_OPTION, JOptionPane.NO_OPTION,
                    new ImageIcon(getClass().getResource("seis.png")));
        }
        else {
            // Si el resultado del dado es diferente de 1 o 6, se pregunta al jugador si desea apostar por el pote
            String apuestaStr = JOptionPane.showInputDialog("¿Quieres apostar por el pote? (Sí/No)");
            if (apuestaStr != null && apuestaStr.equalsIgnoreCase("Sí")) {
                int montoApostado = ingresarMontoApostado();
                if (montoApostado > 0) {
                    // Se simula un nuevo lanzamiento del dado
                    int nuevoResultadoDado = (int) (Math.random() * 6) + 1;
                    // Se muestra el resultado del nuevo lanzamiento del dado
                    JOptionPane.showMessageDialog(null, "Nuevo resultado del dado: " + nuevoResultadoDado);

                    if (nuevoResultadoDado > resultadoDado) {
                        // Si el nuevo resultado es mayor que el original, el jugador gana la apuesta
                        JOptionPane.showMessageDialog(null, "Ganas la apuesta. Recibes $" + montoApostado + " del pote.");
                        ganarApuesta(montoApostado);
                    } else {
                        // Si el nuevo resultado es igual o menor, el jugador pierde la apuesta
                        JOptionPane.showMessageDialog(null, "Pierdes la apuesta. $" + montoApostado + " se agrega al pote.");
                        perderApuesta(montoApostado);
                    }
                } else {
                    // Se muestra un mensaje si el monto de apuesta ingresado es inválido
                    JOptionPane.showMessageDialog(null, "Monto de apuesta inválido.");
                }
            }
        }
        // Al final del turno, se muestra el dinero en el pote
        JOptionPane.showMessageDialog(null, "Dinero en el pote: $" + pote);
    }
    // Método privado para ingresar el monto de apuesta
    private int ingresarMontoApostado() {
        int montoApostado = -1;
        // Se solicita al jugador que ingrese el monto de apuesta
        while (montoApostado < apuestaMinima || montoApostado > dinero || montoApostado > pote) {
            montoApostado = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el monto de apuesta (debe ser mayor que 0, menor o igual a tu dinero y al dinero en el pote):"));
        }
        return montoApostado;
    }
    // Método para obtener el nombre del jugador
    public String getNombre() {
        return nombre;
    }
    // Método para obtener la cantidad de dinero del jugador
    public int getDinero() {
        return dinero;
    }
    // Método para que el jugador gane una apuesta
    public void ganarApuesta(int monto) {
        dinero += monto; // Se incrementa el dinero del jugador
        pote -= monto;  // Se reduce el dinero en el pote
    }
    // Método para que el jugador pierda una apuesta
    public void perderApuesta(int monto) {
        dinero -= monto; // Se reduce el dinero del jugador
        pote += monto;   // Se incrementa el dinero en el pote
    }
    // Método estático para verificar si el juego continúa
    public static boolean juegoContinua(Jugador[] jugadores) {
        for (Jugador jugador : jugadores) {
            if (jugador.dinero > 0) {
                return true; // Si al menos un jugador tiene dinero, el juego continúa
            }
        }
        return false; // Si ninguno de los jugadores tiene dinero, el juego ha terminado
    }
}
