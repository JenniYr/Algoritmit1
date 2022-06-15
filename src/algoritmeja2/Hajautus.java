package algoritmeja2;

/**
 *
 * @author jenni yrjänä
 * @version 28 Jan 2021
 */
public class Hajautus {

    /**
     * @param args ei käytössä
     */
    public static void main (String[] args) {

        int[] taulukko = {15,49,75,46,95,7,88,21,55,36};

        for(int i=0; i<taulukko.length; i++) {
            System.out.print(taulukko[i]+ " ");
        }
        System.out.println();

        taulukko = hajauta(taulukko); // annetaan taulukko hajautettavaksi

        for(int i=0; i<taulukko.length; i++) {
            System.out.print(taulukko[i] + " ");
        }
        System.out.println();
        
        taulukko = poista(taulukko, 95);  // poistetaan luku 95 taulukosta
        
        for(int i=0; i<taulukko.length; i++) {
            System.out.print(taulukko[i] + " ");
        }
        
        System.out.println();
        
        taulukko = poista(taulukko, 88); // poistetaan luku 88 taulukosta
        
        for(int i=0; i<taulukko.length; i++) {
            System.out.print(taulukko[i] + " ");
        }
        
        System.out.println();
        
        taulukko = poista(taulukko, 8); // kokeillaan poistaa taulukosta luku jota siellä ei ole
                                        // Palauttaa saman taulukon takaisin / ei tapahdu mitään
        for(int i=0; i<taulukko.length; i++) {
            System.out.print(taulukko[i] + " ");
        }       
        System.out.println();  // Seuraavaan tehtävään lupaan tehdä tulostuksen omaksi ohjelmakseen 
    }

    /**
     * @param taulukko
     * @param i
     * @return palauttaa taulukon josta poistettu haluttu alkio
     */
    public static int[] poista(int[] taulukko, int i) {
        
        
        int p = etsi(taulukko, i);
        if(p == -1) return taulukko; // Tähän sopisi poikkeus ja viesti ettei lukua löydy taulukosta
        if(p != -1) taulukko[p] = -1;
        return taulukko;
    }
    /**
     * Palauttaa etsityn arvon indeksin
     * Jos haluttua arvoa ei löydy, palauttaa arvon -1
     * @param taulukko
     * @param i
     * @return palauttaa etsityn arvon indeksin
     */
    private static int etsi(int[] taulukko, int i) {

        int hajautettuOsoite = hajauta(i, taulukko.length); // aloitetaan tästä etsintä
        int palautettavaArvo = -1;

        for(int j= hajautettuOsoite; j<taulukko.length; j++) {
            if(taulukko[j] == i) { palautettavaArvo=j; break;}
            if(j==taulukko.length-1) {
                j=0;}           
            if(j == hajautettuOsoite-1) break;
        }

        return palautettavaArvo;
    }

    /**
     * lisää operaatio
     * Rakennettu niin, että saa syötteenä taulukon jossa lukuja. Rakentaa uuden taulukon jossa luvut hajautettu
     * Asianmukaisempi ehkä olisi ollut se, että käyttäjä syöttää itse luvut
     * @param taulukko 
     * @return palauttaa hajautetun taulukon
     */
    public static int[] hajauta(int[] taulukko) {

        int[] tyhja = new int[10];

        for(int i=0; i<tyhja.length; i++) {
            int paikka = hajauta(taulukko[i], taulukko.length);
            if(tyhja[paikka] != 0 && paikka <tyhja.length) {
                for(int j = 0; j<taulukko.length; j++) {
                    paikka++;
                    if(paikka<taulukko.length && tyhja[paikka] == 0) {
                        tyhja[paikka] = taulukko[i];
                        break;
                    }
                    if(paikka == taulukko.length) paikka = -1;
                }
            }
            if(tyhja[paikka] == 0) tyhja[paikka] = taulukko[i];
        }
        return tyhja;
    }
    
    /**
     * Yksinkertainen hajautus
     * @param i on osoittaja
     * @param pituus on nimittäjä
     * @return palauttaa jakojäännöksen
     */
    private static int hajauta(int i, int pituus) {

        return i%pituus;
    }
}
