/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baufirma;

/**
 *
 * @author pascalschulze
 */
public class Bagger extends Fahrzeug {
    String baggertyp;
    float einsatzgewichtInKg;
    
    public void Bagger () {
        
    }
    
    public void Bagger (String neuerBaggertyp, float neuesEinsatzgewichtInKg){
        baggertyp = neuerBaggertyp;
        einsatzgewichtInKg = neuesEinsatzgewichtInKg;
    }
    
    public void setBaggertyp(String neuerBaggertyp){
        baggertyp = neuerBaggertyp;
    }
    
    public String getbaggertyp(){
        return baggertyp;
    }
    
    public void setEinsatzgewichtInKg(float neuesEinsatzgewichtInKg){
        einsatzgewichtInKg = neuesEinsatzgewichtInKg;
    }
    
    public float getEinsatzgewichtInKg(){
        return einsatzgewichtInKg;
    }
    
}
