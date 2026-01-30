package controller;

import model.Historique;
import model.ProjetHistorique;
import view.HistoriqueView;

import javax.swing.*;
import java.awt.*;
import java.io.File;


public class HistoriqueController {

    private HistoriqueView view;
    private Historique historique;


    public HistoriqueController(JFrame parent) {

        // Récupération du modèle (Singleton)
        historique = Historique.getInstance();

        // Création de la vue
        view = new HistoriqueView(parent);

        // Chargement des données dans la vue
        chargerVue();

        // Connexion des actions
        initController();

        // Affichage
        view.setVisible(true);
    }


    private void chargerVue() {

        for (ProjetHistorique projet : historique.getProjets()) {
            view.ajouterProjet(
                    projet.getNomProjet(),
                    projet.getDateFormatee()
            );
        }
    }


    private void initController() {


        view.getBtnRetour().addActionListener(e -> view.dispose());


        view.getBtnSupprimerTout().addActionListener(e -> supprimerTout());


        for (int i = 0; i < view.getNombreLignes(); i++) {

            final int index = i;

            view.getBtnConsulter(index)
                    .addActionListener(e -> ouvrirPdf(index));

            view.getBtnSupprimer(index)
                    .addActionListener(e -> supprimerProjet(index));
        }
    }


    private void ouvrirPdf(int index) {

        try {
            File pdf = new File(
                    historique.getProjets().get(index).getCheminPdf()
            );

            if (!pdf.exists()) {
                JOptionPane.showMessageDialog(
                        view,
                        "Fichier PDF introuvable.",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            Desktop.getDesktop().open(pdf);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    view,
                    "Impossible d’ouvrir le PDF.",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    private void supprimerProjet(int index) {

        if (JOptionPane.showConfirmDialog(
                view,
                "Supprimer ce projet ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION
        ) == JOptionPane.YES_OPTION) {

            historique.supprimerProjet(index);


            view.dispose();
            new HistoriqueController(null);
        }
    }


    private void supprimerTout() {

        if (JOptionPane.showConfirmDialog(
                view,
                "Supprimer tout l’historique ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION
        ) == JOptionPane.YES_OPTION) {

            historique.supprimerTout();


            view.dispose();
            new HistoriqueController(null);
        }
    }
}
