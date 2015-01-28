/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baufirma;
import java.util.ArrayList;

/**
 *
 * @author pascalschulze
 */

public class Transportgeraet extends Fahrzeug {
    String typ;
    String kapazitaet;
    ArrayList<Material> ladungsliste;
    
    public void Transportgeraet () {
        
    }
    
    public void Transportgeraet (String neuerTyp, String neueKapazitaet){
        typ = neuerTyp;
        kapazitaet = neueKapazitaet;
    }
    
    public void setTyp(String neuerTyp){
        typ = neuerTyp;
    }
    
    public String getTyp(){
        return typ;
    }
    
    public void setKapazitaet(String neueKapazitaet){
        kapazitaet = neueKapazitaet;
    }
    
    public String getKapazitaet(){
        return kapazitaet;
    }
    
    public void setLadungsliste(ArrayList<Material> neueLadungsliste){
        ladungsliste = neueLadungsliste;
    }
    
    public ArrayList<Material> getLadungsliste(){
        return ladungsliste;
    }
    
    public void addToLadungsliste(Material neuesMaterial){
        ladungsliste.add(neuesMaterial);
    }
}
