package fr.eni.enienchere.servlet;

import fr.eni.enienchere.bll.CategoryManager;
import fr.eni.enienchere.bll.ProfileManager;
import fr.eni.enienchere.bll.exception.BLLException;
import fr.eni.enienchere.bo.Category;
import fr.eni.enienchere.bo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/showAdmin")
public class ServletAdminShow extends HttpServlet {

    CategoryManager cm;
    ProfileManager pm;
    HttpSession session;
    List<Category> categories;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            cm = new CategoryManager();
            pm = new ProfileManager();
            session = request.getSession();
            if (session.getAttribute("utilisateurConnecte") == null) {
                RequestDispatcher rd = request.getRequestDispatcher("/login");
                rd.forward(request, response);
            } else {
                User user = pm.selectUserProfile((long) session.getAttribute("noUser"));
                if (user.isUserAdmin() == true) {
                    categories = cm.selectAllCategory();
                    request.setAttribute("category", this.categories);
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/adminShow.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/home");
                    rd.forward(request, response);
                }
            }
        } catch (BLLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
