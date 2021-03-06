package fr.eni.enienchere.servlet;

import com.sun.net.httpserver.HttpsServer;
import fr.eni.enienchere.bll.ArticleManager;
import fr.eni.enienchere.bll.exception.BLLException;
import fr.eni.enienchere.bo.Article;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/myArticle")
public class ServletShowUserArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArticleManager am = new ArticleManager();
            HttpSession session =  request.getSession();
            if (session.getAttribute("utilisateurConnecte") == null) {
                session.setAttribute("lastUrl", "/myArticle");
                RequestDispatcher rd = request.getRequestDispatcher("/login");
                rd.forward(request, response);
            } else {
                List<Article> articles = am.selectArticleByUserId((long) session.getAttribute("noUser"));
                request.setAttribute("articles", articles);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/showUserArticle.jsp");
                rd.forward(request, response);
            }
        } catch (BLLException e) {
            e.printStackTrace();
        }
    }
}
