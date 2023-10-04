/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcu;

/**
 *
 * @author zZzer
 */
public class Operaciones {
    public interface operacion{
    public int suma(int a,int b);
    public int resta (int c, int d); 
    public int multi(int e, int f);
    public int division(int g, int h);
    public int potencia(int i, int j);
    public int modulo(int k, int l);
}

public class implementacion implements operacion{
    
        public int suma(int a, int b){
        return a+b;
    }

        @Override
        public int resta(int c, int d) {
           return c-d;
        }

        @Override
        public int multi(int e, int f) {
             return e*f;
        }
        @Override
        public int division(int g, int h){
            return g/h;
        }
        @Override
        public int potencia(int i, int j){
        int b = i;
        for(int p=1;p<j;i++){
        b *= i;
        }
        return b;
        }
        @Override
        public int modulo(int k, int l){
        return k%l;
        }
    }
}
