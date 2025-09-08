package Examen;

import java.util.HashSet;
import java.util.LinkedList;

public class ExamenUno {

    public static int c = 0;
    public static void main(String[] args) {
        //LinkedList<Integer> L1 = new LinkedList();
        //sumandos(L1,4,1);
        //sumandosImpares(L1,10,1);
        //factores(L1,100,2);
        //System.out.println("Cantidad = " + c);
        
        LinkedList<Integer> L1 = new LinkedList<Integer>();
        LinkedList<Integer> L2 = new LinkedList<Integer>();
        L1.add(1);
        L1.add(3);
        L1.add(5);
        L1.add(7);
        L1.add(9);
        int max = 10;
        mochila(L1,L2,max,0);
        //mochilaAyB(L1,L2,max,0,2);
        
        LinkedList<Objeto> L3 = new LinkedList<Objeto>();
        LinkedList<Objeto> L4 = new LinkedList<Objeto>();
        L3.add(new Objeto(1,2,"Amarillo"));
        L3.add(new Objeto(2,2,"Azul")); 
        L3.add(new Objeto(3,3,"Rojo"));
        L3.add(new Objeto(4,4,"Verde"));
        L3.add(new Objeto(5,5,"Cafe"));
        //mochilaColoresDiferentes(L3, L4, max, 0);
        
        int r=2;
        //combiSR(L1,L2,L1.size(),r,0);
        //combiCR(L1,L2,L1.size(),r,0);
        //permCR(L1,L2,L1.size(),r,0);
        permSR(L1,L2,L1.size(),r,0);
        
        
        System.out.println("Total C = " + c);      
}
    // Auxliares
    public static int suma(LinkedList<Integer> L1){
        int suma = 0;
        for(int x : L1){
            suma += x;
        }
        return suma;
    }
    
    public static int suma2(LinkedList<Integer> L1){
        return L1.stream().mapToInt(Integer::intValue).sum();
    }
    
    public static boolean todosIguales(LinkedList<Integer> L1){
        if (L1.isEmpty()) return true; //Lista vacia
        int primero = L1.getFirst();
        for (int x : L1){
            if (x != primero) return false;
        }
        return true;
    }
    
    public static boolean todosIguales2(LinkedList<Integer> L1){
        return L1.stream().distinct().count() <= 1;
    }
    
    public static boolean todosDiferentes(LinkedList<Integer> L1){
        HashSet<Integer> set = new HashSet<Integer>();
        for (int x : L1){
            if (!set.add(x)) return false;
        }
        return true;
    }
    
    public static boolean todosDiferentes2(LinkedList<Integer> L1){
        return L1.stream().distinct().count() == L1.size();
    }
    
    public static int factor(LinkedList<Integer> L1){
        int f = 1;
        for (int x : L1) {
            f *= x;
        }
        return f;
    }
    
    public static int factor2(LinkedList<Integer> L1){
        return L1.stream().reduce(1, (a, b) -> a * b);
    }
    
    public static boolean esPrimo(int x){
        if (x < 2) return false;
        for (int d = 2; d * d <= x; d++) 
            if (x % d == 0) 
                return false;
    return true;
    }
    
    public static boolean esCuadradoPerfecto(int x){
    if (x < 4) return false;           // 1 no lo usamos como factor
    int r = (int)Math.sqrt(x);
    return r*r == x;
    }
    
    //1. El problema de los Sumandos y Factores. (Además para cada uno de ellos hacer un ejercicio adicional, interesante)
        
