/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baufirma;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
import java.lang.*;

/**
 *
 * @author Lehmann
 */

public class Interface {
    private static final String RESET = "\u001B[0m", BLACK = "\u001B[30m", 
            RED = "\u001B[31m", GREEN = "\u001B[32m", YELLOW = "\u001B[33m", 
            BLUE = "\u001B[34m", PURPLE = "\u001B[35m", CYAN = "\u001B[36m", 
            WHITE = "\u001B[37m";    
    
    private static Scanner s;                
    private static String content;
    private static int choice;
    private static boolean statement;
    
    public static boolean startTextInterface () {
        s = new Scanner (System.in);               
        statement = true;
        int angestelltenTyp;
        
        showMainMenuOptions();
        
        switch (getInt()) {            
            case 1:
                // Neuen Auftrag erstellen
                main.auftragListe.add(createNewAuftrag());
                break;
            case 2:
                // Alle Aufträge anzeigen / bearbeiten
                prln("Welcher Auftrag soll angezeigt werden?");
                showAlleAuftraege(main.auftragListe);
                int auftragNum = getInt()-1;
                if (auftragNum >= 0) {
                    showAuftragDetails(main.auftragListe.get(auftragNum));
                    showAuftragEditingOptions();
                    switch (getInt()) {
                        case 0:
                        break;
                        case 1:
                            moveAllAngestellteFromAuftragToList(main.auftragListe.get(auftragNum));
                            main.auftragListe.remove(auftragNum);                            
                            prln("Der Auftrag wurde entfernt.", RED);
                        break;            
                        case 2:                       
                            main.auftragListe.set(auftragNum, editAuftrag(main.auftragListe.get(auftragNum)));                
                        break;     
                        default:                    
                        break;
                    }
                }
                break;
            case 3:
                // Angestellten hinzufügen
                showAngestelltenTypen();
                angestelltenTyp = getInt();
                if (angestelltenTyp > 0 && angestelltenTyp < 5) {
                    addNewAngestellten(angestelltenTyp);                                   
                }
                break;
            case 4:
                // Angestellte/n anzeigen/ bearbeiten
                prhr();
                showAngestelltenTypen();                
                angestelltenTyp = getInt();
                if (angestelltenTyp > 0) {                        
                    showAngestellte(getAngestelltenListByNum(angestelltenTyp));
                    prln("Wählen Sie einen Angestellten!");
                    int angestellterNum = getInt();
                    if (angestellterNum > 0) {
                        showAngestellterDetails(getAngestelltenListByNum(angestelltenTyp).get(angestellterNum-1));                                        
                        showAngestellterEditingOptions();
                        switch (getInt()) {
                            case 0:
                            break;
                            case 1:
                                getAngestelltenListByNum(angestelltenTyp).remove(angestellterNum-1);
                                prln("Der Angestellte wurde entlassen.", RED);
                            break;            
                            case 2:              
                                editAngestellten(getAngestelltenListByNum(angestelltenTyp).get(angestellterNum-1));                                    
                            break;     
                            default:                    
                            break;
                        }
                    }                    
                }    
                break; 
            case 5:
                // Angestellte versetzen
                moveAngestellten();
                break;             
            case 6:
                // Angestellte sortiert anzeigen
                showOrderingOptions();
                showOrderedAngestellte(getInt());
                break;                 
            default:
                statement = false;
                break;                            
        }
        return statement;    
    }
    
    private static Auftrag createNewAuftrag () {                
        prhr();
        
        Auftrag auftrag = new Auftrag();               
        
        prln("Welchen Titel soll der Auftrag haben?");                
        auftrag.setTitel(getString());                   
                                                   
        prln("Wie ist der Name des Auftraggebers?");  
        auftrag.setAuftraggeberName(getString());        

        prln("Erstellen Sie die Adresse des Auftraggebers!");
        auftrag.setAuftraggeberAdresse(createNewAdresse(true));

        prln("Erstellen Sie die Adresse des Auftragsortes!");
        auftrag.setAdresse(createNewAdresse(false));            
        
        prln("Neuer Auftrag wurde erstellt.", RED);
        
        return auftrag;
    }
    
