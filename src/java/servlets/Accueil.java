/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author stag
 */
@WebServlet(name = "Accueil", urlPatterns = {"/Accueil"})
public class Accueil extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    public static final int TAILLE_TAMPON = 10240;
    public static final String CHEMIN_FICHIER = "/home/stag/Documents/JAVA_JSE/ProjetJEE/videos";
    private static final String VUE = "/WEB-INF/accueil.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/accueil.jsp")
                    .forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher(VUE).forward(request,
                response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //on recupere le champ description
        String description = request.getParameter("description");
        request.setAttribute("description", description);
        
        //on récupère le champ fichier
        Part part = request.getPart("video");
        
        //on vérifie qu'on a bien reçu le fichier
        String nomFichier = getNomFichier(part);
        
        //si on a bien un fichier
        if(nomFichier != null && !nomFichier.isEmpty()) {
            String nomChamp = part.getName();
            //corrige un bug du fonctionnement internet explorer
            nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1).substring(nomFichier.lastIndexOf('\\') + 1);
            
            //on ecrit definitivement le fichier
            ecrireFichier(part, nomFichier, CHEMIN_FICHIER);
            
            request.setAttribute(nomChamp, nomFichier);
        }
        
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    private static String getNomFichier(Part part) {
        for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
            if (contentDisposition.trim().startsWith("filename")) {
                return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        
        return null;
    }
    
    
    private void ecrireFichier(Part part, String nomFichier, String chemin) throws IOException{
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        
        try {
            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);
            
            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        }finally {
            try {
                sortie.close();
            } catch (IOException ignore){   
            }
            try {
                entree.close();
            } catch (IOException ignore){ 
            }
        }
    }

}
