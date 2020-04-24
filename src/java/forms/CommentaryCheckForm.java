/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import beans.Commentaire;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Will I Am
 */
public class CommentaryCheckForm {
    // variables statiques

    private static final String CHAMP_NOM = "nom_membre";
    private static final String CHAMP_CONT = "contenu";

    //Les attributs resultat et erreurs et leurs accesseurs pour pouvoir les utiliser avec les EL dans la vue :
    private String resultat;
    private final Map<String, String> erreurs = new HashMap<>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    // La méthode centrale contenant la logique de validation du commentaire :

    public Commentaire checkForm(HttpServletRequest request) {
        String nom_menbre = getValeurChamp(request, CHAMP_NOM);
        String contenu = getValeurChamp(request, CHAMP_CONT);
        // validation du champ commentaire
        Commentaire commentaire = new Commentaire();
        try {
            validationNom_menbre(nom_menbre);
        } catch (Exception e) {
            setErreur(CHAMP_NOM, e.getMessage());
        }
        commentaire.setNom_membre(nom_menbre);
        try {
            validationContenu(contenu);
        } catch (Exception e) {
            setErreur(CHAMP_CONT, e.getMessage());
        }
        commentaire.setContenu(contenu);
        /* Initialisation du résultat global de la validation du commentaire. */
        if (erreurs.isEmpty()) {
            resultat = "Votre commentaire a été envoyé.";
        } else {
            resultat = "Votre commentaire n'a pas été envoyé.";
        }
        return commentaire;

        // le smethodes pour envoyer un commentaire
    }

    private String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur.trim();
        }
    }

    private void validationNom_menbre(String nom_menbre) throws Exception {
        if (nom_menbre != null && nom_menbre.length() < 2) {
            throw new Exception("vous devez ecrire au moins deux carractère.");
            // je me rends compte que cette methode ne sert pas a grand chose et peut etre suprimée
        }

    }

    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
    }

    private void validationContenu(String contenu) throws Exception {
        if (contenu != null && contenu.length() < 2) {
            throw new Exception("vous devez ecrire au moins deux carractère.");
        }
    }

}
