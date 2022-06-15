package Algoritmeja;

/**
*
* @author jenni
* @version 27 Oct 2020
*/
public class Permutaatiot {
    
    /**
     * 
     */
    public static int [] t = {1,2,3,4,5};
    
    /**
     * @param a
     * @param b
     */
    public static void swap(int a, int b) {      
        int apu = t[a];
        t[a] = t[b];
        t[b] = apu;
    }
    
    /**
     * 
     */
    public static void tulosta() {
        for(int i= 0; i<t.length; i++) {
            System.out.print(t[i]);
        }
        System.out.println();
    }
    
    /**
     * @param m
     */
    public static void permutaatio(int m){
            
        if(t.length == 0) {
            System.out.println("Taulukko on tyhjä");
            return;
        }
        
        if(m == t.length) {
            tulosta();
        }       
      
        for(int j = m; j<t.length; j++) {
            
            swap(j, m);

            permutaatio(m+1);

            swap(j, m);                      
        }

    }   

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        
        permutaatio(0);

    }

}
