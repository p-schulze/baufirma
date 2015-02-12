/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
       JButton button1 = new JButton();
       JButton button2 = new JButton();
       JButton button3 = new JButton();
       JPanel panel1 = new JPanel();
       JPanel panel2 = new JPanel();
       backgroundFrame.setTitle("baufirma");
       backgroundFrame.setSize(450,600);
          
       button1.setText("Neuen Auftrag hinzufügen");
       panel1.add(button1);
       panel2.add(button2);
       panel2.add(button3);
       backgroundFrame.add(panel1);
       backgroundFrame.add(panel2);
       
        JMenuBar menuBar = new JMenuBar();
        JMenu hinzufuegenMenu = new JMenu("Hinzufügen");
        JMenuItem item1 = new JMenuItem("Arbeiter");
        JMenuItem item2 = new JMenuItem("Auftrag");
        JMenuItem item3 = new JMenuItem("Kunde");
  
        hinzufuegenMenu.add(item1);
        hinzufuegenMenu.add(item2);
        hinzufuegenMenu.add(item3);
        menuBar.add(hinzufuegenMenu);
        backgroundFrame.add(menuBar, BorderLayout.NORTH);
        
        backgroundFrame.setVisible(true);
        
        item1.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.out.println("Item1");
            }
        });
       
        item2.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.out.println("Item1");
            }
        });
        
        item3.addActionListener(new java.awt.event.ActionListener() {
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
       
        JLabel frage = new JLabel("Was für ein Arbeiter?");
        arbeiterPanel.add(frage);
        String arbeiter[] = {"Bauarbeiter", "Statiker", "Architekt", 
            "Porjketleiter"};
 
        JList arbeiterAuswahl = new JList(arbeiter);

        arbeiterPanel.add(arbeiterAuswahl);
       
       arbeiterFrame.add(arbeiterPanel);
       arbeiterFrame.setVisible(true);
   }
  
}
