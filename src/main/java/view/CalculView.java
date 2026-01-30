package view;

import view.components.RoundedButton;
import view.components.RoundedTextField;

import javax.swing.*;
import java.awt.*;

public class CalculView extends JFrame {


    // Composants graphiques

    private RoundedTextField txtPuissanceRadio;
    private RoundedTextField txtPuissanceBatterie;
    private JComboBox<String> comboRedresseur;

    private RoundedButton btnActualiser;
    private RoundedButton btnRetour;
    private RoundedButton btnEnregistrer;

    private JLabel lblTitre;

    // Constructeur


    public CalculView() {

        setTitle("Optimisation 48V");
        setSize(700, 480);
        setLocationRelativeTo(null);            // Centre la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        initComponents();   // Création des composants
        layoutComponents(); // Placement graphique
    }


    // Initialisation des composants

    private void initComponents() {

        Font fontCombo = new Font("Segoe UI", Font.PLAIN, 14);

        //Titre
        lblTitre = new JLabel(
                "Entré vos données!",
                JLabel.CENTER
        );
        lblTitre.setFont(new Font("Segoe UI", Font.BOLD, 20));

        //Champs de saisie arrondis
        txtPuissanceRadio = new RoundedTextField(15);
        txtPuissanceBatterie = new RoundedTextField(15);

       //ComboBox
        comboRedresseur = new JComboBox<>();
        comboRedresseur.setFont(fontCombo);
        comboRedresseur.addItem("2.5 kW");
        comboRedresseur.addItem("3 kW");
        comboRedresseur.addItem("3.5 kW");
        comboRedresseur.addItem("4 kW");

       //Boutons
        btnActualiser = new RoundedButton("Actualiser", 12);
        btnRetour = new RoundedButton("Retour", 12);
        btnEnregistrer = new RoundedButton("Enregistrer", 12);

        // Couleurs cohérentes avec l'accueil
        btnActualiser.setBackground(new Color(70, 130, 180)); // Bleu
        btnActualiser.setForeground(Color.WHITE);

        btnRetour.setBackground(new Color(46, 139, 87));      // Vert
        btnRetour.setForeground(Color.WHITE);

        btnEnregistrer.setBackground(new Color(255, 165, 0)); // Orange
        btnEnregistrer.setForeground(Color.BLACK);
    }


    // Organisation graphique

    private void layoutComponents() {

        // Couleur de fond personnalisée (meilleure que le gris Swing)
        Color backgroundColor = new Color(245, 247, 250);

        //Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBackground(backgroundColor);
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 25, 20, 25)
        );


           //ZONE NORD : TITRE

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(backgroundColor);
        titlePanel.add(lblTitre, BorderLayout.CENTER);


         //ZONE CENTRALE COMPOSITE  (Actualiser + Formulaire)

        JPanel centerPanel = new JPanel(new BorderLayout(15, 15));
        centerPanel.setBackground(backgroundColor);

        /* --- Bouton Actualiser --- */
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(backgroundColor);
        topPanel.add(btnActualiser);

        /* --- Formulaire --- */
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(backgroundColor);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(14, 12, 14, 12);
        gbc.anchor = GridBagConstraints.WEST;

        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);

        // Ligne 1 : Puissance radio
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lblRadio = new JLabel("Puissance radio (kW)");
        lblRadio.setFont(labelFont);
        formPanel.add(lblRadio, gbc);

        gbc.gridx = 1;
        formPanel.add(txtPuissanceRadio, gbc);

        // Ligne 2 : Puissance batterie
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblBatterie = new JLabel("Puissance batterie (kW)");
        lblBatterie.setFont(labelFont);
        formPanel.add(lblBatterie, gbc);

        gbc.gridx = 1;
        formPanel.add(txtPuissanceBatterie, gbc);

        // Ligne 3 : Redresseur
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblRedresseur = new JLabel("Puissance du redresseur (kW)");
        lblRedresseur.setFont(labelFont);
        formPanel.add(lblRedresseur, gbc);

        gbc.gridx = 1;
        formPanel.add(comboRedresseur, gbc);

        // Assemblage centre
        centerPanel.add(topPanel, BorderLayout.NORTH);
        centerPanel.add(formPanel, BorderLayout.CENTER);


          // ZONE SUD : NAVIGATION

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(backgroundColor);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(backgroundColor);
        leftPanel.add(btnRetour);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(backgroundColor);
        rightPanel.add(btnEnregistrer);

        bottomPanel.add(leftPanel, BorderLayout.WEST);
        bottomPanel.add(rightPanel, BorderLayout.EAST);


          // ASSEMBLAGE FINAL

        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }


    // Getters (pour le Controller)


    public RoundedTextField getTxtPuissanceRadio() {
        return txtPuissanceRadio;
    }

    public RoundedTextField getTxtPuissanceBatterie() {
        return txtPuissanceBatterie;
    }

    public JComboBox<String> getComboRedresseur() {
        return comboRedresseur;
    }

    public RoundedButton getBtnActualiser() {
        return btnActualiser;
    }

    public RoundedButton getBtnRetour() {
        return btnRetour;
    }

    public RoundedButton getBtnEnregistrer() {
        return btnEnregistrer;
    }
}





















