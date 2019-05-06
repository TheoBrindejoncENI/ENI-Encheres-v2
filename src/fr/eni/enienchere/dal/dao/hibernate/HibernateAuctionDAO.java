package fr.eni.enienchere.dal.dao.hibernate;

import fr.eni.enienchere.bo.Auction;
import fr.eni.enienchere.dal.ConnectionProvider;
import fr.eni.enienchere.dal.dao.AuctionDAO;
import fr.eni.enienchere.dal.exception.DALException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 *
 * @author ehourman2019
 *
 */
public class HibernateAuctionDAO implements AuctionDAO {

    @Override
    public void insert(Auction auction) throws DALException {
        Session session = ConnectionProvider.getConnection();
        session.beginTransaction();
        session.save(auction);
        session.getTransaction().commit();
    }

    @Override
    public List<Auction> selectAll() throws DALException {
        Session session = ConnectionProvider.getConnection();
        Query q = session.createQuery("FROM User ");
        List<Auction> auction = q.getResultList();
        return auction;
    }

    @Override
    public List<Auction> selectByIdUser(Long id) throws DALException {
        Session session = ConnectionProvider.getConnection();
        Query q = session.createQuery("FROM Auction WHERE user.idUser=" + id);
        List<Auction> auction = q.getResultList();
        return auction;
    }

    @Override
    public List<Auction> selectByIdArticle(Long id) throws DALException {
        Session session = ConnectionProvider.getConnection();
        Query q = session.createQuery("FROM Auction WHERE article.idArticle=" + id);
        List<Auction> auction = q.getResultList();
        return auction;
    }

    @Override
    public void update(Auction auction) throws DALException {
        Session session = ConnectionProvider.getConnection();
        session.beginTransaction();
        session.saveOrUpdate(auction);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Auction auction) throws DALException {
        Session session = ConnectionProvider.getConnection();
        session.beginTransaction();
        session.delete(auction);
        session.getTransaction().commit();
    }
}
