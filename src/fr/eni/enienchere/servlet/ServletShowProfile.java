package fr.eni.enienchere.servlet;

import fr.eni.enienchere.bll.ProfileManager;
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

@WebServlet("/profile")
public class ServletShowProfile extends HttpServlet {

    private User user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("COUCOU##############");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProfileManager pm = new ProfileManager();
            HttpSession session = request.getSession();
            user = pm.selectUserProfile((long) session.getAttribute("noUser"));
            user = pm.selectUserProfile((long) 1);
        } catch (BLLException e) {
            e.getStackTrace();
        }
        request.setAttribute("user", this.user);
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/showProfile.jsp");
        rd.forward(request, response);
    }
}
