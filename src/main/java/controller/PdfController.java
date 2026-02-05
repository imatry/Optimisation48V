package controller;

import model.ExportPDF;
import model.Optimisation;
import controller.AccueilController;
import view.PdfView;

import javax.swing.*;
import java.io.File;


public class PdfController {

    private final PdfView view;
    private final Optimisation optimisation;

    public PdfController(JFrame parent, Optimisation optimisation) {
        this.optimisation = optimisation;
        this.view = new PdfView(parent);

        remplirDonnees();
        initActions();

        view.setVisible(true);
    }

    private void remplirDonnees() {

        view.getLblRadio().setText(
                "Puissance radio : " + optimisation.getPuissanceRadio() + " kW");

        view.getLblBatterie().setText(
                "Puissance batterie : " + optimisation.getPuissanceBatterie() + " kW");

        view.getLblRedresseur().setText(
                "Redresseur choisi : " + optimisation.getPuissanceRedresseur() + " kW");

        view.getLblPuissanceTotale().setText(
                "Puissance totale calculée : "
                        + optimisation.getPuissanceTotaleCalculee() + " kW");

        view.getLblNombreRedresseurs().setText(
                "Nombre de redresseurs : "
                        + optimisation.getNombreRedresseurs());
    }

    private void initActions() {

        view.getBtnRetour().addActionListener(e -> view.dispose());

        view.getBtnEnregistrer().addActionListener(e -> {

            String nomProjet = view.getTxtNomProjet().getText().trim();

            if (nomProjet.isEmpty()) {
                JOptionPane.showMessageDialog(
                        view,
                        "Veuillez saisir le nom du projet.",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(new File(nomProjet + ".pdf"));

            if (chooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {

                File fichier = chooser.getSelectedFile();

                if (!fichier.getName().toLowerCase().endsWith(".pdf")) {
                    fichier = new File(fichier.getAbsolutePath() + ".pdf");
                }

                try {
                    ExportPDF.genererPdf(optimisation, nomProjet, fichier);

                    JOptionPane.showMessageDialog(
                            view,
                            "PDF généré avec succès.",
                            "Succès",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    view.dispose();
                    // Redirection vers la page d'accueil
                    new AccueilController(); // <-- Ajout ici

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            view,
                            "Erreur lors de la génération du PDF.",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }
}
