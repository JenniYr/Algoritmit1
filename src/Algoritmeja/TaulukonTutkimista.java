package Algoritmeja;

import java.util.Random;

/**
* Muodostetaan taulukko Random-luokan metodilla
* Tutkitaan lasketaan kuinka moni sen luivista kuuluu välille [0,10],[50,100]ja[67,75].
* @author jenni yrjänä
* @version 21 Sep 2020
*/
public class TaulukonTutkimista {
    
    /**
     * @param taulukko
     * @return palauttaa taulukon joka on täytetty satunnaisilla kokonaisluvuilla
     */
    public static int[] muodostaTaulukko(int taulukko) {
        
        int[] t = new int[taulukko];
        Random rand = new Random();
        
        for(int i = 0; i<taulukko; i++) {
            t[i] = rand.nextInt(taulukko);
        }
        
        return t;
        
    }
    
    /**
     * @param taulukko
     * @param alku 
     * @param loppu
     * @return palauttaa lukuarvon joka kertoo kuinka moni taulukon sisällä olevista alkioista on annettujen lukuarvojen sisällä
     */
    public static int tutkiTaulukko(int[] taulukko, int alku, int loppu) {
        
        int laskin = 0;
        int[] t = new int[loppu-alku];
        int counter = alku;
        
        for(int i=0; i<t.length;i++) {
            t[i] = counter;
            counter++;
        }
        
        for(int i =0; i<taulukko.length; i++) {
            
            for(int j = 0; j<t.length; j++) {
                if(taulukko[i] == t[j]) laskin++;
            }
        }
        return laskin;
        
    }
    
    /**
     * Harjoitellaan algoritmin muuttamista rekursiiviseksi
     * @param t 
     * @param n 
     * @param pienin 
     * @return palauttaa taulukon pienimmän arvon
     */
    public static int etsiPienin(int[] t, int n, int pienin){
        
        int apu = pienin;
        if(t[n] <pienin || apu == -1) apu = t[n];
        if(n == 0) return pienin;

        return(etsiPienin(t, n-1, apu));
        
        }
    
    /**
     * @param t
     * @param n 
     * @param luku
     * @return palauttaa 
     */
    public static int[] asetaLuku(int[] t, int n, int luku){

        if(n>=0) {
            t[n] = luku;
            return asetaLuku(t, n-1, luku);
        }
        return t;
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
        
        int[] taulukko = new int[101];
        taulukko = muodostaTaulukko(taulukko.length);
        
        for(int i=0; i<taulukko.length; i++) {
            System.out.println(taulukko[i]);
        }
        
        int lukuarvo = tutkiTaulukko(taulukko, 0, 10);
        
        System.out.println(" ");
        System.out.println(lukuarvo);
        
        lukuarvo = tutkiTaulukko(taulukko, 50, 100);
        
        System.out.println(" ");
        System.out.println(lukuarvo);
        
        lukuarvo = tutkiTaulukko(taulukko, 67, 75);
        
        System.out.println(" ");
        System.out.println(lukuarvo);
        
        int pienin = etsiPienin(taulukko, taulukko.length-1, -1);
        System.out.println(pienin);
        
        int[] taulukkoinen = new int[20];
        taulukkoinen = asetaLuku(taulukkoinen, taulukkoinen.length-1, 0);
        
        for(int i=0; i<taulukkoinen.length; i++) {
            System.out.println(taulukkoinen[i]);
        }
        
        int nollat= laskeNollat(taulukkoinen, taulukkoinen.length-1, 0);
        System.out.println(nollat);
        
    }

    

}
