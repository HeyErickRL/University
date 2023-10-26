
package all;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;
import javax.swing.JFileChooser;
/*
Clase para la interfaz grafica
*/

public class WordCountGUI extends JFrame{
    private JLabel secuencialLabel;
    private JLabel forkJoinLabel;
    private JLabel executorLabel;
    private ExecutorService executor = Executors.newFixedThreadPool(4); // Crear un ExecutorService con 4 hilos.

    public WordCountGUI(){
    setSize(700,500);
    setTitle("Counter Words");
    setLayout (null);
    
        JTextArea area1 = new JTextArea();
        JScrollPane scrollPane1 = new JScrollPane(area1);
        scrollPane1.setBounds(10, 15, 450, 100);
        scrollPane1.setBackground(Color.WHITE);
        scrollPane1.setForeground(Color.BLACK);
        scrollPane1.setFont(new Font("Poppins", Font.PLAIN, 18));
        add(scrollPane1);

        JTextArea area2 = new JTextArea();
        JScrollPane scrollPane2 = new JScrollPane(area2);
        scrollPane2.setBounds(10, 150, 450, 100);
        scrollPane2.setBackground(Color.WHITE);
        scrollPane2.setForeground(Color.BLACK);
        scrollPane2.setFont(new Font("Arial", Font.PLAIN, 18));
        add(scrollPane2);
        
        secuencialLabel = new JLabel("MergeSort Time: ");
        secuencialLabel.setBounds(10, 370, 200, 20);
        add(secuencialLabel);

        forkJoinLabel = new JLabel("Fork/Join Time: ");
        forkJoinLabel.setBounds(250, 370, 200, 20);
        add(forkJoinLabel);

        executorLabel = new JLabel("Executor Time: ");
        executorLabel.setBounds(500, 370, 200, 20);
        add(executorLabel);
        
        JButton btnLoadTxt;
        btnLoadTxt = new JButton("Cargar Archivo");
        btnLoadTxt.setBounds(550,15,100,50);
        btnLoadTxt.setBackground(Color.decode("#4787F7"));
        btnLoadTxt.setForeground(Color.WHITE);
        add(btnLoadTxt);        
            btnLoadTxt.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        
        // Establece el directorio inicial del cuadro de diálogo.
        fileChooser.setCurrentDirectory(new File("."));
        
        int result = fileChooser.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            
            // Lee el contenido del archivo seleccionado.
            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    content.append(line).append("\n");
                }
                
                // Muestra el contenido en el JTextArea.
                area1.setText(content.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
                        }
                    }
                }
            });
              
        JButton btnCountWords;
        btnCountWords = new JButton("Executor");
        btnCountWords.setBounds(500, 400, 100, 50);
        btnCountWords.setBackground(Color.decode("#4787F7"));
        btnCountWords.setForeground(Color.WHITE);
        add(btnCountWords);
        // Suponiendo que tienes un botón "Contar palabras" (btnCountWords) en tu interfaz.
        btnCountWords.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        String content = area1.getText(); // Obtén el contenido del JTextArea.
        
        // Crea una instancia de WordCounter y mide el tiempo.
        long startTime = System.nanoTime();
        WordCounter wordCounter = new WordCounter(content, executor);
        int wordCount = wordCounter.countWordsConcurrently();
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        
        // Muestra el resultado y el tiempo en la interfaz.
        area2.setText("Número de palabras (Executor): " + wordCount);
        executorLabel.setText("Executor Time: " + elapsedTime + " nn");
            }
        });
    
        JButton btnForkJoin;
        btnForkJoin = new JButton("Fork/Join");
        btnForkJoin.setBounds(250,400,100,50);
        btnForkJoin.setBackground(Color.decode("#4787F7"));
        btnForkJoin.setForeground(Color.WHITE);
        add(btnForkJoin);
        btnForkJoin.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String content = area1.getText(); // Obtén el contenido del JTextArea.

            // Crea una instancia de WordCounterForkJoin y mide el tiempo.
            long startTime = System.nanoTime();
            ForkJoinPool forkJoinPool = new ForkJoinPool(); // Puedes crear un ForkJoinPool específico aquí.
            WordCounterForkJoin wordCounter = new WordCounterForkJoin(content, forkJoinPool);
            int wordCount = wordCounter.countWordsConcurrently();
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;

            // Muestra el resultado y el tiempo en la interfaz.
            area2.setText("Número de palabras (Fork/Join): " + wordCount);
            forkJoinLabel.setText("Fork/Join Time: " + elapsedTime + " nn");
        }
    });
        JButton btnSecuencial;
        btnSecuencial = new JButton("Sequencial");
        btnSecuencial.setBounds(10,400,100,50);
        btnSecuencial.setBackground(Color.decode("#4787F7"));
        btnSecuencial.setForeground(Color.WHITE);
        add(btnSecuencial);
        btnSecuencial.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String content = area1.getText(); // Obtén el contenido del JTextArea.

        // Crea una instancia de WordCounterSequential y mide el tiempo.
        long startTime = System.nanoTime();
        WordCounterSequential wordCounter = new WordCounterSequential(content);
        int wordCount = wordCounter.countWordsSequentially();
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        // Muestra el resultado y el tiempo en la interfaz.
        area2.setText("Número de palabras (Secuencial): " + wordCount);
        secuencialLabel.setText("Secuencial Time: " + elapsedTime + " nn");
    }
});
            JButton buton2;
        buton2 = new JButton("Limpiar");
        buton2.setBounds(550,150,100,50);
        buton2.setBackground(Color.decode("#4787F7"));
        buton2.setForeground(Color.WHITE);
        add(buton2);
        buton2.addActionListener(new ActionListener() {
        @Override
    public void actionPerformed(ActionEvent e) {
            
        // Limpiar el contenido de ambas áreas
        area1.setText("");
        area2.setText("");
        
        
                }
        });
        setVisible(true);
}}
