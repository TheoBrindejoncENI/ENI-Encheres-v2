package fr.eni.enienchere.servlet;

import fr.eni.enienchere.bll.UserManager;
import fr.eni.enienchere.bll.exception.BLLException;
import fr.eni.enienchere.bo.User;
import fr.eni.enienchere.dal.exception.DALException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.List;


@WebServlet("/login")
public class ServletLogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String identifiant = request.getParameter("identifiant").trim();
        final String motDePasse = request.getParameter("password").trim();

        UserManager um = null;
        try {
            um = new UserManager();
        } catch (BLLException e) {
            e.printStackTrace();
        }

        List<User> listeUtilisateur = null;
        try {
            assert um != null;
            listeUtilisateur = um.selectAllUser();
        } catch (DALException e) {
            e.printStackTrace();
        }
        Long noUser=0l;
        boolean identifiantExiste = false;
        boolean motDePasseCorrect = false;

        // vérification de l'existence de l'utilisateur dans la BDD + vérification de la
        // conformité de son mdp
        assert listeUtilisateur != null;
        for (User user : listeUtilisateur) {

            if (user.getEmail().equals(identifiant) || user.getUserName().equals(identifiant)) {

                identifiantExiste = true;
            }

            if (identifiantExiste) {

                if (user.getPassword().equals(motDePasse)) {

                    motDePasseCorrect = true;
                    noUser = user.getIdUser();
                    HttpSession session = request.getSession();
                    Boolean utilisateurConnecte = true;
                    session.setAttribute("noUser", noUser);
                    session.setAttribute("utilisateurConnecte", utilisateurConnecte);
                    session.setAttribute("sessionUser", user);
                    doGet(request,response);

                    break;
                }

            }
        }

        // affichage d'une erreur si l'identifiant ou le mdp sont incorrects
        if (!identifiantExiste || !motDePasseCorrect) {

            String erreur = "Erreur : identifiant ou mot de passe incorrect";
            request.setAttribute("erreur", erreur);
            doGet(request,response);

        }
    }


        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            HttpSession session = request.getSession();

            //recuperation des variables session

            if (session.getAttribute("utilisateurConnecte") == null) {
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            } else {
                if (session.getAttribute("lastUrl") == null) {
                    response.sendRedirect(request.getContextPath()+ "/home");
                } else {
                    response.sendRedirect(request.getContextPath()+ session.getAttribute("lastUrl"));
                }
            }

        }
    }