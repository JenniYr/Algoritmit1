package Algoritmeja;

import java.util.Random;

/**
* Harjoitellaan lisäyslajittelua
* @author jenni yrjänä
* @version 23 Oct 2020
*/
public class Lisayslajittelu {
    
    /**
     * @param taulukko
     * @return palauttaa lajitellun taulukon
     */
    public static int[] lisayslajittelu(int[] taulukko) {
        
        int[] t = taulukko;
        
        for(int i = 1; i<t.length; i++) {
            int apu = t[i];
            int j = i-1;
            
            while(j>=0 && t[j] > apu) {
                t[j+1] = t [j];
                j--;
            }
            t[j+1] = apu;
            }
        return t;
        }

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        Random rand = new Random();
        int[] taulukko = new int[25];
        
        for(int i= 0; i<taulukko.length; i++) {
            taulukko[i] = rand.nextInt(taulukko.length);
        }
        
        for(int i= 0; i<taulukko.length; i++) {
            System.out.print(taulukko[i] + " ");
        }
        
        taulukko = lisayslajittelu(taulukko);
        
        System.out.println();
        
        for(int i= 0; i<taulukko.length; i++) {
            System.out.print(taulukko[i] + " ");
        }

    }

}
