
package all;

import javax.swing.JFrame;

/*Esta clase es la entrada principal de la aplicación que inicia la interfaz de usuario y coordina las otras clases. No se muestra aquí,
ya que mencionaste que tendrás una interfaz gráfica, pero es el punto de entrada principal.*/
public class WordCountApp {
    public static void main(String arg[]){
        WordCountGUI interfaz = new WordCountGUI();
        interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
