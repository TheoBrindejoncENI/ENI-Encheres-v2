package fr.eni.enienchere.servlet;

import fr.eni.enienchere.bll.ArticleManager;
import fr.eni.enienchere.bll.CategoryManager;
import fr.eni.enienchere.bll.ProfileManager;
import fr.eni.enienchere.bll.exception.BLLException;
import fr.eni.enienchere.bo.Article;
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

@WebServlet("/articleList")
public class ServletShowArticleList extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArticleManager am = new ArticleManager();
            List<Article> articles = am.selectAllArticle();
            request.setAttribute("articles", articles);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/showArticleList.jsp");
            rd.forward(request, response);

        } catch (BLLException e) {
            e.printStackTrace();
        }
    }
}
