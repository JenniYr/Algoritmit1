package algoritmeja2;

/**
* En ole ihan varma toimiiko find-operaatio sill‰ lailla kuten kuuluisi. Annat varmaan palautetta jos ei toimi?
* @author jenni yrj‰n‰
* @version 2 Feb 2021
*/
public class UnionFind {
    
    private int arvo;
    private String nimi;
    
    /**
     * @param arvo on alkiolle annettu arvo jonka avulla tehd‰‰n union ja find operaatioita
     * @param nimi on alkioon tallennettu merkkijono
     */
    public UnionFind(int arvo, String nimi) {
        this.arvo = arvo;
        this.nimi = nimi;
    }
    
    @Override
    public String toString() {
        return String.format("nimi " + nimi + " arvo " + arvo);
    }

    /**
     * @return palauttaa olion arvon
     */
    public int getArvo() {
        return this.arvo;
    }

    /**
     * @param k
     */
    public void setArvo(int k) {

        this.arvo = k;
    }

    /**
     * @param a
     * @param b
     * @param pvJoukko 
     */
    public static void union(int a, int b, UnionFind[] pvJoukko)
    // Oletus: a ja b juurisolmuja
    {
        int k;
        k = pvJoukko[a].getArvo() + pvJoukko[b].getArvo();
        if (pvJoukko[a].getArvo() <= pvJoukko[b].getArvo())
        {
            pvJoukko[a].setArvo(k);
            pvJoukko[b].setArvo(a);
        }
        else
        {
            pvJoukko[b].setArvo(k);
            pvJoukko[a].setArvo(b);
        }
    }
    
    /**
     * @param x
     * @param pvJoukko
     * @return palauttaa juurisolmun
     */
    public static int find(int x, UnionFind[] pvJoukko){
      int j;
      int next = pvJoukko[x].getArvo();
      // Juurisolmun etsint‰:
      j = x;
      while (pvJoukko[j].getArvo() > 0)
      {
        j = pvJoukko[j].getArvo();
      }
      // Hakupolun tiivistys:
      while (next != j){
          pvJoukko[x].setArvo(j);
          pvJoukko[next].setArvo(pvJoukko[next].getArvo());
          next = pvJoukko[next].getArvo();
      }
      return j;
    }
    
    /**
     * @param t
     */
    public static void tulosta(UnionFind[] t) {
        
        for(int i=0; i<t.length; i++) {
            System.out.println(t[i]);
        }
        System.out.println();
    }

    /**
     * @param args ei k‰ytˆss‰
     */
    public static void main(String[] args) {

        UnionFind[] taulukko = new UnionFind[8];

        UnionFind kissa = new UnionFind(-1,"kissa");
        UnionFind koira = new UnionFind(-1,"koira");
        UnionFind lehma = new UnionFind(-1,"lehma");
        UnionFind possu = new UnionFind(-1,"possu");
        UnionFind lammas = new UnionFind(-1,"lammas");
        UnionFind kirahvi = new UnionFind(-1,"kirahvi");
        UnionFind leijona = new UnionFind(-1,"leijona");
        UnionFind ylimaarainen = new UnionFind(-100, "ylimaarainen");

        taulukko[0] = ylimaarainen; // T‰m‰ on ylim‰‰r‰inen, koska NullPoint Exception, en osannut tehd‰ t‰ss‰ vaiheessa muuta t‰lle
        taulukko[1] = koira;
        taulukko[2] = lehma;
        taulukko[3] = possu;
        taulukko[4] = lammas;
        taulukko[5] = kirahvi;
        taulukko[6] = leijona;
        taulukko[7] = kissa;

        tulosta(taulukko);
        union(1,2, taulukko);
        tulosta(taulukko);
        union(1,3, taulukko);
        tulosta(taulukko);        
        union(6,7, taulukko);
        union(5,4, taulukko);// arvojenantoj‰rjestyksell‰ v‰li‰ sill‰ kummasta tulee juurisolmu ainakin kun molemmissa puissa 1 solmu, pit‰isi varmaan korjata?
        tulosta(taulukko);
        union(6,5, taulukko);
        tulosta(taulukko);
        union(1,6,taulukko);
        tulosta(taulukko);
        int u =find(3, taulukko);
        System.out.println(u);
        tulosta(taulukko);
        }
    }


