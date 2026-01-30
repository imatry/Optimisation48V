package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Historique {

    private static Historique instance;
    private List<ProjetHistorique> projets;

    private static final String FICHIER_HISTORIQUE = "historique.dat";


    private Historique() {
        projets = new ArrayList<>();
        charger();
    }


    public static Historique getInstance() {
        if (instance == null) {
            instance = new Historique();
        }
        return instance;
    }


    public void ajouterProjet(ProjetHistorique projet) {
        projets.add(projet);
        sauvegarder();
    }

    public void supprimerProjet(int index) {
        if (index >= 0 && index < projets.size()) {
            projets.remove(index);
            sauvegarder();
        }
    }

    public void supprimerTout() {
        projets.clear();
        sauvegarder();
    }

    public List<ProjetHistorique> getProjets() {
        return projets;
    }



    private void sauvegarder() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             new FileOutputStream(FICHIER_HISTORIQUE))) {

            oos.writeObject(projets);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void charger() {
        File fichier = new File(FICHIER_HISTORIQUE);
        if (!fichier.exists()) return;

        try (ObjectInputStream ois =
                     new ObjectInputStream(
                             new FileInputStream(fichier))) {

            projets = (List<ProjetHistorique>) ois.readObject();

        } catch (Exception e) {
            projets = new ArrayList<>();
        }
    }
}
