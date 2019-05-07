package fr.eni.enienchere.dal.dao;

import fr.eni.enienchere.bo.Article;
import fr.eni.enienchere.dal.exception.DALException;

import java.util.List;

/**
 *
 * @author ehourman2019
 *
 */
public interface ArticleDAO {

    /**
     * Insert a article in bdd
     * @param article
     * @throws DALException
     */
    void insert(Article article) throws DALException;

    /**
     * Select all article in bdd
     * @return
     * @throws DALException
     */
    List<Article> selectAll() throws DALException;

    /**
     * Select article with id
     * @param id
     * @return
     * @throws DALException
     */
    List<Article> selectById(Long id) throws DALException;

    /**
     * Update article in bdd
     * @param article
     * @throws DALException
     */
    void update(Article article) throws DALException;

    /**
     * Delete article in bdd
     * @param id
     * @throws DALException
     */
    void delete(Long id) throws DALException;
}
