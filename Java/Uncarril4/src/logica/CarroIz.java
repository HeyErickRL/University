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


public class CarroIz extends JPanel {

    public CarroIz() {
       setOpaque(false); // Hace que el panel sea transparente
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Dibuja el carrito
    g.setColor(new Color(255, 0, 0)); // Cambia el color a rojo
    g.fillRect(20, 50, 60, 20); // Cuerpo del carro
    g.fillRect(25, 30, 50, 20); // Techo del carro

    // Dibuja las ruedas del carrito
    g.setColor(new Color(0, 0, 0)); // Cambia el color a negro
    g.fillOval(30, 70, 20, 20); // Rueda izquierda
    g.fillOval(60, 70, 20, 20); // Rueda derecha
}}