package fr.eni.enienchere.servlet;

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

@WebServlet("/article")
public class ServletShowArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArticleManager am = new ArticleManager();
            Article article = am.selectArticleById(Long.parseLong(request.getParameter("id")));
            request.setAttribute("article", article);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/showArticle.jsp");
            rd.forward(request, response);
        } catch (BLLException e) {
            e.printStackTrace();
        }

    }
}
