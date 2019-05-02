package fr.eni.enienchere.dal.dao;

import fr.eni.enienchere.bo.Category;
import fr.eni.enienchere.dal.exception.DALException;

import java.util.List;

/**
 *
 * @author ehourman2019
 *
 */
public interface CategoryDAO {

    /**
     * Insert a category in bdd
     * @param category
     * @throws DALException
     */
    void insert(Category category) throws DALException;

    /**
     * Select all category in bdd
     * @return
     * @throws DALException
     */
    List<Category> selectAll() throws DALException;

    /**
     * Select category with id
     * @param id
     * @return
     * @throws DALException
     */
    List<Category> selectById(Long id) throws DALException;

    /**
     * Update category in bdd
     * @param id
     * @throws DALException
     */
    void update(Long id) throws DALException;

    /**
     * Delete category in bdd
     * @param id
     * @throws DALException
     */
    void delete(Long id) throws DALException;
}
