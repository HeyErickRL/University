
package logica;
//Cuarta prueba SIN SEMAFOROS, ahora con Variables Condicionales
//Se utilizan variables condicionales para mantener el orden de los carros e hilos que estan entrando al "carril", lo que ocasiona que
//este metodo de sincronizacion mantenga el orden de los dos puntos "estrategicos" del carril, osea izquierda y derecha.
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;


public class carros extends Thread {
    int n;
    private static final int MAX_HILOS = 10;

    //Aqui esta la parte importante de la condicion que se maneja
    //Lock representa el bloqueo y las condiciones del carril de la variable esperando para determinar si se puede avanzar
    private static final Lock lock = new ReentrantLock();
    //cond representa que se cumpla la condicion para liberar el candado
    private static final Condition cond = lock.newCondition();

    private interfaz inte;
    //cantidad de hilos que están esperando su turno para moverse.
    private static int Esperando = 0;

    public carros(int n, interfaz inte) {
        this.n = n;
        this.inte = inte;
        lock.lock();
        Esperando++;
        lock.unlock();
    }

    @Override
    public void run() {
        lock.lock();
        Esperando--;
        //System.out.println("Estan esperando: " + Esperando);
        lock.unlock();

        while (true) {
            int numAleatorio = new Random().nextInt(9); // Generar un nuevo número aleatorio en cada iteración

            if (numAleatorio % 2 == 0) {
                try {
                    izquierda();
                } catch (InterruptedException ex) {
                    Logger.getLogger(carros.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    derecha();
                } catch (InterruptedException ex) {
                    Logger.getLogger(carros.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void izquierda() throws InterruptedException {
        lock.lock();
        while (Esperando >= MAX_HILOS) {
            cond.await();
        }

        inte.animarCarritoDerecha();
        System.out.println("El carro esta quemando llanta a la izquierda" + n);
        Esperando++;
        cond.signalAll();
        lock.unlock();
    }

    public void derecha() throws InterruptedException {
        lock.lock();
        while (Esperando >= MAX_HILOS) {
            cond.await();
        }

        inte.animarCarritoIzquierda();
        System.out.println("El otro carro esta quemando llanta a la derecha" + n);
        Esperando++;
        cond.signalAll();
        lock.unlock();
    }

    public static int getWaitingThreadsCount() {
        return Esperando;
    }
}
