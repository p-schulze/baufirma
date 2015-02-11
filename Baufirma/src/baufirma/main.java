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

    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<Auftrag> auftragListe;
    public static ArrayList<Projektleiter> projektleiterListe;
    public static ArrayList<Statiker> statikerListe;
    public static ArrayList<Architekt> architektListe;
    
    public static void main(String[] args) {        
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
               
            }
        }, "Shutdown-thread"));
        auftragListe = new ArrayList<>();
        startTextInterface();        
        //System.out.println("Hallo!");
    }
    
    public void objekte () {
        
    }    
    
    public static void startTextInterface() {
        System.out.println("Willkommen um Baufirma-Manager. Bitte wählen Sie, was Sie tun wollen!");
        System.out.println("1 : Neuen Autrag erstellen");
        Scanner s = new Scanner (System.in);
        int choice = s.nextInt();
        s.nextLine();
        String content = null;
        switch (choice) {
            case 1:
                // Neuen Auftrag erstellen
                auftragListe.add(new Auftrag());                    
                int newIndex = auftragListe.size()-1;                    
                System.out.println("Neuer Auftrag wurde erstellt.");
                
                System.out.println("Welchen Titel soll der Auftrag haben?");                
                content = s.nextLine();
                if (content != null) {
                    auftragListe.get(newIndex).setTitel(content);                   
                    content = null;
                }                                                    
                
                System.out.println("Wie ist der Name des Auftraggebers?");
                content = s.nextLine();
                if (content != null) {
                    auftragListe.get(newIndex).setAuftraggeberName(content);
                    content = null;
                }
                
                System.out.println("Erstellen Sie die Adresse des Auftraggebers!");
                auftragListe.get(newIndex).setAdresse(createNewAdresseByUserInput(true));
                
                System.out.println("Erstellen Sie die Adresse des Auftragsortes!");
                auftragListe.get(newIndex).setAdresse(createNewAdresseByUserInput(false));
                         
                break;
            case 2:
                
                break;
            default:
                    
                break;
        }
    }
    
    
    public static Adresse createNewAdresseByUserInput (boolean metaData) {        
        Scanner s = new Scanner (System.in);      
        
        Adresse adresse = new Adresse();
        
        System.out.println("Land?");
        adresse.setLand(s.nextLine());
        System.out.println("Stadt?");
        adresse.setStadt(s.nextLine());
        System.out.println("PLZ?");
        adresse.setPlz(s.nextInt());
        s.nextLine();
        System.out.println("Straße?");
        adresse.setStrasse(s.nextLine());
        System.out.println("Hausnummer?");
        adresse.setHausnummer(s.nextInt());        
        s.nextLine();
        
        if (metaData == true) {
            System.out.println("Mailadresse?");
            adresse.setMailadresse(s.nextLine());
            System.out.println("Telefonnummer?");
            adresse.setTelefonnummer(s.nextLine());        
        }
        
        return adresse;
    }   
    
    
}