    private static Adresse createNewAdresse (boolean metaData) {                        
        Adresse adresse = new Adresse();        
        prln("Möchten Sie die Adresse hinzufügen? ( 1 : Ja / 0: Nein )");
        
        if (getInt() == 1) {
            prln("Land?");            
            adresse.setLand(getString());
            prln("Stadt?");            
            adresse.setStadt(getString());
            prln("Straße?");            
            adresse.setStrasse(getString());
            prln("Hausnummer?");
            adresse.setHausnummer(getInt());        
        
            if (metaData) {
                prln("Mailadresse?");                
                adresse.setMailadresse(getString());
                prln("Telefonnummer?");
                adresse.setTelefonnummer(getString());        
            }
        }
        
        return adresse;
    } 
    
    private static Auftrag editAuftrag (Auftrag auftrag) {        
        prhr();
        showAuftragEditingAttributes();
                
        switch (getInt()) {            
            case 1:                
                auftrag.setTitel(getString());
                break;
            case 2:                
                auftrag.setAuftraggeberName(getString());
                break;
            case 3:
                auftrag.setAuftraggeberAdresse(editAdresse(auftrag.getAuftraggeberAdresse(), true));                
                break;
            case 4:                
                auftrag.setAdresse(editAdresse(auftrag.getAdresse(), false));                
                break;                
            default:                
                break;                            
        }        
        prln("Auftrag wurde aktualisiert.", RED);
     return auftrag;   
    }        
    
    public static Adresse editAdresse (Adresse adresse, boolean metaData) {        
        prhr();
        showAdresseEditingAttributes(metaData);
        
        choice = getInt();        
        if (!metaData && (choice == 5 || choice == 6)) {
            choice = 0;
        }
        
        switch (choice) {            
            case 1:                
                adresse.setLand(getString());
                break;
            case 2:                
                adresse.setStadt(getString());
                break;
            case 3:
                adresse.setStrasse(getString());
                break; 
            case 4:
                adresse.setHausnummer(getInt());
                break;                 
            case 5:
                adresse.setMailadresse(getString());
                break;               
            case 6:                
                adresse.setTelefonnummer(getString());
                break;                               
            default:
                statement = false;
                break;
        }
                        
        return adresse;               
    }       
    
    private static void addNewAngestellten (int angestellterTyp) {     
        switch (angestellterTyp) {
            case 1:
                Projektleiter newProjektleiter = new Projektleiter();
                addAngestellterStandardInformationen(newProjektleiter);                
                main.projektleiterListe.add(newProjektleiter);
                break;
            case 2:
                Bauarbeiter newBauarbeiter = new Bauarbeiter();
                addAngestellterStandardInformationen(newBauarbeiter);                
                prln("Von welchem Typ ist der Bauarbeiter?");                
                newBauarbeiter.setBauarbeiterTyp(getString());
                main.bauarbeiterListe.add(newBauarbeiter);                
                break;
            case 3:
                Architekt newArchitekt = new Architekt();
                addAngestellterStandardInformationen(newArchitekt);                
                main.architektListe.add(newArchitekt);
                break;
            case 4:
                Statiker newStatiker = new Statiker();
                addAngestellterStandardInformationen(newStatiker);                
                main.statikerListe.add(newStatiker);                
                break;
            default:    
        }
        
        prln("Der Angestellte wurde hinzugefügt.", RED);
    }
    
    private static Angestellter addAngestellterStandardInformationen (Angestellter angestellter) {
        prhr();
        prln("Wie ist der Name des Angestellten?");        
        angestellter.setName(getString());        
        
        prln("Wie ist die Adresse des Angestellten?");
        angestellter.setAdresse(createNewAdresse(true));
        
        prln("Wie ist das Gehalt des Angestellten? (Fließkommazahl mit Komma)");
        angestellter.setGehalt(getFloat());      
        
        return angestellter;
    }
    
