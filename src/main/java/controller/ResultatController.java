package controller;

import model.CalculEnergie;
import model.Optimisation;
import view.CalculView;
import view.ResultatView;

import javax.swing.*;


public class ResultatController {

    private final CalculView calculView;
    private final ResultatView resultatView;
    private final Optimisation optimisation;
    private final CalculEnergie calculEnergie;


    public ResultatController(CalculView calculView, ResultatView resultatView) {

        this.calculView = calculView;
        this.resultatView = resultatView;

        this.optimisation = new Optimisation();
        this.calculEnergie = new CalculEnergie();

        // Le panel résultat est caché au départ
        resultatView.getResultPanel().setVisible(false);

        initActions();
        remplirRecapitulatif();
    }


    private void initActions() {

        // Bouton VALIDER → lancer le calcul
        resultatView.getBtnValider()
                .addActionListener(e -> lancerOptimisation());

        // Bouton RETOUR → revenir à la saisie
        resultatView.getBtnRetour()
                .addActionListener(e -> {
                    resultatView.dispose();
                    calculView.setVisible(true);
                });

        // Bouton EXPORT PDF → ouvrir la prévisualisation
        resultatView.getBtnExporterPDF()
                .addActionListener(e -> {

                    // Ouvre la fenêtre PDF
                    new PdfController(resultatView, optimisation);

                    // FERME la fenêtre résultat
                    resultatView.dispose();
                });
    }


    private void remplirRecapitulatif() {

        resultatView.getLblRadioValue()
                .setText(calculView.getTxtPuissanceRadio().getText() + " kW");

        resultatView.getLblBatterieValue()
                .setText(calculView.getTxtPuissanceBatterie().getText() + " kW");

        resultatView.getLblRedresseurValue()
                .setText(calculView.getComboRedresseur().getSelectedItem().toString());
    }


    private void lancerOptimisation() {

        try {
            // --- Lecture sécurisée des champs ---
            double radio = Double.parseDouble(
                    calculView.getTxtPuissanceRadio().getText().trim()
            );
            double batterie = Double.parseDouble(
                    calculView.getTxtPuissanceBatterie().getText().trim()
            );
            double redresseur = Double.parseDouble(
                    calculView.getComboRedresseur()
                            .getSelectedItem()
                            .toString()
                            .replace(" kW", "")
            );

            // --- Mise à jour du modèle ---
            optimisation.setPuissanceRadio(radio);
            optimisation.setPuissanceBatterie(batterie);
            optimisation.setPuissanceRedresseur(redresseur);

            // --- Calcul métier ---
            calculEnergie.calculer(optimisation);

            // --- Affichage ---
            afficherResultats();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    resultatView,
                    "Erreur de saisie ou de calcul.",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    private void afficherResultats() {

        resultatView.getLblPuissanceDemandee()
                .setText(
                        optimisation.getPuissanceTotaleDemandee() + " kW"
                );

        resultatView.getLblNombreRedresseurs()
                .setText(
                        optimisation.getNombreRedresseurs() + " redresseurs"
                );

        resultatView.getTxtExplication().setText(
                "Avec des redresseurs de "
                        + optimisation.getPuissanceRedresseur()
                        + " kW, le système nécessite "
                        + optimisation.getNombreRedresseurs()
                        + " unités pour fournir "
                        + optimisation.getPuissanceTotaleCalculee()
                        + " kW."
        );

        // Affichage effectif du panel résultat
        resultatView.getResultPanel().setVisible(true);
        resultatView.revalidate();
        resultatView.repaint();
    }
}
