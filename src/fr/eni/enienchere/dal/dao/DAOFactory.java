package fr.eni.enienchere.dal.dao;

import fr.eni.enienchere.dal.dao.hibernate.*;

/**
 *
 * @author ehourman2019
 *
 */
public class DAOFactory {

    public static UserDAO getUserDAO() { return new HibernateUserDAO(); }

    public static  ArticleDAO getArticleDAO() { return new HibernateArticleDAO(); }

    public static CategoryDAO getCategoryDAO() {
        return new HibernateCategoryDAO();
    }

    public static AuctionDAO getAuctionDAO() { return new HibernateAuctionDAO(); }

    public static PickUpDAO getPickUpDAO() { return new HibernatePickUpDAO(); }
}
