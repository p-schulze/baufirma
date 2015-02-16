/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baufirma;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author maxiprivat
 */
public class ReadFromFile {
    
    public static ArrayList read (String filename) {
        Object obj = new Object();
        try {
            // Read from disk using FileInputStream
            FileInputStream f_in = new FileInputStream(filename);

            // Read object using ObjectInputStream
            ObjectInputStream obj_in = new ObjectInputStream (f_in);

            // Read an object
            obj = obj_in.readObject();            
            
            
            if (obj instanceof ArrayList)
            {                
                ArrayList liste = (ArrayList)obj;

                return liste;
            }
        } 
        catch (FileNotFoundException ex) {
            System.out.println("Keine gespeicherten Daten vorhanden!") ;            

        }
        catch (IOException ex) {
            System.out.println("Error with I/O processes") ;
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            System.out.println("Error with Class") ;
            ex.printStackTrace();
        }                
        ArrayList liste = new ArrayList<>();
        return liste;
    } 
}
