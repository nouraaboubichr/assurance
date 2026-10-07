package ma.ens.assurance.services;

import ma.ens.assurance.entities.Assurance;
import ma.ens.assurance.util.HibernateUtil;
import org.hibernate.Session;

public class AssuranceService extends AbstractFacade<Assurance> {

    public AssuranceService() {
        super(Assurance.class);
    }

    /** Rechercher une assurance par son type. */
    public Assurance findByType(String type) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createQuery("from Assurance a where a.type = :type", Assurance.class)
                    .setParameter("type", type)
                    .setMaxResults(1)
                    .uniqueResult();
        }
    }
}