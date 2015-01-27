/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baufirma;
import java.util.Date;
/**
 *
 * @author pascalschulze
 */
public class Angestellter {
    String name;
    String bezeichnung;
    Adresse adresse;
    float gehalt;
    Date bescheaftigtSeit;
    boolean aktiv;
    
    public void Angestellter () {
        aktiv = false;
    }
    
    public void Angestellter (String neuerName, String neueBezeichnung, Adresse neueAdresse, Date neuBescheaftigtSeit) {
        aktiv = false;
        name = neuerName;
        bezeichnung = neueBezeichnung;
        adresse = neueAdresse;
        bescheaftigtSeit = neuBescheaftigtSeit;
    }
    
    public void setName (String neuerName) {
        name = neuerName;
    }
    
    public String getName () {
        return name;
    }
    
    public void setBezeichnung (String neueBezeichnung) {
        bezeichnung = neueBezeichnung;
    }
    
    public void setAdresse (Adresse neueAdresse) {
        adresse = neueAdresse;
    }
    
    public void setGehalt (float neuesGehalt) {
        gehalt = neuesGehalt;
    }
    
    public float getGehalt () {
        return gehalt;
    }
    
    public void setBescheaftigtSeit (Date neuBescheaftigtSeit) {
        bescheaftigtSeit = neuBescheaftigtSeit;
    }
    
    public Date getBescheaftigtSeit () {
        return bescheaftigtSeit;
    }
    
    public void setAktiv (Boolean neuAktiv) {
        aktiv = neuAktiv;
    }
    
     public void setAktiv () {
        aktiv = true;
    }
     
    public void setInaktiv () {
        aktiv = false;
    }
    
    public boolean getAktiv () {
        return aktiv;
    }
    
}
