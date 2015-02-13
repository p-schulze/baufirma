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
    public static ArrayList<Bauarbeiter> bauarbeiterListe;
    public static Scanner s;                
    public static String content;
    
    public static void main(String[] args) {                
        s = new Scanner (System.in);
        content = null;
        auftragListe = new ArrayList<>();       
        auftragListe = (ArrayList<Auftrag>)ReadFromFile.read ("auftragListe.data");                

        projektleiterListe = new ArrayList<>();
        projektleiterListe = (ArrayList<Projektleiter>)ReadFromFile.read ("projektleiterListe.data");               
        
        statikerListe = new ArrayList<>();
        statikerListe = (ArrayList<Statiker>)ReadFromFile.read ("statikerListe.data");               
        
        architektListe = new ArrayList<>();
        architektListe = (ArrayList<Architekt>)ReadFromFile.read ("architektListe.data");               
        
        bauarbeiterListe = new ArrayList<>();
        bauarbeiterListe = (ArrayList<Bauarbeiter>)ReadFromFile.read ("bauarbeiterListe.data");               
        
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
              WriteToFile.write(auftragListe, "auftragListe.data");
              WriteToFile.write(projektleiterListe, "projektleiterListe.data");
              WriteToFile.write(statikerListe, "statikerListe.data");
              WriteToFile.write(architektListe, "architektListe.data");
              WriteToFile.write(bauarbeiterListe, "bauarbeiterListe.data");         
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
        prln("3 : Angestellten hinzufügen");
        int choice = s.nextInt();
        s.nextLine();
        switch (choice) {
            case 1:
                addAuftrag();
                break;
            case 2:
                showAuftrag();
                break;
            case 3:
                addAngestellten();
                break;
            default:
                    
                break;
        }
    }
    
    public static void addAuftrag () {
        
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
    }
    
    public static Adresse createNewAdresseByUserInput (boolean metaData) {                        
        Adresse adresse = new Adresse();        
        prln("Möchten Sie die Adresse hinzufügen? ( 1 : Ja / 0: Nein )");
        int choice;
        choice = s.nextInt();
        s.nextLine();
        
        if (choice == 1) {
            prln("Land?");
            adresse.setLand(s.nextLine());
            prln("Stadt?");
            adresse.setStadt(s.nextLine());
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
        }
        
        return adresse;
    }
    
    public static void showAuftrag() {
        prln("Welcher Auftrag soll angezeigt werden?");
        for (int i = 0; i < auftragListe.size(); i++) {
               prln((i+1) + " : " + auftragListe.get(i).getTitel());
        }

        int num = s.nextInt();                
        printAuftrag(auftragListe.get(num-1));
        s.nextLine();

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
           
            if (toPrintAuftrag.getAuftraggeberAdresse().getStrasse() != null)            
                prln("Straße : " + toPrintAuftrag.getAuftraggeberAdresse().getStrasse());
        
            if (toPrintAuftrag.getAuftraggeberAdresse().getHausnummer() != 0)            
               prln("Hausnummer : " + toPrintAuftrag.getAuftraggeberAdresse().getHausnummer());
        }
    }
    
    public static void addAngestellten () {       
        prln("Welchen Typ hat der Angestellte?");
        prln("1 : Projektleiter");
        prln("2 : Bauarbeiter");
        prln("3 : Architekt");
        prln("4 : Statiker");
        int choice = s.nextInt();
        s.nextLine();
        
        switch (choice) {
            case 1:
                addProjektleiter();
                break;
            case 2:
                addBauarbeiter();
                break;
            case 3:
                addArchitekt();
                break;
            case 4:
                addStatiker();
                break;    
            default:
                    
                break;
        }

    }
    
    public static void addProjektleiter() {
        projektleiterListe.add(new Projektleiter());
        addAngestellterInformationen(projektleiterListe.get(projektleiterListe.size()-1));
        
    }
    
    public static void addBauarbeiter() { 
        bauarbeiterListe.add(new Bauarbeiter());
        addAngestellterInformationen(bauarbeiterListe.get(bauarbeiterListe.size()-1));
        prln("Von welchem Typ ist der Bauarbeiter?");
        bauarbeiterListe.get(bauarbeiterListe.size()-1).setBauarbeiterTyp(s.nextLine());
    }
    
    public static void addArchitekt() {
        architektListe.add(new Architekt());
        addAngestellterInformationen(architektListe.get(architektListe.size()-1));
    }
    
    public static void addStatiker() {
        statikerListe.add(new Statiker());
        addAngestellterInformationen(statikerListe.get(statikerListe.size()-1));
    }
    
    public static void addAngestellterInformationen (Angestellter angestellter) {            
        prln("Wie ist der Name des Angestellten?");
        angestellter.setName(s.nextLine());        
        
        prln("Wie ist die Adresse des Angestellten?");
        angestellter.setAdresse(createNewAdresseByUserInput(true));
        
        prln("Wie ist das Gehalt des Angestellten?");
        angestellter.setGehalt(s.nextFloat());
        s.nextLine();                
    }
    
    public static void prln (String string) {
        System.out.println(string);        
    } 
        
    
}

