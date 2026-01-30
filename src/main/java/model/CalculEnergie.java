package model;


public class CalculEnergie {

    private static final int[] REDRESSEURS_AUTORISES = {3, 5, 6, 8, 9};

    public void calculer(Optimisation optimisation) {

        // --- Données utilisateur ---
        double radio = optimisation.getPuissanceRadio();
        double batterie = optimisation.getPuissanceBatterie();
        double puissanceRedresseur = optimisation.getPuissanceRedresseur();

        // --- Puissance demandée ---
        double puissanceDemandee = radio + batterie;
        optimisation.setPuissanceTotaleDemandee(puissanceDemandee);

        int nombreChoisi = -1;
        double puissanceFournie = 0;

        // --- Optimisation ---
        for (int n : REDRESSEURS_AUTORISES) {

            double puissancePossible = n * puissanceRedresseur;

            if (puissancePossible >= puissanceDemandee) {
                nombreChoisi = n;
                puissanceFournie = puissancePossible;
                break;
            }
        }

        if (nombreChoisi == -1) {
            throw new IllegalStateException(
                    "Puissance demandée trop élevée pour cette configuration."
            );
        }

        optimisation.setNombreRedresseurs(nombreChoisi);
        optimisation.setPuissanceTotaleCalculee(puissanceFournie);
    }
}
