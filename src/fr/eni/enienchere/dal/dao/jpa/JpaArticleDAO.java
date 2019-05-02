package fr.eni.enienchere.dal.dao.jpa;

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
public class JpaArticleDAO implements ArticleDAO {

    @Override
    public void insert(Article article) throws DALException {
        Session session = ConnectionProvider.session;
        session.beginTransaction();
        session.save(article);
        session.getTransaction().commit();
    }

    @Override
    public List<Article> selectAll() throws DALException {
        Session session = ConnectionProvider.session;
        Query q = session.createQuery("FROM ARTICLES_VENDUS");
        List<Article> articles = q.getResultList();
        return articles;
    }

    @Override
    public List<Article> selectById(Long id) throws DALException {
        Session session = ConnectionProvider.session;
        Query q = session.createQuery("FROM ARTICLES_VENDUS WHERE idArticle=" + id);
        List<Article> articles = q.getResultList();
        return articles;
    }

    @Override
    public void update(Long id) throws DALException {
        Session session = ConnectionProvider.session;
        Article article = (Article) session.get(Article.class, id);
        session.beginTransaction();
        session.saveOrUpdate(article);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Long id) throws DALException {
        Session session = ConnectionProvider.session;
        Article article = (Article) session.get(Article.class, id);
        session.beginTransaction();
        session.delete(article);
        session.getTransaction().commit();
    }
}
