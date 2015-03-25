package baufirma;


import java.awt.BorderLayout;
import javax.swing.*;
import java.util.ArrayList;
/**
 *
 * @author pascalschulze
 */
public class Frame {

   //Menu ---------------------------------------------------------------------------------------------------------------------  
   public void startMenu () {
        JDialog backgroundFrame = giveFrame("Baufirma", 280, 43, 0, 0, givePanel(1,1));    
        JMenuBar menuBar = new JMenuBar();

        JMenu menu1 = new JMenu("Hinzufügen");
        JMenuItem angestellter1 = setMenuSub(menu1, "Angestellter");
        JMenuItem auftrag1 = setMenuSub(menu1, "Auftrag");
        
        JMenu menu2 = new JMenu("Bearbeiten");
        JMenuItem angestellter2 = setMenuSub(menu2, "Angestellter");
        JMenuItem auftrag2 = setMenuSub(menu2, "Auftrag");
        
        JMenu menu3 = new JMenu("Übersicht");
        JMenuItem angestellter3 = setMenuSub(menu3, "Angestellter");
        JMenuItem auftrag3 = setMenuSub(menu3, "Auftrag");
     
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        backgroundFrame.add(menuBar, BorderLayout.NORTH);
        
        backgroundFrame.setVisible(true);
        
        angestellter1.addActionListener((java.awt.event.ActionEvent e) -> {
            neuerArbeiterFrame();
        });
        
        auftrag1.addActionListener((java.awt.event.ActionEvent e) -> {
            neuerAuftragFrame();
        });
        
        angestellter2.addActionListener((java.awt.event.ActionEvent e) -> {
            uebersichtAngestellteFrame();
        });
        
        auftrag2.addActionListener((java.awt.event.ActionEvent e) -> {
           uebersichtAuftragFrame(1);
        });
        
        angestellter3.addActionListener((java.awt.event.ActionEvent e) -> {
            uebersichtAngestellteFrame();
        });
        
        auftrag3.addActionListener((java.awt.event.ActionEvent e) -> {
            uebersichtAuftragFrame(0);
        });  
   } //Fertig - Menüs müssen noch zugeordnet werden
  
   //Hinzufügen ---------------------------------------------------------------------------------------------------------------  
   private void neuerArbeiterFrame () {
        JPanel arbeiterPanel = givePanel(7,2);
        newLabelM("Was für ein Arbeiter?", arbeiterPanel);
        String arbeiter[] = {"Bauarbeiter", "Statiker", "Architekt", "Projektleiter"};
        JComboBox arbeiterAuswahl = new JComboBox(arbeiter);
        arbeiterPanel.add(arbeiterAuswahl);
        newLabelM("Name", arbeiterPanel);
        JTextField tfName = newTF("", arbeiterPanel);
        newLabelM("Gehalt in € (Form: xxx.xx)", arbeiterPanel);
        JTextField tfGehalt = newTF("", arbeiterPanel);
        JButton erstellenButton = newButton("Weiter", arbeiterPanel);

        JDialog arbeiterFrame = giveFrame("Neuer Arbeiter", 250, 230, 280, 0, arbeiterPanel);
        
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
   } // !!! Fertig und gekürzt !!!
   
