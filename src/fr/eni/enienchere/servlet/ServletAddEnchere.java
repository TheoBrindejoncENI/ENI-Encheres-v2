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
import java.time.LocalDate;
import java.util.List;

@WebServlet("/createEnchere")
public class ServletAddEnchere extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CategoryManager cm = new CategoryManager();
            ProfileManager pm = new ProfileManager();
            ArticleManager am = new ArticleManager();
            HttpSession session = request.getSession();
            Article article = new Article();

            if (session.getAttribute("utilisateurConnecte") == null) {
                session.setAttribute("lastUrl", "/createEnchere");
                RequestDispatcher rd = request.getRequestDispatcher("/login");
                rd.forward(request, response);
            } else {

                User user = pm.selectUserProfile((long) session.getAttribute("noUser"));
                Category category = cm.selectCategoryById(Long.parseLong(request.getParameter("category")));

                article.setTitle(request.getParameter("title"));
                article.setDescription(request.getParameter("description"));
                article.setCategory(category);
                article.setDescription(request.getParameter("description"));
                article.setAuctionStartDate(LocalDate.parse(request.getParameter("auctionStartDate")));
                article.setAuctionEndDate(LocalDate.parse(request.getParameter("auctionEndDate")));
                article.setInitPrice(Integer.parseInt(request.getParameter("initPrice")));
                article.setUser(user);

                am.insertArticle(article);
                RequestDispatcher rd = request.getRequestDispatcher("/myArticle");
                rd.forward(request, response);
            }

        } catch (BLLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("utilisateurConnecte") == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/login");
            rd.include(request, response);
        } else {
            try {
                CategoryManager cm = new CategoryManager();
                List<Category> categories = cm.selectAllCategory();
                request.setAttribute("category", categories);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/createEnchere.jsp");
                rd.forward(request, response);
            } catch (BLLException e) {
                e.printStackTrace();
            }
        }
    }
}
