package controller;

import view.CalculView;
import view.ResultatView;
import view.AccueilView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculController {


    // Attribut
    private CalculView view;


    // Constructeur
    public CalculController(CalculView view) {
        this.view = view;
        initController();
    }


    // Initialisation des actions

    private void initController() {

        /* ===== Bouton Actualiser ===== */
        view.getBtnActualiser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualiserCalcul();
            }
        });

        /* ===== Bouton Enregistrer ===== */
        view.getBtnEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enregistrer();
            }
        });

        /* ===== Bouton Retour ===== */
        view.getBtnRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retourAccueil();
            }
        });
    }


    // Actions métier



    private void actualiserCalcul() {
        JOptionPane.showMessageDialog(
                view,
                "Actualisation des données...\n(Le calcul sera ajouté plus tard)",
                "Information",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


    private void enregistrer() {

        // Création de la vue Résultat
        ResultatView resultatView = new ResultatView();

        // Création du contrôleur Résultat
        new ResultatController(view, resultatView);

        // Navigation
        view.setVisible(false);
        resultatView.setVisible(true);
    }


    private void retourAccueil() {

        // Ferme la vue actuelle
        view.dispose();

        // Recrée l'accueil (MVC strict)
        new AccueilController();
    }
}
