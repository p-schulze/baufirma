package baufirma;


import java.awt.BorderLayout;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author pascalschulze
 */
public class Frame {
    
   public void Frame () {}
    
   //Menu ---------------------------------------------------------------------------------------------------------------------  
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
        
        JMenu menu4 = new JMenu("Verschieben");
        
  
        menu1.add(angestellter1);
        menu1.add(auftrag1);
        menu2.add(angestellter2);
        menu2.add(auftrag2);
        menu3.add(angestellter3);
        menu3.add(auftrag3);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        backgroundFrame.add(menuBar, BorderLayout.NORTH);
        
        backgroundFrame.setVisible(true);
        
        angestellter1.addActionListener((java.awt.event.ActionEvent e) -> {
            neuerArbeiterFrame();
        } 
        );
        
        auftrag1.addActionListener((java.awt.event.ActionEvent e) -> {
            neuerAuftragFrame();
        } 
        );
        
        angestellter2.addActionListener((java.awt.event.ActionEvent e) -> {
            uebersichtAngestellteFrame();
        });
        
        auftrag2.addActionListener((java.awt.event.ActionEvent e) -> {
           
        } 
        );
        
        angestellter3.addActionListener((java.awt.event.ActionEvent e) -> {
            uebersichtAngestellteFrame();
        });
        
        auftrag3.addActionListener((java.awt.event.ActionEvent e) -> {
            uebersichtAuftragFrame();
        } 
        );
        
