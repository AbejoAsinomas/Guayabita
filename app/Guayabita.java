package com.alejomarquez.guayabita.app;


import com.alejomarquez.guayabita.dominio.Instrucciones;
import com.alejomarquez.guayabita.dominio.JuegoGuayabita;

import javax.swing.*;

public class Guayabita {
    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("C:\\Users\\Alejo\\IdeaProjects\\untitled\\src\\com\\alejomarquez\\guayabita\\dominio\\imagenes_dados\\GuayabaP.png");
        JOptionPane.showMessageDialog(null, "Bienvenidx al juego de la guayabita", "Guayabita",
                JOptionPane.ERROR_MESSAGE, icon);
        int opcion = JOptionPane.showOptionDialog(
                null,
                "¿Qué quieres hacer?",
                "Juego 'Guayabita'",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Ver Instrucciones", "Jugar"},
                "Jugar"
        );

        if (opcion == JOptionPane.YES_OPTION) {
            Instrucciones.mostrarInstrucciones();
        } else {
            JuegoGuayabita juego = new JuegoGuayabita();
            juego.iniciarJuego();
        }
    }
}

