package view.components;

import javax.swing.*;
import java.awt.*;


public class RoundedTextField extends JTextField {

    private int radius; // Rayon des coins arrondis


    public RoundedTextField(int radius) {
        super();
        this.radius = radius;

        // Police uniforme
        setFont(new Font("Segoe UI", Font.PLAIN, 14));

        // Taille par défaut
        setPreferredSize(new Dimension(220, 32));

        // Couleurs
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);

        // Supprimer la bordure Swing par défaut
        setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));

        // Important pour le rendu personnalisé
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        // Fond
        g2.setColor(getBackground());
        g2.fillRoundRect(
                0,
                0,
                getWidth(),
                getHeight(),
                radius,
                radius
        );

        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        // Bordure douce
        g2.setColor(new Color(180, 180, 180));
        g2.drawRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                radius,
                radius
        );

        g2.dispose();
    }
}
