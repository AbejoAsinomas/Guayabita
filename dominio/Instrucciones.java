package com.alejomarquez.guayabita.dominio;


import javax.swing.*;

public class Instrucciones {
    public static void mostrarInstrucciones() {
        ImageIcon icon = new ImageIcon("C:\\Users\\Alejo\\IdeaProjects\\untitled\\src\\com\\alejomarquez\\guayabita\\dominio\\imagenes_dados\\GuayabaP.png");
        JOptionPane.showMessageDialog(null, "Instrucciones del Juego de la Guayabita:\n\n"
                        + "1. Selecciona el número de jugadores y el valor mínimo de apuesta inicial.\n"
                        + "2. Cada jugador comienza con el pote inicial distribuido entre ellos.\n"
                        + "3. Los jugadores se turnan para lanzar el dado.\n"
                        + "4. Si sacan un 1 o un 6, pierden la posibilidad de apostar y ceden el turno.\n"
                        + "5. Si sacan un número del 2 al 5, pueden optar por apostar por el pote.\n"
                        + "6. Si apuestan, lanzan el dado nuevamente y comparan el resultado.\n"
                        + "7. Si el nuevo resultado es mayor, ganan la apuesta; de lo contrario, la pierden.\n"
                        + "8. El juego continúa hasta que ya no quede dinero en el pote.\n"
                        + "9. El jugador con dinero restante al final del juego gana.", "Guayabita",
                JOptionPane.ERROR_MESSAGE, icon);
    }
}

