package fr.eni.enienchere.servlet;

import fr.eni.enienchere.bll.ProfileManager;
import fr.eni.enienchere.bll.UserManager;
import fr.eni.enienchere.bll.exception.BLLException;
import fr.eni.enienchere.bo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/editProfile")
public class ServletEditProfile extends HttpServlet {

    User user;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            ProfileManager pm = new ProfileManager();
            HttpSession session = request.getSession();
            user = pm.selectUserProfile((long) session.getAttribute("noUser"));
        } catch (BLLException e) {
            e.getStackTrace();
        }
        request.setAttribute("user", this.user);
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/editProfile.jsp");
        rd.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            ProfileManager pm = new ProfileManager();
            HttpSession session = request.getSession();
            User user = pm.selectUserProfile((long) session.getAttribute("noUser"));
            user.setUserName(request.getParameter("userName"));
            user.setFirstName(request.getParameter("firstName"));
            user.setLastName(request.getParameter("lastName"));
            user.setEmail(request.getParameter("email"));
            user.setPhoneNumber(request.getParameter("phoneNumber"));
            user.setStreet(request.getParameter("street"));
            user.setPostalCode(request.getParameter("postalCode"));
            user.setCity(request.getParameter("city"));
            String password = request.getParameter("password");
            if (password != null) {
                user.setPassword(password);
            } else {
                user.setPassword(user.getPassword());
            }
            pm.updateUserProfile(user);

            request.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("/profile");
            rd.forward(request, response);
        } catch (BLLException e) {
            e.printStackTrace();
        }
    }
}