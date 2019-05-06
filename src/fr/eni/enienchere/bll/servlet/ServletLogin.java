package fr.eni.enienchere.bll.servlet;

import com.sun.istack.NotNull;
import fr.eni.enienchere.EnchereException;
import fr.eni.enienchere.bll.UserManager;
import fr.eni.enienchere.bll.exception.BLLException;
import fr.eni.enienchere.bo.User;
import fr.eni.enienchere.dal.exception.DALException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User utilisateurLog = null;
        String identifiant = request.getParameter("email");
        String motDePasse = request.getParameter("password");
        UserManager utilMana = null;
        try {
            utilMana = new UserManager();
        } catch (BLLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();

        try {
            utilisateurLog = requireNonNull(utilMana).selectUser(identifiant);
        } catch (EnchereException e) {
            e.printStackTrace();
            @NotNull
            String motDePasseUser = utilisateurLog.getPassword();


            if (utilisateurLog == null || !motDePasseUser.equals(motDePasse)) {

                session.setAttribute("erreur", "Login ou Password incorrect");
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);

            } else if (utilisateurLog != null && motDePasseUser.equals(motDePasse)) {

                session.setAttribute("isConnected", true); //récupération
                session.setAttribute("actualUser", identifiant);
                session.setAttribute("idUser", utilisateurLog.getIdUser());
                session.setAttribute("succes", "Vous êtes connecté");
                session.setAttribute("credit", utilisateurLog.getMoney());
                response.sendRedirect(request.getContextPath() + "/index");

            }

        }
    }

        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            HttpSession session = request.getSession();

            //recuperation des variables session

            if (session.getAttribute("isConnected") == null) {
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/index");
            }


        }
    }