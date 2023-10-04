/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CarroDe extends JPanel {
    private Color colorCarro; // Color aleatorio para el carro

    public CarroDe() {
        setOpaque(false); // Hace que el panel sea transparente
        generarColorAleatorio();
    }

    private void generarColorAleatorio() {
        Random rand = new Random();
        int r = rand.nextInt(256); // Componente rojo (0-255)
        int g = rand.nextInt(256); // Componente verde (0-255)
        int b = rand.nextInt(256); // Componente azul (0-255)
        colorCarro = new Color(r, g, b);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuja el carrito con el color aleatorio
        g.setColor(colorCarro);

        // Dibuja el carrito
        g.fillRect(20, 50, 60, 20); // Cuerpo del carro
        g.fillRect(25, 30, 50, 20); // Techo del carro

        // Dibuja las ruedas del carrito
        g.setColor(Color.BLACK); // Cambia el color a negro
        g.fillOval(30, 70, 20, 20); // Rueda izquierda
        g.fillOval(60, 70, 20, 20); // Rueda derecha
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Carro con Color Aleatorio");
        CarroDe carroDe = new CarroDe();

        frame.add(carroDe);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


