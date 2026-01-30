package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProjetHistorique implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nomProjet;
    private LocalDateTime dateCreation;
    private String cheminPdf;

    public ProjetHistorique(String nomProjet, String cheminPdf) {
        this.nomProjet = nomProjet;
        this.cheminPdf = cheminPdf;
        this.dateCreation = LocalDateTime.now();
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public String getCheminPdf() {
        return cheminPdf;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }


    public String getDateFormatee() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dateCreation.format(formatter);
    }
}
