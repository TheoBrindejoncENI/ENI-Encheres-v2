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

/**
 *
 * @author ehourman2019
 *
 */
@WebServlet("/profile")
public class ServletShowProfile extends HttpServlet {

    private User user;

    /**
     * return doGet()
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    /**
     * view of the user profile
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProfileManager pm = new ProfileManager();
            HttpSession session = request.getSession();
            if (session.getAttribute("utilisateurConnecte") == null) {
                session.setAttribute("lastUrl", "/profile");
                RequestDispatcher rd = request.getRequestDispatcher("/login");
                rd.forward(request, response);
            } else {
                user = pm.selectUserProfile((long) session.getAttribute("noUser"));
                request.setAttribute("user", this.user);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/showProfile.jsp");
                rd.forward(request, response);
            }
        } catch (BLLException e) {
            e.getStackTrace();
        }
    }
}
