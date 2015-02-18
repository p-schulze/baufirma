package baufirma;

import static baufirma.main.s;
import java.awt.BorderLayout;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author pascalschulze
 */
public class Frame {
    
    public void Frame () {}
    
    public void frameErstellen () {
        JFrame backgroundFrame = new JFrame();
        backgroundFrame.setSize(400,43);
        backgroundFrame.setLocation(0, 0);
        backgroundFrame.setResizable(false);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Hinzufügen");
        JMenuItem angestellter1 = new JMenuItem("Angestellter");
        JMenuItem auftrag1 = new JMenuItem("Auftrag");
        
        JMenu menu2 = new JMenu("Bearbeiten");
        JMenuItem angestellter2 = new JMenuItem("Angestellter");
        JMenuItem auftrag2 = new JMenuItem("Auftrag");
        
        JMenu menu3 = new JMenu("Übersicht");
        JMenuItem angestellter3 = new JMenuItem("Angestellter");
        JMenuItem auftrag3 = new JMenuItem("Auftrag");
        
  
        menu1.add(angestellter1);
        menu1.add(auftrag1);
        menu2.add(angestellter2);
        menu2.add(auftrag2);
        menu3.add(angestellter3);
        menu3.add(auftrag3);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        backgroundFrame.add(menuBar, BorderLayout.NORTH);
        
        backgroundFrame.setVisible(true);
        
        angestellter1.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
                neuerArbeiterFrame();
       
            }
        });
        
        auftrag1.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
                neuerAuftragFrame();
            }
        });
        
        angestellter2.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
                bearbeitenAngestellteFrame();
       
            }
        });
        
        auftrag2.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
                bearbeitenAngestellteFrame();
            }
        });
        
        angestellter3.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
                uebersichtAngestellteFrame();
       
            }
        });
        
        auftrag3.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
               uebersichtAuftragFrame();
            }
        });
        
       
   }
  
   public void neuerArbeiterFrame () {
        JDialog arbeiterFrame = new JDialog();
        arbeiterFrame.setSize(250,300);
        arbeiterFrame.setLocation(450, 0);
        JPanel arbeiterPanel = new JPanel();
        
        JLabel frage = new JLabel("Was für ein Arbeiter?", JLabel.CENTER);
        arbeiterPanel.add(frage);
        String arbeiter[] = {"Bauarbeiter", "Statiker", "Architekt", "Projektleiter"};
 
        JComboBox arbeiterAuswahl = new JComboBox(arbeiter);
        
        JLabel nameLabel = new JLabel("Name", JLabel.CENTER);
        JLabel gehaltLabel = new JLabel("Gehalt in € (Form: xxx.xx)", JLabel.CENTER);
        JTextField tfName = new JTextField("", JTextField.CENTER);
        JTextField tfGehalt = new JTextField("", JTextField.CENTER);
        JButton erstellenButton = new JButton("Erstellen");
        
        arbeiterPanel.add(arbeiterAuswahl);
        
        arbeiterPanel.add(nameLabel);
        arbeiterPanel.add(tfName);
        arbeiterPanel.add(gehaltLabel);
        arbeiterPanel.add(erstellenButton);
        arbeiterPanel.add(tfGehalt);
        arbeiterPanel.add(erstellenButton);
        arbeiterPanel.setLayout( new java.awt.GridLayout( 7, 2 ) );
        arbeiterFrame.add(arbeiterPanel);
        arbeiterFrame.setVisible(true);
        
        erstellenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                int index = arbeiterAuswahl.getSelectedIndex();
                String neuerAngestellterName = tfName.getText();
                
                float neuerAngestellterGehalt;
                if(tfGehalt.getText().length() != 0){
                neuerAngestellterGehalt = Float.parseFloat(tfGehalt.getText());
                }
                else {neuerAngestellterGehalt = 0.0f;}
                
                
                
                if (neuerAngestellterName.length() != 0){
                    arbeiterFrame.setVisible(false);
                switch (index) {
                    case 0:                   
                        main.bauarbeiterListe.add(new Bauarbeiter());
                        main.bauarbeiterListe.get(main.bauarbeiterListe.size()-1).setGehalt(neuerAngestellterGehalt);
                        main.bauarbeiterListe.get(main.bauarbeiterListe.size()-1).setName(neuerAngestellterName);
                        neueAdresseAngestellterFrame(main.bauarbeiterListe.get(main.bauarbeiterListe.size()-1), "Adresse Bauarbeiter");
                        break;
                    case 1:
                        main.statikerListe.add(new Statiker());
                        main.statikerListe.get(main.statikerListe.size()-1).setGehalt(neuerAngestellterGehalt);
                        main.statikerListe.get(main.statikerListe.size()-1).setName(neuerAngestellterName);
                        neueAdresseAngestellterFrame(main.statikerListe.get(main.statikerListe.size()-1), "Adresse Statiker");
                        break;
                    case 2:
                        main.architektListe.add(new Architekt());
                        main.architektListe.get(main.architektListe.size()-1).setGehalt(neuerAngestellterGehalt);
                        main.architektListe.get(main.architektListe.size()-1).setName(neuerAngestellterName);
                        neueAdresseAngestellterFrame(main.architektListe.get(main.architektListe.size()-1), "Adresse Architekt");
                        break;
                    case 3:
                        main.projektleiterListe.add(new Projektleiter());
                        main.projektleiterListe.get(main.projektleiterListe.size()-1).setGehalt(neuerAngestellterGehalt);
                        main.projektleiterListe.get(main.projektleiterListe.size()-1).setName(neuerAngestellterName);
                        neueAdresseAngestellterFrame(main.projektleiterListe.get(main.projektleiterListe.size()-1), "Adresse Projektleiter");
                        break;    
                    default:   
                        break;
                   }
                }
                else {
                    fehlerFrame();
                }
                }
            
        });
   }
   
   public void neuerAuftragFrame () {
        JDialog auftragFrame = new JDialog();
        auftragFrame.setSize(250,200);
        auftragFrame.setLocation(450, 0);
        auftragFrame.setResizable(false);
        JPanel auftragPanel = new JPanel();
       
      
        JLabel titelLabel = new JLabel("Welchen Titel soll der Auftrag haben?", JLabel.CENTER);
        JLabel nameLabel = new JLabel("Wie ist der Name des Auftraggebers?", JLabel.CENTER);
        JTextField tfTitel = new JTextField("", JTextField.CENTER);
        JTextField tfName = new JTextField("", JTextField.CENTER);
        JButton auftragSpeichernButton = new JButton("Speichern");
        
        auftragPanel.add(titelLabel);
        auftragPanel.add(tfTitel);
        auftragPanel.add(nameLabel);
        auftragPanel.add(tfName);
        auftragPanel.add(auftragSpeichernButton);
        auftragPanel.setLayout( new java.awt.GridLayout( 5, 1 ) );
        auftragFrame.add(auftragPanel);
        auftragFrame.setVisible(true);
        
      
        
        auftragSpeichernButton.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent e) {
               main.auftragListe.add(new Auftrag());                    
               int newIndex = main.auftragListe.size()-1;  
               
               
               if (tfTitel.getText() != null && tfName.getText() != null) {
                   main.auftragListe.get(newIndex).setTitel(tfTitel.getText());
                   main.auftragListe.get(newIndex).setAuftraggeberName(tfName.getText());
                   
                   neueAdresseAuftragFrame(main.auftragListe.get(newIndex));
                   auftragFrame.setVisible(false);
               }        
               else {
                   fehlerFrame();
               }
                             
        
            }
        });
       
   }
   
   public void neueAdresseAngestellterFrame (Angestellter angestellter, String titelDesFrames) {
        JDialog adresseFrame = new JDialog();
        adresseFrame.setTitle(titelDesFrames);
        
        adresseFrame.setSize(250,230);
        adresseFrame.setLocation(750, 0);
        adresseFrame.setResizable(false);
        JPanel adressePanel = new JPanel();
       
        JLabel landLabel = new JLabel("   Land");
        JLabel stadtLabel = new JLabel("   Stadt");
        JLabel strasseLabel = new JLabel("   Straße");
        JLabel hausnummerLabel = new JLabel("   Hausnummer");
        JLabel mailLabel = new JLabel("   Mailadresse");
        JLabel telefonLabel = new JLabel("   Telefon");
        JLabel zwischenraum = new JLabel("");
        JButton speichern = new JButton("Speichern");
        speichern.setVerticalAlignment(SwingConstants.CENTER);
        
        JTextField tfLand = new JTextField("", JTextField.CENTER);
        JTextField tfStadt = new JTextField("", JTextField.CENTER);
        JTextField tfStrasse = new JTextField("", JTextField.CENTER);
        JTextField tfHausnummer = new JTextField("", JTextField.CENTER);
        JTextField tfMail = new JTextField("", JTextField.CENTER);
        JTextField tfTelefon = new JTextField("", JTextField.CENTER);
        
        adressePanel.add(landLabel);
        adressePanel.add(tfLand);
        adressePanel.add(stadtLabel);
        adressePanel.add(tfStadt);
        adressePanel.add(strasseLabel);
        adressePanel.add(tfStrasse);
        adressePanel.add(hausnummerLabel);
        adressePanel.add(tfHausnummer);
        adressePanel.add(mailLabel);
        adressePanel.add(tfMail);
        adressePanel.add(telefonLabel);
        adressePanel.add(tfTelefon);
        adressePanel.add(zwischenraum);
        adressePanel.add(speichern);
        adressePanel.setLayout( new java.awt.GridLayout( 8, 2 ) );
        adresseFrame.add(adressePanel);
        adresseFrame.setVisible(true);
        
        speichern.addActionListener(new java.awt.event.ActionListener() {
           
            public void actionPerformed(java.awt.event.ActionEvent e) {
                  
                Adresse neueAdresse = new Adresse();
                if(tfLand.getText().length() != 0){
                    neueAdresse.setLand(tfLand.getText());}
                else {
                    neueAdresse.setLand("Land fehlt");
                }
                
                if(tfStadt.getText().length() != 0){
                    neueAdresse.setStadt(tfStadt.getText());}
                else {
                    neueAdresse.setStadt("Stadt fehlt");
                }
                
                if(tfStrasse.getText().length() != 0){
                    neueAdresse.setStrasse(tfStrasse.getText());}
                else {
                    neueAdresse.setStrasse("Strasse fehlt");
                }
                
                if(tfHausnummer.getText().length() != 0){
                    neueAdresse.setHausnummer(Integer.parseInt(tfHausnummer.getText()));}
                else {
                    neueAdresse.setHausnummer(0);
                }
                
                if(tfTelefon.getText().length() != 0){
                    neueAdresse.setTelefonnummer(tfTelefon.getText());}
                else {
                    neueAdresse.setTelefonnummer("Telefonnummer fehlt");
                }
                
                if(tfMail.getText().length() != 0){
                    neueAdresse.setMailadresse(tfMail.getText());}
                else {
                    neueAdresse.setMailadresse("Mailadresse fehlt");
                }

                angestellter.setAdresse(neueAdresse);
                adresseFrame.setVisible(false);
                
            }
        });
      
   }
   
   public void neueAdresseAuftragFrame (Auftrag auftrag) {
        JDialog adresseFrame = new JDialog();        
        adresseFrame.setSize(300,250);
        adresseFrame.setLocation(750, 0);
        adresseFrame.setResizable(false);
        adresseFrame.setTitle("Adresse Auftrag");
        JPanel adressePanel = new JPanel();
        JLabel adresseKundeLabel = new JLabel("Adresse");
        JLabel adresseOrtLabel = new JLabel("Adresse");
        JLabel landLabel = new JLabel("   Land");
        JLabel stadtLabel = new JLabel("   Stadt");
        JLabel strasseLabel = new JLabel("   Straße");
        JLabel hausnummerLabel = new JLabel("   Hausnummer");
        JLabel mailLabel = new JLabel("   Mailadresse");
        JLabel telefonLabel = new JLabel("   Telefon");
        JLabel zwischenraum = new JLabel("");
        JButton speichern = new JButton("Speichern");
        speichern.setVerticalAlignment(SwingConstants.CENTER);
        
        JTextField tfLandKunde = new JTextField("", JTextField.CENTER);
        JTextField tfStadtKunde = new JTextField("", JTextField.CENTER);
        JTextField tfStrasseKunde = new JTextField("", JTextField.CENTER);
        JTextField tfHausnummerKunde = new JTextField("", JTextField.CENTER);
        JTextField tfMailKunde = new JTextField("", JTextField.CENTER);
        JTextField tfTelefonKunde = new JTextField("", JTextField.CENTER);
        
        JTextField tfLandOrt = new JTextField("", JTextField.CENTER);
        JTextField tfStadtOrt = new JTextField("", JTextField.CENTER);
        JTextField tfStrasseOrt = new JTextField("", JTextField.CENTER);
        JTextField tfHausnummerOrt = new JTextField("", JTextField.CENTER);
        
        adressePanel.add(landLabel);
        adressePanel.add(tfLandKunde);
        adressePanel.add(tfLandOrt);
        
        adressePanel.add(stadtLabel);
        adressePanel.add(tfStadtKunde);
        adressePanel.add(tfStadtOrt);
        
        adressePanel.add(strasseLabel);
        adressePanel.add(tfStrasseKunde);
        adressePanel.add(tfStrasseOrt);
        
        adressePanel.add(hausnummerLabel);
        adressePanel.add(tfHausnummerKunde);
        adressePanel.add(tfHausnummerOrt);
       
        adressePanel.add(mailLabel);
        adressePanel.add(tfMailKunde);
        adressePanel.add(zwischenraum);
        
        adressePanel.add(telefonLabel);
        adressePanel.add(tfTelefonKunde);
        adressePanel.add(speichern);
        adressePanel.setLayout( new java.awt.GridLayout( 6, 3 ) );
        adresseFrame.add(adressePanel);
        adresseFrame.setVisible(true);
        
        speichern.addActionListener(new java.awt.event.ActionListener() {
           
            public void actionPerformed(java.awt.event.ActionEvent e) {
                  
                Adresse neueAdresseKunde = new Adresse();
                Adresse neueAdresseOrt = new Adresse();
               
                if(tfLandKunde.getText().length() != 0){
                    neueAdresseKunde.setLand(tfLandKunde.getText());}
                else {
                    neueAdresseKunde.setLand("Land fehlt");
                }
                
                if(tfStadtKunde.getText().length() != 0){
                    neueAdresseKunde.setStadt(tfStadtKunde.getText());}
                else {
                    neueAdresseKunde.setStadt("Stadt fehlt");
                }
                
                if(tfStrasseKunde.getText().length() != 0){
                    neueAdresseKunde.setStrasse(tfStrasseKunde.getText());}
                else {
                    neueAdresseKunde.setStrasse("Stadt fehlt");
                }
                
                if(tfHausnummerKunde.getText().length() != 0){
                    neueAdresseKunde.setHausnummer(Integer.parseInt(tfHausnummerKunde.getText()));}
                else {
                    neueAdresseKunde.setHausnummer(0);
                }
                
                if(tfTelefonKunde.getText().length() != 0){
                    neueAdresseKunde.setTelefonnummer(tfTelefonKunde.getText());}
                else {
                    neueAdresseKunde.setTelefonnummer("Telefonnummer fehlt");
                }
                
                if(tfMailKunde.getText().length() != 0){
                    neueAdresseKunde.setMailadresse(tfMailKunde.getText());}
                else {
                    neueAdresseKunde.setMailadresse("Mailadresse fehlt");
                }

                auftrag.setAuftraggeberAdresse(neueAdresseKunde);
                
                
                
                if(tfLandOrt.getText().length() != 0){
                    neueAdresseOrt.setLand(tfLandOrt.getText());}
                else {
                    neueAdresseOrt.setLand("Land fehlt");
                }
                
                if(tfStadtOrt.getText().length() != 0){
                    neueAdresseOrt.setStadt(tfStadtOrt.getText());}
                else {
                    neueAdresseOrt.setStadt("Stadt fehlt");
                }
                
                if(tfStrasseOrt.getText().length() != 0){
                    neueAdresseOrt.setStrasse(tfStrasseOrt.getText());}
                else {
                    neueAdresseOrt.setStrasse("Stadt fehlt");
                }
                
                if(tfHausnummerOrt.getText().length() != 0){
                    neueAdresseOrt.setHausnummer(Integer.parseInt(tfHausnummerOrt.getText()));}
                else {
                    neueAdresseOrt.setHausnummer(0);
                }
                
                auftrag.setAdresse(neueAdresseOrt);
                
                adresseFrame.setVisible(false);
            }
        });
      
   }

   public void fehlerFrame () {
       
        JDialog fehlerFrame = new JDialog();
        fehlerFrame.setSize(340,100);
        fehlerFrame.setLocation(700, 700);
        fehlerFrame.setResizable(false);
        JPanel fehlerPanel = new JPanel();
        fehlerFrame.setTitle("Fehler");
        
        JLabel fehlerLabel1 = new JLabel("Es ist zu einem Fehler gekommen.", JLabel.CENTER);
        JLabel fehlerlabel2 = new JLabel("Es sind nicht alle Pflichtfelder ausgefüllt.", JLabel.CENTER);
        JButton fehlerButton = new JButton("OK");
        
        fehlerPanel.add(fehlerLabel1);
        fehlerPanel.add(fehlerlabel2);
        fehlerPanel.add(fehlerButton);
       
        fehlerFrame.add(fehlerPanel);
        fehlerFrame.setVisible(true);
        
        fehlerButton.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent e) {
                fehlerFrame.setVisible(false);
            }
        });
        
   }
   
   public void uebersichtAngestellteFrame () {
        JDialog uebersichtAngestellteFrame = new JDialog();
        uebersichtAngestellteFrame.setSize(230,400);
        uebersichtAngestellteFrame.setLocation(700, 700);
        uebersichtAngestellteFrame.setResizable(false);
        JPanel uebersichtAngestelltePanel = new JPanel();
        uebersichtAngestellteFrame.setTitle("Übersicht Angestellte");
        
        JLabel bauarbeiterLabel = new JLabel("Bauarbeiter", JLabel.CENTER);
        JLabel linie1 = new JLabel("--------------------", JLabel.CENTER);
        JLabel linie2 = new JLabel("--------------------", JLabel.CENTER);
        JLabel linie3 = new JLabel("--------------------", JLabel.CENTER);
        JLabel architektLabel = new JLabel("Architekt", JLabel.CENTER);
        JLabel statikerLabel = new JLabel("Statiker", JLabel.CENTER);
        JLabel projektleiterLabel = new JLabel("Projektleiter", JLabel.CENTER);
        JButton bauarbeiterButton = new JButton("Details");
        JButton architektButton = new JButton("Details");
        JButton statikerButton = new JButton("Details");
        JButton projektleiterButton = new JButton("Details");
        
        ArrayList<String> listeBauarbeiter = new ArrayList<>();
        ArrayList<String> listeArchitekten = new ArrayList<>();
        ArrayList<String> listeStatiker = new ArrayList<>();
        ArrayList<String> listeProjektleiter = new ArrayList<>();
        
        for(int i = 0; i < main.bauarbeiterListe.size(); i++){
            listeBauarbeiter.add(main.bauarbeiterListe.get(i).getName());
        }
        
        for(int i = 0; i < main.statikerListe.size(); i++){
            listeStatiker.add(main.statikerListe.get(i).getName());
        }
        
        for(int i = 0; i < main.architektListe.size(); i++){
            listeArchitekten.add(main.architektListe.get(i).getName());
        }
        
        for(int i = 0; i < main.projektleiterListe.size(); i++){
            listeProjektleiter.add(main.projektleiterListe.get(i).getName());
        }
        
        String[] bauarbeiter = listeBauarbeiter.toArray(new String[listeBauarbeiter.size()]);
        JComboBox bauarbeiterPop = new JComboBox(bauarbeiter);
       
        String[] statiker = listeStatiker.toArray(new String[listeStatiker.size()]);
        JComboBox statikerPop = new JComboBox(statiker);
        
        String[] architekt = listeArchitekten.toArray(new String[listeArchitekten.size()]);
        JComboBox architektPop = new JComboBox(architekt);
        
        String[] projektleiter = listeProjektleiter.toArray(new String[listeProjektleiter.size()]);
        JComboBox projektleiterPop = new JComboBox(projektleiter);
        
        uebersichtAngestelltePanel.add(bauarbeiterLabel);
        uebersichtAngestelltePanel.add(bauarbeiterPop);
        uebersichtAngestelltePanel.add(bauarbeiterButton);
        
        uebersichtAngestelltePanel.add(linie1);
        
        uebersichtAngestelltePanel.add(statikerLabel);
        uebersichtAngestelltePanel.add(statikerPop);
        uebersichtAngestelltePanel.add(statikerButton);
        
        uebersichtAngestelltePanel.add(linie2);
        
        uebersichtAngestelltePanel.add(architektLabel);
        uebersichtAngestelltePanel.add(architektPop);
        uebersichtAngestelltePanel.add(architektButton);
        
        uebersichtAngestelltePanel.add(linie3); 
        
        uebersichtAngestelltePanel.add(projektleiterLabel);
        uebersichtAngestelltePanel.add(projektleiterPop);
        uebersichtAngestelltePanel.add(projektleiterButton);
        
        
        uebersichtAngestelltePanel.setLayout( new java.awt.GridLayout( 15, 1 ) );
        
        uebersichtAngestellteFrame.add(uebersichtAngestelltePanel);
        uebersichtAngestellteFrame.setVisible(true);
   }
   
   public void uebersichtAuftragFrame () {
        JDialog uebersichtAuftragFrame = new JDialog();
        uebersichtAuftragFrame.setSize(230,100);
        uebersichtAuftragFrame.setLocation(700, 700);
        uebersichtAuftragFrame.setResizable(false);
        JPanel uebersichtAuftragPanel = new JPanel();
        uebersichtAuftragFrame.setTitle("Übersicht Aufträge");
        
        JLabel auftragLabel = new JLabel("Aufträge", JLabel.CENTER);
        JButton auftragButton = new JButton("Details");
       
        ArrayList<String> listeAuftraege = new ArrayList<>();
        
        for(int i = 0; i < main.auftragListe.size(); i++){
            listeAuftraege.add(main.auftragListe.get(i).getTitel());
        }
        
        
        String[] auftraege = listeAuftraege.toArray(new String[listeAuftraege.size()]);
        JComboBox auftraegePop = new JComboBox(auftraege);
       
        uebersichtAuftragPanel.add(auftragLabel);
        uebersichtAuftragPanel.add(auftraegePop);
        uebersichtAuftragPanel.add(auftragButton);

        uebersichtAuftragPanel.setLayout( new java.awt.GridLayout( 3, 1 ) );
        
        uebersichtAuftragFrame.add(uebersichtAuftragPanel);
        uebersichtAuftragFrame.setVisible(true);
        
        auftragButton.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent e) {
              
                String ausgweahltesObjekt = (String)auftraegePop.getSelectedItem();

                for(int i=0; i < main.auftragListe.size(); i++){
                    System.out.println(main.auftragListe.get(i).getTitel());
                    if(ausgweahltesObjekt.equals(main.auftragListe.get(i).getTitel())){
                       
                        detailAuftrag(main.auftragListe.get(i));
                        
                    }
                }
                
                
            }
        });
   }
   
   public void bearbeitenAngestellteFrame () {
       
   }
   
   public void bearbeitenAuftragFrame () {
       
   }
   
   public void detailAuftrag (Auftrag auftrag){
      
        JDialog detailAuftragFrame = new JDialog();
        detailAuftragFrame.setSize(330,300);
        detailAuftragFrame.setLocation(700, 700);
        detailAuftragFrame.setResizable(false);
        JPanel detailAuftragPanel = new JPanel();
        
        detailAuftragFrame.setTitle("Übersicht " + auftrag.getTitel());
       
        JLabel titelLabel = new JLabel("Auftrag:");
        JLabel adresseOrtLabel = new JLabel("Daten des Auftrages:");
        JLabel adresseKundeLabel = new JLabel("Daten des Auftraggebers:");
        JLabel projektleiterLabel = new JLabel("Projektleiter:");
        JLabel architektLabel = new JLabel("Architekt:");
        JLabel statikerLabel = new JLabel("Statiker:");
       // JLabel bauarbeiterLabel = new JLabel("Bauarbeiter:");
       // JLabel materialLabel = new JLabel("Material:");
       // JLabel aufgabenLabel = new JLabel("Aufgaben:");
      
        JLabel titel = new JLabel(auftrag.getTitel());
        
      //  JLabel projektleiterDaten = new JLabel(auftrag.getProjektleiter().getName());
          JLabel projektleiterDaten = new JLabel("Projektleiter Name");
      //  JLabel architektDaten = new JLabel(auftrag.getArchitekt().getName());
          JLabel architektDaten = new JLabel("Architekt Name");
       // JLabel statikerDaten = new JLabel(auftrag.getStatiker().getName());
          JLabel statikerDaten = new JLabel("Statiker Name");
        JLabel auftraggeberName = new JLabel(auftrag.getAuftraggeberName());
        JLabel auftraggeberStadtLand = new JLabel(auftrag.getAuftraggeberAdresse().getStadt() + ", " + auftrag.getAuftraggeberAdresse().getLand());
        JLabel auftraggeberStrasseHausnummer = new JLabel(auftrag.getAuftraggeberAdresse().getStrasse() + " " + auftrag.getAuftraggeberAdresse().getHausnummer());
        JLabel auftraggeberMail = new JLabel(auftrag.getAuftraggeberAdresse().getMailadresse());
        JLabel auftraggeberTelefonnummer = new JLabel(auftrag.getAuftraggeberAdresse().getTelefonnummer());
        
        JLabel ortStadtLand = new JLabel(auftrag.getAdresse().getStadt() + ", " + auftrag.getAdresse().getLand());
        JLabel ortStrasseHausnummer = new JLabel(auftrag.getAdresse().getStrasse() + " " + auftrag.getAdresse().getHausnummer());
        
        JLabel zwischenraum1 = new JLabel("");
        JLabel zwischenraum2 = new JLabel("");
        JLabel zwischenraum3 = new JLabel("");
        JLabel zwischenraum4 = new JLabel("");
        JLabel zwischenraum5 = new JLabel("");
        JLabel zwischenraum6 = new JLabel("");
        
        detailAuftragPanel.add(titelLabel);
        detailAuftragPanel.add(titel);
        
        detailAuftragPanel.add(adresseOrtLabel);
        detailAuftragPanel.add(ortStadtLand);
        detailAuftragPanel.add(zwischenraum1);
        detailAuftragPanel.add(ortStrasseHausnummer);
      
        detailAuftragPanel.add(adresseKundeLabel);
        detailAuftragPanel.add(auftraggeberName);
        detailAuftragPanel.add(zwischenraum2);
        detailAuftragPanel.add(auftraggeberStadtLand);
        detailAuftragPanel.add(zwischenraum3);
        detailAuftragPanel.add(auftraggeberStrasseHausnummer);
        detailAuftragPanel.add(zwischenraum4);
        detailAuftragPanel.add(auftraggeberMail);
        detailAuftragPanel.add(zwischenraum5);
        detailAuftragPanel.add(auftraggeberTelefonnummer);
        
        detailAuftragPanel.add(projektleiterLabel);
        detailAuftragPanel.add(projektleiterDaten);
       
        detailAuftragPanel.add(architektLabel);
        detailAuftragPanel.add(architektDaten);
        
        detailAuftragPanel.add(statikerLabel);
        detailAuftragPanel.add(statikerDaten);
        detailAuftragPanel.setLayout( new java.awt.GridLayout( 12, 2 ) );
        detailAuftragFrame.add(detailAuftragPanel);
        detailAuftragFrame.setVisible(true);
       
   }
} 