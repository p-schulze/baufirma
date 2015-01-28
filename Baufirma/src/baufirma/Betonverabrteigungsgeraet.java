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
public class Betonverabrteigungsgeraet extends Fahrzeug{
    String typ;
    int fassungsvermoegenInL;
    
    public void Betonverabrteigungsgeraet () {
        
    }
    
    public void Betonverabrteigungsgeraet (String neuerTyp, int neuesFassungsvermoegenInL){
        typ = neuerTyp;
        fassungsvermoegenInL = neuesFassungsvermoegenInL;
    }
    
    public void setTyp(String neuerTyp){
        typ = neuerTyp;
    }
    
    public String getTyp(){
        return typ;
    }
    
    public void setFassungsvermoegenInL(int neuesFassungsvermoegenInL){
        fassungsvermoegenInL = neuesFassungsvermoegenInL;
    }
    
    public int getFassungsvermoegenInL(){
        return fassungsvermoegenInL;
    }
}
