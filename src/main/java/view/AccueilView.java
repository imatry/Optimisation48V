package view;

import view.components.RoundedButton;

import javax.swing.*;
import java.awt.*;

public class AccueilView extends JFrame {

    // Boutons accessibles depuis le contrôleur (MVC)
    public JButton btnAPropos;
    public JButton btnHistorique;
    public JButton btnNouvelleOptimisation;

    public AccueilView() {


        setTitle("Optimisation 48V");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


          // TITRE EN HAUT
        JLabel lblTitre = new JLabel("Application d’aide à l’optimisation des systèmes 48V Télécom", JLabel.CENTER);
        lblTitre.setFont(new Font("Segoe UI", Font.BOLD, 22));
        add(lblTitre, BorderLayout.NORTH);

        /*---ZONE CENTRALE---*/
        JPanel centrePanel = new JPanel();
        centrePanel.setLayout(new BoxLayout(centrePanel, BoxLayout.Y_AXIS));

        //Image centrale
        ImageIcon iconOriginal = new ImageIcon(getClass().getResource("/img/Bienv1.jpg"));

        // Redimensionnement de l'image pour un rendu propre
        Image imageRedimensionnee = iconOriginal.getImage().getScaledInstance(700, 440, Image.SCALE_SMOOTH);

        ImageIcon iconFinal = new ImageIcon(imageRedimensionnee);

        JLabel lblImage = new JLabel(iconFinal);
        lblImage.setAlignmentX(Component.CENTER_ALIGNMENT);



        /* Ajout des éléments au centre */
        centrePanel.add(Box.createVerticalGlue());      // espace flexible haut
        centrePanel.add(lblImage);
        centrePanel.add(Box.createVerticalStrut(20));  // espace fixe
        centrePanel.add(Box.createVerticalGlue());      // espace flexible bas
 
        add(centrePanel, BorderLayout.CENTER);

        /*---ZONE INFÉRIEURE (BOUTONS)---*/
        JPanel basPanel = new JPanel(new GridLayout(1, 3, 20, 10));
        basPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Police et taille communes pour les boutons
        Font fontBouton = new Font("Segoe UI", Font.BOLD, 13);
        Dimension tailleBouton = new Dimension(140, 28);

        /* Bouton À propos */
        btnAPropos = new RoundedButton("À propos", 12);
        btnAPropos.setFont(fontBouton);
        btnAPropos.setPreferredSize(tailleBouton);
        btnAPropos.setBackground(new Color(70, 130, 180)); // bleu doux
        btnAPropos.setForeground(Color.BLACK);
        btnAPropos.setFocusPainted(false);

        /* Bouton Historique */
        btnHistorique = new RoundedButton("Historique", 12);
        btnHistorique.setFont(fontBouton);
        btnHistorique.setPreferredSize(tailleBouton);
        btnHistorique.setBackground(new Color(46, 139, 87)); // vert
        btnHistorique.setForeground(Color.BLACK);
        btnHistorique.setFocusPainted(false);

        /* Bouton Nouvelle optimisation */
        btnNouvelleOptimisation = new RoundedButton("Nouvelle Optimisation", 12);
        btnNouvelleOptimisation.setFont(fontBouton);
        btnNouvelleOptimisation.setPreferredSize(
                new Dimension(200, 38)
        );
        btnNouvelleOptimisation.setBackground(new Color(255, 165, 0)); // orange
        btnNouvelleOptimisation.setForeground(Color.BLACK);
        btnNouvelleOptimisation.setFocusPainted(false);

        //Ajout des boutons
        basPanel.add(btnAPropos);
        basPanel.add(btnHistorique);
        basPanel.add(btnNouvelleOptimisation);

        add(basPanel, BorderLayout.SOUTH);


        setVisible(true);
    }
}
