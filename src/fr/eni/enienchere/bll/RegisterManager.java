package fr.eni.enienchere.bll;

import fr.eni.enienchere.bll.exception.BLLException;
import fr.eni.enienchere.bo.User;
import fr.eni.enienchere.dal.dao.DAOFactory;
import fr.eni.enienchere.dal.dao.UserDAO;
import fr.eni.enienchere.dal.exception.DALException;

import java.util.regex.Pattern;

public class RegisterManager {

    private static UserDAO userDAO;

    /**
     * Constructor
     * @throws BLLException
     */
    public RegisterManager() throws BLLException {
        userDAO = DAOFactory.getUserDAO();
    }

    /**
     * Insert a user in bdd
     * @param userName
     * @param lastName
     * @param firstName
     * @param email
     * @param phoneNumber
     * @param street
     * @param postalCode
     * @param city
     * @param password
     * @throws BLLException
     */
    public void insertUser(String userName, String lastName, String firstName, String email, String phoneNumber,
                           String street, String postalCode, String city, String password) throws BLLException {
        try  {
            User user = new User(userName, lastName, firstName, email, phoneNumber, street, postalCode, city, password);
            checkUser(user);
            userDAO.insert(user);
        } catch (DALException e) {
           e.printStackTrace();
        }
    }

    /**
     * Check all setting of a user.
     * @param user
     * @throws BLLException
     */
    public void checkUser(User user) throws BLLException {

        boolean isOK = true;
        StringBuffer sb = new StringBuffer();

        if(user == null){
            throw new BLLException("User null");
        }

        if(user.getUserName() == null || user.getUserName().trim().length()==0){
            sb.append("Le pseudo est obligatoire.\n");
            isOK = false;
        }
        if(user.getFirstName()== null || user.getFirstName().trim().length()==0){
            sb.append("Le prénom est obligatoire.\n");
            isOK = false;
        }
        if(user.getLastName()==null || user.getLastName().trim().length()==0){
            sb.append("Le nom de famille est obligatoire.\n");
            isOK = false;
        }
        if (user.getEmail() == null || user.getEmail().trim().length()== 0) {
            sb.append("L'email est obligatoire.");
            isOK = false;
        } else {
            boolean emailCheck = emailCheck(user.getEmail());
            if (emailCheck == false) {
                sb.append("L'email n'est pas valide.");
                isOK = false;
            }
        }
        if (user.getPhoneNumber() != null || user.getPhoneNumber().trim().length() > 0) {
            boolean numberCheck = numberCheck(user.getPhoneNumber());
            if (numberCheck == false) {
                sb.append("Le numéro de téléphone n'est pas valide");
                isOK = false;
            }
        }
        if (user.getStreet() == null || user.getStreet().trim().length() ==0) {
            sb.append("La rue n'est pas valide.");
            isOK = false;
        }
        if (user.getPostalCode() == null || user.getPostalCode().trim().length() == 0) {
            sb.append("Le code postal est obligatoire");
            isOK = false;
        } else {
            if (user.getPostalCode().length() > 5 && user.getPostalCode().length() < 5) {
                sb.append("Le code postal est invalide");
                isOK = false;
            }
        }
        if (user.getCity() == null || user.getCity().trim().length() ==0 ) {
            sb.append("La ville postal est obligatoire");
            isOK = false;
        }
        if (user.getPassword() == null || user.getPassword().trim().length() ==0 ) {
            sb.append("Le password est obligatoire");
            isOK = false;
        }

        if(!isOK) {
            throw new BLLException(sb.toString());
        }
    }

    /**
     * Check email with regex
     * @param email
     * @return
     * @throws BLLException
     */
    public boolean emailCheck(String email) throws BLLException {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }

    /**
     * Check numberPhone with regex
     * @param numberPhone
     * @return
     * @throws BLLException
     */
    public  boolean numberCheck(String numberPhone) throws BLLException {
        String numberRegex = "^[0-9]+$";
        Pattern pat = Pattern.compile(numberRegex);
        return pat.matcher(numberPhone).matches();
    }
}
