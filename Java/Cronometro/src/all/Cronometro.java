
package all;

import javax.swing.SwingUtilities;


public class Cronometro extends Thread {
   private Interfaz interfaz; // Referencia a la interfaz
    
    public Cronometro(Interfaz interfaz) {
        this.interfaz = interfaz;
    }
    
    
    public void run() {
    int segundos = 0;
//While para mantener el registro de segundos activo mientras el boton "Start" ese inicializado
    while (interfaz.isRunning()) {
        try {
            final int segundosFinal = segundos;
            Thread.sleep(100); // Esperar 1 segundo
            segundos++;

            // Actualizar la etiqueta en la interfaz gráfica usando SwingUtilities.invokeLater
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
//updateLabel(segundosFinal) de la instancia de Interfaz, donde segundosFinal es una variable final que almacena el valor actual de segundos.
                    interfaz.updateLabel(segundosFinal); // Usar la variable final efectivamente
                }
            });

            // Verificar si han pasado 2 minutos (120 segundos) y detener el cronómetro
            if (segundos >= 120) {
                interfaz.corriendo = false; // Detener el cronómetro
                interfaz.startHilo = false;
                break; // Salir del bucle
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
}