    private static ArrayList<? extends Angestellter> getAngestelltenListByNum (int num) {
        ArrayList<? extends Angestellter> list;
        switch (num) {
            case 1:                
                list = main.projektleiterListe;
                break;
            case 2:                
                list = main.bauarbeiterListe;                
                break;
            case 3:                
                list = main.architektListe;
                break;
            case 4:                
                list = main.statikerListe;                
                break;
            default:            
                list = null;
        }           
        
        return list;
    }
    
    public static Angestellter editAngestellten(Angestellter angestellter) {        
        showAngestellterEditingAttributes();                
        switch (getInt()) {            
            case 1:                
                angestellter.setName(getString());
                break;
            case 2:                
                angestellter.setGehalt(getFloat());
                break;
            case 3:
                angestellter.setAdresse(editAdresse(angestellter.getAdresse(), true));
                break;                                                          
            default:
        }
        prln("Angestellter wurde aktualisiert.", RED);    
        
        return (Angestellter)angestellter;
    }

    private static void moveAngestellten () {
        prhr();
        prln("Wie möchten Sie den Angestellten versetzen?");
        prln("0 :  zum Hauptmenü", BLUE);
        prln("1 :  Aus einem Auftrag in die Angestellten-Liste", BLUE);
        prln("2 :  Aus der Angestellten-Liste in einen Auftrag", BLUE);
        
        int angestellterTyp, auftragNum;
        
        switch (getInt()) {
            case 1:
                prhr();
                prln("Aus welchem Auftrag möchten Sie den Angestellten verschieben?");
                showAlleAuftraege(main.auftragListe);
                auftragNum = getInt();
                if (auftragNum <= 0) break;
                
                showAngestelltenTypen();
                angestellterTyp = getInt();
                if (angestellterTyp <= 0) break;
                
                switch (angestellterTyp) {
                    case 1:                                                        
                        main.projektleiterListe.add(main.auftragListe.get(auftragNum-1).getProjektleiter());
                        main.auftragListe.get(auftragNum-1).setProjektleiter(null);
                        prln("Projektleiter wurde verschoben.", RED);
                        break;
                    case 2:
                        prhr();
                        prln("Welcher Bauarbeiter soll verschoben werden?");
                        int choice = getInt();
                        if (choice > 0) {
                            prhr();
                            showAngestellte(main.auftragListe.get(auftragNum-1).getBauarbeiterListe());
                            main.bauarbeiterListe.add(main.auftragListe.get(auftragNum-1).getBauarbeiterFromListe(choice-1));
                            main.auftragListe.get(auftragNum-1).removeBauarbeiterFromListe(choice-1);
                        }    
                        break;
                    case 3:
                        main.architektListe.add(main.auftragListe.get(auftragNum-1).getArchitekt());
                        main.auftragListe.get(auftragNum-1).setArchitekt(null);
                        prln("Architekt wurde verschoben.", RED);
                        break;
                    case 4:
                        main.statikerListe.add(main.auftragListe.get(auftragNum-1).getStatiker());
                        main.auftragListe.get(auftragNum-1).setStatiker(null);
                        prln("Statiker wurde verschoben.", RED);                  
                        break;
                    default:
                }                    
            break;
            case 2:
                prhr();
                prln("In welchen Auftrag möchten Sie den Angestellten verschieben?");
                showAlleAuftraege(main.auftragListe);                
                auftragNum = getInt();                                                
                if (auftragNum <= 0) break;
                
                showAngestelltenTypen();
                angestellterTyp = getInt();                
                if (angestellterTyp <= 0) break;
                
                prhr();
                prln("Welcher Angestellter?");
                showAngestellte(getAngestelltenListByNum(angestellterTyp));                                                  
                int angestellterNum = getInt();
                if (angestellterNum <= 0) break;                
                
                switch (angestellterTyp) {
                    case 1:
                        if (main.auftragListe.get(auftragNum-1).getProjektleiter() != null) {
                            main.projektleiterListe.add(main.auftragListe.get(auftragNum-1).getProjektleiter());
                            prln("Alter Projektleiter wurde in die Projektleiterliste verschoben", RED);
                        }
                        main.auftragListe.get(auftragNum-1).setProjektleiter(main.projektleiterListe.get(angestellterNum-1));                        
                        main.projektleiterListe.remove(angestellterNum-1);                        
                        prln("Projektleiter wurde verschoben.", RED);
                        break;
                    case 2:                    
                        main.auftragListe.get(auftragNum-1).addBauarbeiterToListe(
                        main.bauarbeiterListe.get(angestellterNum-1));                       
                        main.bauarbeiterListe.remove(angestellterNum-1);                        
                        break;
                    case 3:
                        if (main.auftragListe.get(auftragNum-1).getArchitekt() != null) {
                            main.architektListe.add(main.auftragListe.get(auftragNum-1).getArchitekt());
                            prln("Alter Architekt wurde in die Architektenliste verschoben", RED);
                        }
                        main.auftragListe.get(auftragNum-1).setArchitekt(main.architektListe.get(angestellterNum-1));                        
                        main.architektListe.remove(angestellterNum-1);                        
                        prln("Architekt wurde verschoben.", RED);
                        break;
                    case 4:
                        if (main.auftragListe.get(auftragNum-1).getStatiker() != null) {
                            main.statikerListe.add(main.auftragListe.get(auftragNum-1).getStatiker());
                            prln("Alter Statiker wurde in die Statikerliste verschoben", RED);
                        }
                        main.auftragListe.get(auftragNum-1).setStatiker(main.statikerListe.get(angestellterNum-1));                        
                        main.statikerListe.remove(angestellterNum-1);                        
                        prln("Statiker wurde verschoben.", RED);                  
                        break;
                    default:
                }                                  
                break;
            default:    
        }
        
    }
    