    public static void sumandos(LinkedList<Integer> L1, int n, int i) {
        int sum = suma(L1);
        if(sum > n) return;
        if(sum == n){
            System.out.println(L1);
            c++;
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
    
    public static void sumandosIguales(LinkedList<Integer> L1, int n, int i){
        int sum = suma(L1);
        if(sum > n) return;
        if (sum == n){
            if(todosIguales(L1)){
                System.out.println(L1);
                c++;
            }
            return;
        }
        int k=i;
        while (k<=n){
            L1.add(k);
            sumandosIguales(L1,n,k);
            L1.removeLast();
            k++;
        }
    }
    
    public static void sumandosDiferentes(LinkedList<Integer> L1, int n, int i){
        int sum = suma(L1);
        if(sum > n) return;
        if (sum == n){
            if (todosDiferentes(L1)){
                System.out.println(L1);
                c++;
            }
            return;
        }
        int k = i;
        while(k <= n){
            L1.add(k);
            sumandosDiferentes(L1,n,k);
            L1.removeLast();
            k++;
        }
    }
    
    public static void sumandosImpares(LinkedList<Integer> L1, int n, int i) {
        int sum = suma(L1);
        if(sum > n) return;
        if(sum == n){
            System.out.println(L1);
            c++;
            return;
        }
        int k = i;
        while(k <= n){
            if(k % 2 == 1){
                L1.add(k);
                sumandosImpares(L1,n,k);
                L1.removeLast();
            }
            k++;
        }
    }

    public static void factores(LinkedList<Integer> L1, int n, int i) {
        int fact = factor(L1);
        if (fact > n) return;
        if (fact == n){
            System.out.println(L1);
            c++;
            return;
        }
        int k = i;
        while(k <= n){
            L1.add(k);
            factores(L1, n, k);
            L1.removeLast();
            k++;
        }
    }
    
    public static void factoresIguales(LinkedList<Integer> L1, int n, int i) {
        int fact = factor(L1);
        if (fact > n) return;
        if (fact == n){
            if (todosIguales(L1)){
                System.out.println(L1);
                c++;
            } 
            return;
        }
        int k = i;
        while(k <= n){
            L1.add(k);
            factoresIguales(L1, n, k);
            L1.removeLast();
            k++;
        }
    }
    
    public static void factoresDiferentes(LinkedList<Integer> L1, int n, int i) {
        int fact = factor(L1);
        if (fact > n) return;
        if (fact == n){
            if (todosDiferentes(L1)){
                System.out.println(L1);
                c++;
            } 
            return;
        }
        int k = i;
        while(k <= n){
            L1.add(k);
            factoresDiferentes(L1, n, k);
            L1.removeLast();
            k++;
        }
    }
    
    public static void factoresPrimos(LinkedList<Integer> L1, int n, int i) {
        int fact = factor(L1);
        if (fact > n || n % fact != 0) return;
        if (fact == n) { 
            System.out.println(L1); 
            c++; 
            return; 
        }
        int resto = n / fact;
        for (int k = i; k <= resto; k++) {
            if (esPrimo(k) && resto % k == 0) {
                L1.add(k);
                factoresPrimos(L1, n, k);   // no-decreciente
                L1.removeLast();
            }
        }
    }
      
    //2. El problema de la Mochila. (Además, implementar para Objetos con varios atributos)
    public static void mochila (LinkedList<Integer> L1, LinkedList<Integer> L2, int max, int i){
        int sum = suma(L2);
        if (sum <= max){
            c++;
            System.out.println(L2);
        }
        int k = i;
        while (k < L1.size()){
            L2.add(L1.get(k));
            mochila(L1,L2, max, k + 1);
            L2.removeLast();
            k++;
        }
    }
    
    public static void mochilaDiferentes(LinkedList<Integer> L1, LinkedList<Integer> L2, int max, int i){
        int sum = suma(L2);
        if (sum <= max){
            if(todosDiferentes(L2)){
                c++;
                System.out.println(L2);
            }
        }
        int k = i;
        while (k < L1.size()){
            L2.add(L1.get(k));
            mochilaDiferentes(L1,L2, max, k + 1);
            L2.removeLast();
            k++;
        }
    }
    
    public static void mochilaAyB (LinkedList<Integer> L1, LinkedList<Integer> L2, int max, int a, int b){
        int sum = suma(L2);
        if (sum <= max  && !L2.isEmpty()){
            c++;
            System.out.println(L2);
        }
        int k = a;
        while (k < b){
            L2.add(L1.get(k));
            mochilaAyB(L1,L2, max, k + 1, b);
            L2.removeLast();
            k=k+1;
        }
    }

    public static class Objeto{
        int peso, volumen;
        String color;
        
        public Objeto(int peso, int volumen, String color){
            this.peso = peso;
            this.volumen = volumen;
            this.color = color;
        }
        
        @Override
        public String toString(){
            return "(" + peso + "," + volumen + "," + color+")";
        }
    }
    
    public static int sumaPeso(LinkedList<Objeto> L){
        int p=0;
        for (Objeto o : L)
            p+=o.peso;
        return p;
    }
    
    public static boolean coloresDiferentes(LinkedList<Objeto> L){
        HashSet<String> s = new HashSet<String>();
        for(Objeto o : L)
            if(!s.add(o.color))
                return false;
        return true;
    }
    
    public static void mochilaColoresDiferentes(LinkedList<Objeto> L1, LinkedList<Objeto> L2, int max, int i) {
        int sum = sumaPeso(L2);
        if(sum > max) return;
        if(!L2.isEmpty() && coloresDiferentes(L2)){
            System.out.println(L2 + " peso=" +sum);
            c++;
        }
        if(i >= L1.size()) return;
        for (int k = i; k < L1.size(); k++) {
            L2.add(L1.get(k));
            mochilaColoresDiferentes(L1,L2,max, k+1);
            L2.removeLast();
        }
    }
        
        
    //3. El problema de Combinaciones, Permutaciones. (Además implementar una aplicación cualquiera del práctico)
      
    public static void combiSR(LinkedList<Integer> L1, LinkedList<Integer> L2, int n, int r, int i){
        if (L2.size() == r) {
            System.out.println(L2);
            c++;
            return;
        }
        int k = i;
        while (k < L1.size()){
            L2.add(L1.get(k));
            combiSR(L1,L2,n,r,k+1);
            L2.removeLast();
            k++;
        }
    }
    
    public static void combiCR(LinkedList<Integer> L1, LinkedList<Integer> L2, int n, int r, int i){
        if (L2.size() == r) {
            System.out.println(L2);
            c++;
            return;
        }
        int k = i;
        while (k < L1.size()){
            L2.add(L1.get(k));
            combiCR(L1,L2,n,r,k);
            L2.removeLast();
            k++;
        }
    }
    
    public static void permCR(LinkedList<Integer> L1, LinkedList<Integer> L2, int n, int r, int i){
        if (L2.size() == r){
            System.out.println(L2);
            c++;
            return;
        }
        int k = 0;
        while (k < L1.size()){
            L2.add(L1.get(k));
            permCR(L1,L2,n,r,k+1);
            L2.removeLast();
            k++;
        }
    }
    
    public static void permSR(LinkedList<Integer> L1, LinkedList<Integer> L2, int n, int r, int i){
        if (L2.size() == r){
            System.out.println(L2);
            c++;
            return;
        }
        int k = 0;
        while (k < L1.size()){
            if(!L2.contains(L1.get(k))){
                L2.add(L1.get(k));
                permSR(L1,L2,n,r,k+1);
                L2.removeLast();
            }
            k++;
        }
    }
        
    }
