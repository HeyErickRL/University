
package all;

//hacer una carrera que calcule la velocidad y tiempo al que llega cada animal, investigar
//imprimir lo que va recorriendo por segundo
//cuando llegue a la meta debe recorrer 800metros como limite
//*EL raton llego a la meta* Pero los demas deben seguir corriendo hasta que cumplan los 800 metros

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Limite de 2:00 minutos
public class Interfaz extends JFrame implements ActionListener{
   private JLabel label;
   private JButton btnIniciar;
   private JButton btnDetener;
   private Cronometro cronometro;
  
   
   int hora=0; 
   int minutos=0;
   int segundos=0;
   int limite= 0;
   
   boolean startHilo=true;
   boolean corriendo=false;
   
   public Interfaz(){
      initialize();
      setSize(250,120);
      getContentPane().setLayout(null);
      setLocationRelativeTo(null);
      setVisible(true);
   }
   
   private void initialize(){
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   label = new JLabel("00:00:00");
   label.setFont(new Font("Roboto",Font.PLAIN,30));
   label.setBounds(47,11,137,45);
   getContentPane().add(label);
   
   btnIniciar = new JButton("Start");
   btnIniciar.setBounds(20, 54, 89, 23);
   btnIniciar.addActionListener(this);
   getContentPane().add(btnIniciar); // 

    btnDetener = new JButton("Stop");
    btnDetener.setBounds(119, 54, 89, 23);
    btnDetener.addActionListener(this);
    getContentPane().add(btnDetener); // 

   }
   
  @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIniciar) {
            // Iniciar el boton
            if (!corriendo) {
            corriendo = true;
            startHilo = true;
            updateLabel(0); // iniciar la etiqueta en 00:00:00
            cronometro = new Cronometro(this); // inicializamos el hilo
            cronometro.start();
                
            }
        } else if (e.getSource() == btnDetener) {
            // Detener el boton
            if (corriendo) {
                corriendo = false;
                startHilo = false;
                
            }
        } 
        //buton17.setBackground(Color.GRAY);
        //buton17.setForeground(Color.WHITE);
     
}
    public void updateLabel(int segundos) {
        //Para calcular las horas, se debe dividir los segundos que esta registrando el "label" para despues ser divididos por 3600 (1hora)
       int horas = segundos / 3600;
       //Para obtener los minutos es necesario sacar el modulo de los segundos registrados sobre la (3600) hora y dividirlo entre 60(1 minuto)
       int minutos = (segundos % 3600) / 60;
       //Obtener los segundos restantes despues de "eliminar" las horas y minutos
       segundos %= 60;

       String tiempo = String.format("%02d:%02d:%02d", horas, minutos, segundos);
       label.setText(tiempo);
   }

   public boolean isRunning() {
       return startHilo;
   }
}
       
           
       


   

