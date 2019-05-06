package fr.eni.enienchere.bll.servlet;

import fr.eni.enienchere.bll.UserManager;
import fr.eni.enienchere.bll.exception.BLLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class ServletRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String phoneNumber = request.getParameter("phoneNumber");
        String postalCode = request.getParameter("postalCode");

        try {
            UserManager rm = new UserManager();
            rm.insertUser(userName, lastName, firstName, email, phoneNumber, street, postalCode, city, password);

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/registerComplete.jsp");
            rd.forward(request, response);

        } catch (BLLException e) {
            e.getStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
        rd.forward(request, response);
    }
}
