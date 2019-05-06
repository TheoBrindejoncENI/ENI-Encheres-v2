package fr.eni.enienchere.dal.dao.hibernate;

import fr.eni.enienchere.EnchereException;
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
        Query q = session.createQuery("FROM User ");
        List<User> users = q.getResultList();
        return users;
    }

    @Override
    public List<User> selectById(Long id) throws DALException {
        Session session = ConnectionProvider.getConnection();
        Query q = session.createQuery("FROM User WHERE idUser=" + id);
        List<User> users = q.getResultList();
        return users;
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
        User user = null;

        try(Session session = ConnectionProvider.getConnection()){
            Query q = session.createQuery("FROM User WHERE email=:email");
            q.setParameter("email",email);
            user = (User) q.list().get(0);

        } catch(Exception e) {
            e.printStackTrace();
            EnchereException enchereException = new EnchereException();
            //TODO : CodesResultatDAL
            //businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_ECHEC);
            throw enchereException;
        }

        if(user == null)
        {
            EnchereException enchereException = new EnchereException();
            //TODO : CodesResultatDAL
            //businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_INEXISTANTE);
            throw enchereException;
        }

        return user;
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
