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
public class Hebzeug extends Fahrzeug {
    
    String typ;
    float maxBelastungInKg;
    
    public void Hebzeug () {
        
    }
    
    public void Hebzeug (String neuerTyp, float neueMaxBelastungInKg){
        typ = neuerTyp;
        maxBelastungInKg = neueMaxBelastungInKg;
    }
    
    public void setTyp(String neuerTyp){
        typ = neuerTyp;
    }
    
    public String getTyp(){
        return typ;
    }
    
    public void setMaxBelastungInKg(float neueMaxBelastungInKg){
        maxBelastungInKg = neueMaxBelastungInKg;
    }
    
    public float getMaxBelastungInKg(){
        return maxBelastungInKg;
    }
}
