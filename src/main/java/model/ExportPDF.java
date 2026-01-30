package model;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ExportPDF {


    public static void genererPdf(
            Optimisation optimisation,
            String nomProjet,
            File fichier
    ) throws Exception {

        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        PdfWriter.getInstance(document, new FileOutputStream(fichier));
        document.open();

        Font titre = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
        Font section = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD);
        Font texte = new Font(Font.FontFamily.HELVETICA, 11);

        Paragraph header = new Paragraph(
                "APPLICATION D’AIDE À L’OPTIMISATION\nDES SYSTÈMES 48V TELECOM",
                titre
        );
        header.setAlignment(Element.ALIGN_CENTER);
        document.add(header);

        document.add(new Paragraph(" "));
        document.add(new Paragraph("Nom du projet : " + nomProjet, texte));

        String dateStr = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        document.add(new Paragraph("Date : " + dateStr, texte));

        document.add(new Paragraph(" "));
        document.add(new Paragraph("RÉCAPITULATIF", section));
        document.add(new Paragraph(" "));

        document.add(new Paragraph(
                "Puissance radio : " + optimisation.getPuissanceRadio() + " kW", texte));
        document.add(new Paragraph(
                "Puissance batterie : " + optimisation.getPuissanceBatterie() + " kW", texte));
        document.add(new Paragraph(
                "Puissance redresseur : " + optimisation.getPuissanceRedresseur() + " kW", texte));

        document.add(new Paragraph(" "));
        document.add(new Paragraph("RÉSULTATS", section));
        document.add(new Paragraph(" "));

        document.add(new Paragraph(
                "Puissance totale calculée : "
                        + optimisation.getPuissanceTotaleCalculee() + " kW",
                texte
        ));

        document.add(new Paragraph(
                "Nombre de redresseurs : "
                        + optimisation.getNombreRedresseurs(),
                texte
        ));

        document.close();


        ProjetHistorique projet = new ProjetHistorique(
                nomProjet,
                fichier.getAbsolutePath()
        );

        Historique.getInstance().ajouterProjet(projet);
    }
}
