

package all;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.List;
import java.util.concurrent.Callable;

/*
 Esta clase se encarga de contar las palabras en el contenido del documento, tanto de forma secuencial como concurrente.
*/
public class WordCounter {
    private String content;
    private ExecutorService executor;

    public WordCounter(String content, ExecutorService executor) {
        this.content = content;
        this.executor = executor;
    }

    public int countWordsSequentially() {
        // Dividir el contenido en palabras utilizando espacios en blanco como delimitador.
        String[] words = content.split("\\s+");

        // Contar el número de palabras.
        return words.length;
    }

    public int countWordsConcurrently() {
    // Dividir el contenido en palabras utilizando espacios en blanco como delimitador.
    String[] words = content.split("\\s+");

    // Dividir las palabras en partes para procesamiento paralelo.
    int numThreads = 4; // Número de hilos a utilizar.
    int partSize = words.length / numThreads;
    List<Callable<Integer>> tasks = new ArrayList<>(); // Corrección aquí.

    for (int i = 0; i < numThreads; i++) {
        final int start = i * partSize;
        final int end = (i == numThreads - 1) ? words.length : (i + 1) * partSize;
        tasks.add(() -> countWordsInRange(words, start, end));
    }

    try {
        List<Future<Integer>> results = executor.invokeAll(tasks);

        // Sumar los resultados de los hilos.
        int totalWordCount = 0;
        for (Future<Integer> result : results) {
            totalWordCount += result.get();
        }
        return totalWordCount;
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
        return 0;
    }
}

    private int countWordsInRange(String[] words, int start, int end) {
    int count = 0;
    for (int i = start; i < end; i++) {
        // Verifica que la palabra no esté vacía (puede haber espacios en blanco).
        if (!words[i].isEmpty()) {
            count++;
        }
    }
    return count;
}

}

