/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baufirma;
import java.io.*;
/**
 *
 * @author maxiprivat
 */
public class WriteToFile {
    
    public static void main (String[] args) throws IOException{
 
        String text = "Dieser Text wird in einer Datei gespeichert!";
        Bauarbeiter franz = new Bauarbeiter();
    String dateiName = "Test.txt";
    FileOutputStream schreibeStrom = 
                     new FileOutputStream(dateiName);
    for (int i=0; i < text.length(); i++){
      schreibeStrom.write((byte)text.charAt(i));
    }
    schreibeStrom.close();
    System.out.println("Datei ist geschrieben!");
  }
}
