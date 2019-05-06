package fr.eni.enienchere.dal.dao.hibernate;

import fr.eni.enienchere.EnchereException;
import fr.eni.enienchere.bll.exception.BLLException;
import fr.eni.enienchere.bo.User;
import fr.eni.enienchere.dal.ConnectionProvider;
import fr.eni.enienchere.dal.dao.UserDAO;
import fr.eni.enienchere.dal.exception.DALException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.result.ResultSetOutput;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ehourman2019
 *
 */
public class HibernateUserDAO implements UserDAO {

    @Override
    public void insert(User user) throws DALException {
        Session session = ConnectionProvider.getConnection();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public List<User> selectAll() throws DALException {
        Session session = ConnectionProvider.getConnection();
        Query q = session.createQuery("FROM User");
        List<User> users = q.getResultList();
        return users;
    }

    @Override
    public User selectById(Long id) throws DALException {
        Session session = ConnectionProvider.getConnection();
        Query q = session.createQuery("FROM User WHERE idUser=:idUser");
        q.setParameter("idUser", id);
        List<User> users = q.getResultList();
        User user = users.get(0);
        return user;
    }

    @Override
    public void update(Long id) throws DALException {
        Session session = ConnectionProvider.getConnection();
        User user = (User) session.get(User.class, id);
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
    }

    @Override
    public User selectByUserName(String username) throws EnchereException {
        User result = null;
        try(Session session = ConnectionProvider.getConnection()){
            Query q = session.createQuery("FROM User WHERE userName=:userName");
            q.setParameter("userName", username);
            List<User> users = q.getResultList();
            result = users.get(1);

        } catch(Exception e) {
            e.printStackTrace();
            EnchereException enchereException = new EnchereException();
            throw enchereException;
        }

        if(result == null)
        {
            EnchereException enchereException = new EnchereException();
            //TODO : CodesResultatDAL
            //businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_INEXISTANTE);
            throw enchereException;
        }

        return result;
    }

    @Override
    public User selectByEmail(String email) throws EnchereException {
        List<User> liste;
        User res = null;
        Session session = ConnectionProvider.getConnection();
        Query q = session.createQuery("from User where email=:email");
        liste = q.getResultList();
        for(User u : liste) {
            if(u.getEmail().equals(email)) {
                res = u;
                break;
            }
        }
        return res;
    }



    @Override
    public void delete(Long id) throws DALException {
        Session session = ConnectionProvider.getConnection();
        User user = (User) session.get(User.class, id);
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }
}
