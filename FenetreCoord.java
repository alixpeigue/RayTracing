import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import java.awt.Font;


//public class FenetreCoord extends JFrame implements ActionListener{ // besoin de boutons pour le menu, le choix de la scène
public class FenetreCoord extends JFrame implements ActionListener{
    // taille fenêtre et attributs
    int width;
    int height;
    // declaration des boutons en attribut qui seront utilises dans le ActionPerformed
    JComboBox listeVolume = new JComboBox();
    JComboBox listeMatieres = new JComboBox();
    JButton etapeSuiv1 = new JButton("Passer étape suivante");
    JButton effRendu = new JButton("Effacer le rendu");
    JButton sortie = new JButton(" Sortie du programme");
    JPanel panelEtape2 = new JPanel();
    JButton testAffichage = new JButton("Test affichage");
    JLabel testRendu = new JLabel(" ");
    // Window window ;

    // constructeur
    public FenetreCoord(String nom, int w, int h) {
        super(nom);
        this.width = w;
        this.height = h;
        this.setSize(width, height);
        this.setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // panel
        JPanel panelGlobal = new JPanel();
        panelGlobal.setBounds(0, 0, this.width, this.height); // panneau qui englobe tt la fenetre
        panelGlobal.setBackground(Color.blue);
        panelGlobal.setLayout(null);

        JPanel panelMenu = new JPanel();
        panelMenu.setBounds(0, 0, 300, 50);
        panelMenu.setLayout(null);
        panelMenu.setBackground(Color.orange);


        JLabel labelMenu = new JLabel("Menu");
        labelMenu.setBounds(125, 10, 50, 20);
        panelMenu.add(labelMenu);
        panelGlobal.add(panelMenu);

        //PANEL GLOBAL DES ETAPES
        JPanel panelEtapes = new JPanel();
        panelEtapes.setVisible(true);
        panelEtapes.setBackground(Color.yellow);
        panelEtapes.setLayout(null);
        panelEtapes.setBounds(0, 50, 300, 450);
        panelGlobal.add(panelEtapes);

        // Panel etape 1
        JPanel panelEtape1 = new JPanel();
        panelEtape1.setVisible(true);
        panelEtape1.setLayout(null);
        panelEtape1.setBounds(0, 0, 300, 150);
        panelEtape1.setBackground(Color.red);
        // Listes deroulantes Etape 1
        listeVolume.setBounds(10, 10, 200, 30);
        listeVolume.addItem("--Choix volume--");
        listeVolume.addItem("Sphère");
        listeVolume.addItem("Cube");
        listeVolume.addItem("Cylindre");
        listeVolume.addActionListener(this);
        listeMatieres.setBounds(10, 45, 200, 30);
        listeMatieres.addItem("--Choix matière--");
        listeMatieres.addItem("Bois");
        listeMatieres.addActionListener(this);

        etapeSuiv1.setBounds(10, 90, 200, 30);
        etapeSuiv1.setBackground(Color.green);
        etapeSuiv1.addActionListener(this);

        panelEtape1.add(listeVolume);
        panelEtape1.add(listeMatieres);
        panelEtape1.add(etapeSuiv1);
        panelEtapes.add(panelEtape1);
        // Panel Etape2
        JPanel panelEtape2 = new JPanel();
        panelEtape2.setVisible(true);
        panelEtape2.setLayout(null);
        panelEtape2.setBounds(0, 150, 300, 150);
        panelEtape2.setBackground(Color.cyan);

        panelEtapes.add(panelEtape2);
        // Boutons d'etape2

        // PanelEtape3
        JPanel panelEtape3 = new JPanel();
        panelEtape3.setVisible(true);
        panelEtape3.setLayout(null);
        panelEtape3.setBackground(Color.magenta);
        panelEtape3.setBounds(0, 300, 300, 150);
        panelEtapes.add(panelEtape3);
        //Boutons d'etape 3
        effRendu.setBounds(20, 20, 200, 50);
        sortie.setBounds(20, 80, 200, 50);
        effRendu.addActionListener(this);
        panelEtape3.add(effRendu);
        panelEtape3.add(sortie);

        //PANEL AFFICHAGE RENDU
        JPanel panelZoneAffichage = new JPanel();
        panelZoneAffichage.setBounds(500, 100, 300, 300);
        //cons.fill=;
        panelZoneAffichage.setVisible(true);

        JLabel labelVide = new JLabel("Future zone de rendu ////");
        // Test de modif de police de caractère
        Font police = new Font(" Calibri ", Font.BOLD, 18);
        labelVide.setFont(police);
        //labelVide.setText(" RENDU");
        panelZoneAffichage.add(labelVide);

        panelZoneAffichage.add(testRendu);

        panelZoneAffichage.setBackground(Color.gray);
        panelGlobal.add(panelZoneAffichage);

        //window = new Window(0);: test pour lier IHM/Rendu en mettant window en para


        add(panelGlobal);
        this.setVisible(true);
    } // fin du constructeur

    public void actionPerformed(ActionEvent e) {
        System.out.println("Clic");
        if (e.getSource() == etapeSuiv1) {
            System.out.println("Etape suivante");
        }
        if (e.getSource() == effRendu) {
            System.out.println(" Effacer");
        }
        if (listeVolume.getSelectedItem() == "Sphère") {
            System.out.println("Sphère sélectionnée");
            //panelEtape2.setVisible(true);
        }
        if (listeVolume.getSelectedItem() == "Cube") {
            System.out.println("Cube sélectionné");
            //panelEtape2.setVisible(true);
        }
        if (listeMatieres.getSelectedItem() == "Bois") {
            System.out.println("Bois sélectionné");
            //panelEtape2.setVisible(true);
        }
        if (e.getSource() == testAffichage) {
            System.out.println("Bouton test affichage cliqué");
            /*JFrame frame = new JFrame();
            Window window = new Window(0);
            frame.getContentPane().add(window);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(720, 720);
            frame.setVisible(true);

            Timer timer = new Timer(10, window);
            //timer.start();
            */
            JLabel testAFF= new JLabel(new ImageIcon("./Crepe2.png"));
            //panelZoneAffichage.add(testAFF);
            testAFF.setVisible(true);
            panelEtape2.add(testAFF);
        }

    }


        public static void main (String[]args){
            FenetreCoord f = new FenetreCoord(" IHM", 1000, 535);

        }

}



