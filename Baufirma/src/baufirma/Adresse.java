/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baufirma;

import java.io.Serializable;

/**
 *
 * @author pascalschulze
 */
public class Adresse implements Serializable {
    String land, stadt, strasse, telefonnummer, mailadresse;
    int plz, hausnummer;

    public void Adresse () {
        
    }
    
    public void Adresse (String neuesLand, String neueStadt, int neuePlz, String neueStrasse, int neueHausnummer) {
        land = neuesLand;
        stadt = neueStadt;
        plz = neuePlz;
        strasse = neueStrasse;
        hausnummer = neueHausnummer;
    }
    
    public void Adresse (String neuesLand, String neueStadt, int neuePlz, String neueStrasse, int neueHausnummer, String neueTelefonnummer, String neueMailadresse) {
        land = neuesLand;
        stadt = neueStadt;
        plz = neuePlz;
        strasse = neueStrasse;
        hausnummer = neueHausnummer;
        telefonnummer = neueTelefonnummer;
        mailadresse = neueMailadresse;   
    }
    
    public String getLand () {
        return land;
    }
    
    public void setLand (String neuesLand) {
        land = neuesLand;
    }
    
    public String getStadt () {
        return stadt;
    }
    
    public void setStadt (String neueStadt) {
        stadt = neueStadt;
    }
    
    public int getPlz () {
        return plz;
    }
    
    public void setPlz (int neuePlz) {
        plz = neuePlz;
    }
    
    public String getStrasse () {
        return strasse;
    }
    
    public void setStrasse (String neueStrasse) {
        strasse = neueStrasse;
    }
    
    public int getHausnummer () {
        return hausnummer;
    }
    
    public void setHausnummer (int neueHausnummer) {
        hausnummer = neueHausnummer;
    }
    
    public String getTelefonnummer () {
        return telefonnummer;
    }
    
    public void setTelefonnummer (String neueTelefonnummer) {
        telefonnummer = neueTelefonnummer;
    }
    
    public String getMailadresse () {
        return mailadresse;
    }
    
    public void setMailadresse (String neueMailadresse) {
        mailadresse = neueMailadresse;
    }
    
    
}
