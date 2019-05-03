package fr.eni.enienchere.bll;

import fr.eni.enienchere.bll.exception.BLLException;
import fr.eni.enienchere.bo.User;
import fr.eni.enienchere.dal.dao.DAOFactory;
import fr.eni.enienchere.dal.dao.UserDAO;
import fr.eni.enienchere.dal.exception.DALException;

public class LoginManager {

    static UserDAO userDAO;

    public LoginManager() throws DALException{
        userDAO = DAOFactory.getUserDAO();
    }

    public void checkUserLog(String userName, String lastName, String firstName, String email, String phoneNumber,
                           String street, String postalCode, String city, String password) throws BLLException {
        try  {
            User user = User.class.cast(userName);
        } catch (DALException e) {
            e.printStackTrace();
        }
    }
}
