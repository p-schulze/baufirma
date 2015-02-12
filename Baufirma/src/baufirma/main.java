/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baufirma;

import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.*;




/**
 *
 * @author pascalschulze, tilllehmann
 */
public class main {

    /**
     * @param args the command line arguments
     */

    public static ArrayList<Auftrag> auftragListe;
    public static ArrayList<Projektleiter> projektleiterListe;
    public static ArrayList<Statiker> statikerListe;
    public static ArrayList<Architekt> architektListe;
    public static Auftrag auftrag;
    
    public static void main(String[] args) {                
        auftragListe = new ArrayList<>();        
        auftragListe = ReadFromFile.read ();                
        
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
              WriteToFile.write(auftragListe);
                       
            }
        }, "Shutdown-thread"));

        auftragListe = new ArrayList<>();
        
        Frame masterFrame = new Frame();
        masterFrame.frameErstellen();

        startTextInterface();        
    }


        //System.out.println("Hallo!");


    
    public static void startTextInterface() {
        prln("Willkommen um Baufirma-Manager. Bitte wählen Sie, was Sie tun wollen!");
        prln("1 : Neuen Autrag erstellen");
        prln("2 : Auftragsinformationen anzeigen");
        Scanner s = new Scanner (System.in);
        int choice = s.nextInt();
        s.nextLine();
        String content = null;
        switch (choice) {
            case 1:
                // Neuen Auftrag erstellen
                auftragListe.add(new Auftrag());                    
                int newIndex = auftragListe.size()-1;                    
                prln("Neuer Auftrag wurde erstellt.");
                
                prln("Welchen Titel soll der Auftrag haben?");                
                content = s.nextLine();
                if (content != null) {
                    auftragListe.get(newIndex).setTitel(content);                   
                    content = null;
                }                                                    
                
                prln("Wie ist der Name des Auftraggebers?");
                content = s.nextLine();
                if (content != null) {
                    auftragListe.get(newIndex).setAuftraggeberName(content);
                    content = null;
                }
                
                prln("Erstellen Sie die Adresse des Auftraggebers!");
                auftragListe.get(newIndex).setAuftraggeberAdresse(createNewAdresseByUserInput(true));
                
                prln("Erstellen Sie die Adresse des Auftragsortes!");
                auftragListe.get(newIndex).setAdresse(createNewAdresseByUserInput(false));
                
                break;
            case 2:
                prln("Welcher Auftrag soll angezeigt werden?");
                for (int i = 0; i < auftragListe.size(); i++) {
                    prln((i+1) + " : " + auftragListe.get(i).getTitel());
                }
                
                int num = s.nextInt();                
                printAuftrag(auftragListe.get(num-1));
                s.nextLine();

                break;
            default:
                    
                break;
        }
    }
    
    
    public static Adresse createNewAdresseByUserInput (boolean metaData) {        
        Scanner s = new Scanner (System.in);      
        
        Adresse adresse = new Adresse();
        
        prln("Land?");
        adresse.setLand(s.nextLine());
        prln("Stadt?");
        adresse.setStadt(s.nextLine());
        prln("PLZ?");
        adresse.setPlz(s.nextInt());
        s.nextLine();
        prln("Straße?");
        adresse.setStrasse(s.nextLine());
        prln("Hausnummer?");
        adresse.setHausnummer(s.nextInt());        
        s.nextLine();
        
        if (metaData == true) {
            prln("Mailadresse?");
            adresse.setMailadresse(s.nextLine());
            prln("Telefonnummer?");
            adresse.setTelefonnummer(s.nextLine());        
        }
        
        return adresse;
    }  
    
    public static void printAuftrag (Auftrag toPrintAuftrag) {
        if (toPrintAuftrag.getTitel() != null)
            prln("Auftrag : " + toPrintAuftrag.getTitel());

        if (toPrintAuftrag.getAdresse() != null) {
            prln("Auftrag Adressdaten:");

            if (toPrintAuftrag.getAdresse().getLand() != null) {
                prln("Land : " + toPrintAuftrag.getAdresse().getLand()); }
        
            if (toPrintAuftrag.getAdresse().getLand() != null) {
                prln("Stadt : " + toPrintAuftrag.getAdresse().getStadt()); }
        
            if (toPrintAuftrag.getAdresse().getPlz() != 0) {           
                prln("PLZ : " + toPrintAuftrag.getAdresse().getPlz()); }
        
            if (toPrintAuftrag.getAdresse().getStrasse() != null) {           
                prln("Straße : " + toPrintAuftrag.getAdresse().getStrasse()); }
        
            if (toPrintAuftrag.getAdresse().getHausnummer() != 0) {           
               prln("Hausnummer : " + toPrintAuftrag.getAdresse().getHausnummer()); }
        }
                       
        if (toPrintAuftrag.getAuftraggeberName() != null) {
            prln("Auftraggebername : " + toPrintAuftrag.getAuftraggeberName()); 
        }
        
        
        if (toPrintAuftrag.getAuftraggeberAdresse() != null) {
            prln("Auftraggeber Adressdaten:");

            if (toPrintAuftrag.getAuftraggeberAdresse().getLand() != null)
                prln("Land : " + toPrintAuftrag.getAuftraggeberAdresse().getLand());
        
            if (toPrintAuftrag.getAuftraggeberAdresse().getLand() != null)
                prln("Stadt : " + toPrintAuftrag.getAuftraggeberAdresse().getStadt());
        
            if (toPrintAuftrag.getAuftraggeberAdresse().getPlz() != 0)            
                prln("PLZ : " + toPrintAuftrag.getAuftraggeberAdresse().getPlz());
        
            if (toPrintAuftrag.getAuftraggeberAdresse().getStrasse() != null)            
                prln("Straße : " + toPrintAuftrag.getAuftraggeberAdresse().getStrasse());
        
            if (toPrintAuftrag.getAuftraggeberAdresse().getHausnummer() != 0)            
               prln("Hausnummer : " + toPrintAuftrag.getAuftraggeberAdresse().getHausnummer());
        }
    }
    
    public static void prln (String string) {
        System.out.println(string);
    } 
        
    
}

