package algoritmeja2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/*
* @author jenni yrjänä
* @version 5 Mar 2021
*/
public class Arp {
    
    
    /**
     * @param ipUusi
     * @param macUusi
     * @param ip
     * @param mac
     * @return b
     */
    public static boolean vertaa (String ipUusi, String macUusi, String ip , String mac) {
        
        //Vertaillaan näitä keskenään ja palautetaan boolean sen mukaan onko vastaavat vai ei
        
        return b;
    }
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        
        String ipUusi = "";   // tähän havaitun yhteyden ip
        String macUusi = "";  // tähän havaitun yhteyden mac
        Boolean b = false;
        String[] osoitteet= osoitteet;
        
        while(osoitteet != tyhjä) {
            // kaivetaan taulukosta verratavat ip ja mac osoitteet
            b = vertaa(ipUusi, macUusi, ip, mac);
            if(b = true) break; // vastaavuus löytyi
        }
        
        if(b = false) { //osoite on uusi, tehdään tarvittavat toimenpiteet}
    }
}