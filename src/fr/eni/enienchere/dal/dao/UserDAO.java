package fr.eni.enienchere.dal.dao;

import fr.eni.enienchere.EnchereException;
import fr.eni.enienchere.bo.User;
import fr.eni.enienchere.dal.exception.DALException;

import java.util.List;

/**
 *
 * @author ehourman2019
 *
 */
public interface UserDAO {

    /**
     * Insert a user in bdd
     * @param user
     * @throws DALException
     */
    void insert(User user) throws DALException;

    /**
     * Select all user in bdd
     * @return
     * @throws DALException
     */
    List<User> selectAll() throws DALException;

    /**
     * Select user with id
     * @param id
     * @return
     * @throws DALException
     */
    User selectById(Long id) throws DALException;

    /**
     * Select a user with useName
     * @param username
     * @return
     * @throws DALException
     */
    User selectByUserName(String username) throws EnchereException;

    /**
     * Select a user with useName
     * @param email
     * @return
     * @throws DALException
     */
    User selectByEmail(String email) throws EnchereException;



    /**
     * Update user in bdd
     * @param id
     * @throws DALException
     */
    void update(Long id) throws DALException;

    /**
     * Delete user in bdd
     * @param id
     * @throws DALException
     */
    void delete(Long id) throws DALException;
}
