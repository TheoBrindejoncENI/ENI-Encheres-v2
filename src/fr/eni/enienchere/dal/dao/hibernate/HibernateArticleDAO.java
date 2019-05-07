package fr.eni.enienchere.dal.dao.hibernate;

import fr.eni.enienchere.bo.Article;
import fr.eni.enienchere.dal.ConnectionProvider;
import fr.eni.enienchere.dal.dao.ArticleDAO;
import fr.eni.enienchere.dal.exception.DALException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 *
 * @author ehourman2019
 *
 */
public class HibernateArticleDAO implements ArticleDAO {

    @Override
    public void insert(Article article) throws DALException {
        Session session = ConnectionProvider.getConnection();
        session.beginTransaction();
        session.save(article);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Article> selectAll() throws DALException {
        Session session = ConnectionProvider.getConnection();
        Query q = session.createQuery("FROM Article");
        List<Article> articles = q.getResultList();
        return articles;
    }

    @Override
    public List<Article> selectById(Long id) throws DALException {
        Session session = ConnectionProvider.getConnection();
        Query q = session.createQuery("FROM Article WHERE idArticle=:idArticle");
        q.setParameter("idArticle", id);
        List<Article> articles = q.getResultList();
        return articles;
    }

    @Override
    public void update(Article article) throws DALException {
        Session session = ConnectionProvider.getConnection();
        session.saveOrUpdate(article);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Long id) throws DALException {
        Session session = ConnectionProvider.getConnection();
        Article article = (Article) session.get(Article.class, id);
        session.beginTransaction();
        session.delete(article);
        session.getTransaction().commit();
    }
}
