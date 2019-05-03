package fr.eni.enienchere.dal.dao.jpa;

import fr.eni.enienchere.bo.User;
import fr.eni.enienchere.dal.ConnectionProvider;
import fr.eni.enienchere.dal.dao.UserDAO;
import fr.eni.enienchere.dal.exception.DALException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 *
 * @author ehourman2019
 *
 */
public class JpaUserDAO implements UserDAO {

    @Override
    public void insert(User user) throws DALException {
        Session session = ConnectionProvider.getConnection();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public List<User> selectAll() throws DALException {
        Session session = ConnectionProvider.session;
        Query q = session.createQuery("FROM UTILISATEURS");
        List<User> users = q.getResultList();
        return users;
    }

    @Override
    public List<User> selectById(Long id) throws DALException {
        Session session = ConnectionProvider.session;
        Query q = session.createQuery("FROM UTILISATEURS WHERE idUser=" + id);
        List<User> users = q.getResultList();
        return users;
    }

    @Override
    public void update(Long id) throws DALException {
        Session session = ConnectionProvider.session;
        User user = (User) session.get(User.class, id);
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
    }

    @Override
    public List<User> selectByUserName(String username) throws DALException{
        Session session = ConnectionProvider.session;
        Query q = session.createQuery("FROM UTILISATEURS WHERE userName=" + username);
        List<User> users = q.getResultList();
        return users;
    }

    @Override
    public void delete(Long id) throws DALException {
        Session session = ConnectionProvider.session;
        User user = (User) session.get(User.class, id);
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }
}
