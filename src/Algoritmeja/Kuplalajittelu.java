package Algoritmeja;

import java.util.Random;

/**
* Harjoitellaan kuplalajittelua
* @author jenni yrjänä
* @version 23 Oct 2020
*/
public class Kuplalajittelu {
    
    /**
     * @param taulukko
     * @return palauttaa lajitellun taulukon
     */
    public static int[] kuplalajittelu(int[] taulukko) {
        
        int[] t = taulukko;
        
        for(int i=0; i<t.length; i++ ) {
            for(int j = i+1; j<t.length; j++) {
                if(t[j]<t[i]) {
                    int apu = t[i];
                    t[i] = t[j];
                    t[j] = apu;
                }
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
        
        taulukko = kuplalajittelu(taulukko);
        
        System.out.println();
        
        for(int i= 0; i<taulukko.length; i++) {
            System.out.print(taulukko[i] + " ");
        }

    }

}
