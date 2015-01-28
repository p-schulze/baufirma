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
public class Pkw extends Fahrzeug {
    
    String typ;
    int sitzplaetze;
    
    public void Pkw () {
        
    }
    
    public void Pkw (String neuerTyp, int neueSitzplaetze){
        typ = neuerTyp;
        sitzplaetze = neueSitzplaetze;
    }
    
    public void setTyp(String neuerTyp){
        typ = neuerTyp;
    }
    
    public String getTyp(){
        return typ;
    }
    
    public void setSitzplaetze(int neueSitzplaetze){
        sitzplaetze = neueSitzplaetze;
    }
    
    public int getSitzplaetze(){
        return sitzplaetze;
    }
}