    private static void moveAllAngestellteFromAuftragToList (Auftrag auftrag) {
        if (auftrag.getProjektleiter() != null) {
            main.projektleiterListe.add(auftrag.getProjektleiter());
            auftrag.setProjektleiter(null);
            prln("Projektleiter wurde zurück in die Projektleiterliste verschoben.", RED);
        }
        
        if (auftrag.getStatiker() != null) {
            main.statikerListe.add(auftrag.getStatiker());
            auftrag.setStatiker(null);
            prln("Statiker wurde zurück in die StatikerListe verschoben.", RED);
        }
        
        if (auftrag.getArchitekt() != null) {
            main.architektListe.add(auftrag.getArchitekt());
            auftrag.setArchitekt(null);
            prln("Architekt wurde zurück in die Architektenliste verschoben.", RED);
        }
             
        int i;
        for (i = 0; i < auftrag.getBauarbeiterListe().size(); i++) {
            main.bauarbeiterListe.add(auftrag.getBauarbeiterFromListe(i));
        }
        
        auftrag.setBauarbeiterListe(new ArrayList<>());
        
        if (i > 0) {
            prln(i + " Bauarbeiter wurden zurück in die Bauarbeiterliste verschoben.", RED);
        }
    }
    
    private static ArrayList<Angestellter> getAlleAngestellte () {
        ArrayList<Angestellter> list = new ArrayList<>();
        
        // Angestellte aus den Angestelltenlisten
        for (int i = 1; i < 5; i++) {
            list.addAll(getAngestelltenListByNum(i));
        }        
        
        // Angestellte aus den Aufträgen
        for (int i = 0; i < main.auftragListe.size(); i++) {
            list.addAll(main.auftragListe.get(i).getBauarbeiterListe());
            if (main.auftragListe.get(i).getProjektleiter() != null) list.add(main.auftragListe.get(i).getProjektleiter());
            if (main.auftragListe.get(i).getStatiker() != null) list.add(main.auftragListe.get(i).getStatiker());
            if (main.auftragListe.get(i).getArchitekt() != null) list.add(main.auftragListe.get(i).getArchitekt());            
        }                        
        
        return list;
    }
        
    /**************************************** Darstellungsfunktionen ****************************************/
    
