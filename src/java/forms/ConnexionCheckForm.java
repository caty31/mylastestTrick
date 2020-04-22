/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import beans.Utilisateur;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Will I Am
 */
public class ConnexionCheckForm {

    private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASS = "motdepasse";
    private String resultat;
    private final Map<String, String> erreurs = new HashMap<>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Utilisateur checkForm(HttpServletRequest request) {
        /* Récupération des champs du formulaire */
        String email = getValeurChamp(request, CHAMP_EMAIL);
        String motDePasse = getValeurChamp(request, CHAMP_PASS);
        Utilisateur utilisateur = new Utilisateur();
        /* Validation du champ email. */
        try {
            validationEmail(email);
        } catch (Exception e) {
            setErreur(CHAMP_EMAIL, e.getMessage());
        }
        utilisateur.setEmail(email);
        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse(motDePasse);

        } catch (Exception e) {
            setErreur(CHAMP_PASS, e.getMessage());
        }
        utilisateur.setMotDePasse(motDePasse);
        /* Initialisation du résultat global de la validation. */
        if (erreurs.isEmpty()) {
            resultat = "Succès de la connexion.";
        } else {
            resultat = "Échec de la connexion.";
        }
        return utilisateur;
    }

    // Validation de  l'adresse email saisie.
    private void validationEmail(String email) throws Exception {
        if (email == null) {
            throw new Exception("vous devez saisir une adresse mail.");
        } else if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)"
        )) {
            throw new Exception("Merci de saisir une adresse mail valide.");
        }
    }

    //  Validation du mot de passe saisi.
    private void validationMotDePasse(String motDePasse) throws Exception {

        if (motDePasse != null) {
            if (motDePasse.length() < 3 || motDePasse.length() > 8) {
                throw new Exception("Le mot de passe doit contenir entre 3 et 8 carracteres.");

            }
        } else {
            throw new Exception("Merci de saisir votre mot de passe.");
        }
    }

    /*
 * Ajoute un message correspondant au champ spécifié à la map des
erreurs.
     */
    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
    }

    /*
 * Méthode utilitaire qui retourne null si un champ est vide, et son
contenu
 * sinon.
     */
    private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);

        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur;
        }
    }
}
