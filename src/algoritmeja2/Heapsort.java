package algoritmeja2;

import java.util.Random;

/**
 * Pahoittelut, ett‰ ohjelma on sekavan n‰kˆinen. Aliohjelmat muuttavat indeksiss‰ 0 olevan taulukon kokoa ja
 * t‰m‰ "pikapaikalla" korjattu. Parempi tapa olisi, ett‰ aliohjelma ei sit‰ muuttaisi vaikka lukua
 * hyˆdynnet‰‰n indeksin‰.
 * Heapsort ei heti sellaisenaan auennut, mutta youtube-opiskelun j‰lkeen ymm‰rsin jutun idean.
 * @author Jenni Yrj‰n‰
 * @version 25 Jan 2021
 */
public class Heapsort {


    /**
     * @param taulukko
     * @param n taulukon koko
     * @return palauttaa taulukon
     */
    public static int[] heapsort(int[] taulukko, int n) {

        taulukko[0] = n;
        teeKeko(taulukko);

        for(int i = n; i>1; i--) {

            int apu = taulukko[1];  // T‰m‰ olisi parempi olla omassa aliohjelmassa
            taulukko[1] = taulukko[i];
            taulukko[i] = apu;

            taulukko[0]--;
            korjaaKeko(taulukko, 1);
        }
        taulukko[0] = taulukko.length-1;
        return taulukko;
    }

    /**
     * T‰m‰ p‰tk‰ kopioitu luentomonisteesta
     * @param taulukko
     * @param i
     * @return palauttaa korjatun version taulukosta
     */
    public static int[] korjaaKeko(int[] taulukko, int i) {
        if (2*i > taulukko[0]) {
            return taulukko;
        }
        int j = 2*i;
        int alkio = taulukko[i];

        while (j <= taulukko[0])
        {
            if ((j < taulukko[0]) && (taulukko[j] > taulukko[j+1]))
                j = j+1;
            if (alkio <= taulukko[j])
                break;
            taulukko[j/2] = taulukko[j];
            j = 2*j;
        }
        taulukko[j/2] = alkio;
        return taulukko;
    }

    /**
     * @param taulukko
     * @return palauttaa taulukon
     */
    public static int[] teeKeko(int[] taulukko) {

        for(int i = taulukko[0]/2; i>= 1; i--) {
            korjaaKeko(taulukko, i);
        }

        return taulukko;
    }

    /**
     * @param t
     * @return palauttaa k‰‰nnetyn taulukon
     */
    public static int[] kaannaTaulukko(int[] t) {

        int[] taulukko = new int[t.length];
        int koko = taulukko.length-1;

        for(int i = 1; i<taulukko.length; i++) {
            taulukko[koko] = t[i];
            koko--;
        }

        taulukko[0] = taulukko.length-1;

        return taulukko;
    }


    /**
     * 
     * @param args ei k‰ytˆss‰
     */
    public static void main(String[] args) {

        Random rand = new Random();
        int[] taulukko = new int[10];


        for(int i=0; i<taulukko.length; i++) {
            taulukko[i] = rand.nextInt(100);
        }


        taulukko[0] = taulukko.length -1;
        int koko = taulukko[0];
        System.out.println(taulukko[0] + " taulukon koko");

        for(int i= 0; i<taulukko.length; i++) {
            System.out.print(taulukko[i] + " ");
        }

        System.out.print(" Satunnaisessa j‰rjestyksess‰ oleva taulukko");

        taulukko = teeKeko(taulukko);

        System.out.println();
        for(int i= 0; i<taulukko.length; i++) {
            System.out.print(taulukko[i] + " ");
        }
        System.out.print(" kekoj‰rjestyksess‰ oleva taulukko");

        taulukko = heapsort(taulukko, koko);
        System.out.println();

        for(int i= 0; i<taulukko.length; i++) {
            System.out.print(taulukko[i] + " ");
        }
        System.out.println("J‰rjestetty taulukko v‰‰rin p‰in");


        taulukko = kaannaTaulukko(taulukko);

        for(int i= 0; i<taulukko.length; i++) {
            System.out.print(taulukko[i] + " ");
        }

        System.out.println("J‰rjestetty taulukko oikein p‰in");
    }
}