        private void neuerArbeiterDetailFrame (int auswahl, String neuerName, float neuesGehalt) {

        JPanel neuerArbeiterDetailPanel = givePanel(3,2);
        JDialog neuerArbeiterDetailFrame = giveFrame("Angestellter Detail", 200, 100, 280, 0, neuerArbeiterDetailPanel);
        
        switch (auswahl){
            case 0:
                newLabelM("Bauarbeitertyp", neuerArbeiterDetailPanel);
                JTextField tfTyp = newTF("", neuerArbeiterDetailPanel);             
                JButton weiter1 = newButton("Weiter", neuerArbeiterDetailPanel);
                neuerArbeiterDetailFrame.setVisible(true);
                weiter1.addActionListener((java.awt.event.ActionEvent e) -> {
                    main.bauarbeiterListe.add(new Bauarbeiter());
                    main.bauarbeiterListe.get(main.bauarbeiterListe.size()-1).setGehalt(neuesGehalt);
                    main.bauarbeiterListe.get(main.bauarbeiterListe.size()-1).setName(neuerName);
                    main.bauarbeiterListe.get(main.bauarbeiterListe.size()-1).setBauarbeiterTyp(tfTyp.getText());
                    neuerArbeiterDetailFrame.setVisible(false);
                    neueAdresseAngestellterFrame(main.bauarbeiterListe.get(main.bauarbeiterListe.size()-1), "Adresse Bauarbeiter");
                    
                });
                break;
            case 1:
               main.statikerListe.add(new Statiker());
               main.statikerListe.get(main.statikerListe.size()-1).setGehalt(neuesGehalt);
               main.statikerListe.get(main.statikerListe.size()-1).setName(neuerName);
               neuerArbeiterDetailFrame.setVisible(false);
               neueAdresseAngestellterFrame(main.statikerListe.get(main.statikerListe.size()-1), "Adresse Statiker");
               break;
            case 2:
                main.architektListe.add(new Architekt());
                main.architektListe.get(main.architektListe.size()-1).setGehalt(neuesGehalt);
                main.architektListe.get(main.architektListe.size()-1).setName(neuerName);
                neueAdresseAngestellterFrame(main.architektListe.get(main.architektListe.size()-1), "Adresse Architekt");
                neuerArbeiterDetailFrame.setVisible(false);
                break;
                
            case 3:
            
                newLabelM("Erstehilfeausbildung (Ja / Nein)", neuerArbeiterDetailPanel);
                JTextField jaOderNein = newTF("", neuerArbeiterDetailPanel);
                JButton weiter2 = newButton("Weiter", neuerArbeiterDetailPanel);
               
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
                    neuerArbeiterDetailFrame.setVisible(false);
                    neueAdresseAngestellterFrame(main.projektleiterListe.get(main.projektleiterListe.size()-1), "Adresse Bauarbeiter");
                });
                break;
        }
        
       
     
        
   } // !!! Fertig und gekürzt !!!
        
        private void neueAdresseAngestellterFrame (Angestellter angestellter, String titelDesFrames) {
        JPanel adressePanel = givePanel(7, 2);     
        JDialog adresseFrame = giveFrame(titelDesFrames, 250, 230, 280, 0, adressePanel);
        
        Adresse neueAdresse = new Adresse();
        neueAdresse.setLand("Land fehlt");
        neueAdresse.setStadt("Stadt fehlt");
        neueAdresse.setStrasse("Straße fehlt");
        neueAdresse.setHausnummer(0);
        neueAdresse.setTelefonnummer("T-Nummer fehlt");
        neueAdresse.setMailadresse("Mailadresse fehlt");
        angestellter.setAdresse(neueAdresse);

        newLabel("   Land", adressePanel);
        JTextField tfLand = newTF("", adressePanel);
        newLabel("   Stadt", adressePanel);
        JTextField tfStadt = newTF("", adressePanel);
        newLabel("   Straße", adressePanel);
        JTextField tfStrasse = newTF("", adressePanel);
        newLabel("   Hausnummer", adressePanel);
        JTextField tfHausnummer = newTF("", adressePanel);
        newLabel("   Mailadresse", adressePanel);
        JTextField tfMail = newTF("", adressePanel);
        newLabel("   Telefon", adressePanel);
        JTextField tfTelefon = newTF("", adressePanel);
        newLabel("", adressePanel);
        JButton speichern = newButton("Speichern", adressePanel);
       
        speichern.addActionListener((java.awt.event.ActionEvent e) -> {
           
            if(tfLand.getText().length() != 0){
                angestellter.getAdresse().setLand(tfLand.getText());}
              
            if(tfStadt.getText().length() != 0){
                angestellter.getAdresse().setStadt(tfStadt.getText());}
           
            if(tfStrasse.getText().length() != 0){
                angestellter.getAdresse().setStrasse(tfStrasse.getText());}
           
            if(tfHausnummer.getText().length() != 0){
                angestellter.getAdresse().setHausnummer(Integer.parseInt(tfHausnummer.getText()));}
           
            if(tfTelefon.getText().length() != 0){
                angestellter.getAdresse().setTelefonnummer(tfTelefon.getText());}
            
            if(tfMail.getText().length() != 0){
                angestellter.getAdresse().setMailadresse(tfMail.getText());}
            
            adresseFrame.setVisible(false);
        });
      
   } // !!! Fertig und gekürzt !!!
   
   private void neuerAuftragFrame () {
        JPanel auftragPanel = givePanel(5,2);
        JDialog auftragFrame = giveFrame("Neuer Auftrag", 250, 200, 530, 0, auftragPanel);

        newLabelM("Welchen Titel soll der Auftrag haben?", auftragPanel);
        JTextField tfTitel = newTF("", auftragPanel);
        newLabelM("Wie ist der Name des Auftraggebers?", auftragPanel);
        JTextField tfName = newTF("", auftragPanel);
        JButton auftragSpeichernButton = newButton("Speichern", auftragPanel);   
        
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
       
   } // !!! Fertig und gekürzt !!!
        
        private void neueAdresseAuftragFrame (Auftrag auftrag) {
        JPanel adressePanel = givePanel(7,3);
        JDialog adresseFrame = giveFrame("Neuer Auftrag - Adresse", 300, 250, 530, 0, adressePanel);   

        newLabel("", adressePanel);
        newLabel("Kunde", adressePanel);
        newLabel("Bauort", adressePanel);
        newLabel("   Land", adressePanel);
        JTextField tfLandKunde = newTF("", adressePanel);
        JTextField tfLandOrt = newTF("", adressePanel);
        newLabel("   Stadt", adressePanel);
        JTextField tfStadtKunde = newTF("", adressePanel);
        JTextField tfStadtOrt = newTF("", adressePanel);
        newLabel("   Straße", adressePanel);
        JTextField tfStrasseKunde = newTF("", adressePanel);
        JTextField tfStrasseOrt = newTF("", adressePanel);
        newLabel("   Hausnummer", adressePanel);
        JTextField tfHausnummerKunde = newTF("", adressePanel);
        JTextField tfHausnummerOrt = newTF("", adressePanel);
        newLabel("   Mailadresse", adressePanel);
        JTextField tfMailKunde = newTF("", adressePanel);
        newLabel("", adressePanel);
        newLabel("   Telefon", adressePanel);
        JTextField tfTelefonKunde = newTF("", adressePanel);
        JButton speichern = newButton("Speichern", adressePanel);

        speichern.addActionListener((java.awt.event.ActionEvent e) -> {
            Adresse neueAdresseKunde = new Adresse();
            neueAdresseKunde.setLand(checkNull(tfLandKunde.getText().length(), tfLandKunde.getText(), "Kein Land"));           
            neueAdresseKunde.setStadt(checkNull(tfStadtKunde.getText().length(), tfStadtKunde.getText(), "Keine Stadt"));           
            neueAdresseKunde.setStrasse(checkNull(tfStrasseKunde.getText().length(), tfStrasseKunde.getText(), "Keine Straße"));           
            neueAdresseKunde.setHausnummer(Integer.parseInt(checkNull(tfHausnummerKunde.getText().length(), tfHausnummerKunde.getText(), "0")));           
            neueAdresseKunde.setTelefonnummer(checkNull(tfTelefonKunde.getText().length(), tfTelefonKunde.getText(), "Kein Telefon"));           
            neueAdresseKunde.setMailadresse(checkNull(tfMailKunde.getText().length(), tfMailKunde.getText(), "Keine Email"));
            auftrag.setAuftraggeberAdresse(neueAdresseKunde);
            
            Adresse neueAdresseOrt = new Adresse();
            neueAdresseOrt.setLand(checkNull(tfLandOrt.getText().length(), tfLandOrt.getText(), "Kein Land"));
            neueAdresseOrt.setStadt(checkNull(tfStadtOrt.getText().length(), tfStadtOrt.getText(), "Keine Stadt"));           
            neueAdresseOrt.setStrasse(checkNull(tfStrasseOrt.getText().length(), tfStrasseOrt.getText(), "Keine Straße"));         
            neueAdresseOrt.setHausnummer(Integer.parseInt(checkNull(tfHausnummerOrt.getText().length(), tfHausnummerOrt.getText(), "0")));         
            neueAdresseOrt.setTelefonnummer(checkNull(tfTelefonKunde.getText().length(), tfTelefonKunde.getText(), "Kein Telefon"));         
            neueAdresseOrt.setMailadresse(checkNull(tfMailKunde.getText().length(), tfMailKunde.getText(), "Keine Email"));    
            auftrag.setAdresse(neueAdresseOrt);
            
            adresseFrame.setVisible(false);
        });
      
   } // !!! Fertig und gekürzt !!!
        
   //Bearbeiten ---------------------------------------------------------------------------------------------------------------  
   private void bearbeitenAngestellterFrame (Angestellter angestellter) {
       
   }
   
   private void bearbeitenAuftragFrame (Auftrag auftrag, int index) {
        JPanel bearbeitenAuftragPanel = givePanel(20,2);
        JDialog bearbeitenAuftragFrame = giveFrame("Auftrag Bearbeiten", 330, 600, 580, 490, bearbeitenAuftragPanel);
        
        newLabel("     Titel ", bearbeitenAuftragPanel);
        JTextField tfTitel = newTF(auftrag.getTitel(), bearbeitenAuftragPanel);
        
        newLabel("  Daten Bauort ---------", bearbeitenAuftragPanel);
        newLabel("--------------------", bearbeitenAuftragPanel);
        newLabel("     Land: ", bearbeitenAuftragPanel);
        JTextField tfOrtLand = newTF(auftrag.getAdresse().getLand(), bearbeitenAuftragPanel);
        newLabel("     Stadt: ", bearbeitenAuftragPanel);
        JTextField tfOrtStadt = newTF(auftrag.getAdresse().getStadt(), bearbeitenAuftragPanel);
        newLabel("     Straße: ", bearbeitenAuftragPanel);
        JTextField tfOrtStrasse = newTF(auftrag.getAdresse().getStrasse(), bearbeitenAuftragPanel);
        newLabel("     Hausnummer: ", bearbeitenAuftragPanel);
        JTextField tfOrtHausnummer = newTF("" + auftrag.getAdresse().getHausnummer(), bearbeitenAuftragPanel);
        
        newLabel("  Daten Kunde ---------", bearbeitenAuftragPanel);
        newLabel("--------------------", bearbeitenAuftragPanel);
        newLabel("     Name: ", bearbeitenAuftragPanel);
        JTextField tfKundeName = newTF(auftrag.getAuftraggeberName(), bearbeitenAuftragPanel);
        newLabel("     Land: ", bearbeitenAuftragPanel);
        JTextField tfKundeLand = newTF(auftrag.getAuftraggeberAdresse().getLand(), bearbeitenAuftragPanel);
        newLabel("     Stadt: ", bearbeitenAuftragPanel);
        JTextField tfKundeStadt = newTF(auftrag.getAuftraggeberAdresse().getStadt(), bearbeitenAuftragPanel);
        newLabel("     Straße: ", bearbeitenAuftragPanel);
        JTextField tfKundeStrasse = newTF(auftrag.getAuftraggeberAdresse().getStrasse(), bearbeitenAuftragPanel);
        newLabel("     Hausnummer: ", bearbeitenAuftragPanel);
        JTextField tfKundeHausnummer = newTF("" + auftrag.getAuftraggeberAdresse().getHausnummer(), bearbeitenAuftragPanel);
        newLabel("     Telefonnummer: ", bearbeitenAuftragPanel);
        JTextField tfKundeTelefonnummer = newTF(auftrag.getAuftraggeberAdresse().getTelefonnummer(), bearbeitenAuftragPanel);
        newLabel("     Mailadresse: ", bearbeitenAuftragPanel);
        JTextField tfKundeMail = newTF(auftrag.getAuftraggeberAdresse().getMailadresse(), bearbeitenAuftragPanel);
        
        newLabel("  Angestellte ----------", bearbeitenAuftragPanel);
        newLabel("--------------------", bearbeitenAuftragPanel);
        newLabel("     Projektleiter:", bearbeitenAuftragPanel);
        JButton projektleiterAuswaehlen = newButton("Auswählen", bearbeitenAuftragPanel);
        newLabel("     Architekt:", bearbeitenAuftragPanel);
        JButton architektAuswaehlen = newButton("Auswählen", bearbeitenAuftragPanel);
        newLabel("     Statiker:", bearbeitenAuftragPanel);
        JButton statikerAuswaehlen = newButton("Auswählen", bearbeitenAuftragPanel);
        newLabel("     Bauarbeiter:", bearbeitenAuftragPanel);
        JButton bauarbeiterBearbeiten = newButton("Bearbeiten", bearbeitenAuftragPanel);
        JButton loeschenButton = newButton("Löschen", bearbeitenAuftragPanel);
        JButton auftragSpeichern = newButton("Speichern", bearbeitenAuftragPanel);
        
        auftragSpeichern.addActionListener((java.awt.event.ActionEvent e) -> {
             auftrag.setTitel(tfTitel.getText());
             auftrag.getAdresse().setLand(tfOrtLand.getText());
             auftrag.getAdresse().setStadt(tfOrtStadt.getText());
             auftrag.getAdresse().setStrasse(tfOrtStrasse.getText());
             auftrag.getAdresse().setHausnummer(Integer.parseInt(tfOrtHausnummer.getText()));
             auftrag.setAuftraggeberName(tfKundeName.getText());
             auftrag.getAuftraggeberAdresse().setLand(tfKundeLand.getText());
             auftrag.getAuftraggeberAdresse().setStadt(tfKundeStadt.getText());
             auftrag.getAuftraggeberAdresse().setStrasse(tfKundeStrasse.getText());
             auftrag.getAuftraggeberAdresse().setHausnummer(Integer.parseInt(tfKundeHausnummer.getText()));
             auftrag.getAuftraggeberAdresse().setTelefonnummer(tfKundeTelefonnummer.getText());
             auftrag.getAuftraggeberAdresse().setMailadresse(tfKundeMail.getText());
             bearbeitenAuftragFrame.setVisible(false);
        });
        
        loeschenButton.addActionListener((java.awt.event.ActionEvent e) -> {
             auftragLoeschen(auftrag, index);
             bearbeitenAuftragFrame.setVisible(false);
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
        
   } //Fertig und gekürzt
   
   //Übersicht ----------------------------------------------------------------------------------------------------------------  
    private void uebersichtAngestellteFrame () {
        JPanel uebersichtAngestelltePanel = givePanel(15,1);
        JDialog uebersichtAngestellteFrame = giveFrame("Übersicht Angestellte", 230, 450, 0, 250, uebersichtAngestelltePanel);
  
        JComboBox bauarbeiterPop = new JComboBox();
        if(main.bauarbeiterListe != null){
        for(int i = 0; i < main.bauarbeiterListe.size(); i++){
            bauarbeiterPop.addItem(main.bauarbeiterListe.get(i).getName());
        }}
        JComboBox statikerPop = new JComboBox();
        if(main.statikerListe != null){
        for(int i = 0; i < main.statikerListe.size(); i++){
            statikerPop.addItem(main.statikerListe.get(i).getName());
        }}
        JComboBox architektPop = new JComboBox();
        if(main.architektListe != null){
        for(int i = 0; i < main.architektListe.size(); i++){
            architektPop.addItem(main.architektListe.get(i).getName());
        }}
        JComboBox projektleiterPop = new JComboBox();
        if(main.projektleiterListe != null){
        for(int i = 0; i < main.projektleiterListe.size(); i++){
            projektleiterPop.addItem(main.projektleiterListe.get(i).getName());
        }}
       
        newLabelM("Bauarbeiter", uebersichtAngestelltePanel);
        uebersichtAngestelltePanel.add(bauarbeiterPop);
        JButton bauarbeiterButton = newButton("Details", uebersichtAngestelltePanel);
        newLabelM("--------------------", uebersichtAngestelltePanel);
        newLabelM("Architekt", uebersichtAngestelltePanel);
        uebersichtAngestelltePanel.add(architektPop);
        JButton architektButton = newButton("Details", uebersichtAngestelltePanel);
        newLabelM("--------------------", uebersichtAngestelltePanel);
        newLabelM("Statiker", uebersichtAngestelltePanel);
        uebersichtAngestelltePanel.add(statikerPop);
        JButton statikerButton = newButton("Details", uebersichtAngestelltePanel);
        newLabelM("--------------------", uebersichtAngestelltePanel);
        newLabelM("Projektleiter",uebersichtAngestelltePanel);
        uebersichtAngestelltePanel.add(projektleiterPop);
        JButton projektleiterButton = newButton("Details", uebersichtAngestelltePanel);
       
        bauarbeiterButton.addActionListener((java.awt.event.ActionEvent e) -> {
            detailAngestellter(main.bauarbeiterListe.get(bauarbeiterPop.getSelectedIndex()), 0, bauarbeiterPop.getSelectedIndex());
        });
        
        architektButton.addActionListener((java.awt.event.ActionEvent e) -> {
            detailAngestellter(main.architektListe.get(bauarbeiterPop.getSelectedIndex()), 2, 1);
        });
        
        statikerButton.addActionListener((java.awt.event.ActionEvent e) -> {
            detailAngestellter(main.statikerListe.get(bauarbeiterPop.getSelectedIndex()), 2, 1);
        });
        
        projektleiterButton.addActionListener((java.awt.event.ActionEvent e) -> {
            detailAngestellter(main.projektleiterListe.get(bauarbeiterPop.getSelectedIndex()), 1, bauarbeiterPop.getSelectedIndex());
        });
      
   } // Gekürzt - Verknüpfungen der Buttons fehlt noch!
   
    private void uebersichtAuftragFrame (int auswahl) {
        JPanel uebersichtAuftragPanel = givePanel(3,1);
        JDialog uebersichtAuftragFrame = giveFrame("Übersicht Auftrag", 230, 100, 0, 490, uebersichtAuftragPanel);

        newLabelM("Aufträge", uebersichtAuftragPanel);
        JComboBox auftraegePop = new JComboBox();
        for(int i = 0; i < main.auftragListe.size(); i++){
            auftraegePop.addItem(main.auftragListe.get(i).getTitel());
        }
        uebersichtAuftragPanel.add(auftraegePop);
        JButton auftragButton = newButton("Details", uebersichtAuftragPanel);
      
        auftragButton.addActionListener((java.awt.event.ActionEvent e) -> {
            String ausgweahltesObjekt = (String)auftraegePop.getSelectedItem();
            
            for(int index=0; index < main.auftragListe.size(); index++){
                
                if(ausgweahltesObjekt.equals(main.auftragListe.get(index).getTitel())){
                    switch(auswahl){
                        case 0:
                            detailAuftrag(main.auftragListe.get(index), index); 
                            break;
                        case 1:
                            bearbeitenAuftragFrame(main.auftragListe.get(index), index); 
                            break;
                    }
                }
            }
        });
   } //!!! Fertig und gekürzt !!!
   
   //Detailansicht --------------------------------------------------------------------------------------------------------------  
   private void detailAngestellter (Angestellter angestellter, int auswahl, int index){
        JPanel detailAngestellterPanel = givePanel(8,2);
        JDialog detailAngestellterFrame = giveFrame("Detail Angestellter", 380, 180, 230, 250, detailAngestellterPanel);
       
        newLabel("   Name", detailAngestellterPanel);
        System.out.println(angestellter.getName());
        newLabel(angestellter.getName(), detailAngestellterPanel);
        newLabel("   Adresse des Angestellten:", detailAngestellterPanel);
        newLabel(angestellter.getAdresse().getStadt() + ", " + angestellter.getAdresse().getLand(), detailAngestellterPanel);
        newLabel("", detailAngestellterPanel);
        newLabel(angestellter.getAdresse().getStrasse() + " " + angestellter.getAdresse().getHausnummer(), detailAngestellterPanel);
        newLabel("", detailAngestellterPanel);
        newLabel(angestellter.getAdresse().getMailadresse(), detailAngestellterPanel);
        newLabel("", detailAngestellterPanel);
        newLabel(angestellter.getAdresse().getTelefonnummer(), detailAngestellterPanel);
        newLabel("   Gehalt:", detailAngestellterPanel);
        newLabel(Float.toString(angestellter.getGehalt()), detailAngestellterPanel);

        switch (auswahl){
            case 0:
                newLabel("   Typ:", detailAngestellterPanel);
                newLabel(main.bauarbeiterListe.get(index).getBauarbeiterTyp(), detailAngestellterPanel);
                break;
            case 1: 
                newLabel("   Erstehilfe:", detailAngestellterPanel);
                newLabel(Boolean.toString(main.projektleiterListe.get(index).getErsteHilfe()), detailAngestellterPanel);
                break;
            case 2:
                newLabel("", detailAngestellterPanel);
                newLabel("", detailAngestellterPanel);
        }
        newLabel("", detailAngestellterPanel);
        JButton bearbeitenButton = newButton("Bearbeiten", detailAngestellterPanel);
        
        bearbeitenButton.addActionListener((java.awt.event.ActionEvent e) -> {
            bearbeitenAngestellterFrame(angestellter);
        });
       
   } //!!! Fertig und gekürzt !!!
   
   private void detailAuftrag (Auftrag auftrag, int index){
        JPanel detailAuftragPanel = givePanel(13,2);
        JDialog detailAuftragFrame = giveFrame("Detail Auftrag", 350, 300, 230, 490, detailAuftragPanel);
       
        newLabel("   Auftrag:", detailAuftragPanel);
        newLabel(auftrag.getTitel(), detailAuftragPanel);
        newLabel("   Daten des Auftrages:", detailAuftragPanel);
        newLabel(auftrag.getAdresse().getStadt() + ", " + auftrag.getAdresse().getLand(), detailAuftragPanel);
        newLabel("", detailAuftragPanel);
        newLabel(auftrag.getAdresse().getStrasse() + " " + auftrag.getAdresse().getHausnummer(), detailAuftragPanel);
        newLabel("   Daten des Auftraggebers:", detailAuftragPanel);
        newLabel(auftrag.getAuftraggeberName(), detailAuftragPanel);
        newLabel("", detailAuftragPanel);
        newLabel(auftrag.getAuftraggeberAdresse().getStadt() + ", " + auftrag.getAuftraggeberAdresse().getLand(), detailAuftragPanel);
        newLabel("", detailAuftragPanel);
        newLabel(auftrag.getAuftraggeberAdresse().getStrasse() + " " + auftrag.getAuftraggeberAdresse().getHausnummer(), detailAuftragPanel);
        newLabel("", detailAuftragPanel);
        newLabel(auftrag.getAuftraggeberAdresse().getMailadresse(), detailAuftragPanel);
        newLabel("", detailAuftragPanel);
        newLabel(auftrag.getAuftraggeberAdresse().getTelefonnummer(), detailAuftragPanel);
        
        newLabel("   Projektleiter:", detailAuftragPanel);
        if(auftrag.getProjektleiter() != null){
            newLabel(auftrag.getProjektleiter().getName(), detailAuftragPanel);
        } 
        else{
            newLabel("Kein Projektleiter", detailAuftragPanel);
        } 
        newLabel("   Architekt:", detailAuftragPanel);
        if(auftrag.getArchitekt() != null){
            newLabel(auftrag.getArchitekt().getName(), detailAuftragPanel);
        } 
        else{
            newLabel("Kein Architekt", detailAuftragPanel);
        }
        newLabel("   Statiker:", detailAuftragPanel);
        if(auftrag.getStatiker() != null){
            newLabel(auftrag.getStatiker().getName(), detailAuftragPanel);
        } 
        else{
            newLabel("Kein Statiker", detailAuftragPanel);
        }
        newLabel("   Bauarbeiter:", detailAuftragPanel);
        
        JComboBox bauarbeiterPop = new JComboBox();
        if(auftrag.getBauarbeiterListe()!= null){
        for(int i = 0; i < auftrag.getBauarbeiterListe().size(); i++){
            bauarbeiterPop.addItem(auftrag.getBauarbeiterListe().get(i).getName()); 
        }} 
        detailAuftragPanel.add(bauarbeiterPop);
        newLabel("", detailAuftragPanel);
        JButton bearbeitenButton = newButton("Bearbeiten", detailAuftragPanel);

        bearbeitenButton.addActionListener((java.awt.event.ActionEvent e) -> {
            bearbeitenAuftragFrame(auftrag, index);
        });
       
       
   } // !!! Fertig und gekürzt !!!
   
   //Verschieben -----------------------------------------------------------------------------------------------------------------  
    private void verschieben (Auftrag auftrag, int auswahl){
        JPanel verschiebenPanel = givePanel(3,3);
        JDialog verschiebenFrame = giveFrame("Angestellte Verschieben", 380, 100, 910, 490, verschiebenPanel);
        
        switch (auswahl){
            case 0:
                newLabelM("Liste der aktuellen Bauarbeiter", verschiebenPanel);
                newLabel("", verschiebenPanel);
                newLabelM("Liste der verfügbaren Bauarbeiter", verschiebenPanel);
                JComboBox aktuelleBauarbeiterPop = new JComboBox();
                if(auftrag.getBauarbeiterListe() != null){
                for(int i = 0; i < auftrag.getBauarbeiterListe().size(); i++){
                    aktuelleBauarbeiterPop.addItem(auftrag.getBauarbeiterListe().get(i).getName());
                }}
                verschiebenPanel.add(aktuelleBauarbeiterPop);
                JButton hinzufuegenB = newButton("<---", verschiebenPanel);
                JComboBox verfuegbareBauarbeiterPop = new JComboBox();
                if(main.bauarbeiterListe != null){
                for(int i = 0; i < main.bauarbeiterListe.size(); i++){
                verfuegbareBauarbeiterPop.addItem(main.bauarbeiterListe.get(i).getName());
                }}
                verschiebenPanel.add(verfuegbareBauarbeiterPop);
                newLabel("", verschiebenPanel);
                JButton entfernenB = newButton("--->", verschiebenPanel);
                
                hinzufuegenB.addActionListener((java.awt.event.ActionEvent e) -> {
                    Bauarbeiter tempBauarbeiter = main.bauarbeiterListe.get(verfuegbareBauarbeiterPop.getSelectedIndex());                
                    aktuelleBauarbeiterPop.addItem(main.bauarbeiterListe.get(verfuegbareBauarbeiterPop.getSelectedIndex()).getName());                 
                    main.bauarbeiterListe.remove(verfuegbareBauarbeiterPop.getSelectedIndex());                
                    verfuegbareBauarbeiterPop.removeItemAt(verfuegbareBauarbeiterPop.getSelectedIndex());                            
                    auftrag.addBauarbeiterToListe(tempBauarbeiter);           
                });
                
                entfernenB.addActionListener((java.awt.event.ActionEvent e) -> {
                    Bauarbeiter tempBauarbeiter = auftrag.bauarbeiterListe.get(aktuelleBauarbeiterPop.getSelectedIndex());
                    verfuegbareBauarbeiterPop.addItem(tempBauarbeiter.getName());
                    auftrag.bauarbeiterListe.remove(aktuelleBauarbeiterPop.getSelectedIndex());
                    aktuelleBauarbeiterPop.removeItemAt(aktuelleBauarbeiterPop.getSelectedIndex());
                    main.bauarbeiterListe.add(tempBauarbeiter);
                });
                break;
     
            case 1: 
                verschiebenFrame.setLocation(910, 580);
                newLabel("Aktueller Architekt", verschiebenPanel);
                newLabel("", verschiebenPanel);
                newLabel("Liste der verfügbaren Architekten", verschiebenPanel);
                JLabel aktuellerArchitekt = new JLabel("Kein Architekt");
                if(auftrag.getArchitekt() != null){
                    aktuellerArchitekt.setText(auftrag.getArchitekt().getName());
                } 
                verschiebenPanel.add(aktuellerArchitekt);
                JButton hinzufuegenA = newButton("<---", verschiebenPanel);
                JComboBox architektPop = new JComboBox();
                if(main.architektListe != null){
                    for(int i = 0; i < main.architektListe.size(); i++){
                    architektPop.addItem(main.architektListe.get(i).getName());
                    }
                }
                verschiebenPanel.add(architektPop);
                newLabel("", verschiebenPanel);
                JButton entfernenA = newButton("--->", verschiebenPanel);

                hinzufuegenA.addActionListener((java.awt.event.ActionEvent e) -> {
                   
                   if(auftrag.getArchitekt() != null){
                        Architekt tempAAlt = auftrag.getArchitekt();
                        main.architektListe.add(tempAAlt); //Alter Architekt zur Main
                        architektPop.addItem(tempAAlt.getName()); //Alter Architekt zum Pop
                   }
                   
                   Architekt tempANeu = main.architektListe.get(architektPop.getSelectedIndex());
                   architektPop.removeItemAt(architektPop.getSelectedIndex()); //Neuer Architekt aus Pop gelöscht
                   aktuellerArchitekt.setText(tempANeu.getName()); //Name des NeuenArchitekten auf Label gesetzt
                   auftrag.setArchitekt(tempANeu); //Neuer Architekt zum Auftrag hinzugefügt
                   main.architektListe.remove(architektPop.getSelectedIndex());
                });
                
                entfernenA.addActionListener((java.awt.event.ActionEvent e) -> {
                    if(auftrag.getStatiker() != null){
                        Architekt tempArchitekt = auftrag.getArchitekt();
                        aktuellerArchitekt.setText("Kein Architekt");
                        auftrag.setArchitekt(null);
                        main.architektListe.add(tempArchitekt);
                        architektPop.addItem(tempArchitekt.getName());
                    }
                });
                
                break;
                
            case 2:
                verschiebenFrame.setLocation(910, 680);
                newLabel("Aktueller Statiker", verschiebenPanel);
                newLabel("", verschiebenPanel);
                newLabel("Liste der verfügbaren Statiker", verschiebenPanel);
                JLabel aktuellerStatiker = new JLabel("Kein Statiker");
                if(auftrag.getStatiker() != null){
                    aktuellerStatiker.setText(auftrag.getStatiker().getName());
                }
                verschiebenPanel.add(aktuellerStatiker);
                JButton hinzufuegenS = newButton("<---", verschiebenPanel);
                JComboBox statikerPop = new JComboBox();
                if(main.statikerListe != null){
                for(int i = 0; i < main.statikerListe.size(); i++){
                    statikerPop.addItem(main.statikerListe.get(i).getName());
                }}
                verschiebenPanel.add(statikerPop);
                newLabel("", verschiebenPanel);
                JButton entfernenS = newButton("--->", verschiebenPanel);
   
                hinzufuegenS.addActionListener((java.awt.event.ActionEvent e) -> {
                   
                   if(auftrag.getStatiker() != null){
                        Statiker tempSAlt = auftrag.getStatiker();
                        main.statikerListe.add(tempSAlt); //Alter Statiker zur Main
                        statikerPop.addItem(tempSAlt.getName()); //Alter Statiker zum Pop
                   }
                   
                   Statiker tempSNeu = main.statikerListe.get(statikerPop.getSelectedIndex());
                   statikerPop.removeItemAt(statikerPop.getSelectedIndex()); //Neuer Architekt aus Pop gelöscht
                   aktuellerStatiker.setText(tempSNeu.getName()); //Name des NeuenArchitekten auf Label gesetzt
                   auftrag.setStatiker(tempSNeu); //Neuer Architekt zum Auftrag hinzugefügt
                   main.statikerListe.remove(statikerPop.getSelectedIndex());


                });
                
                entfernenS.addActionListener((java.awt.event.ActionEvent e) -> {
                  if(auftrag.getStatiker() != null){
                    Statiker tempStatiker = auftrag.getStatiker();
                    aktuellerStatiker.setText("Kein Statiker");
                    auftrag.setStatiker(null);            
                    main.statikerListe.add(tempStatiker);
                    statikerPop.addItem(tempStatiker.getName());
                  }
                });
                
                break;
          
            case 3:
                verschiebenFrame.setLocation(910, 780);
                newLabel("Aktueller Projektleiter", verschiebenPanel);
                newLabel("", verschiebenPanel);
                newLabel("Liste der verfügbaren Projektleiter", verschiebenPanel);
                JLabel aktuellerProjektleiter = new JLabel("Kein Projektleiter");
                if(auftrag.getProjektleiter() != null){
                    aktuellerProjektleiter.setText(auftrag.getProjektleiter().getName());
                }
                verschiebenPanel.add(aktuellerProjektleiter);
                JButton hinzufuegenP = newButton("<---", verschiebenPanel);
                JComboBox projektleiterPop = new JComboBox();
                if(main.projektleiterListe != null){
                for(int i = 0; i < main.projektleiterListe.size(); i++){
                    projektleiterPop.addItem(main.projektleiterListe.get(i).getName());
                }}
                verschiebenPanel.add(projektleiterPop);
                newLabel("", verschiebenPanel);
                JButton entfernenP = newButton("--->", verschiebenPanel);
                
                hinzufuegenP.addActionListener((java.awt.event.ActionEvent e) -> {
                   if(auftrag.getProjektleiter() != null){
                        Projektleiter tempPAlt = auftrag.getProjektleiter();
                        main.projektleiterListe.add(tempPAlt);
                        projektleiterPop.addItem(tempPAlt.getName());
                   } 
                   Projektleiter tempPNeu = main.projektleiterListe.get(projektleiterPop.getSelectedIndex());
                   main.projektleiterListe.remove(projektleiterPop.getSelectedIndex());
                   projektleiterPop.removeItemAt(projektleiterPop.getSelectedIndex()); //Neuer Architekt aus Pop gelöscht
                   aktuellerProjektleiter.setText(tempPNeu.getName()); //Name des NeuenArchitekten auf Label gesetzt
                   auftrag.setProjektleiter(tempPNeu); //Neuer Architekt zum Auftrag hinzugefügt
                
                });
                
                entfernenP.addActionListener((java.awt.event.ActionEvent e) -> {
                    if(auftrag.getProjektleiter() != null){
                        Projektleiter tempProjektleiter = auftrag.getProjektleiter();                
                        aktuellerProjektleiter.setText("Kein Projektleiter");
                        auftrag.setProjektleiter(null);  
                        main.projektleiterListe.add(tempProjektleiter);
                        projektleiterPop.addItem(tempProjektleiter.getName());
                   }
                });
                
                break;
        }
        
        
  } // !!! Fertig und gekürzt !!!
   
   //Extraframes -----------------------------------------------------------------------------------------------------------------  
   private void fehlerFrame () {
        JPanel fehlerPanel = givePanel(2,1); 
        JDialog fehlerFrame = giveFrame("Fehler", 340, 100, 700, 700, fehlerPanel);

        JLabel fehlerLabel1 = new JLabel("Es ist zu einem Fehler gekommen.", JLabel.CENTER), fehlerlabel2 = new JLabel("Es sind nicht alle Pflichtfelder ausgefüllt.", JLabel.CENTER);  
        fehlerPanel.add(fehlerLabel1);
        fehlerPanel.add(fehlerlabel2);
        JButton fehlerButton = newButton("OK", fehlerPanel);
        
        fehlerButton.addActionListener((java.awt.event.ActionEvent e) -> {
            fehlerFrame.setVisible(false);
        });
        
   } // !!! Fertig und gekürzt !!!
   
   private void auftragLoeschen (Auftrag auftrag, int index) {
        JPanel aLoeschenPanel = givePanel(2,1); 
        JDialog aLoeschenFrame = giveFrame("Auftrag löschen", 340, 100, 700, 700, aLoeschenPanel);

        newLabelM("Auftrag " + auftrag.getTitel() + " wirklich löschen?", aLoeschenPanel);  
        JButton loeschenButton = newButton("Löschen", aLoeschenPanel);
        
        loeschenButton.addActionListener((java.awt.event.ActionEvent e) -> {
            if(auftrag.getArchitekt() != null){
               main.architektListe.add(auftrag.getArchitekt());
            }
            if(auftrag.getStatiker() != null){
               main.statikerListe.add(auftrag.getStatiker());
            }
            if(auftrag.getProjektleiter() != null){
               main.projektleiterListe.add(auftrag.getProjektleiter());
            }
            if(auftrag.getBauarbeiterListe() != null){
               for(int i = 0; i < auftrag.getBauarbeiterListe().size(); i++){
                   main.bauarbeiterListe.add(auftrag.getBauarbeiterListe().get(i));
               }
            }
            main.auftragListe.remove(index);    
        });
        
   } // !!! Fertig und gekürzt !!!
   
   //Hilfsmethoden ---------------------------------------------------------------------------------------------------
   private JDialog giveFrame (String titel, int gx, int gy, int px, int py, JPanel panel){
        JDialog newFrame = new JDialog();
        newFrame.setSize(gx,gy);
        newFrame.setTitle(titel);
        newFrame.setLocation(px, py);
        newFrame.setResizable(false);
        newFrame.add(panel);
        newFrame.setVisible(true);
        return newFrame;
   }
   
   private JPanel givePanel (int zeilen, int spalten){
        JPanel newPanel = new JPanel();
        newPanel.setLayout( new java.awt.GridLayout( zeilen, spalten ) );
        return newPanel;
   }
   
   private void newLabel(String newLabelText, JPanel panel){
            JLabel label = new JLabel(newLabelText);
            panel.add(label); 
   }
   
   private void newLabelM(String newLabelText, JPanel panel){
            JLabel label = new JLabel(newLabelText, JLabel.CENTER);
            panel.add(label);
   }
   
   private JTextField newTF(String newTFText, JPanel panel){
       JTextField textField = new JTextField(newTFText);
       panel.add(textField);
       return textField;
   }
   
   private JButton newButton(String newButtonText, JPanel panel){
       JButton button = new JButton(newButtonText);
       panel.add(button);
       return button;
   }
   
   private String checkNull (int checkValue, String textTrue, String textFalse){
       if(checkValue != 0){
           return textTrue;
       } else{
           return textFalse;
       } 
   }
   
   private JMenuItem setMenuSub (JMenu top, String sub){
        JMenuItem subMen = new JMenuItem(sub);
        top.add(subMen);
        return subMen;
   }
}