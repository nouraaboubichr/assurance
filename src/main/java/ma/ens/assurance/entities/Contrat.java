package ma.ens.assurance.entities;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateDebut;
    private Date dateFin;

    @Enumerated(EnumType.STRING)
    private StatutContrat statut;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    @ManyToOne
    @JoinColumn(name = "assurance_id")
    private Assurance assurance;

    public Contrat(String s, String string) {
    }

    public Contrat(Date dateDebut, Date dateFin, StatutContrat statut, Client client, Assurance assurance) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
        this.client = client;
        this.assurance = assurance;
    }

    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public Date getDateDebut() {

        return dateDebut;
    }
    public void setDateDebut(Date dateDebut) {

        this.dateDebut = dateDebut;
    }
    public Date getDateFin() {

        return dateFin;
    }
    public void setDateFin(Date dateFin) {

        this.dateFin = dateFin;
    }
    public StatutContrat getStatut() {

        return statut;
    }
    public void setStatut(StatutContrat statut) {

        this.statut = statut;
    }
    public Client getClient() {

        return client;
    }
    public void setClient(Client client) {

        this.client = client;
    }
    public Assurance getAssurance() {

        return assurance;
    }
    public void setAssurance(Assurance assurance) {

        this.assurance = assurance;
    }
}