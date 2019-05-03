package fr.eni.enienchere.dal;


import fr.eni.enienchere.bo.User;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

class Runner {

    @Test
    void test() {
        // Ajout
        User voitureAajoutee = new User();
        Session session = ConnectionProvider.session;
        session.beginTransaction();
        session.save(voitureAajoutee);
        session.getTransaction().commit();
    }
}
