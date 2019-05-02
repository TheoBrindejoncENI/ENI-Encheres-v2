package fr.eni.enienchere.dal.dao.jpa;

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
public class JpaPickUpDAO implements PickUpDAO {

    @Override
    public void insert(PickUp pickUp) throws DALException {
        Session session = ConnectionProvider.session;
        session.beginTransaction();
        session.save(pickUp);
        session.getTransaction().commit();
    }

    @Override
    public List<PickUp> selectAll() throws DALException {
        Session session = ConnectionProvider.session;
        Query q = session.createQuery("FROM RETRAITS ");
        List<PickUp> pickUps = q.getResultList();
        return pickUps;
    }

    @Override
    public List<PickUp> selectById(Long id) throws DALException {
        Session session = ConnectionProvider.session;
        Query q = session.createQuery("FROM RETRAITS WHERE article.idArticle=" + id);
        List<PickUp> pickUps = q.getResultList();
        return pickUps;
    }

    @Override
    public void update(PickUp pickUp) throws DALException {
        Session session = ConnectionProvider.session;
        session.beginTransaction();
        session.saveOrUpdate(pickUp);
        session.getTransaction().commit();
    }

    @Override
    public void delete(PickUp pickUp) throws DALException {
        Session session = ConnectionProvider.session;;
        session.beginTransaction();
        session.delete(pickUp);
        session.getTransaction().commit();
    }
}
