/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package all;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;


/*public class main {
    public static void main(String[] args) {
        int consumidores = 8;
        List<Integer> canasta = new ArrayList<>(); // Shared canasta between threads
        Hilos[] hilosArray = new Hilos[consumidores]; // Create an array of Hilos

        // Create and start each thread in a loop
        for (int i = 0; i < consumidores; i++) {
            Hilos consumidor = new Hilos("Consumidor", canasta);
            consumidor.start();
            try {
                Thread.sleep(1000); // Add a small delay between starting threads
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Hilos productor = new Hilos("Productor", canasta); // Provide threadType and canasta
        productor.start();
    
    }
}*/
public class main {
    
    public static boolean vacia=true;
    
    public static void main(String[] args) {
        int numConsumidores = 8;
        List<Integer> canasta = new ArrayList<>(); // Canasta compartida entre los hilos
        Semaphore productorSemaphore = new Semaphore(1); // Semaphore para el productor

        // Crear y arrancar los consumidores en un orden específico
        for (int i = 1; i <= numConsumidores; i++) {
            Hilos consumidor = new Hilos("Consumidor " + i, canasta, productorSemaphore);
            consumidor.start();
        }

        // Crear y arrancar el productor
        Hilos productor = new Hilos("Productor", canasta, productorSemaphore);
        productor.start();
    }
}
