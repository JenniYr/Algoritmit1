package Algoritmeja;

import java.util.Random;

/**
* Algoritmeja1 -kurssin Demo2 ohjelmointitehtävä
* Luodaan tietorakenne jono
* Operaatiot
* Enqueue
* Dequeue
* isEmpty
* size
* front
* @author jenni yrjänä
* @version 22 Sep 2020
*/
public class Jono {
    
    /**
     * @param t 
     * @param eka 
     * @param vika 
     * @return palauttaa jottain
     */
    public static int[] taytaTaulukko(int t, int eka, int vika){
        
        int[] taulukko = new int[t];
        
        Random rand = new Random();
        
        for(int i=0; i<vika; i++) {
            taulukko[i] = rand.nextInt(100);
        }
        
        return taulukko;
        
    }
    
    /**
     * @param t
     * @param k
     * @param indeksi
     * @return palauttaa taulukon, jossa on lisättynä uusi alkio
     */
    public static int[] enqueue(int[] t, int k, int indeksi) {
        
        int[] taulukko = t;
        taulukko[indeksi ] = k;
        
        return taulukko;
        
    }
    
    /**
     * @param t
     * @param k
     * @param indeksi 
     * @return palauttaa taulukon, josta "poistettu" alkio
     */
    public static int[] dequeue(int[] t, int k, int indeksi) {
        
        if(t.length== 0) return t;
        
        int[] taulukko = t;
        
        if(t[0] == k) {

            for(int i = 0;i<indeksi; i++) {
                taulukko[i] = taulukko[i+1];
            }
        }
        
        return taulukko;
        
    }
    
    /**
     * @param t
     * @param n
     * @param lkm 
     * @return palauttaa lukumaaran
     */
    public static int laskeNollat(int[] t, int n, int lkm){
        int lukumaara = lkm;
        if(n>=0 && t[n] == 0) {
            lukumaara++;
        
        return laskeNollat(t, n-1, lukumaara);
        }
        return lukumaara;
        }
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {

        int[] taulukko = new int[10];
        
        taulukko = taytaTaulukko(taulukko.length, 0, taulukko.length/2);
        
        for(int i =0; i<taulukko.length; i++) {
            System.out.println(taulukko[i]);
        }
        
        int indeksi = taulukko.length -laskeNollat(taulukko, taulukko.length-1, 0);
        
        System.out.println(indeksi);
        
        taulukko = enqueue(taulukko, 66, indeksi);
        indeksi++;
        
        for(int i =0; i<taulukko.length; i++) {
            System.out.println(taulukko[i]);
        }
        
        taulukko = dequeue(taulukko, taulukko[0], indeksi);
        indeksi--;
        
        for(int i =0; i<taulukko.length; i++) {
            System.out.println(taulukko[i]);
        }
        
        boolean b = isEmpty(taulukko);
        
        if(b == true) System.out.println("jono oli tyhjä");
        if(b == false) System.out.println("jonosta löytyi jotain");
        
        int size = size(taulukko);
        
        System.out.println(size);
        
        taulukko = dequeue(taulukko, taulukko[0], indeksi);
        indeksi--;
        size = size(taulukko);
        System.out.println(size);
        
        taulukko = dequeue(taulukko, taulukko[0], indeksi);
        size = size(taulukko);
        System.out.println(size);
        
        int eka = front(taulukko);
        
        System.out.println(eka);
    }

    private static int front(int[] taulukko) {
        if(isEmpty(taulukko) == true) return 0;
        return taulukko[0];
    }

    private static int size(int[] taulukko) {
        int nollat = laskeNollat(taulukko, taulukko.length-1, 0);
        
        return taulukko.length-nollat;
    }

    private static boolean isEmpty(int[] taulukko) {
        if(taulukko[0] == 0) return true;
        return false;
    }
    
    

}
