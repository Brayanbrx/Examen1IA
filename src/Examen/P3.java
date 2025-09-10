package Examen;
  //3. El problema de Combinaciones, Permutaciones. (Además implementar una aplicación cualquiera del práctico
import java.util.LinkedList;

public class P3 {
    
    public static int c = 0;
    public static void main(String[] args) {
        LinkedList<Integer> L1 = new LinkedList<Integer>();
        LinkedList<Integer> L2 = new LinkedList<Integer>();
        L1.add(1);
        L1.add(3);
        L1.add(5);
        L1.add(7);
        L1.add(9);
        
        
        int r=4;
        permSR(L1, L2, L1.size(), r, 0);
        
        
    }
    public static void combiSR(LinkedList<Integer> L1, LinkedList<Integer> L2, int n, int r, int i){
        if(L2.size() == r){
            System.out.println(L2);
            c++;
            return;
        }
        int k=i;
        while(k < L1.size()){
            L2.add(L1.get(k));
            combiSR(L1,L2,n,r,k+1);
            //combiCR(L1,L2,n,r,k); CR solo k
            L2.removeLast();
            k++;
        }
    }
    
    //combiCR ejemplo de lanzar 2 dados.
    //permSR posibles maneras de mezclar 4 numeros
    
    public static void permSR(LinkedList<Integer> L1, LinkedList<Integer> L2, int n, int r, int i){
        if(L2.size() == r){
            System.out.println(L2);
            c++;
            return;
        }
        int k = 0; //perm K = 0
        while(k < L1.size()){
            if (!L2.contains(L1.get(k))){ //se oculta para CR
                L2.add(L1.get(k));
                permSR(L1,L2,n,r,k+1);
                L2.removeLast();
                //k++; CR
            }            // se oculta para CR
            k++;        // se oculta para CR
        }
    }
    
}
