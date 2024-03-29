
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;


public class FenetreAccueil extends JFrame {
    // Attributs
    int width;
    int height;

    // Constructeur
    public FenetreAccueil(String nom, int w, int h) {
        super(nom);
        this.width = w;
        this.height = h;
        this.setSize(width, height);
        this.setLocation(100, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // pour fermer uniquement cette fenetre et pas FenetreCoord en même temps

        //creation des composants

        JTextArea Description = new JTextArea();
        Description.setBounds(10, 10, 350, 260);
        Color lightBlue = new Color(204, 209, 255);
        Description.setBackground(lightBlue);
        Description.setText("  Bienvenue ! " +"\n"+
                "  Voici les fonctionnalités de notre programme qui repose " + "\n" +
                "  sur la technique du raytracing, utilisée dans le cinéma." + "\n" +
                "  Elle permet de visualiser des objets en 3D. Pour cela," + "\n" +
                "  une caméra  est positionnée  dans l'espace. On définit " + "\n" +
                "  ensuite une scène, qui contient les objets à afficher:" + "\n" +
                "  des sphères par exemple. Enfin, des rayons sont  envoyés" + "\n" +
                "  de la camera vers la scène. On calcule l'intersection " + "\n" +
                "  entre les rayons et l'objet. Les réflexions sont prises" + "\n" +
                "  en compte, et dépendent du matériau de l'objet. Tu peux" + "\n" +
                "  modifier les paramètres suivants: la position, la taille," + "\n" +
                "  le nombre, le matériau, la couleur, la texture ainsi que " + "\n" +
                "  le type des objets dans la scène.  " + " \n" +
                "  Voici  les options disponibles.  ");

        Font police = new Font(" Arial ",Font.PLAIN,12);
        Description.setFont(police);
        Description.setVisible(true);

        JLabel metalMat = new JLabel();
        metalMat.setBounds(100, 10, 185, 130);
        ImageIcon imageMetal = new ImageIcon("images/metal.png");
        metalMat.setIcon(imageMetal);
        metalMat.setVisible(true);

        JLabel diffuseMat = new JLabel();
        diffuseMat.setBounds(350,10,185,130);
        ImageIcon imageDiffuse = new ImageIcon("images/bois.png");
        diffuseMat.setIcon(imageDiffuse);
        diffuseMat.setVisible(true);

        JLabel textures = new JLabel( "           Choix des textures :   BRIQUE,   PLANCHER   OU   VERRE  ");
        textures.setBounds(20, 135, 500, 20);
        textures.setForeground(Color.white);
        Font police2 = new Font(" Arial ",Font.BOLD,14);
        textures.setFont(police2);

        JLabel color = new JLabel( "Coloris disponibles : ");
        color.setLocation(5, 5);
        color.setSize(300, 15);

        JLabel degrade = new JLabel();
        degrade.setBounds(20, 20, 600, 50);
        ImageIcon palette = new ImageIcon("images/degrade.png");
        degrade.setIcon(palette);
        degrade.setVisible(true);

        JLabel mat = new JLabel("                          Choix des matériaux :      METALLIQUE  ou DIFFUSIF ");
        mat.setBounds(5, 10, 700, 20);
        mat.setForeground(Color.white);
        mat.setFont(police2);

        JLabel geo = new JLabel(" Choix des objets a placer");
        geo.setBounds(350, 20, 300, 15);
        geo.setFont(police2);

        JLabel sphere = new JLabel(" Sphere. Choix du centre et du rayon. ");
        sphere.setBounds(15, 60, 280, 20);
        sphere.setForeground(Color.black);

        JLabel sphereIcon = new JLabel();
        sphereIcon.setBounds(40, 70, 250, 250);
        ImageIcon sp = new ImageIcon("images/sp.gif");
        sphereIcon.setIcon(sp);

        JLabel cube = new JLabel(" Cube. Choix du centre, de l'arête.");
        cube.setBounds(320, 60, 200, 20);
        cube.setForeground(Color.black);

        JLabel cubeIcon = new JLabel();
        cubeIcon.setBounds(340, 90, 200, 250);
        ImageIcon cb = new ImageIcon("images/square2.jpg");
        cubeIcon.setIcon(cb);

        JLabel planarIcon = new JLabel();
        planarIcon.setBounds(600, 90, 400, 250);
        ImageIcon plan = new ImageIcon("images/planarSurface.png");
        planarIcon.setIcon(plan);

        JLabel plans = new JLabel(" Plan. Choix d'un point, d'un vecteur normal. ");
        plans.setBounds(630, 60, 250, 20);
        plans.setForeground(Color.black);

        JLabel brickIcon = new JLabel();
        brickIcon.setBounds(30, 165, 180, 50);
        //ImageIcon brick = new ImageIcon("images/brickwall.jpg");
        ImageIcon brick = new ImageIcon(new ImageIcon("./textures/brick.jpg").getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH));

        brickIcon.setIcon(brick);

        JLabel woodIcon = new JLabel();
        woodIcon.setBounds(220, 165, 180, 50);
        //ImageIcon wood = new ImageIcon("images/wood.jpg");
        ImageIcon wood = new ImageIcon(new ImageIcon("./textures/wood.jpg").getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH));

        woodIcon.setIcon(wood);

        JLabel glassIcon = new JLabel();
        glassIcon.setBounds(410, 165, 180, 50);
        ImageIcon glass = new ImageIcon("images/Verres.png");
        glassIcon.setIcon(glass);

        // panels

        // PANEL PRESENTATION MATERIAUX
        JPanel panelMat = new JPanel();
        panelMat.setLayout(null);
        panelMat.setBounds(380,10, 580, 260);
        panelMat.setBackground(Color.black);
        panelMat.add(metalMat);
        panelMat.add(diffuseMat);
        panelMat.add(mat);
        panelMat.add(textures);
        panelMat.add(brickIcon);
        panelMat.add(woodIcon);
        panelMat.add(glassIcon);
        panelMat.setVisible(true);

        // PANEL PRESENTATION COULEURS
        JPanel panelCol = new JPanel();
        panelCol.setLayout(null);
        panelCol.setBounds(10,280, 950, 80);
        Color blueSky= new Color(153, 100, 255);
        panelCol.setBackground(blueSky);
        panelCol.setVisible(true);
        panelCol.add(color);
        panelCol.add(degrade);


        // PANEL PRESENTATION OBJETS
        JPanel panelGeo = new JPanel();
        panelGeo.setLayout(null);
        panelGeo.setBounds(10,375, 950, 330);
        panelGeo.setBackground(Color.white);
        panelGeo.setVisible(true);
        panelGeo.add(sphere);
        panelGeo.add(cube);
        panelGeo.add(geo);
        panelGeo.add(plans);
        panelGeo.add(sphereIcon);
        panelGeo.add(cubeIcon);
        panelGeo.add(planarIcon);

        // PANEL GLOBAL
        JPanel panelGlobal = new JPanel();
        panelGlobal.setLayout(null);
        panelGlobal.setBounds(50,0, width, height);
        Color lavande = new Color(153, 153, 255);
        panelGlobal.setBackground(lavande);
        panelGlobal.setVisible(true);

        panelGlobal.add(Description);
        panelGlobal.add(panelMat);
        panelGlobal.add(panelCol);
        panelGlobal.add(panelGeo);

        this.add(panelGlobal);

        this.setVisible(true);

    }

}













