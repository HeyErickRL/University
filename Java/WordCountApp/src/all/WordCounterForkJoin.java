/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package all;
/*
Creamos una clase WordCounterForkJoin que utiliza ForkJoinPool y una tarea recursiva WordCountTask para contar palabras de manera concurrente.

La tarea WordCountTask divide el contenido en partes más pequeñas y utiliza la recursión para realizar el 
conteo de palabras. Si la porción es lo suficientemente pequeña (umbral de 1000 en este ejemplo), se cuenta de manera secuencial.

Luego, combinamos los resultados de las partes izquierda y derecha para obtener el resultado final.
*/
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class WordCounterForkJoin {
    private String content;
    private ForkJoinPool forkJoinPool;

    public WordCounterForkJoin(String content, ForkJoinPool forkJoinPool) {
        this.content = content;
        this.forkJoinPool = forkJoinPool;
    }

    public int countWordsConcurrently() {
        WordCountTask wordCountTask = new WordCountTask(content, 0, content.length());
        return forkJoinPool.invoke(wordCountTask);
    }

    private class WordCountTask extends RecursiveTask<Integer> {
        private String content;
        private int start;
        private int end;

        public WordCountTask(String content, int start, int end) {
            this.content = content;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start < 1000) { // Umbral para contar palabras de manera secuencial
                int count = 0;
                String[] words = content.substring(start, end).split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        count++;
                    }
                }
                return count;
            } else {
                int mid = (start + end) / 2;
                WordCountTask leftTask = new WordCountTask(content, start, mid);
                WordCountTask rightTask = new WordCountTask(content, mid, end);
                leftTask.fork();
                int rightResult = rightTask.compute();
                int leftResult = leftTask.join();
                return leftResult + rightResult;
            }
        }
    }
}
