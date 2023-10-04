/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package all;

import static all.main.vacia;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



/*public class Hilos extends Thread {
    private static final int MIN_SIZE = 10;
    private static final int MAX_SIZE = 30;
    private List<Integer> canasta;
    private static Lock lock = new ReentrantLock();
    private static Lock accessLock = new ReentrantLock();
    private String threadType;
private static Semaphore semaphore = new Semaphore(1);
    public Hilos(String threadType, List<Integer> canasta) {
        this.threadType = threadType;
        this.canasta = canasta;
    }

    @Override
    public void run() {
        if (threadType.equals("Productor")) {
            // Lógica para el hilo Productor
            Random random = new Random();

            while (true) {
                // Verificar si la canasta está vacía y rellenarla
                if (canasta.isEmpty()) {
                    int canastaSize = random.nextInt(MAX_SIZE - MIN_SIZE + 1) + MIN_SIZE;
                    System.out.println("Productor rellenó la canasta con un tamaño de: " + canastaSize);

                    for (int i = 0; i < canastaSize; i++) {
                        int randomNumber = random.nextInt(50) + 1;
                        canasta.add(randomNumber);
                    }

                    System.out.println("Productor llenó la canasta: " + canasta);
                }

                semaphore.release(); // Permitir que un Consumidor acceda
            }
        } else {
            // Lógica para los hilos Consumidores
            while (true) {
                try {
                    semaphore.acquire(); // Esperar hasta que se permita el acceso
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (canasta) {
                    try {
                        while (canasta.isEmpty()) {
                            System.out.println("Consumidor " + getId() + " encontró la canasta vacía. Esperando...");
                            canasta.wait();
                        }

                        // Acceder a la canasta y procesar un elemento
                        int removedNumber = canasta.remove(0);
                        System.out.println("Consumidor " + getId() + " removió el número: " + removedNumber);
                        canasta.notifyAll(); // Notificar al Productor que la canasta está vacía
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } 
    }}}
*/

class Hilos extends Thread {
    
    private static final int MIN_SIZE = 10;
    private static final int MAX_SIZE = 30;
    private List<Integer> canasta;
    private Semaphore productorSemaphore;
    private String threadType;
    private static int consumidorIndex = 1;

    public Hilos(String threadType, List<Integer> canasta, Semaphore productorSemaphore) {
        this.threadType = threadType;
        this.canasta = canasta;
        this.productorSemaphore = productorSemaphore;
    }

    @Override
    public void run() {
        if (threadType.startsWith("Consumidor")) {
            // Lógica para los hilos Consumidores
            while (true) {
                try {
                    synchronized (canasta) {
                        while (canasta.isEmpty()) {
                            if(vacia){
                            System.out.println(threadType + " encontró la canasta vacía. Esperando...");
                            vacia = false;
                            }else{}
                            
                            //vacia = false;
                            canasta.wait();
                        }

                        // Acceder a la canasta y procesar un elemento
                        int removedNumber = canasta.remove(0);
                        System.out.println(threadType + " removió el número: " + removedNumber);
                        canasta.notifyAll(); // Notificar al Productor que la canasta está vacía

                        // Incrementar el índice del consumidor y dormir
                        consumidorIndex++;
                        if (consumidorIndex > 8) {
                            consumidorIndex = 1; // Volver al primer consumidor
                            Thread.sleep(1000); // Esperar un tiempo antes de comenzar de nuevo
                        } else {
                            Thread.sleep(1000); // Esperar un tiempo entre consumidores
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (threadType.equals("Productor")) {
            // Lógica para el hilo Productor
            Random random = new Random();

            while (true) {
                synchronized (canasta) {
                    // Verificar si la canasta está vacía y rellenarla
                    if (canasta.isEmpty()) {
                        int canastaSize = random.nextInt(MAX_SIZE - MIN_SIZE + 1) + MIN_SIZE;
                        System.out.println("");
                        System.out.println("Productor rellenó la canasta con un tamaño de: " + canastaSize);

                        for (int i = 0; i < canastaSize; i++) {
                            int randomNumber = random.nextInt(50) + 1;
                            canasta.add(randomNumber);
                        }

                        System.out.println("Productor llenó la canasta: " + canasta);
                        canasta.notifyAll(); // Notificar a los Consumidores que la canasta está llena
                    }
                }
            }
        }
    }
}