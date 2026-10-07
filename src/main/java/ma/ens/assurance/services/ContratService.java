package ma.ens.assurance.services;

import ma.ens.assurance.entities.Contrat;
import ma.ens.assurance.entities.StatutContrat;
import ma.ens.assurance.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class ContratService extends AbstractFacade<Contrat> {

    public ContratService() {
        super(Contrat.class);
    }

    /** Contrats d'un client, par CIN. */
    public List<Contrat> findByClientCin(String cin) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createQuery(
                            "select c from Contrat c "
                                    + "join fetch c.client join fetch c.assurance "
                                    + "where c.client.cin = :cin order by c.dateDebut", Contrat.class)
                    .setParameter("cin", cin)
                    .list();
        }
    }

    /** Contrats associés à une assurance, par type. */
    public List<Contrat> findByAssuranceType(String type) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createQuery(
                            "select c from Contrat c "
                                    + "join fetch c.client join fetch c.assurance "
                                    + "where c.assurance.type = :type order by c.dateDebut", Contrat.class)
                    .setParameter("type", type)
                    .list();
        }
    }


}