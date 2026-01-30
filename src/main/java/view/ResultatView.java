package view;

import view.components.RoundedButton;

import javax.swing.*;
import java.awt.*;

public class ResultatView extends JFrame {


       // COMPOSANTS – RÉCAPITULATIF


    private JLabel lblRadioValue;
    private JLabel lblBatterieValue;
    private JLabel lblRedresseurValue;


    private JPanel recapPanel;

       //COMPOSANTS – RÉSULTATS
    private JLabel lblPuissanceDemandee;
    private JLabel lblNombreRedresseurs;
    private JTextArea txtExplication;


    private JPanel resultPanel;


       // BOUTONS


    private RoundedButton btnValider;
    private RoundedButton btnRetour;
    private RoundedButton btnExporterPDF;


      // CONSTRUCTEUR


    public ResultatView() {

        setTitle("Optimisation 48V");
        setSize(820, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        initComponents();
        layoutComponents();
    }


       // INITIALISATION DES COMPOSANTS

    private void initComponents() {

        Font normal = new Font("Segoe UI", Font.PLAIN, 14);
        Font bold   = new Font("Segoe UI", Font.BOLD, 14);

        // --------- Récapitulatif ----------
        lblRadioValue = new JLabel("— kW");
        lblBatterieValue = new JLabel("— kW");
        lblRedresseurValue = new JLabel("—");

        // --------- Résultats ----------
        lblPuissanceDemandee = new JLabel("— kW");
        lblPuissanceDemandee.setFont(bold);

        lblNombreRedresseurs = new JLabel("— redresseurs");
        lblNombreRedresseurs.setFont(bold);

        txtExplication = new JTextArea(4, 50);
        txtExplication.setFont(normal);
        txtExplication.setEditable(false);
        txtExplication.setLineWrap(true);
        txtExplication.setWrapStyleWord(true);
        txtExplication.setBackground(new Color(245, 247, 250));
        txtExplication.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        // --------- Boutons ----------
        btnValider = new RoundedButton("Valider", 14);
        btnValider.setBackground(new Color(70, 130, 180));
        btnValider.setForeground(Color.WHITE);

        btnRetour = new RoundedButton("Retour", 14);
        btnRetour.setBackground(new Color(46, 139, 87));
        btnRetour.setForeground(Color.WHITE);

        btnExporterPDF = new RoundedButton("Exporter PDF", 14);
        btnExporterPDF.setBackground(new Color(255, 165, 0));
        btnExporterPDF.setForeground(Color.BLACK);
    }


       //ORGANISATION GLOBALE DE LA FENÊTRE

    private void layoutComponents() {

        Color bg = new Color(245, 247, 250);

        JPanel main = new JPanel(new BorderLayout(15, 15));
        main.setBackground(bg);
        main.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));

        // --------- Titre ----------
        JLabel titre = new JLabel("RÉCAPITULATIF ET RÉSULTATS", JLabel.CENTER);
        titre.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titre.setForeground(new Color(33, 150, 243));
        main.add(titre, BorderLayout.NORTH);

        // --------- Centre ----------
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBackground(bg);

        center.add(createRecapPanel());
        center.add(Box.createVerticalStrut(10));

        JPanel validatePanel = new JPanel();
        validatePanel.setBackground(bg);
        validatePanel.add(btnValider);
        center.add(validatePanel);

        center.add(Box.createVerticalStrut(15));
        center.add(createResultPanel());

        main.add(center, BorderLayout.CENTER);
        main.add(createBottomPanel(), BorderLayout.SOUTH);

        setContentPane(main);
    }


       // PANEL RÉCAPITULATIF (TAILLE FIXE)

    private JPanel createRecapPanel() {

        recapPanel = new JPanel(new GridLayout(3, 2, 15, 8));
        recapPanel.setBackground(Color.WHITE);
        recapPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(33, 150, 243)),
                "Récapitulatif des données saisies"
        ));

        recapPanel.add(new JLabel("Puissance radio :"));
        recapPanel.add(lblRadioValue);

        recapPanel.add(new JLabel("Puissance batterie :"));
        recapPanel.add(lblBatterieValue);

        recapPanel.add(new JLabel("Redresseur choisi :"));
        recapPanel.add(lblRedresseurValue);


        Dimension fixedSize = new Dimension(740, 120);
        recapPanel.setPreferredSize(fixedSize);
        recapPanel.setMinimumSize(fixedSize);
        recapPanel.setMaximumSize(fixedSize);

        return recapPanel;
    }


    private JPanel createResultPanel() {

        resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        resultPanel.setBackground(Color.WHITE);
        resultPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(76, 175, 80)),
                "Résultat de l’optimisation"
        ));

        resultPanel.add(lblPuissanceDemandee);
        resultPanel.add(Box.createVerticalStrut(5));
        resultPanel.add(lblNombreRedresseurs);
        resultPanel.add(Box.createVerticalStrut(10));
        resultPanel.add(txtExplication);

        // Caché tant que Valider n’est pas cliqué
        resultPanel.setVisible(false);

        return resultPanel;
    }


       //PANEL BAS (BOUTONS)

    private JPanel createBottomPanel() {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(245, 247, 250));

        panel.add(btnRetour, BorderLayout.WEST);
        panel.add(btnExporterPDF, BorderLayout.EAST);

        return panel;
    }

       // GETTERS (POUR LE CONTROLLER)


    public JLabel getLblRadioValue() { return lblRadioValue; }
    public JLabel getLblBatterieValue() { return lblBatterieValue; }
    public JLabel getLblRedresseurValue() { return lblRedresseurValue; }

    public JLabel getLblPuissanceDemandee() { return lblPuissanceDemandee; }
    public JLabel getLblNombreRedresseurs() { return lblNombreRedresseurs; }
    public JTextArea getTxtExplication() { return txtExplication; }

    public JPanel getResultPanel() { return resultPanel; }

    public RoundedButton getBtnValider() { return btnValider; }
    public RoundedButton getBtnRetour() { return btnRetour; }
    public RoundedButton getBtnExporterPDF() { return btnExporterPDF; }
}
