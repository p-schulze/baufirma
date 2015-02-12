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
public class Fahrzeug implements Serializable {
    
    String bezeichnung, kennzeichen, modell;
    boolean selbstfahrend;
    
    public void Fahrzeug () {
        
    }
    
    public void Fahrzeug (String neueBezeichnung, String neuesKennzeichen, String neuesModell, boolean neuSelbstfahrend){
        bezeichnung = neueBezeichnung;
        kennzeichen = neuesKennzeichen;
        modell = neuesModell;
        selbstfahrend = neuSelbstfahrend;
    }
    
    public void setBezeichnung(String neueBezeichnung){
        bezeichnung = neueBezeichnung;
    }
    
    public String getBezeichnung (){
        return bezeichnung;
    }
    
    public void setKennzeichen(String neuesKennzeichen){
        kennzeichen = neuesKennzeichen;
    }
    
    public String getKennzeichen (){
        return kennzeichen;
    }
    
    public void setModell(String neuesModell){
        modell = neuesModell;
    }
    
    public String getModell (){
        return modell;
    }
    
    public void setSelbstfahrend(boolean neuSelbstfahrend){
        selbstfahrend = neuSelbstfahrend;
    }
    
    public boolean getSlebstfahrend (){
        return selbstfahrend;
    }
    
}
