/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package all;


public class WordCounterSequential {
    private String content;

    public WordCounterSequential(String content) {
        this.content = content;
    }

    public int countWordsSequentially() {
        // Dividir el contenido en palabras utilizando espacios en blanco como delimitador.
        String[] words = content.split("\\s+");

        // Contar el número de palabras.
        int count = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }

        return count;
    }
}

