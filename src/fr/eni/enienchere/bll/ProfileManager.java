package fr.eni.enienchere.bll;

import fr.eni.enienchere.EnchereException;
import fr.eni.enienchere.bll.exception.BLLException;
import fr.eni.enienchere.bo.User;
import fr.eni.enienchere.dal.dao.DAOFactory;
import fr.eni.enienchere.dal.dao.UserDAO;
import fr.eni.enienchere.dal.exception.DALException;

public class ProfileManager {

    private static UserDAO userDAO;

    /**
     * Constructor
     * @throws BLLException
     */
    public ProfileManager() throws BLLException {
        userDAO = DAOFactory.getUserDAO();
    }

   public User selectUserProfile(long id) throws BLLException{
       try  {
           return (User) userDAO.selectById(id);
        } catch (DALException e) {
            e.printStackTrace();
        }
       return null;
    }

    public void updateUserProfile(User user) throws BLLException {
        try {
            userDAO.update(user);
        } catch (DALException e) {
            e.printStackTrace();
        }
    }

    public void deleteUserProfile(long id) throws BLLException {
        try {
            userDAO.delete(id);
        } catch (DALException e) {
            e.printStackTrace();
        }
    }
}
