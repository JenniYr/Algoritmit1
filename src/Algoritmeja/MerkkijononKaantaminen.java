package Algoritmeja;

/**
*
* @author jenni
* @version 30 Oct 2020
*/
public class MerkkijononKaantaminen {
    
    /**
     * @param c
     * @param k
     * @param sananPituus 
     * @param indeksi
     * @return palauttaa muokatun taulukon
     */
    public static char[] lisaaSana(char[] c, char[] k, int sananPituus, int indeksi) {
        
        int joku = indeksi;
        
        for(int j = c.length-sananPituus-indeksi; j<c.length-indeksi; j++) {
            k[joku] = c[j];
            joku++;
            if(joku>=c.length) joku--;
        }
        
        joku++;
        if(joku>=c.length) return k;
        k[joku] = ' ';
        
        return k;
        
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        String mj = "algoritmien opiskelu on kivaa";
        char[] c = new char[mj.length()];
        char[] k = new char[mj.length()];
        
        for(int i = 0; i<mj.length(); i++) {
            c[i]  = mj.charAt(i);
        }
        
        int laskuri = 0;
        int apulaskuri = 0;
        int indeksi = 0;
        
        for(int j = mj.length()-1; j>=0; j--) {
            if(c[j] != ' ') laskuri++;
            if(c[j] == ' ' || j == 0) {
                k = lisaaSana(c, k, laskuri, indeksi);
                apulaskuri = apulaskuri +laskuri +1;
                indeksi = apulaskuri;
                laskuri = 0;
            }
        }
        
        for(int l=0; l<k.length; l++) {
            System.out.print(k[l]);
        }

    }

}
