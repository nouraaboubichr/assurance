package ma.ens.assurance;

import ma.ens.assurance.entities.Assurance;
import ma.ens.assurance.entities.Client;
import ma.ens.assurance.entities.Contrat;
import ma.ens.assurance.entities.StatutContrat;
import ma.ens.assurance.services.AssuranceService;
import ma.ens.assurance.services.ClientService;
import ma.ens.assurance.services.ContratService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {

    private static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");

    private static Date d(String s) {
        try {
            return F.parse(s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static void afficher(List<Contrat> contrats) {
        if (contrats.isEmpty()) {
            System.out.println("  (aucun contrat)");
            return;
        }
        System.out.printf(
                "Id", "Client", "Assurance", "Début", "Fin", "Statut");
        for (Contrat c : contrats) {
            System.out.printf("  %-4d%-22s%-14s%-12s%-12s%-10s%n",
                    c.getId(),
                    c.getClient().getNom() + " " + c.getClient().getPrenom(),
                    c.getAssurance().getType(),
                    F.format(c.getDateDebut()),
                    F.format(c.getDateFin()),
                    c.getStatut());
        }
    }

    public static void main(String[] args) {

        ClientService cs = new ClientService();
        AssuranceService as = new AssuranceService();
        ContratService cos = new ContratService();


        Client c1 = new Client("EE123456", "ALAMI", "Karim", "karim@mail.ma", "0661000001");
        Client c2 = new Client("AB654321", "BENNANI", "Sara", "sara@mail.ma", "0661000002");
        Client c3 = new Client("CD111222", "TAZI", "Omar", "omar@mail.ma", "0661000003");
        Client c4 = new Client("Hg13425524", "ABOUBICHR", "NOURA", "noura@mail.ma", "0617977422");
        cs.create(c1);
        cs.create(c2);
        cs.create(c3);
        cs.create(c4);


        Assurance a1 = new Assurance("AUTO", 3500, "Tous risques");
        Assurance a2 = new Assurance("HABITATION", 1800, "Incendie et vol");
        Assurance a3 = new Assurance("SANTE", 5200, "Hospitalisation");
        as.create(a1);
        as.create(a2);
        as.create(a3);

        cos.create(new Contrat(d("01/01/2024"), d("31/12/2026"), StatutContrat.ACTIF, c1, a1));
        cos.create(new Contrat(d("01/06/2025"), d("31/05/2028"), StatutContrat.ACTIF, c2, a1));

        System.out.println("Rechercher une assurance par son type ");
        System.out.println(as.findByType("SANTE"));

        System.out.println("\n Contrats d'un client (CIN = EE123456) ");
        afficher(cos.findByClientCin("EE123456"));

        System.out.println("\nContrats de l'assurance de type AUTO ");
        afficher(cos.findByAssuranceType("AUTO"));

    }
}