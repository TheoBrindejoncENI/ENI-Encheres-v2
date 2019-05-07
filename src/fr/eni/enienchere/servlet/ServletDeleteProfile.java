package fr.eni.enienchere.servlet;

import fr.eni.enienchere.bll.ProfileManager;
import fr.eni.enienchere.bll.exception.BLLException;

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
@WebServlet("/deleteProfile")
public class ServletDeleteProfile extends HttpServlet {

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
     * Delete a user in bdd
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProfileManager pm = new ProfileManager();
            HttpSession session = request.getSession();
            pm.deleteUserProfile((long) session.getAttribute("noUser"));
            RequestDispatcher rd = request.getRequestDispatcher("/logout");
            rd.forward(request, response);
        } catch (BLLException e) {
            e.getStackTrace();
        }
    }
}
