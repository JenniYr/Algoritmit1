package algoritmeja2;

/**
*
* @author jenni yrjänä
* @version 11 Feb 2021
*/
public class KapssakkiTaulukoimalla {
    
    /**
     * @param ha on taulukko hyötyarvoista
     * @param p on taulukko painoista
     * @param painoraja on repun painoraja
     * @return palauttaa matriisin indeksin jossa taulukoitu vastaus
     */
    public static int taulukoi(int[] ha, int[] p, int painoraja){
        
        int[][] taulukointi = new int[11][11];
        int eiOteta; int otetaan;
        int pr = painoraja;
        
        for(int r=0; r<taulukointi.length; r++) {
            
            taulukointi[0][r] = 0;
        }
        
        for(int k=0; k<taulukointi.length; k++) {
            
            taulukointi[k][0] = 0;
        }

        for(int i=1; i<p.length; i++) {
            for(int j=1; j<ha.length; j++) {
                if(pr < p[j]) taulukointi[i][j] = taulukointi[i-1][j];
                else if(pr > p[j]) try {
                otetaan = ha[i] + taulukointi[i-1][j-p[i]];
                eiOteta =  taulukointi[i-1][j];
                if(otetaan>eiOteta) pr = pr -p[i];
                taulukointi[i][j] = max(eiOteta, otetaan);
                } catch(@SuppressWarnings("unused") Exception e) {
                    taulukointi[i][j] = taulukointi[i-1][j];
                }
                
            } 
        }
        

        for(int m = 0; m<taulukointi.length; m++) {
            for(int n =0; n<taulukointi.length; n++) {
                System.out.print(taulukointi[m][n]);
            }
            System.out.println();
        }




        return taulukointi[ha.length][p.length];
    }
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        
        int[] paino = {1,1,2,3,4,5,6,7,8,9};
        int[] hyotyarvo = {1,1,2,3,4,5,6,7,8,9};
        
        int painoraja = 10;
        
        int taulukointi = taulukoi(hyotyarvo, paino, painoraja);
        
        System.out.println(taulukointi);
    }

    static int max(int i, int j) {
        
        if(i>j)return i;
        
        return j;
    }

}
