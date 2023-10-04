
package logica;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class interfaz extends JFrame implements ActionListener{
    private AtomicReference<String> primerLugar = new AtomicReference<>(null);
    private JLabel animal1; // Declarar animal1 como campo de clase
    private JLabel animal2; // Declarar animal2 como campo de clase
    private JLabel animal3; // Declarar animal3 como campo de clase
    private JButton btnIniciar;
    
    public interfaz(){
      setSize(900,350);
      getContentPane().setLayout(null);
      setLocationRelativeTo(null);
      
      
      animal1 = new JLabel("");
      animal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pantera.png")));
      animal1.setFont(new Font("Roboto",Font.PLAIN,30));
      animal1.setBounds(47,10,137,45);
      getContentPane().add(animal1);
      
      animal2 = new JLabel("");
      animal2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lobo.png")));
      animal2.setFont(new Font("Roboto",Font.PLAIN,30));
      animal2.setBounds(47,100,137,45);
      getContentPane().add(animal2);
      
      animal3 = new JLabel("");
      animal3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pantera.png")));
      animal3.setFont(new Font("Roboto",Font.PLAIN,30));
      animal3.setBounds(47,200,137,45);
      getContentPane().add(animal3);
   
      btnIniciar = new JButton("Start");
      btnIniciar.setBounds(320, 270, 89, 23);
      btnIniciar.addActionListener(this);
      getContentPane().add(btnIniciar);
      
      setVisible(true);//
    }

@Override
    public void actionPerformed(ActionEvent e) {
        btnIniciar.setEnabled(false);
        
        animal1.setLocation(0, animal1.getLocation().y);
        animal2.setLocation(0, animal2.getLocation().y);
        animal3.setLocation(0, animal3.getLocation().y);

        // Crear y ejecutar hilos de carrera con nombres descriptivos
        carrera panteraThread = new carrera(animal1, 10, 800, primerLugar, "Pantera");
        carrera loboThread = new carrera(animal2, 15, 800, primerLugar, "Lobo");
        carrera otroAnimalThread = new carrera(animal3, 12, 800, primerLugar, "Otro Animal");

        panteraThread.start();
        loboThread.start();
        otroAnimalThread.start();
    Thread esperaTerminar = new Thread(() -> {
            try {
                panteraThread.join();
                loboThread.join();
                otroAnimalThread.join();
                mostrarResultado(); // Mostrar resultado después de que todos los animales terminen
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        });

        esperaTerminar.start(); // Iniciar el hilo para esperar a que todos terminen
    }
    
 private void mostrarResultado() {
        // Imprimir el resultado aquí
        btnIniciar.setEnabled(true);
 }


}
