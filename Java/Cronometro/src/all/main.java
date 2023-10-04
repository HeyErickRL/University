
package all;

import javax.swing.SwingUtilities;


public class main {
    public static void main(String[]args){
         SwingUtilities.invokeLater(() -> {
            Interfaz cro = new Interfaz();
        });
}}
/*if (segundos >= 120) {
                    interfaz.corriendo = false; // Detener el cronómetro
                    interfaz.startHilo = false;
                    break; // Salir del bucle
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/