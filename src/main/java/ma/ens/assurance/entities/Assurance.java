package ma.ens.assurance.entities;

import java.util.List;
import javax.persistence.*;

@Entity
public class Assurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private double montant;
    private String couverture;


    @OneToMany(mappedBy = "assurance")
    private List<Contrat> contrats;

    public Assurance() {
    }

    public Assurance(String type, double montant, String couverture) {
        this.type = type;
        this.montant = montant;
        this.couverture = couverture;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public String getCouverture() {
        return couverture;
    }
    public void setCouverture(String couverture) {
        this.couverture = couverture;
    }
    public List<Contrat> getContrats() {
        return contrats;
    }
    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }

    @Override
    public String toString() {
        return type + " (" + montant + " DH, " + couverture + ")";
    }
}