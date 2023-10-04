
package logica;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javax.swing.*;
import java.awt.*;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class interfaz extends JFrame {

    private CarroDe carritoDerecha; // Agrega una instancia de carritoderecha
    private CarroIz carritoIzquierda; // Agrega una instancia de carritoderecha

    public interfaz() {
        configurarVentana();


        // Crea una instancia de carritoderecha
        carritoDerecha = new CarroDe();
        carritoIzquierda = new CarroIz();
        this.add(carritoDerecha);
        this.add(carritoIzquierda);
    }

    public void configurarVentana() {
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("QUEMON DE LLANTA");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(300, 300));
    }

    public void animarCarritoDerecha() {
        int nort = -60;
        int y = 250;
        for (int i = 0; i < 45; i++) {
            nort += 15;
            carritoDerecha.setBounds(nort, y, 100, 100);
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void animarCarritoIzquierda() {
        int sur = 600;
        int y = 250;
        for (int i = 0; i < 50; i++) {
            sur -= 15;
            carritoIzquierda.setBounds(sur, y, 100, 100);
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            interfaz ventana = new interfaz();
            ventana.setVisible(true);
        });
    }
}

