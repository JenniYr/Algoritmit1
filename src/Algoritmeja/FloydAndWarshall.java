package Algoritmeja;

/**
*
* @author jenni
* @version 8 Oct 2020
*/
public class FloydAndWarshall {
    
    /**
     * @param matriisi
     * @return palauttaa lyhyimpien etäisyyksien matriisin
     */
    public static int[][] fandW(int[][] matriisi) {
        
        int[][] palautus = matriisi;
        
        for(int k=0; k< matriisi.length; k++) {
            for(int i = 0; i< matriisi.length; i++) {
                for(int j= 0; j< matriisi.length; j++) {
                    if(matriisi[i][j]>matriisi[i][k]+matriisi[k][j]) {
                        matriisi[i][j] = matriisi[i][k] + matriisi[k][j];
                    }
                }
            }
        }
        
        return palautus;
        
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        int[][] pituusmatriisi = new int[4][4];
        pituusmatriisi[0][0]= 0;
        pituusmatriisi[0][1] = 12;
        pituusmatriisi[0][2] = 38;
        pituusmatriisi[0][3] = 28;
        pituusmatriisi[1][0] = 1000;
        pituusmatriisi[1][1] = 0;
        pituusmatriisi[1][2] = 8;
        pituusmatriisi[1][3] = 1000;
        pituusmatriisi[2][0] = 1000;
        pituusmatriisi[2][1] = 20;
        pituusmatriisi[2][2] = 0;
        pituusmatriisi[2][3] = 6;
        pituusmatriisi[3][0] = 25;
        pituusmatriisi[3][1] = 30;
        pituusmatriisi[3][2] = 1000;
        pituusmatriisi[3][3] = 0;
        
        for(int i= 0; i<pituusmatriisi.length; i++) {
            System.out.println();
            for(int j=0; j<pituusmatriisi.length; j++) {
                System.out.print(pituusmatriisi[i][j] + " ");
            }
        }
        
        int[][] lyhyimmatEtaisyydet = fandW(pituusmatriisi);
        
        System.out.println();
        
        for(int i= 0; i<lyhyimmatEtaisyydet.length; i++) {
            System.out.println();
            for(int j=0; j<pituusmatriisi.length; j++) {
                System.out.print(pituusmatriisi[i][j] + " ");
            }
        }

    }

}
