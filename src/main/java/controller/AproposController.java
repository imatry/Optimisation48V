package controller;

import view.AproposView;

import java.awt.Desktop;
import java.net.URI;

public class AproposController {

    private AproposView view;

    public AproposController(AproposView view) {
        this.view = view;
        initController();
    }


    private void initController() {

        // Bouton Fermer
        view.getBtnFermer().addActionListener(e -> view.dispose());

        // Clic sur l'email
        view.getLblEmail().addMouseListener(
                new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        ouvrirClientMail();
                    }
                }
        );
    }

    private void ouvrirClientMail() {
        try {
            Desktop.getDesktop().mail(
                    new URI("mailto:bi62168@gmail.com")
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
