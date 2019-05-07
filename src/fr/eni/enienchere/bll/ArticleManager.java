package fr.eni.enienchere.bll;

import fr.eni.enienchere.bll.exception.BLLException;
import fr.eni.enienchere.bo.Article;
import fr.eni.enienchere.dal.dao.ArticleDAO;
import fr.eni.enienchere.dal.dao.DAOFactory;
import fr.eni.enienchere.dal.exception.DALException;

import java.util.List;

/**
 *
 * @author ehourman2019
 *
 */
public class ArticleManager {

    private ArticleDAO articleDAO;

    /**
     * Constructor
     * @throws BLLException
     */
    public ArticleManager() throws BLLException {
        articleDAO = DAOFactory.getArticleDAO();
    }

    public void insertArticle(Article article) throws BLLException {
        try {
            articleDAO.insert(article);
        } catch (DALException e) {
            e.printStackTrace();
        }
    }

    public List<Article> selectAllArticle() throws  BLLException {
        try {
            return (List<Article>) articleDAO.selectAll();
        } catch (DALException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Article selectArticleById(long id) throws BLLException {
        try  {
            return (Article) articleDAO.selectById(id);
        } catch (DALException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  void updateArticle(Article article) throws BLLException {
        try {
            articleDAO.update(article);
        } catch (DALException e) {
            e.printStackTrace();
        }
    }

    public void deleteArticle(long id) throws BLLException {
        try {
            articleDAO.delete(id);
        } catch (DALException e) {
            e.printStackTrace();
        }
    }
}
