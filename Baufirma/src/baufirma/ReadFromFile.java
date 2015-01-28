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
public class ReadFromFile {
    
    public static void main (String[] args) throws IOException{
     byte zeichen;
     char buchstabe;
     String text = "";
     String dateiName = "Test.txt";
     FileInputStream leseStrom = new FileInputStream(dateiName);
     do{
       zeichen = (byte)leseStrom.read();
       System.out.print(zeichen+" ");
       text += (char)zeichen;
     } while (zeichen !=-1);
     leseStrom.close();
     System.out.println();
     System.out.println(text);
  }
    
}
