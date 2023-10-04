
package logica;

import static java.lang.Thread.sleep;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class carrera extends Thread {
    private JLabel animalLabel;
    private int velocidad;
    private int metros;
    private AtomicReference<String> primerLugar;
    private String nombreAnimal;
    
    public carrera(JLabel animalLabel, int velocidad, int metros,  AtomicReference<String> primerLugar, String nombreAnimal) {
        this.animalLabel = animalLabel;
        this.velocidad = velocidad;
        this.metros = metros;
        this.primerLugar = primerLugar;
        this.nombreAnimal = nombreAnimal;
    }

    
    

    @Override
    public void run() {
        while (animalLabel.getLocation().x < metros) {
            try {
                sleep((int) (Math.random() * 1000));
                int currentX = animalLabel.getLocation().x;
                animalLabel.setLocation(currentX + velocidad, animalLabel.getLocation().y);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        if (animalLabel.getLocation().x >= metros) {
            // Verificar si es el primer lugar y actualizar si es necesario
            if (primerLugar.compareAndSet(null, nombreAnimal)) {
                System.out.println("El " + nombreAnimal + " ganó la carrera.");
            } else {
                // Verificar si es el segundo lugar y actualizar si es necesario
                if (primerLugar.compareAndSet(null, nombreAnimal)) {
                    System.out.println("El " + nombreAnimal + " llegó en segundo lugar.");
                } else {
                    System.out.println("El " + nombreAnimal + " llegó en tercer lugar.");
                }
            }
        }
    }
}
