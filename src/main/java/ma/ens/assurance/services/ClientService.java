package ma.ens.assurance.services;

import ma.ens.assurance.entities.Client;
import ma.ens.assurance.util.HibernateUtil;
import org.hibernate.Session;

public class ClientService extends AbstractFacade<Client> {

    public ClientService() {
        super(Client.class);
    }

    /** Recherche un client par son CIN. */
    public Client findByCin(String cin) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createQuery("from Client c where c.cin = :cin", Client.class)
                    .setParameter("cin", cin)
                    .uniqueResult();
        }
    }

}