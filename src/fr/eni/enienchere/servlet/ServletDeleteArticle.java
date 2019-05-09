package fr.eni.enienchere.servlet;

import fr.eni.enienchere.bll.ArticleManager;
import fr.eni.enienchere.bll.CategoryManager;
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

@WebServlet("/deleteArticle")
public class ServletDeleteArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProfileManager pm = new ProfileManager();
            ArticleManager am = new ArticleManager();
            HttpSession session = request.getSession();
            if (session.getAttribute("utilisateurConnecte") == null) {
                session.setAttribute("lastUrl", "/myArticle");
                RequestDispatcher rd = request.getRequestDispatcher("/login");
                rd.forward(request, response);
            } else {
                User user = pm.selectUserProfile((long) session.getAttribute("noUser"));
                am.deleteArticle(Long.parseLong(request.getParameter("id")));
                RequestDispatcher rd = request.getRequestDispatcher("/myArticle");
                rd.forward(request, response);
            }
        } catch (BLLException e) {
            e.getStackTrace();
        }
    }
}
