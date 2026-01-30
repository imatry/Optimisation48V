package model;


public class Optimisation {


       //DONNÉES SAISIES

    private double puissanceRadio;
    private double puissanceBatterie;
    private double puissanceRedresseur;


       //DONNÉES CALCULÉES

    private double puissanceTotaleDemandee;
    private int nombreRedresseurs;
    private double puissanceTotaleCalculee;


       //GETTERS / SETTERS

    public double getPuissanceRadio() {
        return puissanceRadio;
    }

    public void setPuissanceRadio(double puissanceRadio) {
        this.puissanceRadio = puissanceRadio;
    }

    public double getPuissanceBatterie() {
        return puissanceBatterie;
    }

    public void setPuissanceBatterie(double puissanceBatterie) {
        this.puissanceBatterie = puissanceBatterie;
    }

    public double getPuissanceRedresseur() {
        return puissanceRedresseur;
    }

    public void setPuissanceRedresseur(double puissanceRedresseur) {
        this.puissanceRedresseur = puissanceRedresseur;
    }

    public double getPuissanceTotaleDemandee() {
        return puissanceTotaleDemandee;
    }

    public void setPuissanceTotaleDemandee(double puissanceTotaleDemandee) {
        this.puissanceTotaleDemandee = puissanceTotaleDemandee;
    }

    public int getNombreRedresseurs() {
        return nombreRedresseurs;
    }

    public void setNombreRedresseurs(int nombreRedresseurs) {
        this.nombreRedresseurs = nombreRedresseurs;
    }

    public double getPuissanceTotaleCalculee() {
        return puissanceTotaleCalculee;
    }

    public void setPuissanceTotaleCalculee(double puissanceTotaleCalculee) {
        this.puissanceTotaleCalculee = puissanceTotaleCalculee;
    }
}
