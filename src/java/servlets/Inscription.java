/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Utilisateur;
import forms.InscriptionCheckForm;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Will I Am
 */
@WebServlet(name = "Inscription", urlPatterns = {"/inscription"})
public class Inscription extends HttpServlet {

    /* Des constantes */
    private static final String ATT_FORM = "form";
    private static final String ATT_USER = "utilisateur";
    public static final String VUE = "/WEB-INF/inscription.jsp";

    /* Requête GET sur notre formulaire => affichage du formulaire */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher(VUE).forward(
                request, response);
    }

    /* Soumission du formulaire => réception et contrôle des données */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        InscriptionCheckForm form = new InscriptionCheckForm();
        /*
 * Appel au traitement et à la validation de la requête, et
récupération
 * du bean en résultant
         */
        Utilisateur utilisateur = form.checkForm(request);
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_USER, utilisateur);
        this.getServletContext().getRequestDispatcher(VUE).forward(
                request, response);
    }
}
