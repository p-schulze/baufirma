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
public class Projektleiter extends Angestellter {
    
    public Boolean ersteHilfeAusbildung;
    
    public void Projektleiter () { 
        
    }
    
    public void setErsteHilfe (Boolean trueOderFalse){
        ersteHilfeAusbildung = trueOderFalse;
    }
    
    public Boolean getErsteHilfe (){
        return ersteHilfeAusbildung;
    }
}
