package Algoritmeja;

/**
* Demo 5 teht‰v‰ 5
* Taulukossa on kokonaislukuja n kappaletta. Onko taulukossa dublikaatteja?
* Suunnittele osittavan ja rekursiivisen menetelmien mukaiset algoritmit
* M‰‰r‰‰ kertaluokka
* a) Luvut ovat sattumanvaraisessa j‰rjestyksess‰.
* Tutkitaan ensin, onko ensimm‰inen luku sama kuin jokin muu taulukon luku.
* Ellei ole, tutkitaan samalla tavalla lopputaulukko toisesta luvusta alkaen jne.
* 
* b)
* Oletetaan, ett‰ luvut ovat taulukossa kasvavassa j‰rjestyksess‰.
* Tutkitaan ensin, onko taulukon alkuosassa toiseksi viimeiseen alkioon saakka dublikaatteja,
* ellei ole tutkitaan onko koko taulukon viimeinen luku sama kuin alkuosan viimeinen luku
* @author jenni yrj‰n‰
* @version 30 Oct 2020
*/
public class DublikaattienTutkimista {
    
    /**
     * @param t
     * @param i 
     * @return palauttaa totuuden kaikesta
     */
    public static boolean rekursiivinen (int[] t, int i) {
        
        if(t.length == 1 || t.length == i) {
            
            return false;
        }
        
        
        for(int j = i+1; j<t.length; j++) {
            if(t[j] == t[i]) return true;
        }
        
        return rekursiivinen(t, i+1);
        
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] t = {2,5,8,3,0,9,3,3,6,8,4};
        int[] ta = {0,2,3,3,3,4,5,6,8,8,9};
        int[] tau = {2,5,7,3,4,8,9};
        int[] taul = {1,2,3,4,5,6,7,8,9};

        boolean e = rekursiivinen(t,0);

        System.out.println(e);

        e = rekursiivinen(ta,0);

        System.out.println(e);


        e = rekursiivinen(tau,0);

        System.out.println(e);


        e = rekursiivinen(taul,0);

        System.out.println(e);


    }

}
