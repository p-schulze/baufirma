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
    
    public static ArrayList<Auftrag> auftragListe = new ArrayList<>();
    public static ArrayList<Projektleiter> projektleiterListe = new ArrayList<>();
    public static ArrayList<Statiker> statikerListe = new ArrayList<>();
    public static ArrayList<Architekt> architektListe = new ArrayList<>();
    public static ArrayList<Bauarbeiter> bauarbeiterListe = new ArrayList<>();               
    public static String content;
    
    public void Frame () {}
    
    public void frameErstellen () {
        JFrame backgroundFrame = new JFrame();
        backgroundFrame.setSize(400,43);
        backgroundFrame.setResizable(false);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Hinzufügen");
        JMenuItem angestellter1 = new JMenuItem("Angestellter");
        JMenuItem auftrag1 = new JMenuItem("Auftrag");
        JMenuItem kunden1 = new JMenuItem("Kunde");
        
        JMenu menu2 = new JMenu("Bearbeiten");
        JMenuItem angestellter2 = new JMenuItem("Angestellter");
        JMenuItem kunden2 = new JMenuItem("Kunde");
        JMenuItem auftrag2 = new JMenuItem("Auftrag");
        
        JMenu menu3 = new JMenu("Übersicht");
        JMenuItem angestellter3 = new JMenuItem("Angestellter");
        JMenuItem auftrag3 = new JMenuItem("Auftrag");
        JMenuItem kunden3 = new JMenuItem("Kunde");
        
  
        menu1.add(angestellter1);
        menu1.add(auftrag1);
        menu1.add(kunden1);
        menu2.add(angestellter2);
        menu2.add(auftrag2);
        menu2.add(kunden2);
        menu3.add(angestellter3);
        menu3.add(auftrag3);
        menu3.add(kunden3);
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
        
        kunden1.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
                neuerKundeFrame();
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
        JLabel gehaltLabel = new JLabel("Gehalt in € (Form: xxx.yy)", JLabel.CENTER);
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
                if(tfGehalt.getText() != null){
                neuerAngestellterGehalt = Float.parseFloat(tfGehalt.getText());
                }
                else {neuerAngestellterGehalt = 0.0f;}
                
                if (neuerAngestellterName != null){
                    arbeiterFrame.setVisible(false);
                switch (index) {
                    case 0:
                        System.out.println("Bauarbeiter");
                        
                        main.bauarbeiterListe.add(new Bauarbeiter());
                        main.bauarbeiterListe.get(main.bauarbeiterListe.size()-1).setGehalt(neuerAngestellterGehalt);
                        main.bauarbeiterListe.get(main.bauarbeiterListe.size()-1).setName(neuerAngestellterName);
                        neueAdresseFrame(main.bauarbeiterListe.get(main.bauarbeiterListe.size()-1));
                        break;
                    case 1:
                        statikerListe.add(new Statiker());
                        statikerListe.get(statikerListe.size()-1).setGehalt(neuerAngestellterGehalt);
                        statikerListe.get(statikerListe.size()-1).setName(neuerAngestellterName);
                        neueAdresseFrame(statikerListe.get(statikerListe.size()-1));
                        break;
                    case 2:
                        architektListe.add(new Architekt());
                        architektListe.get(architektListe.size()-1).setGehalt(neuerAngestellterGehalt);
                        architektListe.get(architektListe.size()-1).setName(neuerAngestellterName);
                        neueAdresseFrame(architektListe.get(architektListe.size()-1));
                        break;
                    case 3:
                        projektleiterListe.add(new Projektleiter());
                        projektleiterListe.get(projektleiterListe.size()-1).setGehalt(neuerAngestellterGehalt);
                        projektleiterListe.get(projektleiterListe.size()-1).setName(neuerAngestellterName);
                        neueAdresseFrame(projektleiterListe.get(projektleiterListe.size()-1));
                        break;    
                    default:   
                        break;
                }
                }
                else{System.out.println("Geben sie einen Name ein.");}
            }
        });
   }
  
   public void neuerKundeFrame () {
        JDialog arbeiterFrame = new JDialog();
        arbeiterFrame.setSize(250,300);
        arbeiterFrame.setLocation(450, 0);
        JPanel auftragPanel = new JPanel();
       
        JLabel nameLabel = new JLabel("Name", JLabel.CENTER);
        JLabel adresseLabel = new JLabel("Adresse", JLabel.CENTER);
        JLabel beschaeftigtSeitLabel = new JLabel("Beschäftigt seit", JLabel.CENTER);
        JTextField tfName = new JTextField("", JTextField.CENTER);
        JButton adresseButton = new JButton("Hinzufügen");
        JTextField tfZeit = new JTextField("", JTextField.CENTER);
        JButton erstellenButton = new JButton("Erstellen");
        
        
        auftragPanel.add(erstellenButton);
        auftragPanel.add(nameLabel);
        auftragPanel.add(tfName);
        auftragPanel.add(adresseLabel);
        auftragPanel.add(adresseButton);
        auftragPanel.add(beschaeftigtSeitLabel);
        auftragPanel.add(tfZeit);
        auftragPanel.add(erstellenButton);
        auftragPanel.setLayout( new java.awt.GridLayout( 10, 2 ) );
        arbeiterFrame.add(auftragPanel);
        arbeiterFrame.setVisible(true);
        
        adresseButton.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
            }
        });
        
        erstellenButton.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
               
            }
        });
   }
   
   public void neuerAuftragFrame () {
        JDialog auftragFrame = new JDialog();
        auftragFrame.setSize(250,300);
        auftragFrame.setLocation(450, 0);
        auftragFrame.setResizable(false);
        JPanel auftragPanel = new JPanel();
       
      
        JLabel titelLabel = new JLabel("Welchen Titel soll der Auftrag haben?", JLabel.CENTER);
        JLabel nameLabel = new JLabel("Wie ist der Name des Auftraggebers?", JLabel.CENTER);
        JLabel datenAuftraggeberLabel = new JLabel("Daten des Auftraggebers", JLabel.CENTER);
        JLabel datenAuftragsortLabel = new JLabel("Daten des Auftragortes", JLabel.CENTER);
        JTextField tfTitel = new JTextField("", JTextField.CENTER);
        JTextField tfName = new JTextField("", JTextField.CENTER);
        JButton datenAuftraggeberButton = new JButton("Hinzufügen");
        JButton datenAuftragsortButton = new JButton("Hinzufügen");
        JButton auftragSpeichernButton = new JButton("Speichern");
        
        auftragPanel.add(titelLabel);
        auftragPanel.add(tfTitel);
        auftragPanel.add(nameLabel);
        auftragPanel.add(tfName);
        auftragPanel.add(datenAuftraggeberLabel);
        auftragPanel.add(datenAuftraggeberButton);
        auftragPanel.add(datenAuftragsortLabel);
        auftragPanel.add(datenAuftragsortButton);
        auftragPanel.add(auftragSpeichernButton);
        auftragPanel.setLayout( new java.awt.GridLayout( 10, 2 ) );
        auftragFrame.add(auftragPanel);
        auftragFrame.setVisible(true);
        
        datenAuftraggeberButton.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
               
            }
        });
         
        datenAuftragsortButton.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
            }
        });
        
        auftragSpeichernButton.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent e) {
               auftragListe.add(new Auftrag());                    
               int newIndex = auftragListe.size()-1;  
               
               content = tfTitel.getText();
               if (content != null) {
               auftragListe.get(newIndex).setTitel(content);                   
               content = null;}        
               
                System.out.println(auftragListe.get(newIndex));
        
            }
        });
       
   }
   
   public void neueAdresseFrame (Angestellter angestellter) {
        JDialog adresseFrame = new JDialog();
        adresseFrame.setTitle("Daten Hinzufügen");
        
        adresseFrame.setSize(250,230);
        adresseFrame.setLocation(750, 0);
        adresseFrame.setResizable(false);
        JPanel adressePanel = new JPanel();
            
        JLabel nameLabel = new JLabel("   Land");
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
        
        adressePanel.add(nameLabel);
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
        adressePanel.setLayout( new java.awt.GridLayout( 7, 2 ) );
        adresseFrame.add(adressePanel);
        adresseFrame.setVisible(true);
        
        speichern.addActionListener(new java.awt.event.ActionListener() {
           
            public void actionPerformed(java.awt.event.ActionEvent e) {
                  
                Adresse neueAdresse = new Adresse();
                neueAdresse.setLand(null);
                neueAdresse.setStadt(tfStadt.getText());
                neueAdresse.setStrasse(tfStrasse.getText());
                neueAdresse.setHausnummer(Integer.parseInt(tfHausnummer.getText()));
                neueAdresse.setTelefonnummer(tfTelefon.getText());
                neueAdresse.setMailadresse(tfMail.getText());
                angestellter.setAdresse(neueAdresse);
                System.out.println("Adresse erstellt");
                adresseFrame.setVisible(false);
                
            }
        });
      
   }

} 