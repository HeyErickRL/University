
package matrizyhilos;

import java.util.Random;


public class matriz {
    public static void main(String args[]){
        int matriz[] = new int[]{2, 4, 5, 2, 1, 3, 7, 8, 1};
        
        /*Random r = new Random();
        int a=3, b=3;
        
        int[][] matriz = new int [a][b];
        
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                matriz[i][j]=r.nextInt(50);
                System.out.println("["+matriz[i][j]+"]");
            }
        }
        */
        //imprimir la primer matriz
        System.out.println("Matriz inicial:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int indice = i * 3 + j; 
                System.out.print("[" +matriz[indice] + "]");
            }
            System.out.println(); // Salto de línea para la siguiente fila
        }
        // Crear hilos
        hilos hilo1 = new hilos(matriz, 0, 4);
        hilos hilo2 = new hilos(matriz, 5, 8);

        // Iniciar hilos
        hilo1.start();
        hilo2.start();
        
            try {
            // Esperar a que ambos hilos terminen
                hilo1.join();
                hilo2.join();
            } catch (InterruptedException e) {
            e.printStackTrace();
            }

        // Imprimir la matriz resultante
        System.out.println("Matriz resultante:");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("[" + matriz[i] + "]");
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
        
}}//Cierre de la clase matriz y del main