    private static void showMainMenuOptions () {
        prhr();
        prln("Willkommen um Baufirma-Manager. Bitte wählen Sie, was Sie tun wollen!");
        prln("0 : Baufirma Manager beenden", BLUE);
        prln("1 : Neuen Autrag erstellen", BLUE);
        prln("2 : Auftrag anzeigen / verändern.", BLUE);
        prln("3 : Angestellten hinzufügen", BLUE);
        prln("4 : (unbeschäftigte) Angestellte anzeigen / verändern", BLUE);
        prln("5 : Angestellten versetzen", BLUE); 
        prln("6 : Alle Angestellte geordnet anzeigen", BLUE); 
    }
        
    private static void showAlleAuftraege (ArrayList<Auftrag> auftragListe) {
        prln("0 : Zum Hauptmenü", BLUE);
        for (int i = 0; i < auftragListe.size(); i++) {
               prln((i+1) + " : " + auftragListe.get(i).getTitel(), BLUE);
        }        
    }
    
    private static void showAuftragEditingOptions () {
        prhr();
        prln ("Möchten Sie den Auftrag verändern?");
        prln ("0 : Nicht verändern und zum Hauptmenü", BLUE);
        prln ("1 : Auftrag entfernen", BLUE);
        prln ("2 : Auftrag bearbeiten", BLUE);        
    }
    
    private static void showAuftragDetails (Auftrag auftrag) {
        if (auftrag == null) return;
        
        prhr();
        if (auftrag.getTitel() != null)
            prln("Auftrag : " + auftrag.getTitel());

        if (auftrag.getAuftraggeberName() != null) {
            prln("Auftraggebername : " + auftrag.getAuftraggeberName()); 
        }        
        
        if (auftrag.getAuftraggeberAdresse() != null) {
            prln("Auftraggeber Adressdaten: ");
            showAdresse(auftrag.getAuftraggeberAdresse());
        } 
        
        if (auftrag.getAdresse() != null) {
            prln("Auftrag Adressdaten:");
           showAdresse(auftrag.getAdresse());
        }
        
        if (auftrag.getProjektleiter() != null) {
            prln("Projektleitername: " + auftrag.getProjektleiter().getName());
        }
        
        if (auftrag.getStatiker() != null) {
            prln("Statikername: " + auftrag.getStatiker().getName());
        }
                
        if (auftrag.getArchitekt() != null) {
            prln("Architektname: " + auftrag.getArchitekt().getName());
        }
        
        if (auftrag.getBauarbeiterListe() != null) {
            prln("Bauarbeiter:");
            for (int i = 0; i < auftrag.getBauarbeiterListe().size(); i++) {
                prln(auftrag.getBauarbeiterListe().get(i).getName());
            }
        }
        
    }    
    
    private static void showAdresse (Adresse adresse) {
         if (adresse.getLand() != null) {
            prln("Land : " + adresse.getLand()); }
        
        if (adresse.getStadt() != null) {
            prln("Stadt : " + adresse.getStadt()); }

        if (adresse.getStrasse() != null) {           
            prln("Straße : " + adresse.getStrasse()); }

        if (adresse.getHausnummer() != 0) {           
           prln("Hausnummer : " + adresse.getHausnummer()); }

        if (adresse.getMailadresse() != null) {           
           prln("Mailadresse : " + adresse.getMailadresse()); }

        if (adresse.getTelefonnummer() != null) {           
           prln("Telefonnummer : " + adresse.getTelefonnummer()); }
    }
    
    private static void showAuftragEditingAttributes () {
        prln("Welches Attribut soll bearbeitet werden?");
        prln("0 : zum Hauptmenü", BLUE);
        prln("1 : Titel", BLUE);
        prln("2 : Aufraggebername", BLUE);
        prln("3 : Auftraggeberadresse", BLUE);
        prln("4 : Auftragsortadresse", BLUE);
    }
    
    private static void showAdresseEditingAttributes (boolean metaData) {
        prln("Welches Attribut der Adresse soll bearbeitet werden?");
        prln("0 : zum Hauptmenü", BLUE);
        prln("1 : Land", BLUE);
        prln("2 : Stadt", BLUE);
        prln("3 : Straße", BLUE);
        prln("4 : Hausnummer", BLUE);
        if (metaData) {
            prln("5 : Mailadresse", BLUE);
            prln("6 : Telefonnummer", BLUE);
        }     
    }
    
