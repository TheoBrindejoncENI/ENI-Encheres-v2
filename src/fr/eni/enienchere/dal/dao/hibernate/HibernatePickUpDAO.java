package fr.eni.enienchere.dal.dao.hibernate;

import fr.eni.enienchere.bo.PickUp;
import fr.eni.enienchere.dal.ConnectionProvider;
import fr.eni.enienchere.dal.dao.PickUpDAO;
import fr.eni.enienchere.dal.exception.DALException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 *
 * @author ehourman2019
 *
 */
public class HibernatePickUpDAO implements PickUpDAO {

    @Override
    public void insert(PickUp pickUp) throws DALException {
        Session session = ConnectionProvider.getConnection();
        session.beginTransaction();
        session.save(pickUp);
        session.getTransaction().commit();
    }

    @Override
    public List<PickUp> selectAll() throws DALException {
        Session session = ConnectionProvider.getConnection();
        Query q = session.createQuery("FROM PickUp ");
        List<PickUp> pickUps = q.getResultList();
        return pickUps;
    }

    @Override
    public List<PickUp> selectById(Long id) throws DALException {
        Session session = ConnectionProvider.getConnection();
        Query q = session.createQuery("FROM PickUp WHERE article.idArticle=" + id);
        List<PickUp> pickUps = q.getResultList();
        return pickUps;
    }

    @Override
    public void update(PickUp pickUp) throws DALException {
        Session session = ConnectionProvider.getConnection();
        session.beginTransaction();
        session.saveOrUpdate(pickUp);
        session.getTransaction().commit();
    }

    @Override
    public void delete(PickUp pickUp) throws DALException {
        Session session = ConnectionProvider.getConnection();
        session.beginTransaction();
        session.delete(pickUp);
        session.getTransaction().commit();
    }
}
