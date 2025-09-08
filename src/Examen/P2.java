package Examen;
 //2. El problema de la Mochila. (Además, implementar para Objetos con varios atributos)
import java.util.LinkedList;

public class P2 {
    public static int c = 0;
    public static void main(String[] args) {
        /*LinkedList<Integer> L1 = new LinkedList<Integer>();
        LinkedList<Integer> L2 = new LinkedList<Integer>();
        L1.add(1);
        L1.add(3);
        L1.add(5);
        L1.add(7);*/
        LinkedList<Objeto> L1 = new LinkedList<Objeto>();
        LinkedList<Objeto> L2 = new LinkedList<Objeto>();
        L1.add(new Objeto(1,"Rojo"));
        L1.add(new Objeto(3,"Verde"));
        L1.add(new Objeto(5, "Amarillo"));
        L1.add(new Objeto(7, "Cafe"));
        int max = 10;
        mochila2(L1,L2,max,0);
        
    }

    public static void mochila(LinkedList<Integer> L1, LinkedList<Integer> L2, int max, int i) {
        int sum = suma(L2);
        if (sum <= max && !L2.isEmpty()){
            //if(todosDiferentes(L2)){
            c++;
            System.out.println(L2);
            //}
        }
        int k = i;
        while (k < L1.size()){
            L2.add(L1.get(k));
            mochila(L1,L2,max, k+1);
            L2.removeLast();
            k++;
        }
    }
    
        public static void mochila2(LinkedList<Objeto> L1, LinkedList<Objeto> L2, int max, int i) {
        int sum = sumaPeso(L2);
        if (sum <= max && !L2.isEmpty()){
            //if(todosDiferentes(L2)){
            c++;
            System.out.println(L2);
            //}
        }
        int k = i;
        while (k < L1.size()){
            L2.add(L1.get(k));
            mochila2(L1,L2,max, k+1);
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
