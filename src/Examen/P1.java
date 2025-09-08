package Examen;

//1.	El problema de los Sumandos y Factores. (Además para cada uno de ellos hacer un ejercicio adicional, interesante)

import java.util.LinkedList;

public class P1 {
    public static int c = 0;
    public static void main(String[] args) {
        LinkedList<Integer> L1 = new LinkedList<Integer>();
        int max = 10;
        sumandos(L1,max,1);
        //factores(L1,10,2);
        
    }

    public static void sumandos(LinkedList<Integer> L1, int n, int i) {
        int sum=suma(L1);
        if (sum > n) return;
        if (sum == n) {
           //if(todosCuadrados(L1)){ //Tambien todos distintos
            System.out.println(L1);
            c++;
            //}
            return;
        }
        int k=i;
        while(k <= n){
            L1.add(k);
            sumandos(L1,n,k);
            L1.removeLast();
            k++;
        }  
    }
     
    public static void factores(LinkedList<Integer> L1, int n, int i) {
        int sum=factor(L1);
        if (sum > n) return;
        if (sum == n) {
            //if(todosPares(L1)){ //o todos diferentes
            System.out.println(L1);
            c++;
            //}
            return;
        }
        int k=i;
        while(k <= n){
            L1.add(k);
            factores(L1,n,k);
            L1.removeLast();
            k++;
        }  
    }
    
    
    
    //auxiliares
    
    public static int suma(LinkedList<Integer> L1){
        int s=0;
        for(int x : L1){
            s+=x;
        }
        return s;
    }
    
    public static int factor(LinkedList<Integer> L1){
        int s=1;
        for(int x : L1){
            s*=x;
        }
        return s;
    }
    
    public static boolean todosIguales(LinkedList<Integer> L1){
        /*if (L1.isEmpty()) return true; //Lista vacia
        int primero = L1.getFirst();
        for (int x : L1){
            if (x != primero) return false;
        }
        return true;*/
        return L1.stream().distinct().count()<=1;
    }
    
    public static boolean todosDistintos(LinkedList<Integer> L1){
        /*HashSet<Integer> set = new HashSet<Integer>();
        for (int x : L1){
            if (!set.add(x)) return false;
        }
        return true;*/
        return L1.stream().distinct().count() == L1.size();
    }
    
    public static boolean todosPares(LinkedList<Integer> L1){
        for( int x : L1){
            if(!(x%2==0)) return false;
        }
        return true;
        //return L1.stream().allMatch(x -> x % 2 == 0);
    }
    
    public static boolean todosImpares(LinkedList<Integer> L1){
        return L1.stream().allMatch(x -> x % 2 == 1);
    }
    
    public static boolean todosCuadrados(LinkedList<Integer> L1){
        for(int x : L1){
            if(x<0) return false;
            int r = (int) Math.sqrt(x);
            if( r * r != x) return false;
        }
        return true;
    }
}
