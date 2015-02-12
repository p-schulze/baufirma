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
public class Material implements Serializable {
    
    String name;
    String typ;
    int menge;
    
    public void Material(){
        
    }
    
    public void Material(String neuerName, String neuerTyp){
        
    }
    
    public void setName(String neuerName){
        name = neuerName;
    }
    
    public String getName () {
        return name;
    }
    
    public void setTyp(String neuerTyp){
        typ = neuerTyp;
    }
    
    public String getTyp(){
        return typ;
    }
    
    public void setMenge(int neueMenge){
        menge = neueMenge;
    }
    
    public int getMenge(){
        return menge;
    }
}
