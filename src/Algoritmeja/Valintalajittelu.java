package Algoritmeja;

import java.util.Random;

/**
* Harjoitellaan valintalajittelua
* @author jenni yrjänä
* @version 21 Oct 2020
*/
public class Valintalajittelu {
    
    /**
     * @param taulukko
     * @return palauttaa lajitellun taulukon
     */
    public static int[] valintalajittelu(int[] taulukko) {
        
        for(int i=0; i<taulukko.length-1; i++) {
            int k = i;
            for(int j = i+1; j<taulukko.length; j++) {
                if(taulukko[j] < taulukko[k]) k=j;
            }
            if(k!=i) {
                int apu = taulukko[k];
                taulukko[k] = taulukko[i];
                taulukko[i] = apu;
            }
        }
        
        return taulukko;
        
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
        
        taulukko = valintalajittelu(taulukko);
        
        System.out.println();
        
        for(int i= 0; i<taulukko.length; i++) {
            System.out.print(taulukko[i] + " ");
        }

    }
}