    private static void showAngestelltenTypen () {        
        prln("Angestellte/r welchen Typs?");        
        prln("0 : zum Hauptmenü", BLUE);
        prln("1 : Projektleiter", BLUE);
        prln("2 : Bauarbeiter", BLUE);
        prln("3 : Architekt", BLUE);
        prln("4 : Statiker", BLUE);                                 
    }
    
    private static void showAngestellte(ArrayList<? extends Angestellter> liste) {         
        prhr();
        prln("0 : zum Hauptmenü", BLUE);
        for (int i = 0; i < liste.size(); i++) {
               prln((i+1) + " : " + liste.get(i).getName(), BLUE);
        }
    }
    
    private static void showAngestellterDetails(Angestellter angestellter) {
        if (angestellter != null) { 
            prhr();        
            prln("Name : " + angestellter.getName());
            prln("Adresse : ");
            showAdresse(angestellter.getAdresse());
            prln("Gehalt : " + angestellter.getGehalt());
        }    
    }
    
    private static void showAngestellterEditingOptions () {
        prhr();        
        prln ("Möchten Sie den Angestellten verändern?", BLUE);
        prln ("0 : Nicht verändern", BLUE);
        prln ("1 : Angestellten entlassen", BLUE);
        prln ("2 : Angestellten bearbeiten", BLUE);
    }
    
    private static void showAngestellterEditingAttributes () {
        prhr();
        prln("Welches Attribut soll bearbeitet werden?");
        prln("0 : zum Hauptmenü", BLUE);
        prln("1 : Name", BLUE);
        prln("2 : Gehalt (Fließkommazahl mit Komma)", BLUE);
        prln("3 : Adresse", BLUE);
    }
    
    private static void showOrderingOptions () {
        prhr();
        prln("Wonach soll sortiert werden?");
        prln("0 : zum Hauptmenü", BLUE);
        prln("1 : Name", BLUE);
        prln("2 : Gehalt", BLUE);
    }
    
    private static void showOrderedAngestellte (int type) {
        prhr();
        ArrayList<Angestellter> alleAngestellte = getAlleAngestellte();                
        int j;
        
        switch (type ){
            case 1:
                // Name               
                for (int i = 1; i < alleAngestellte.size(); i++) {                    
                    j = i;
                    while (j >= 1 && alleAngestellte.get(j).getName().compareTo(alleAngestellte.get(j-1).getName()) < 0) {
                        Collections.swap(alleAngestellte, j, j-1);
                        j--;
                    }
                }
                break;
            case 2:
                // Gehalt                
                for (int i = 1; i < alleAngestellte.size(); i++) {                    
                    j = i;
                    while (j >= 1 && alleAngestellte.get(j).getGehalt() < alleAngestellte.get(j-1).getGehalt()) {
                        Collections.swap(alleAngestellte, j, j-1);
                        j--;
                    }
                }
                break;
            default:                 
        }
        
        for (int i = 0; i < alleAngestellte.size(); i++) {
            System.out.printf("%-30.30s  %-30.30s%n", alleAngestellte.get(i).getName(), alleAngestellte.get(i).getGehalt() + "\t€");
        }
        
        prln("Drücken Sie eine beliebige Taste...", BLUE);
        getString();
    }
    
    /**************************************** Hilfsfunktionen ****************************************/

    private static float getFloat() {
        setColor(GREEN);
        float d_choice = s.nextFloat();
        s.nextLine();        
        return d_choice;
    }
    
    private static int getInt() {
        setColor(GREEN);
        choice = s.nextInt();
        s.nextLine();        
        return choice;
    }
    
    private static String getString() {                
        setColor(GREEN);                
        return s.nextLine();
    }
    
    private static void prln (String string) {
        System.out.println(RESET + string);        
    }
    
    private static void prln (String string, String color) {
        System.out.println(color + string + RESET);        
    }
    
    private static void prhr () {
        prln(RESET + "*********************************************************************");
    }       
    
    private static void setColor (String color) {
         System.out.print(color);
    }
        
}