        menu4.addActionListener((java.awt.event.ActionEvent e) -> {
            uebersichtAuftragFrame();
        } 
        );
        
       
   } //Fertig - Menüs müssen noch zugeordnet werden
  
   //Hinzufügen ---------------------------------------------------------------------------------------------------------------  
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
        JButton erstellenButton = new JButton("Weiter");
        
     
        
        arbeiterPanel.add(arbeiterAuswahl);
        
        arbeiterPanel.add(nameLabel);
        arbeiterPanel.add(tfName);
        arbeiterPanel.add(gehaltLabel);
        arbeiterPanel.add(tfGehalt);
        arbeiterPanel.add(erstellenButton);
        arbeiterPanel.setLayout( new java.awt.GridLayout( 7, 2 ) );
        arbeiterFrame.add(arbeiterPanel);
        arbeiterFrame.setVisible(true);
        
        erstellenButton.addActionListener((java.awt.event.ActionEvent e) -> {
            int index = arbeiterAuswahl.getSelectedIndex();
            String neuerAngestellterName = tfName.getText();
            
            float neuerAngestellterGehalt;
            if(tfGehalt.getText().length() != 0){
                neuerAngestellterGehalt = Float.parseFloat(tfGehalt.getText());
            }
            else {neuerAngestellterGehalt = 0.0f;}
            
            if (neuerAngestellterName.length() != 0){
                arbeiterFrame.setVisible(false);       
                neuerArbeiterDetailFrame(index, neuerAngestellterName, neuerAngestellterGehalt);
         
            }
            else {
                fehlerFrame();
            }
        });
   } //Fertig
   
        public void neuerArbeiterDetailFrame (int auswahl, String neuerName, float neuesGehalt) {
        JDialog neuerArbeiterDetailFrame = new JDialog();
        neuerArbeiterDetailFrame.setLocation(450, 0);
        JPanel neuerArbeiterDetailPanel = new JPanel();
        neuerArbeiterDetailPanel.setLayout( new java.awt.GridLayout( 3, 2 ) );
        neuerArbeiterDetailFrame.setSize(200,100);
        switch (auswahl){
            case 0:
               
                JLabel typ = new JLabel("Bauarbeitertyp", JLabel.CENTER);
                JTextField tfTyp = new JTextField("", JTextField.CENTER);
                JButton weiter1 = new JButton("Weiter");
                
                
                
                neuerArbeiterDetailPanel.add(typ);
                neuerArbeiterDetailPanel.add(tfTyp);
                neuerArbeiterDetailPanel.add(weiter1);
                neuerArbeiterDetailFrame.add(neuerArbeiterDetailPanel);
                neuerArbeiterDetailFrame.setVisible(true);
                weiter1.addActionListener((java.awt.event.ActionEvent e) -> {
                    main.bauarbeiterListe.add(new Bauarbeiter());
                    main.bauarbeiterListe.get(main.bauarbeiterListe.size()-1).setGehalt(neuesGehalt);
                    main.bauarbeiterListe.get(main.bauarbeiterListe.size()-1).setName(neuerName);
                    main.bauarbeiterListe.get(main.bauarbeiterListe.size()-1).setBauarbeiterTyp(tfTyp.getText());
                    neueAdresseAngestellterFrame(main.bauarbeiterListe.get(main.bauarbeiterListe.size()-1), "Adresse Bauarbeiter");
                });
                break;
            case 1:
               main.statikerListe.add(new Statiker());
               main.statikerListe.get(main.statikerListe.size()-1).setGehalt(neuesGehalt);
               main.statikerListe.get(main.statikerListe.size()-1).setName(neuerName);
               neueAdresseAngestellterFrame(main.statikerListe.get(main.statikerListe.size()-1), "Adresse Statiker");
               break;
            case 2:
                main.architektListe.add(new Architekt());
                main.architektListe.get(main.architektListe.size()-1).setGehalt(neuesGehalt);
                main.architektListe.get(main.architektListe.size()-1).setName(neuerName);
                neueAdresseAngestellterFrame(main.architektListe.get(main.architektListe.size()-1), "Adresse Architekt");
                break;
                
            case 3:
            
                JLabel ersteHilfe = new JLabel("Erstehilfeausbildung (Ja / Nein)", JLabel.CENTER);
                JTextField jaOderNein = new JTextField("");
                JButton weiter2 = new JButton("Weiter");
                
                neuerArbeiterDetailPanel.add(ersteHilfe);
                neuerArbeiterDetailPanel.add(jaOderNein);
                neuerArbeiterDetailPanel.add(weiter2);
                neuerArbeiterDetailFrame.add(neuerArbeiterDetailPanel);
                neuerArbeiterDetailFrame.setVisible(true);
                weiter2.addActionListener((java.awt.event.ActionEvent e) -> {
                    Boolean ersteHilfeAusbildung = false;
                    if(jaOderNein.getText().endsWith("ja") || jaOderNein.getText().endsWith("Ja")){
                          ersteHilfeAusbildung = true;
                    } else if(jaOderNein.getText().endsWith("nein") || jaOderNein.getText().endsWith("Nein")){
                          ersteHilfeAusbildung = false;
                    } else {
                        fehlerFrame();
                    }
                    
                    main.projektleiterListe.add(new Projektleiter());
                    main.projektleiterListe.get(main.projektleiterListe.size()-1).setGehalt(neuesGehalt);
                    main.projektleiterListe.get(main.projektleiterListe.size()-1).setName(neuerName);
                    main.projektleiterListe.get(main.projektleiterListe.size()-1).setErsteHilfe(ersteHilfeAusbildung);
                    neueAdresseAngestellterFrame(main.projektleiterListe.get(main.projektleiterListe.size()-1), "Adresse Bauarbeiter");
                });
                break;
        }
        
       
     
        
   } //Fertig
        
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
      
   } //Fertig
   
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
        
      
        
        auftragSpeichernButton.addActionListener((java.awt.event.ActionEvent e) -> {
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
        });
       
   }
        
        public void neueAdresseAuftragFrame (Auftrag auftrag) {
        JDialog adresseFrame = new JDialog();        
        adresseFrame.setSize(300,250);
        adresseFrame.setLocation(750, 0);
        adresseFrame.setResizable(false);
        adresseFrame.setTitle("Adresse Auftrag");
        JPanel adressePanel = new JPanel();
        JLabel adresseKundeLabel = new JLabel("Kunde");
        JLabel adresseOrtLabel = new JLabel("Bauort");
        JLabel landLabel = new JLabel("   Land");
        JLabel stadtLabel = new JLabel("   Stadt");
        JLabel strasseLabel = new JLabel("   Straße");
        JLabel hausnummerLabel = new JLabel("   Hausnummer");
        JLabel mailLabel = new JLabel("   Mailadresse");
        JLabel telefonLabel = new JLabel("   Telefon");
        JLabel zwischenraum = new JLabel("");
        JLabel zwischenraum2 = new JLabel("");
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
       
        adressePanel.add(zwischenraum2);
        adressePanel.add(adresseKundeLabel);
        adressePanel.add(adresseOrtLabel);
                
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
        adressePanel.setLayout( new java.awt.GridLayout( 7, 3 ) );
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
        
        
        
   
   //Bearbeiten ---------------------------------------------------------------------------------------------------------------  
   public void bearbeitenAngestellterFrame (Angestellter angestellter) {
       
   }
   
   public void bearbeitenAuftragFrame (Auftrag auftrag, int index) {
       
        JDialog bearbeitenAuftragFrame = new JDialog();
        bearbeitenAuftragFrame.setSize(330,600);
        bearbeitenAuftragFrame.setLocation(700, 700);
        bearbeitenAuftragFrame.setResizable(false);
        JPanel bearbeitenAuftragPanel = new JPanel();
        bearbeitenAuftragFrame.setTitle("Auftrag " + auftrag.getTitel() + " wird bearbeitet");
        
        JLabel titelLabel = new JLabel("     Titel ");
        JLabel datenBauort = new JLabel("  Daten Bauort ---------");
        JLabel datenKunde = new JLabel("  Daten Kunde ---------");
        JLabel angestellteLabel = new JLabel("  Angestellte ----------");
        JLabel ortLand = new JLabel("     Land: ");
        JLabel ortStadt = new JLabel("     Stadt: ");
        JLabel ortStrasse = new JLabel("     Straße: ");
        JLabel ortHausnummer = new JLabel("     Hausnummer: ");
        JLabel kundeLand = new JLabel("     Land: ");
        JLabel kundeStadt = new JLabel("     Stadt: ");
        JLabel kundeStrasse = new JLabel("     Straße: ");
        JLabel kundeHausnummer = new JLabel("     Hausnummer: ");
        JLabel kundeTelefonnummer = new JLabel("     Telefonnummer: ");
        JLabel kundeMail = new JLabel("     Mailadresse: ");
        JLabel kundeName = new JLabel("     Name: ");
        JLabel projektleiterLabel = new JLabel("     Projektleiter:");
        JLabel architektLabel = new JLabel("     Architekt:");
        JLabel statikerLabel = new JLabel("     Statiker:");
        JLabel bauarbeiterLabel = new JLabel("     Bauarbeiter:");
        JButton auftragSpeichern = new JButton("Speichern");
        JButton bauarbeiterBearbeiten = new JButton("Bearbeiten");
        JButton architektAuswaehlen = new JButton("Auswählen");
        JButton statikerAuswaehlen = new JButton("Auswählen");
        JButton projektleiterAuswaehlen = new JButton("Auswählen");
        JButton loeschenButton = new JButton("Löschen");
        
        JTextField tfTitel = new JTextField(auftrag.getTitel());
        JTextField tfOrtLand = new JTextField(auftrag.getAdresse().getLand());
        JTextField tfOrtStadt = new JTextField(auftrag.getAdresse().getStadt());
        JTextField tfOrtStrasse = new JTextField(auftrag.getAdresse().getStrasse());
        JTextField tfOrtHausnummer = new JTextField(auftrag.getAdresse().getHausnummer());
       
        JTextField tfKundeName = new JTextField(auftrag.getAuftraggeberName());
        JTextField tfKundeLand = new JTextField(auftrag.getAuftraggeberAdresse().getLand());
        JTextField tfKundeStadt = new JTextField(auftrag.getAuftraggeberAdresse().getStadt());
        JTextField tfKundeStrasse = new JTextField(auftrag.getAuftraggeberAdresse().getStrasse());
        JTextField tfKundeHausnummer = new JTextField(auftrag.getAuftraggeberAdresse().getHausnummer());
        JTextField tfKundeTelefonnummer = new JTextField(auftrag.getAuftraggeberAdresse().getTelefonnummer());
        JTextField tfKundeMail = new JTextField(auftrag.getAuftraggeberAdresse().getMailadresse());
        
        
        JLabel zwischenraum1 = new JLabel("--------------------");
        JLabel zwischenraum2 = new JLabel("--------------------");
        JLabel zwischenraum3 = new JLabel("--------------------");
        JLabel zwischenraum4 = new JLabel("");
        
        bearbeitenAuftragPanel.add(titelLabel);
        bearbeitenAuftragPanel.add(tfTitel);
        
        bearbeitenAuftragPanel.add(datenBauort);
        bearbeitenAuftragPanel.add(zwischenraum1);
        
        bearbeitenAuftragPanel.add(ortLand);
        bearbeitenAuftragPanel.add(tfOrtLand);
        
        bearbeitenAuftragPanel.add(ortStadt);
        bearbeitenAuftragPanel.add(tfOrtStadt);
        
        bearbeitenAuftragPanel.add(ortStrasse);
        bearbeitenAuftragPanel.add(tfOrtStrasse);
       
        bearbeitenAuftragPanel.add(ortHausnummer);
        bearbeitenAuftragPanel.add(tfOrtHausnummer);
        
        bearbeitenAuftragPanel.add(datenKunde);
        bearbeitenAuftragPanel.add(zwischenraum2);
        
        bearbeitenAuftragPanel.add(kundeName);
        bearbeitenAuftragPanel.add(tfKundeName);
        
        bearbeitenAuftragPanel.add(kundeLand);
        bearbeitenAuftragPanel.add(tfKundeLand);
        
        bearbeitenAuftragPanel.add(kundeStadt);
        bearbeitenAuftragPanel.add(tfKundeStadt);
        
        bearbeitenAuftragPanel.add(kundeStrasse);
        bearbeitenAuftragPanel.add(tfKundeStrasse);
        
        bearbeitenAuftragPanel.add(kundeHausnummer);
        bearbeitenAuftragPanel.add(tfKundeHausnummer);
        
        bearbeitenAuftragPanel.add(kundeMail);
        bearbeitenAuftragPanel.add(tfKundeMail);
        
        bearbeitenAuftragPanel.add(kundeTelefonnummer);
        bearbeitenAuftragPanel.add(tfKundeTelefonnummer);
        
        bearbeitenAuftragPanel.add(angestellteLabel);
        bearbeitenAuftragPanel.add(zwischenraum3);
        
        bearbeitenAuftragPanel.add(projektleiterLabel);
        bearbeitenAuftragPanel.add(projektleiterAuswaehlen);
        
        bearbeitenAuftragPanel.add(architektLabel);
        bearbeitenAuftragPanel.add(architektAuswaehlen);
        
        bearbeitenAuftragPanel.add(statikerLabel);
        bearbeitenAuftragPanel.add(statikerAuswaehlen);
        
        bearbeitenAuftragPanel.add(bauarbeiterLabel);
        bearbeitenAuftragPanel.add(bauarbeiterBearbeiten);
        
        bearbeitenAuftragPanel.add(loeschenButton);
        bearbeitenAuftragPanel.add(auftragSpeichern);
       
        bearbeitenAuftragPanel.setLayout( new java.awt.GridLayout( 20, 2 ) );
        bearbeitenAuftragFrame.add(bearbeitenAuftragPanel);
        bearbeitenAuftragFrame.setVisible(true);
        
        auftragSpeichern.addActionListener((java.awt.event.ActionEvent e) -> {
             auftrag.setTitel(tfTitel.getText());
        });
        
        loeschenButton.addActionListener((java.awt.event.ActionEvent e) -> {
             main.auftragListe.remove(index);
        });
        
        projektleiterAuswaehlen.addActionListener((java.awt.event.ActionEvent e) -> {
            verschieben(auftrag, 3);
        });
         
         
        architektAuswaehlen.addActionListener((java.awt.event.ActionEvent e) -> {
             verschieben(auftrag, 1);
        });
          
          
        statikerAuswaehlen.addActionListener((java.awt.event.ActionEvent e) -> {
             verschieben(auftrag, 2);
        });
        
        bauarbeiterBearbeiten.addActionListener((java.awt.event.ActionEvent e) -> {
             verschieben(auftrag, 0);
        });
        
        
        
        
   } //Eigentlich fertig
   
   
   //Übersicht ----------------------------------------------------------------------------------------------------------------  
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
   } //Fertig
   
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
        
        auftragButton.addActionListener((java.awt.event.ActionEvent e) -> {
            System.out.println("Button gedrückt");
            
            String ausgweahltesObjekt = (String)auftraegePop.getSelectedItem();
            
            for(int index=0; index < main.auftragListe.size(); index++){
                
                if(ausgweahltesObjekt.equals(main.auftragListe.get(index).getTitel())){
                    System.out.println("weiter an Detail.");
                    detailAuftrag(main.auftragListe.get(index), index);
                    
                }
            }
        });
   } //Fertig
   
   
   
   
   //Detailansicht --------------------------------------------------------------------------------------------------------------  
   public void detailAngestellter (Angestellter angestellter){
      
        JDialog detailAngestellterFrame = new JDialog();
        detailAngestellterFrame.setSize(330,300);
        detailAngestellterFrame.setLocation(700, 700);
        detailAngestellterFrame.setResizable(false);
        JPanel detailAngestellterPanel = new JPanel();
        
        detailAngestellterFrame.setTitle("Übersicht " + angestellter.getName());
       
        JLabel nameLabel = new JLabel("Name");
        JLabel adresseLabel = new JLabel("Adresse des Angestellten:");
        JLabel gehaltLabel = new JLabel("Daten des Auftraggebers:");

        JLabel angestellterName = new JLabel(angestellter.getName());
        JLabel angestellterStadtLand = new JLabel(angestellter.getAdresse().getStadt() + ", " + angestellter.getAdresse().getLand());
        JLabel angestellterStrasseHausnummer = new JLabel(angestellter.getAdresse().getStrasse() + " " + angestellter.getAdresse().getHausnummer());
        JLabel angestellterMail = new JLabel(angestellter.getAdresse().getMailadresse());
        JLabel angestellterTelefonnummer = new JLabel(angestellter.getAdresse().getTelefonnummer());
        JLabel angestellterGehalt = new JLabel(Float.toString(angestellter.getGehalt()));
      
    
        JButton bearbeitenButton = new JButton("Bearbeiten");
        JLabel zwischenraum1 = new JLabel("");
        JLabel zwischenraum2 = new JLabel("");
        JLabel zwischenraum3 = new JLabel("");
        JLabel zwischenraum4 = new JLabel("");
        
        detailAngestellterPanel.add(nameLabel);
        detailAngestellterPanel.add(angestellterName);
        
        detailAngestellterPanel.add(adresseLabel);
        detailAngestellterPanel.add(angestellterStadtLand);
        detailAngestellterPanel.add(zwischenraum1);
        detailAngestellterPanel.add(angestellterStrasseHausnummer);
        detailAngestellterPanel.add(zwischenraum2);
        detailAngestellterPanel.add(angestellterMail);
        detailAngestellterPanel.add(zwischenraum3);
        detailAngestellterPanel.add(angestellterTelefonnummer);
        detailAngestellterPanel.add(gehaltLabel);
        detailAngestellterPanel.add(angestellterGehalt);
        detailAngestellterPanel.add(zwischenraum4);
        detailAngestellterPanel.add(bearbeitenButton);
        
        
        detailAngestellterPanel.setLayout( new java.awt.GridLayout( 12, 2 ) );
        detailAngestellterFrame.add(detailAngestellterPanel);
        detailAngestellterFrame.setVisible(true);
        
        bearbeitenButton.addActionListener((java.awt.event.ActionEvent e) -> {
            bearbeitenAngestellterFrame(angestellter);
        });
       
   }
   
   public void detailAuftrag (Auftrag auftrag, int index){
      
        JDialog detailAuftragFrame = new JDialog();
        detailAuftragFrame.setSize(350,300);
        detailAuftragFrame.setLocation(720, 700);
        detailAuftragFrame.setResizable(false);
        JPanel detailAuftragPanel = new JPanel();

        detailAuftragFrame.setTitle("Übersicht :" + auftrag.getTitel());
        System.out.println(auftrag.getTitel());
        System.out.println("1");
        JLabel titelLabel = new JLabel("   Auftrag:");
        JLabel adresseOrtLabel = new JLabel("   Daten des Auftrages:");
        JLabel adresseKundeLabel = new JLabel("   Daten des Auftraggebers:");
        JLabel projektleiterLabel = new JLabel("   Projektleiter:");
        JLabel architektLabel = new JLabel("   Architekt:");
        JLabel statikerLabel = new JLabel("   Statiker:");
        JLabel bauarbeiterLabel = new JLabel("   Bauarbeiter:");
       
        ArrayList<String> listeBauarbeiter = new ArrayList<>();
        JComboBox bauarbeiterPop = new JComboBox();
        
        if(auftrag.getBauarbeiterListe()!= null){
        for(int i = 0; i < auftrag.getBauarbeiterListe().size(); i++){
            bauarbeiterPop.addItem(auftrag.getBauarbeiterListe().get(i).getName());
            
        }      
        } 

        JLabel titel = new JLabel(auftrag.getTitel());
        JLabel projektleiterDaten = new JLabel("Kein Projektleiter");
        JLabel architektDaten = new JLabel("Kein Architekt");
        JLabel statikerDaten = new JLabel("Kein Statiker");
        
       
        if(auftrag.getProjektleiter() != null){
        projektleiterDaten.setText(auftrag.getProjektleiter().getName());
        } 
       
        if(auftrag.getArchitekt() != null){
        architektDaten.setText(auftrag.getArchitekt().getName());
        }
        
        if(auftrag.getStatiker() != null){
        statikerDaten.setText(auftrag.getStatiker().getName());
        }
        
        JLabel auftraggeberName = new JLabel(auftrag.getAuftraggeberName());
        JLabel auftraggeberStadtLand = new JLabel(auftrag.getAuftraggeberAdresse().getStadt() + ", " + auftrag.getAuftraggeberAdresse().getLand());
        JLabel auftraggeberStrasseHausnummer = new JLabel(auftrag.getAuftraggeberAdresse().getStrasse() + " " + auftrag.getAuftraggeberAdresse().getHausnummer());
        JLabel auftraggeberMail = new JLabel(auftrag.getAuftraggeberAdresse().getMailadresse());
        JLabel auftraggeberTelefonnummer = new JLabel(auftrag.getAuftraggeberAdresse().getTelefonnummer());
       
        JLabel ortStadtLand = new JLabel(auftrag.getAdresse().getStadt() + ", " + auftrag.getAdresse().getLand());
        JLabel ortStrasseHausnummer = new JLabel(auftrag.getAdresse().getStrasse() + " " + auftrag.getAdresse().getHausnummer());
        JButton bearbeitenButton = new JButton("Bearbeiten");
        JLabel zwischenraum1 = new JLabel("");
        JLabel zwischenraum2 = new JLabel("");
        JLabel zwischenraum3 = new JLabel("");
        JLabel zwischenraum4 = new JLabel("");
        JLabel zwischenraum5 = new JLabel("");
        JLabel zwischenraum6 = new JLabel("");
        
        detailAuftragPanel.add(titelLabel);
        detailAuftragPanel.add(titel);
        System.out.println("5");
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
        
        detailAuftragPanel.add(bauarbeiterLabel);
        detailAuftragPanel.add(bauarbeiterPop);

        detailAuftragPanel.add(zwischenraum6);
        detailAuftragPanel.add(bearbeitenButton);
        detailAuftragPanel.setLayout( new java.awt.GridLayout( 13, 2 ) );
        detailAuftragFrame.add(detailAuftragPanel);
        detailAuftragFrame.setVisible(true);
        
        bearbeitenButton.addActionListener((java.awt.event.ActionEvent e) -> {
            bearbeitenAuftragFrame(auftrag, index);
        });
       
   } //Müsste fertig sein
   
   
   //Verschieben -----------------------------------------------------------------------------------------------------------------  
    public void verschieben (Auftrag auftrag, int auswahl){
   
        JDialog verschiebenFrame = new JDialog();
        JPanel verschiebenPanel = new JPanel();
        verschiebenFrame.setSize(340,100);
        verschiebenPanel.setLayout( new java.awt.GridLayout( 3, 3 ) );
         
        switch (auswahl){
            case 0:
                JLabel akutelleBauarbeiterLabel = new JLabel("Liste der aktuellen Bauarbeiter");
                JLabel verfuegbareBauarbeiterLabel = new JLabel("Liste der verfügbaren Bauarbeiter");
                JButton hinzufuegenB = new JButton("<---");
                JButton entfernenB = new JButton("--->");
                JLabel zwischenraum1 = new JLabel("");
                JLabel zwischenraum2 = new JLabel("");
                JComboBox aktuelleBauarbeiterPop = new JComboBox();
                if(auftrag.getBauarbeiterListe() != null){
                for(int i = 0; i < auftrag.getBauarbeiterListe().size(); i++){
                aktuelleBauarbeiterPop.addItem(auftrag.getBauarbeiterListe().get(i).getName());
                }
                }
                
             
                JComboBox verfuegbareBauarbeiterPop = new JComboBox();
                for(int i = 0; i < main.bauarbeiterListe.size(); i++){
                verfuegbareBauarbeiterPop.addItem(main.bauarbeiterListe.get(i).getName());
                }
                
                verschiebenPanel.add(akutelleBauarbeiterLabel);
                verschiebenPanel.add(zwischenraum1);
                verschiebenPanel.add(verfuegbareBauarbeiterLabel);
                verschiebenPanel.add(aktuelleBauarbeiterPop);
                verschiebenPanel.add(hinzufuegenB);
                verschiebenPanel.add(verfuegbareBauarbeiterPop);
                verschiebenPanel.add(zwischenraum2);
                verschiebenPanel.add(entfernenB);
                
                
                verschiebenFrame.add(verschiebenPanel);
                verschiebenFrame.setVisible(true);
                
                hinzufuegenB.addActionListener((java.awt.event.ActionEvent e) -> {
                
                    
                    Bauarbeiter tempBauarbeiter = new Bauarbeiter(); 
                    tempBauarbeiter =  main.bauarbeiterListe.get(verfuegbareBauarbeiterPop.getSelectedIndex());
                    System.out.println("Gespiegelt");
                    
                    aktuelleBauarbeiterPop.addItem(main.bauarbeiterListe.get(verfuegbareBauarbeiterPop.getSelectedIndex()).getName());
                    System.out.println("In das neue Pop");

                    main.bauarbeiterListe.remove(verfuegbareBauarbeiterPop.getSelectedIndex());
                    System.out.println("Aus Liste gelöscht");
                    
                    verfuegbareBauarbeiterPop.removeItemAt(verfuegbareBauarbeiterPop.getSelectedIndex());
                    System.out.println("Aus Pop gelöscht");
                    
                    auftrag.addBauarbeiterToListe(tempBauarbeiter);
                    System.out.println("Zu Liste hinzu");
                   
                    
                });
                
                break;
                
                
            case 1: 
                JLabel aktuellerArchitektLabel = new JLabel("Aktueller Architekt");
                JLabel verfuegbareArchitektLabel = new JLabel("Liste der verfügbaren Architekten");
                JButton hinzufuegenA = new JButton("<---");
                JButton entfernenA = new JButton("--->");
                JButton speichernA = new JButton("Speichern");
                JLabel aktuellerArchitekt = new JLabel(auftrag.getArchitekt().getName());
       
                
                JComboBox architektPop = new JComboBox();
                for(int i = 0; i < main.architektListe.size(); i++){
                architektPop.addItem(main.architektListe.get(i).getName());
                }
                
                break;
                
            case 2:
                JLabel aktuellerStatikerLabel = new JLabel("Aktueller Statiker");
                JLabel verfuegbareStatikerLabel = new JLabel("Liste der verfügbaren Statiker");
                JButton hinzufuegenS = new JButton("<---");
                JButton entfernenS = new JButton("--->");
                JButton speichernS = new JButton("Speichern");
                JLabel aktuellerStatiker = new JLabel("Kein Statiker");
                if(auftrag.getStatiker() != null){
                    aktuellerStatiker.setText(auftrag.getStatiker().getName());
                }
                JComboBox statikerPop = new JComboBox();
                if(main.statikerListe != null){
                for(int i = 0; i < main.statikerListe.size(); i++){
                statikerPop.addItem(main.statikerListe.get(i).getName());
                }}
                break;
          
            case 3:
                JLabel aktuellerProjektleiterLabel = new JLabel("Aktueller Projektleiter");
                JLabel verfuegbareProjektleiterLabel = new JLabel("Liste der verfügbaren Projektleiter");
                JButton hinzufuegenP = new JButton("<---");
                JButton entfernenP = new JButton("--->");
                JButton speichernP = new JButton("Speichern");
                JLabel aktuellerProjektleiter = new JLabel(auftrag.getProjektleiter().getName());
                
                JComboBox projektleiterPop = new JComboBox();
                for(int i = 0; i < main.projektleiterListe.size(); i++){
                projektleiterPop.addItem(main.projektleiterListe.get(i).getName());
                }
                break;
        }
        
        
  } //Muss noch gemacht werden
   
   //Fehlerframe -----------------------------------------------------------------------------------------------------------------  
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
        
        fehlerButton.addActionListener((java.awt.event.ActionEvent e) -> {
            fehlerFrame.setVisible(false);
        });
        
   } //Fertig
   

} 