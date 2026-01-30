package view;

import view.components.RoundedButton;
import view.components.RoundedTextField;

import javax.swing.*;
import java.awt.*;


public class PdfView extends JDialog {

       //COMPOSANTS

    private RoundedTextField txtNomProjet;

    private JLabel lblRadio;
    private JLabel lblBatterie;
    private JLabel lblRedresseur;
    private JLabel lblPuissanceTotale;
    private JLabel lblNombreRedresseurs;

    private RoundedButton btnRetour;
    private RoundedButton btnEnregistrer;

    public PdfView(JFrame parent) {
        super(parent, "Export du résultat", true);
        setSize(700, 520);
        setLocationRelativeTo(parent);
        setResizable(false);
        initComponents();
    }

    private void initComponents() {

       //Styles
        Font titleFont   = new Font("Segoe UI", Font.BOLD, 20);
        Font sectionFont = new Font("Segoe UI", Font.BOLD, 14);
        Font textFont    = new Font("Segoe UI", Font.PLAIN, 13);

        Color bg = new Color(245, 247, 250);

        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBackground(bg);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));


           //HEADER

        JLabel lblTitre = new JLabel(
                "APPLICATION D’AIDE À L’OPTIMISATION DES SYSTÈMES 48V TELECOM"
        );
        lblTitre.setFont(titleFont);
        lblTitre.setHorizontalAlignment(SwingConstants.CENTER);

        mainPanel.add(lblTitre, BorderLayout.NORTH);


           //CONTENU CENTRAL

        JPanel content = new JPanel();
        content.setBackground(bg);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

         //Nom du projet
        JLabel lblProjet = new JLabel("Nom du projet :");
        lblProjet.setFont(sectionFont);

        txtNomProjet = new RoundedTextField(20);
        txtNomProjet.setMaximumSize(new Dimension(300, 34));

        content.add(lblProjet);
        content.add(Box.createVerticalStrut(6));
        content.add(txtNomProjet);
        content.add(Box.createVerticalStrut(25));

        /* ---------- Section Récap ---------- */
        JLabel lblRecap = new JLabel("Récapitulatif");
        lblRecap.setFont(sectionFont);
        lblRecap.setBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY)
        );

        content.add(lblRecap);
        content.add(Box.createVerticalStrut(12));

        lblRadio = new JLabel();
        lblBatterie = new JLabel();
        lblRedresseur = new JLabel();

        setFont(textFont, lblRadio, lblBatterie, lblRedresseur);

        content.add(lblRadio);
        content.add(lblBatterie);
        content.add(lblRedresseur);
        content.add(Box.createVerticalStrut(25));

        /* ---------- Section Résultat ---------- */
        JLabel lblResult = new JLabel("Résultat de l’optimisation");
        lblResult.setFont(sectionFont);
        lblResult.setBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY)
        );

        content.add(lblResult);
        content.add(Box.createVerticalStrut(12));

        lblPuissanceTotale = new JLabel();
        lblNombreRedresseurs = new JLabel();

        setFont(textFont, lblPuissanceTotale, lblNombreRedresseurs);

        content.add(lblPuissanceTotale);
        content.add(lblNombreRedresseurs);

        JScrollPane scrollPane = new JScrollPane(content);
        scrollPane.setBorder(null);

        mainPanel.add(scrollPane, BorderLayout.CENTER);


         //BOUTONS

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 5));
        btnPanel.setBackground(bg);

        btnRetour = new RoundedButton("Annuler", 12);
        btnEnregistrer = new RoundedButton("Enregistrer", 12);

        btnRetour.setBackground(new Color(46, 139, 87));
        btnRetour.setForeground(Color.WHITE);

        btnEnregistrer.setBackground(new Color(255, 165, 0));
        btnEnregistrer.setForeground(Color.BLACK);

        btnPanel.add(btnRetour);
        btnPanel.add(btnEnregistrer);

        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }


      //TILITAIRE

    private void setFont(Font font, JLabel... labels) {
        for (JLabel lbl : labels) {
            lbl.setFont(font);
        }
    }


       //GETTERS (MVC STRICT)

    public RoundedTextField getTxtNomProjet() {
        return txtNomProjet;
    }

    public RoundedButton getBtnRetour() {
        return btnRetour;
    }

    public RoundedButton getBtnEnregistrer() {
        return btnEnregistrer;
    }

    public JLabel getLblRadio() {
        return lblRadio;
    }

    public JLabel getLblBatterie() {
        return lblBatterie;
    }

    public JLabel getLblRedresseur() {
        return lblRedresseur;
    }

    public JLabel getLblPuissanceTotale() {
        return lblPuissanceTotale;
    }

    public JLabel getLblNombreRedresseurs() {
        return lblNombreRedresseurs;
    }
}
