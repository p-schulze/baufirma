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
public class WriteToFile {
    
    public static void write (ArrayList<Auftrag> arraylist) {
        try {
        ObjectOutputStream out;       
        FileOutputStream file = new FileOutputStream("test.txt");
        out = new ObjectOutputStream(file);
        out.writeObject(arraylist);

        out.close();
        System.out.println("Object written to file");        
        } 
        catch (FileNotFoundException ex) {
            System.out.println("Error with specified file") ;
            ex.printStackTrace();
        }
        catch (IOException ex) {
            System.out.println("Error with I/O processes") ;
            ex.printStackTrace();
        }
    }
}
