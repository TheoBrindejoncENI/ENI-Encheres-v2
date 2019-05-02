package fr.eni.enienchere.dal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author ehourman2019
 *
 */
public abstract class ConnectionProvider {

    public static Session session;

    static {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public static Session getConnection() {
        return ConnectionProvider.session;
    }
}
