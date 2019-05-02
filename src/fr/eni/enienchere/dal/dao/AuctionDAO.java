package fr.eni.enienchere.dal.dao;

import fr.eni.enienchere.bo.Auction;
import fr.eni.enienchere.dal.exception.DALException;

import java.util.List;

/**
 *
 * @author ehourman2019
 *
 */
public interface AuctionDAO {

    /**
     * Insert a auction in bdd
     * @param auction
     * @throws DALException
     */
    void insert(Auction auction) throws DALException;

    /**
     * Select all auction in bdd
     * @return
     * @throws DALException
     */
    List<Auction> selectAll() throws DALException;

    /**
     * Select auction with id user
     * @param id
     * @return
     * @throws DALException
     */
    List<Auction> selectByIdUser(Long id) throws DALException;

    /**
     * Select auction with id Article
     * @param id
     * @return
     * @throws DALException
     */
    List<Auction> selectByIdArticle(Long id) throws DALException;

    /**
     * Update article in bdd
     * @param auction
     * @throws DALException
     */
    void update(Auction auction) throws DALException;

    /**
     * Delete article in bdd
     * @param auction
     * @throws DALException
     */
    void delete(Auction auction) throws DALException;
}
