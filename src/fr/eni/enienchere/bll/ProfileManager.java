package fr.eni.enienchere.bll;

import fr.eni.enienchere.bll.exception.BLLException;
import fr.eni.enienchere.bo.User;
import fr.eni.enienchere.dal.dao.DAOFactory;
import fr.eni.enienchere.dal.dao.UserDAO;
import fr.eni.enienchere.dal.exception.DALException;

/**
 *
 * @author ehourman2019
 *
 */
public class ProfileManager {

    private static UserDAO userDAO;

    /**
     * Constructor
     * @throws BLLException
     */
    public ProfileManager() throws BLLException {
        userDAO = DAOFactory.getUserDAO();
    }

    /**
     * add user in bdd
     * @param id
     * @return
     * @throws BLLException
     */
   public User selectUserProfile(long id) throws BLLException{
       try  {
           return (User) userDAO.selectById(id);
        } catch (DALException e) {
            e.printStackTrace();
        }
       return null;
    }

    /**
     * update user in bdd
     * @param user
     * @throws BLLException
     */
    public void updateUserProfile(User user) throws BLLException {
        try {
            userDAO.update(user);
        } catch (DALException e) {
            e.printStackTrace();
        }
    }

    /**
     * delete user in bdd
     * @param id
     * @throws BLLException
     */
    public void deleteUserProfile(long id) throws BLLException {
        try {
            userDAO.delete(id);
        } catch (DALException e) {
            e.printStackTrace();
        }
    }
}
