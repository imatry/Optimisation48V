package controller;

import view.AccueilView;
import view.CalculView;
import view.AproposView;


public class AccueilController {

    private AccueilView view;

    public AccueilController() {

        // Création de la vue d'accueil
        view = new AccueilView();

        // Liaison des boutons
        initController();

        // Affichage de la vue
        view.setVisible(true);
    }


    private void initController() {

        view.btnNouvelleOptimisation.addActionListener(e -> ouvrirCalcul());


        view.btnAPropos.addActionListener(e -> ouvrirApropos());


        view.btnHistorique.addActionListener(e -> ouvrirHistorique());
    }


    private void ouvrirCalcul() {

        view.dispose(); // ferme l'accueil

        CalculView calculView = new CalculView();
        new CalculController(calculView);
        calculView.setVisible(true);
    }


    private void ouvrirApropos() {

        AproposView aproposView = new AproposView(view);
        new AproposController(aproposView);
        aproposView.setVisible(true);
    }


    private void ouvrirHistorique() {

        // On ouvre simplement le contrôleur Historique
        new HistoriqueController(view);
    }
}
