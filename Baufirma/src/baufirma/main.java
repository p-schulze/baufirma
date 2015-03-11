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
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static ArrayList<Auftrag> auftragListe;
    public static ArrayList<Projektleiter> projektleiterListe;
    public static ArrayList<Statiker> statikerListe;
    public static ArrayList<Architekt> architektListe;
    public static ArrayList<Bauarbeiter> bauarbeiterListe;
    public static Scanner s;                
    public static String content;
    public static boolean statement;
    
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
        
<<<<<<< Updated upstream
        prhr();
        prln("Möchten Sie das visuelle Interface starten? ( 1 : Ja / 0: Nein )");
        if (s.nextInt() == 1) {
            Frame masterFrame = new Frame();
            masterFrame.frameErstellen();
        }
        s.nextLine();
        
=======
       
        Frame masterFrame = new Frame();
        masterFrame.frameErstellen();

        

>>>>>>> Stashed changes
        statement = true;
        while (statement) {            
            startTextInterface();        
        }
<<<<<<< Updated upstream
    }   
=======



        
    //    startTextInterface();        

        
       // startTextInterface();        


    }
>>>>>>> Stashed changes
    
    public static void startTextInterface() {
        prhr();
        prln("Willkommen um Baufirma-Manager. Bitte wählen Sie, was Sie tun wollen!");
        prln("0 : Baufirma Manager beenden", ANSI_BLUE);
        prln("1 : Neuen Autrag erstellen", ANSI_BLUE);
        prln("2 : Auftrag anzeigen / verändern.", ANSI_BLUE);
        prln("3 : Angestellten hinzufügen", ANSI_BLUE);
        prln("4 : Angestellten anzeigen / verändern", ANSI_BLUE);
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
            case 4:
                showAngestellten();
                break;                
            default:
                statement = false;
                break;
        }
    }
    
    public static void addAuftrag () {        
        prhr();
        // Neuen Auftrag erstellen
        auftragListe.add(new Auftrag());                    
        int newIndex = auftragListe.size()-1;                    
        prln("Neuer Auftrag wurde erstellt.", ANSI_RED);

        prln("Welchen Titel soll der Auftrag haben?");                
        setColor(ANSI_GREEN);
        content = s.nextLine();
        if (content != null) {
            auftragListe.get(newIndex).setTitel(content);                   
            content = null;
        }                                                    

        prln("Wie ist der Name des Auftraggebers?");
        setColor(ANSI_GREEN);
        content = s.nextLine();        
        auftragListe.get(newIndex).setAuftraggeberName(content);
        content = null;        

        prln("Erstellen Sie die Adresse des Auftraggebers!");
        auftragListe.get(newIndex).setAuftraggeberAdresse(createNewAdresseByUserInput(true));

        prln("Erstellen Sie die Adresse des Auftragsortes!");
        auftragListe.get(newIndex).setAdresse(createNewAdresseByUserInput(false));            
    }
    
    public static void editAuftrag (Auftrag auftrag) {
        prhr();
        prln("Welches Attribut soll bearbeitet werden?");
        prln("0 : Baufirma Manager beenden", ANSI_BLUE);
        prln("1 : Titel", ANSI_BLUE);
        prln("2 : Aufraggebername", ANSI_BLUE);
        prln("3 : Auftraggeberadresse", ANSI_BLUE);
        prln("4 : Auftragsortadresse", ANSI_BLUE);
        
        int choice = s.nextInt();
        s.nextLine();
        switch (choice) {            
            case 1:
                setColor(ANSI_GREEN);
                auftrag.setTitel(s.nextLine());
                break;
            case 2:
                setColor(ANSI_GREEN);
                auftrag.setAuftraggeberName(s.nextLine());
                break;
            case 3:
                auftrag.setAuftraggeberAdresse(editAdresse(auftrag.getAuftraggeberAdresse(), true));                
                break;
            case 4:                
                auftrag.setAdresse(editAdresse(auftrag.getAdresse(), false));                
                break;                
            default:
                statement = false;
                break;                            
        }        
        prln("Auftrag wurde aktualisiert.", ANSI_RED);    
    }
    
    public static Adresse createNewAdresseByUserInput (boolean metaData) {                        
        Adresse adresse = new Adresse();        
        prln("Möchten Sie die Adresse hinzufügen? ( 1 : Ja / 0: Nein )");
        int choice;
        choice = s.nextInt();
        s.nextLine();
        
        if (choice == 1) {
            prln("Land?");
            setColor(ANSI_GREEN);
            adresse.setLand(s.nextLine());
            prln("Stadt?");
            setColor(ANSI_GREEN);
            adresse.setStadt(s.nextLine());
            prln("Straße?");
            setColor(ANSI_GREEN);
            adresse.setStrasse(s.nextLine());
            prln("Hausnummer?");
            adresse.setHausnummer(s.nextInt());        
            s.nextLine();
        
            if (metaData == true) {
                prln("Mailadresse?");
                setColor(ANSI_GREEN);
                adresse.setMailadresse(s.nextLine());
                prln("Telefonnummer?");
                setColor(ANSI_GREEN);
                adresse.setTelefonnummer(s.nextLine());        
            }
        }
        
        return adresse;
    }
    
    public static Adresse editAdresse (Adresse adresse, boolean metaData) {
        prhr();
        prln("Welches Attribut der Adresse soll bearbeitet werden?");
        prln("0 : Baufirma Manager beenden", ANSI_BLUE);
        prln("1 : Land", ANSI_BLUE);
        prln("2 : Stadt", ANSI_BLUE);
        prln("3 : Straße", ANSI_BLUE);
        prln("4 : Hausnummer", ANSI_BLUE);
        if (metaData) {
            prln("5 : Mailadresse", ANSI_BLUE);
            prln("6 : Telefonnummer", ANSI_BLUE);
        }           
        
        int choice = s.nextInt();
        s.nextLine();
        if (!metaData && (choice == 5 || choice == 6)) {
            choice = 0;
        }
        
        switch (choice) {            
            case 1:
                setColor(ANSI_GREEN);
                adresse.setLand(s.nextLine());
                break;
            case 2:
                setColor(ANSI_GREEN);
                adresse.setStadt(s.nextLine());
                break;
            case 3:
                setColor(ANSI_GREEN);
                adresse.setStrasse(s.nextLine());
                break; 
            case 4:
                setColor(ANSI_GREEN);
                adresse.setHausnummer(s.nextInt());
                s.nextLine();
                break;                 
            case 5:
                setColor(ANSI_GREEN);
                adresse.setMailadresse(s.nextLine());
                break;               
            case 6:
                setColor(ANSI_GREEN);
                adresse.setTelefonnummer(s.nextLine());
                break;                               
            default:
                statement = false;
                break;
        }
                        
        return adresse;               
    }
    
    public static void showAuftrag() {
        prhr();
        prln("Welcher Auftrag soll angezeigt werden?");
        prln("0 : Baufirma Manager beenden", ANSI_BLUE);
        for (int i = 0; i < auftragListe.size(); i++) {
               prln((i+1) + " : " + auftragListe.get(i).getTitel(), ANSI_BLUE);
        }

        int num = s.nextInt();   
        s.nextLine();        
        
        if (num == 0) {
            statement = false;
            return;
        }
        
        printAuftrag(auftragListe.get(num-1));
                        
        prln ("Möchten Sie den Auftrag verändern?");
        prln ("0 : Nicht verändern", ANSI_BLUE);
        prln ("1 : Auftrag entfernen", ANSI_BLUE);
        prln ("2 : Auftrag bearbeiten", ANSI_BLUE);
        
        int choice = s.nextInt();
        s.nextLine();
        switch (choice) {
            case 0:
                startTextInterface();
                break;
            case 1:
                auftragListe.remove(num-1);
                prln("Der Auftrag wurde entfernt.", ANSI_RED);
                break;            
            case 2:
                editAuftrag(auftragListe.get(num-1));                
                break;     
            default:
                    
                break;
        }

    }
    
    public static void printAuftrag (Auftrag toPrintAuftrag) {
        prhr();
        if (toPrintAuftrag.getTitel() != null)
            prln("Auftrag : " + toPrintAuftrag.getTitel());

        if (toPrintAuftrag.getAdresse() != null) {
            prln("Auftrag Adressdaten:");
           printAdresse(toPrintAuftrag.getAdresse());
        }
                       
        if (toPrintAuftrag.getAuftraggeberName() != null) {
            prln("Auftraggebername : " + toPrintAuftrag.getAuftraggeberName()); 
        }
        
        
        if (toPrintAuftrag.getAuftraggeberAdresse() != null) {
            prln("Auftraggeber Adressdaten: ");
            printAdresse(toPrintAuftrag.getAuftraggeberAdresse());
        }
    }
    
    public static void printAdresse (Adresse adresse) {
         if (adresse.getLand() != null) {
                prln("Land : " + adresse.getLand()); }
        
            if (adresse.getLand() != null) {
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
    
    public static void addAngestellten () {       
        prhr();
        prln("Welchen Typ hat der Angestellte?");
        prln("1 : Projektleiter", ANSI_BLUE);
        prln("2 : Bauarbeiter", ANSI_BLUE);
        prln("3 : Architekt", ANSI_BLUE);
        prln("4 : Statiker", ANSI_BLUE);
        
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
        setColor(ANSI_GREEN);
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
        prhr();
        prln("Wie ist der Name des Angestellten?");
        setColor(ANSI_GREEN);
        angestellter.setName(s.nextLine());        
        
        prln("Wie ist die Adresse des Angestellten?");
        angestellter.setAdresse(createNewAdresseByUserInput(true));
        
        prln("Wie ist das Gehalt des Angestellten?");
        angestellter.setGehalt(s.nextFloat());
        setColor(ANSI_GREEN);
        s.nextLine();                
    }
    
    public static void showAngestellten () {
        prhr();
        prln("Welche Angestelltengruppe möchten sie sehen?", ANSI_BLUE);
        prln("0 : Baufirma Manager beenden", ANSI_BLUE);
        prln("1 : Projektleiter", ANSI_BLUE);
        prln("2 : Bauarbeiter", ANSI_BLUE);
        prln("3 : Architekt", ANSI_BLUE);
        prln("4 : Statiker", ANSI_BLUE);
        
        int choice = s.nextInt();
        s.nextLine();
        
        if (choice == 0) {
            statement = false;
            return;
        }
                
        switch (choice) {
            case 1:
                printAngestellten(projektleiterListe);                
                break;
            case 2:
                printAngestellten(bauarbeiterListe);
                break;
            case 3:
                printAngestellten(architektListe);
                break;
            case 4:
                printAngestellten(statikerListe);
                break;    
            default:
                
                break;
        }
    }
    
    public static void printAngestellten (ArrayList<? extends Angestellter> liste) {
        prhr();
        prln("0 : Baufirma Manager beenden", ANSI_BLUE);
        for (int i = 0; i < liste.size(); i++) {
               prln((i+1) + " : " + liste.get(i).getName(), ANSI_BLUE);
        }
                        
        int num = s.nextInt();
        s.nextLine();
        
        if (num == 0) {
            statement = false;
            return;
        }
        
        prhr();
        
        prln("Name : " + liste.get(num-1).getName());
        prln("Adresse : ");
        printAdresse(liste.get(num-1).getAdresse());
        prln("Gehalt : " + liste.get(num-1).getGehalt());
        
        prln ("Möchten Sie den Angestellten verändern?", ANSI_BLUE);
        prln ("0 : Nicht verändern", ANSI_BLUE);
        prln ("1 : Angestellten entlassen", ANSI_BLUE);
        prln ("2 : Angestellten bearbeiten", ANSI_BLUE);
        
        int choice = s.nextInt();
        s.nextLine();
        switch (choice) {
            case 1:
                liste.remove(num-1);
                prln("Der Angestellte wurde entlassen.", ANSI_RED);
                break;            
            case 2:
                editAngestellten(liste.get(num-1));
                break;                
            default:
                
                break;
        }             
    }
    
    public static void editAngestellten(Angestellter angestellter) {
        prhr();
        prln("Welches Attribut soll bearbeitet werden?");
        prln("0 : Baufirma Manager beenden", ANSI_BLUE);
        prln("1 : Name", ANSI_BLUE);
        prln("2 : Gehalt", ANSI_BLUE);
        prln("3 : Adresse", ANSI_BLUE);
        
        int choice = s.nextInt();
        s.nextLine();
        switch (choice) {            
            case 1:
                setColor(ANSI_GREEN);
                angestellter.setName(s.nextLine());
                break;
            case 2:
                setColor(ANSI_GREEN);
                angestellter.setGehalt(s.nextInt());
                s.nextLine();
                break;
            case 3:
                angestellter.setAdresse(editAdresse(angestellter.getAdresse(), true));
                break;              
            default:
                statement = false;
                break;
        }
        prln("Angestellter wurde aktualisiert.", ANSI_RED);    
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

