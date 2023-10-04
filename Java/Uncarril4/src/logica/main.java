/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Random;

public class main {
    public static void main(String[] arg){
        
        Random num = new Random();
        int numm = 15;
        interfaz ventan = new interfaz();
        ventan.setVisible(true);
        
        for(int i = 0; i < numm; i++ ){
            carros h = new carros(i, ventan);  // Crear el hilo
            System.out.println("Hlos generados: " + carros.getWaitingThreadsCount()); // Mostrar cuántos hilos esperan ejecutarse

            int numAleatorio = num.nextInt(9); 
            if(numAleatorio % 2 == 0){
                h.start(); // Iniciar el hilo
            }else{
                h.start(); // Iniciar el hilo
            }
        }
    }
}