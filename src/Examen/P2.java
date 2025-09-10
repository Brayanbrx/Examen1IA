package Examen;
 //2. El problema de la Mochila. (Además, implementar para Objetos con varios atributos)
import java.util.LinkedList;
import java.util.Arrays;

public class P2 {
    public static int c = 0;
    public static void main(String[] args) {
        /*LinkedList<Integer> L1 = new LinkedList<Integer>(Arrays.asList(1,3,5,7,10));
        LinkedList<Integer> L2 = new LinkedList<Integer>(); */
        LinkedList<Objeto> L1 = new LinkedList<Objeto>();
        LinkedList<Objeto> L2 = new LinkedList<Objeto>();
        L1.add(new Objeto(1,"Rojo"));
        L1.add(new Objeto(3,"Verde"));
        L1.add(new Objeto(5, "Amarillo"));
        L1.add(new Objeto(7, "Cafe"));
        int n = 10;
        mochila2(L1,L2,n,0);
        
    }

    public static void mochila(LinkedList<Integer> L1, LinkedList<Integer> L2, int n, int i) {
        int sum = suma(L2);
        if (sum <= n ){
            //if(todosDiferentes(L2)){
            System.out.println(L2);
            c++;
            //}
        }
        int k = i;
        while (k < L1.size()){
            L2.add(L1.get(k));
            mochila(L1,L2,n, k+1);
            L2.removeLast();
            k++;
        }
    }
    
        public static void mochila2(LinkedList<Objeto> L1, LinkedList<Objeto> L2, int n, int i) {
        int sum = sumaPeso(L2);
        if (sum <= n ){
            //if(todosDiferentes(L2)){
            System.out.println(L2);
            c++;
            //}
        }
        int k = i;
        while (k < L1.size()){
            L2.add(L1.get(k));
            mochila2(L1,L2,n, k+1);
            L2.removeLast();
            k++;
        }
    }

    
    
    public static int suma(LinkedList<Integer> L1) {
        int c = 0;
        for (int x : L1){
            c+=x;
        }
        return c;
        //return L1.stream().mapToInt(Integer::intValue).sum();
    }
    
    public static int sumaPeso(LinkedList<Objeto> L1){
        int c = 0;
        for (Objeto x : L1){
            c += x.peso;
        }
        return c;
    }
    
    public static class Objeto{
        int peso;
        String color;

        public Objeto(int peso, String color) {
            this.peso = peso;
            this.color = color;
        }

        @Override
        public String toString() {
            return "MochilaOb{" + "peso=" + peso + ", color=" + color + '}';
        }
        
    }
}
