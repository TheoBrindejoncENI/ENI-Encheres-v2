package fr.eni.enienchere.dal.dao;

import fr.eni.enienchere.bo.PickUp;
import fr.eni.enienchere.dal.exception.DALException;

import java.util.List;

/**
 *
 * @author ehourman2019
 *
 */
public interface PickUpDAO {
    /**
     * Insert a category in bdd
     * @param pickUp
     * @throws DALException
     */
    void insert(PickUp pickUp) throws DALException;

    /**
     * Select all category in bdd
     * @return
     * @throws DALException
     */
    List<PickUp> selectAll() throws DALException;

    /**
     * Select category with id
     * @param id
     * @return
     * @throws DALException
     */
    List<PickUp> selectById(Long id) throws DALException;

    /**
     * Update category in bdd
     * @param pickUp
     * @throws DALException
     */
    void update(PickUp pickUp) throws DALException;

    /**
     * Delete category in bdd
     * @param pickUp
     * @throws DALException
     */
    void delete(PickUp pickUp) throws DALException;
}
