
package matrizyhilos;


public class hilos extends Thread{
    private int[] matriz;
    private int inicio;
    private int fin;

    // Constructor que recibe la matriz y los índices inicial y final
    public hilos(int[] matriz, int inicio, int fin) {
        this.matriz = matriz;
        this.inicio = inicio;
        this.fin = fin;
    }
    @Override
    public void run() {
        for (int i = inicio; i <= fin; i++) {
            matriz[i] *= 2; // Multiplica cada elemento por 2
        }}
        
}
 

