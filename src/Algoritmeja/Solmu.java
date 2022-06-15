package Algoritmeja;

/**
*
* @author jenni
* @version 2 Oct 2020
*/
public class Solmu {

    /**
     * 
     */
    public char key;
    /**
     * 
     */
    public Solmu left;
    /**
     * 
     */
    public Solmu right;
    
    /**
     * @param k 
     * 
     */
    public Solmu(char k) {
        this.key=k;
        this.right = null;
        this.left = null; 
    }
    
    
    /**
     * @param vasen
     */
    public void addVasen(Solmu vasen) {
        this.left = vasen;
    }
    
    /**
     * @param oikea
     */
    public void addOikea(Solmu oikea) {
        this.right = oikea;
    }
    
    /**
     * @param eka
     */
    public static void tulostaEsijarjestyksessa(Solmu eka) {
        System.out.println(eka.key);
        if(eka.left != null) tulostaEsijarjestyksessa(eka.left);
        if(eka.right != null) tulostaEsijarjestyksessa(eka.right);
    }
    
    /**
     * @param eka
     */
    public static void tulostaSisajarjestyksessa(Solmu eka) {
        
        if(eka.left != null) tulostaSisajarjestyksessa(eka.left);
        System.out.println(eka.key);
        if(eka.right != null) tulostaSisajarjestyksessa(eka.right);
    }
    
    /**
     * @param eka
     */
    public static void tulostaJalkijarjestyksessa(Solmu eka) {
        if(eka.left != null) tulostaJalkijarjestyksessa(eka.left);       
        if(eka.right != null) tulostaJalkijarjestyksessa(eka.right);
        System.out.println(eka.key);
    }
    /**
     * 
     * @param args ei kaytossa
     */
    public static void main(String[] args) {
        
        Solmu k = new Solmu('k');
        Solmu d = new Solmu('d');
        Solmu e = new Solmu('e');
        Solmu b = new Solmu('b');
        Solmu c = new Solmu('c');
        Solmu a = new Solmu('a');
        Solmu o = new Solmu('o');
        Solmu m = new Solmu('m');
        Solmu q = new Solmu('q');
        Solmu p = new Solmu('p');
        Solmu r = new Solmu('r');
        
        k.addVasen(d);
        d.addVasen(b);
        d.addOikea(e);
        b.addVasen(a);
        b.addOikea(c);
        
        k.addOikea(o);
        o.addVasen(m);
        o.addOikea(q);
        q.addVasen(p);
        q.addOikea(r);
        
        tulostaEsijarjestyksessa(k);
        System.out.println("-------------------------------------------------------------------------------------");
        tulostaSisajarjestyksessa(k);
        System.out.println("-------------------------------------------------------------------------------------");
        tulostaJalkijarjestyksessa(k);
    }

}
