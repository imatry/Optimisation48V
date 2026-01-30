package view;

import view.components.RoundedButton;

import javax.swing.*;
import java.awt.*;


public class AproposView extends JFrame {

    private RoundedButton btnFermer;
    private JLabel lblEmail;

    public AproposView(JFrame parent) {

        setTitle("À propos");
        setSize(600, 450);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        initComponents();
        layoutComponents();
    }


    private void initComponents() {

        btnFermer = new RoundedButton("Fermer", 12);
        btnFermer.setBackground(new Color(46, 139, 87)); // Vert
        btnFermer.setForeground(Color.WHITE);

        lblEmail = new JLabel(
                "<html><a href=''>bi62168@gmail.com</a></html>"
        );
        lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblEmail.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }


    private void layoutComponents() {

        Color bg = new Color(245, 247, 250);

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(bg);
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(20, 25, 20, 25)
        );


        JLabel lblTitre = new JLabel("À propos de l'application", JLabel.CENTER);
        lblTitre.setFont(new Font("Segoe UI", Font.BOLD, 20));

        mainPanel.add(lblTitre, BorderLayout.NORTH);


        JPanel content = new JPanel();
        content.setBackground(bg);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        JLabel lblDescription = new JLabel(
                "<html><p style='width:500px;'>"
                        + "<b>Optimisation 48V</b> est une application "
                        + "d’aide au dimensionnement des systèmes "
                        + "d’alimentation 48V utilisés en télécoms.<br><br>"
                        + "Elle permet de calculer la puissance totale, "
                        + "le nombre de redresseurs et de générer "
                        + "un rapport PDF professionnel."
                        + "</p></html>"
        );
        lblDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel lblAuteur = new JLabel("<html><br><b>Auteur :</b> KB24</html>");
        lblAuteur.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        content.add(lblDescription);
        content.add(lblAuteur);
        content.add(lblEmail);

        JScrollPane scrollPane = new JScrollPane(content);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        mainPanel.add(scrollPane, BorderLayout.CENTER);


        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.setBackground(bg);
        bottom.add(btnFermer);

        mainPanel.add(bottom, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    public RoundedButton getBtnFermer() {
        return btnFermer;
    }

    public JLabel getLblEmail() {
        return lblEmail;
    }
}
