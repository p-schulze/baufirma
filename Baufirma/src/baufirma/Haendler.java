/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baufirma;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author pascalschulze
 */
public class Haendler implements Serializable {
    
    String name;
    Adresse adresse;
    ArrayList<Material> haendlerMaterialListe;
    
    public void Haendler () {
        
    }
    
    public void Haendler (String neuerName, Adresse neueAdresse) {
        name = neuerName;
        adresse = neueAdresse;
    }
    
    public void setName (String neuerName){
        name = neuerName;
    }
    
    public String getName () {
        return name;
    }
    
    public void setAdresse(Adresse neueAdresse){
        adresse = neueAdresse;
    }
    
    public Adresse getAdresse () {
        return adresse;
    }
    
    public void setHaendlerMaterialListe(ArrayList<Material> neueHaendlerMaterialListe){
        haendlerMaterialListe = neueHaendlerMaterialListe;
    }
    
    public ArrayList<Material> getHaendlerMaterialListe(){
        return haendlerMaterialListe;
    }
    
    public void addToHaendlerMaterialListe(Material neuesMaterial){
        haendlerMaterialListe.add(neuesMaterial);
    }
}
