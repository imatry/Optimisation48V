package view;

import view.components.RoundedButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class HistoriqueView extends JFrame {


    private JPanel panelListe;  // conteneur des projets
    private RoundedButton btnSupprimerTout;
    private RoundedButton btnRetour;

    // Boutons dynamiques par ligne
    private final List<RoundedButton> btnConsulterList = new ArrayList<>();
    private final List<RoundedButton> btnSupprimerList = new ArrayList<>();

    public HistoriqueView(JFrame parent) {

        setTitle("Historique des projets");
        setSize(700, 500);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        initUI();
    }



    private void initUI() {

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelPrincipal.setBackground(Color.WHITE);

        //  TITRE
        JLabel lblTitre = new JLabel("Historique des projets", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Segoe UI", Font.BOLD, 20));
        panelPrincipal.add(lblTitre, BorderLayout.NORTH);

        // LISTE SCROLLABLE DES PROJETS
        panelListe = new JPanel();
        panelListe.setLayout(new BoxLayout(panelListe, BoxLayout.Y_AXIS));
        panelListe.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(panelListe);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        //  BOUTONS BAS
        JPanel panelBas = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBas.setBackground(Color.WHITE);

        btnSupprimerTout = new RoundedButton("Supprimer tout l'historique", 12);
        btnSupprimerTout.setBackground(new Color(200, 50, 50)); // Rouge
        btnSupprimerTout.setForeground(Color.WHITE);

        btnRetour = new RoundedButton("Retour", 12);
        btnRetour.setBackground(new Color(70, 130, 180)); // Bleu doux
        btnRetour.setForeground(Color.WHITE);

        panelBas.add(btnSupprimerTout);
        panelBas.add(btnRetour);

        panelPrincipal.add(panelBas, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);
    }


    public void ajouterProjet(String nomProjet, String date) {

        JPanel panelProjet = new JPanel(new BorderLayout());
        panelProjet.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        panelProjet.setBackground(Color.WHITE);


        JLabel lblInfo = new JLabel(
                "<html><b>" + nomProjet + "</b><br/>Date : " + date + "</html>"
        );
        lblInfo.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        // Panel des actions (boutons)
        JPanel panelActions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelActions.setBackground(Color.WHITE);

        // Bouton Consulter PDF (bleu)
        RoundedButton btnConsulter = new RoundedButton("Consulter PDF", 12);
        btnConsulter.setBackground(new Color(70, 130, 180)); // Bleu
        btnConsulter.setForeground(Color.WHITE);

        // Bouton Supprimer (rouge)
        RoundedButton btnSupprimer = new RoundedButton("Supprimer", 12);
        btnSupprimer.setBackground(new Color(200, 50, 50)); // Rouge
        btnSupprimer.setForeground(Color.WHITE);


        btnConsulterList.add(btnConsulter);
        btnSupprimerList.add(btnSupprimer);


        panelActions.add(btnConsulter);
        panelActions.add(btnSupprimer);

        panelProjet.add(lblInfo, BorderLayout.CENTER);
        panelProjet.add(panelActions, BorderLayout.SOUTH);


        panelListe.add(panelProjet);
        panelListe.add(Box.createVerticalStrut(8));


        revalidate();
        repaint();
    }



    public RoundedButton getBtnRetour() {
        return btnRetour;
    }

    public RoundedButton getBtnSupprimerTout() {
        return btnSupprimerTout;
    }

    public RoundedButton getBtnConsulter(int index) {
        return btnConsulterList.get(index);
    }

    public RoundedButton getBtnSupprimer(int index) {
        return btnSupprimerList.get(index);
    }

    public int getNombreLignes() {
        return btnConsulterList.size();
    }
}
