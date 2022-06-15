package algoritmeja2;

import java.util.Random;

/**
*
* @author jenni yrjänä
* @version 12 Feb 2021
*/
public class PiinLikiarvo {
     
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        double nelionSivu = 1.0;
        double r = nelionSivu / 2;
        int n = 10000; // pisteiden lkm

        int k = laskePisteetYmpyrassa(n, r);
        double likiarvo = 4.0 * k/n;
        System.out.println(likiarvo);
        
        k = laskePisteetYmpyrassa(100, r);
        likiarvo = 4.0 * k/100;
        System.out.println(likiarvo);
    }

    /**
     * @param n on pisteiden lkm
     * @param sade on ympyrän säde
     * @return palauttaa arvon k joka on pisteiden lkm ympyrässä
     */
    public static int laskePisteetYmpyrassa(int n, double sade) {
        Random satunnais = new Random();
        
        int k =0;
        
        for(int i=0; i<=n; i++) {
            double x = satunnais.nextDouble();
            double y = satunnais.nextDouble();       
            double et = laskeEtaisyys(x,y, sade,sade);
            if(et<sade) k++;
        }
        return k;

    }
    
    /**
     * @param x pisteen 1 x koordinaatti
     * @param y pisteen 1 y koordinaatti
     * @param x2  pisteen 2 x koordinaatti
     * @param y2  pisteen 2 y koordinaatti
     * @return palauttaa kahden pisteen välisen etäisyyden
     */
    public static double laskeEtaisyys(double x, double y, double x2, double y2) {
        
        double tulos1 = (x-x2)*(x-x2);
        double tulos2 = (y-y2)*(y-y2);
        double tulos3 = tulos1+tulos2;
        double tulos4 = Math.sqrt(tulos3);
        return tulos4;
    }

}
