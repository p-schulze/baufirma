/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baufirma;

import java.util.Scanner;
import java.util.ArrayList;


/**
 *
 * @author pascalschulze, tilllehmann
 */

public class main {
    private static final String ANSI_RESET = "\u001B[0m", ANSI_BLACK = "\u001B[30m", 
            ANSI_RED = "\u001B[31m", ANSI_GREEN = "\u001B[32m", ANSI_YELLOW = "\u001B[33m", 
            ANSI_BLUE = "\u001B[34m", ANSI_PURPLE = "\u001B[35m", ANSI_CYAN = "\u001B[36m", 
            ANSI_WHITE = "\u001B[37m";  
            
    public static ArrayList<Auftrag> auftragListe;
    public static ArrayList<Projektleiter> projektleiterListe;
    public static ArrayList<Statiker> statikerListe;
    public static ArrayList<Architekt> architektListe;
    public static ArrayList<Bauarbeiter> bauarbeiterListe;
    public static Scanner s;                  
    public static boolean statement;
    
    public static void main(String[] args) {                        
        s = new Scanner(System.in);                
        auftragListe = (ArrayList<Auftrag>)ReadFromFile.read ("auftragListe.data");                      
        projektleiterListe = (ArrayList<Projektleiter>)ReadFromFile.read ("projektleiterListe.data");                               
        statikerListe = (ArrayList<Statiker>)ReadFromFile.read ("statikerListe.data");                              
        architektListe = (ArrayList<Architekt>)ReadFromFile.read ("architektListe.data");                               
        bauarbeiterListe = (ArrayList<Bauarbeiter>)ReadFromFile.read ("bauarbeiterListe.data");              
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            WriteToFile.write(auftragListe, "auftragListe.data");
            WriteToFile.write(projektleiterListe, "projektleiterListe.data");
            WriteToFile.write(statikerListe, "statikerListe.data");
            WriteToFile.write(architektListe, "architektListe.data");
            WriteToFile.write(bauarbeiterListe, "bauarbeiterListe.data");
        }, "Shutdown-thread"));        

        prhr();
        prln("Möchten Sie das visuelle Interface starten? ( 1 : Ja / 0: Nein )");
        if (s.nextInt() == 1) {
            Frame masterFrame = new Frame();
            masterFrame.startMenu();
            System.out.println("Listen leeren?");
            if (s.nextInt() == 1) {
                bauarbeiterListe = null;
                architektListe = null;
                statikerListe = null;
                projektleiterListe = null;
                
                if(bauarbeiterListe == null &&
                architektListe == null &&
                statikerListe == null &&
                projektleiterListe == null){
                    System.out.println("Alle Listen sind leer.");
                }
            
            }
        }
        s.nextLine();
                
        statement = true;
        while (statement) {            
            statement = Interface.startTextInterface();        
        }

    }         
    
    public static void prln (String string) {
        System.out.println(ANSI_RESET + string);        
    }
    
    public static void prln (String string, String color) {
        System.out.println(color + string + ANSI_RESET);        
    }
    
    public static void prhr () {
        prln(ANSI_RESET + "*********************************************************************");
    }       
    
    public static void setColor (String color) {
        System.out.print(color);
    }
}

