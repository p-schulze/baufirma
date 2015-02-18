/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baufirma;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author pascalschulze
 */
public class Angestellter extends Object implements Serializable {
    String name;
    Adresse adresse;
    float gehalt;
    boolean aktiv;    
    
    public void Angestellter () {
        aktiv = false;
    }
    
    public void Angestellter (String neuerName, Adresse neueAdresse, float Gehalt) {
        aktiv = false;
        name = neuerName;
        adresse = neueAdresse;
    }
    
    public void setName (String neuerName) {
        name = neuerName;
    }
    
    public String getName () {
        return name;
    }
    public void setAdresse (Adresse neueAdresse) {
        adresse = neueAdresse;
    }
    
    public Adresse getAdresse() {
        return adresse;
    }
    
    public void setGehalt (float neuesGehalt) {
        gehalt = neuesGehalt;
    }
    
    public float getGehalt () {
        return gehalt;
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
