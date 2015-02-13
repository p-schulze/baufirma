package baufirma;
import java.awt.BorderLayout;
import javax.swing.*;


/**
 *
 * @author pascalschulze
 */
public class Frame {
    
    
    public void Frame () {}
    
    public void frameErstellen () {
        JFrame backgroundFrame = new JFrame();
        backgroundFrame.setSize(400,43);
        backgroundFrame.setResizable(false);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Hinzufügen");
        JMenuItem angestellter1 = new JMenuItem("Angestellter");
        JMenuItem auftrag1 = new JMenuItem("Auftrag");
        JMenuItem kunden1 = new JMenuItem("Kunden");
        
        JMenu menu2 = new JMenu("Bearbeiten");
        JMenuItem angestellter2 = new JMenuItem("Angestellter");
        JMenuItem fahrzeug2 = new JMenuItem("Fahrzeug");
        JMenuItem kunden2 = new JMenuItem("Kunden");
        
        JMenu menu3 = new JMenu("Übersicht");
        JMenuItem angestellter3 = new JMenuItem("Angestellter");
        JMenuItem auftrag3 = new JMenuItem("Auftrag");
        JMenuItem kunden3 = new JMenuItem("Kunden");
        
  
        menu1.add(angestellter1);
        menu1.add(auftrag1);
        menu1.add(kunden1);
        menu2.add(angestellter2);
        menu2.add(fahrzeug2);
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
                Frame neuerArbeiter = new Frame();
                neuerArbeiter.neuerArbeiterFrame();
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
        JLabel adresseLabel = new JLabel("Daten", JLabel.CENTER);
        JLabel beschaeftigtSeitLabel = new JLabel("Beschäftigt seit", JLabel.CENTER);
        JTextField tfName = new JTextField("", JTextField.CENTER);
        JButton adresseButton = new JButton("Hinzufügen");
        JTextField tfZeit = new JTextField("", JTextField.CENTER);
        JButton erstellenButton = new JButton("Erstellen");
        
        arbeiterPanel.add(arbeiterAuswahl);
        arbeiterPanel.add(erstellenButton);
        arbeiterPanel.add(nameLabel);
        arbeiterPanel.add(tfName);
        arbeiterPanel.add(adresseLabel);
        arbeiterPanel.add(adresseButton);
        arbeiterPanel.add(beschaeftigtSeitLabel);
        arbeiterPanel.add(tfZeit);
        arbeiterPanel.add(erstellenButton);
        arbeiterPanel.setLayout( new java.awt.GridLayout( 10, 2 ) );
        arbeiterFrame.add(arbeiterPanel);
        arbeiterFrame.setVisible(true);
        
        adresseButton.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
                Frame neueAdresse = new Frame();
                neueAdresse.neueAdresseFrame();
            }
        });
        
        erstellenButton.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
                Frame neueAdresse = new Frame();
                neueAdresse.neueAdresseFrame();
            }
        });
   }
  
   public void neuesFahrzeugFrame () {
        JDialog arbeiterFrame = new JDialog();
        arbeiterFrame.setSize(250,300);
        arbeiterFrame.setLocation(450, 0);
        JPanel arbeiterPanel = new JPanel();
       
        JLabel frage = new JLabel("Was für ein Arbeiter?", JLabel.CENTER);
        arbeiterPanel.add(frage);
        String arbeiter[] = {"Bauarbeiter", "Statiker", "Architekt", "Projektleiter"};
 
        JComboBox arbeiterAuswahl = new JComboBox(arbeiter);
        
        JLabel nameLabel = new JLabel("Name", JLabel.CENTER);
        JLabel adresseLabel = new JLabel("Adresse", JLabel.CENTER);
        JLabel beschaeftigtSeitLabel = new JLabel("Beschäftigt seit", JLabel.CENTER);
        JTextField tfName = new JTextField("", JTextField.CENTER);
        JTextField tfAdresse = new JTextField("", JTextField.CENTER);
        JTextField tfZeit = new JTextField("", JTextField.CENTER);
        JButton erstellenButton = new JButton("Erstellen");
        
        arbeiterPanel.add(arbeiterAuswahl);
        arbeiterPanel.add(erstellenButton);
        arbeiterPanel.add(nameLabel);
        arbeiterPanel.add(tfName);
        arbeiterPanel.add(adresseLabel);
        arbeiterPanel.add(tfAdresse);
        arbeiterPanel.add(beschaeftigtSeitLabel);
        arbeiterPanel.add(tfZeit);
        arbeiterPanel.add(erstellenButton);
        arbeiterPanel.setLayout( new java.awt.GridLayout( 10, 2 ) );
        arbeiterFrame.add(arbeiterPanel);
        arbeiterFrame.setVisible(true);
        
       
   }
   
   public void neueAdresseFrame () {
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
        
      
   }
}
