/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import DAO.UserDAO;
import beans.Utilisateur;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Will I Am
 */
public class InscriptionCheckForm {

    /* Des constantes */
    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASS = "motdepasse";
    private static final String CHAMP_CONF = "confirmation";
    private static final String CHAMP_NOM = "nom";
    private static final String CHAMP_PRENOM = "prenom";

    //Les attributs resultat et erreurs et leurs accesseurs pour pouvoir les utiliser avec les EL dans la vue :
    private String resultat;
    private final Map<String, String> erreurs = new HashMap<>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    // La méthode centrale contenant la logique de validation :

    public Utilisateur checkForm(HttpServletRequest request) {
        
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(InscriptionCheckForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String email = getValeurChamp(request, CHAMP_EMAIL);
        String motDePasse = getValeurChamp(request, CHAMP_PASS);
        String confirmation = getValeurChamp(request, CHAMP_CONF);
        String nom = getValeurChamp(request, CHAMP_NOM);
        String prenom = getValeurChamp(request, CHAMP_PRENOM);

        
        // validation du champs utilisateurs
        Utilisateur utilisateur = new Utilisateur();
        
     
        //validation du champ email
        try {
            validationEmail(email);
        } catch (Exception e) {
            erreurs.put(CHAMP_EMAIL, e.getMessage());
        }
        utilisateur.setEmail(email);
        
        
        //validation du mot de passe
        try {
            validationMotsDePasse(motDePasse, confirmation);
        } catch (Exception e) {
            erreurs.put(CHAMP_PASS, e.getMessage());
            erreurs.put(CHAMP_CONF, null);
        }
        utilisateur.setMotDePasse(motDePasse);
        
      
        //validation du nom
        try {
            validationNom(nom);
        } catch (Exception e) {
            erreurs.put(CHAMP_NOM, e.getMessage());
        }
        utilisateur.setNom(nom);
        
        
        //validation du prenom
        try {
            validationPrenom(prenom);
        } catch (Exception e) {
            erreurs.put(CHAMP_PRENOM, e.getMessage());
        }
        utilisateur.setPrenom(prenom);
        
     
        //verification du resultat des test
        if (erreurs.isEmpty()) {
            resultat = "Succès de l'inscription.";
            UserDAO udao = new UserDAO();
            udao.create(utilisateur);
            System.out.println(utilisateur);
        } else {
            resultat = "Échec de l'inscription.";
        }
        return utilisateur;

    }

    // mes methodes
    // validation email
    private void validationEmail(String email) throws Exception {
        if (email != null) {
            if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                throw new Exception("Merci de saisir une adresse mail valide."
                );
            }
        } else {
            throw new Exception("Merci de saisir une adresse mail.");
        }
    }
    
    
    // validation mot de passe
    private void validationMotsDePasse(String motDePasse, String confirmation
    )
            throws Exception {
        if (motDePasse != null  && motDePasse.length() !=0 && confirmation != null) {
            if (!motDePasse.equals(confirmation)) {
                throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
            } else if (motDePasse.length() < 5) {
                throw new Exception("Les mots de passe doivent contenir au moins 5 caractères.");
            }
        } else {
            throw new Exception("Merci de saisir et confirmer votre mot depasse.");
        }
    }
    
    
    // validation nom
    private void validationNom(String nom) throws Exception {
        if (nom != null && nom.length() < 3) {
            throw new Exception("Remplisser un nom d'au moins 3 carractères.");
        }
    }
    
    
    // validation prenom
    private void validationPrenom(String prenom) throws Exception {
        if (prenom != null && prenom.length() < 3) {
            throw new Exception("Remplisser un prenom d'au moins 3 carractères.");
        }
    }

    
    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
    }

    private String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}
