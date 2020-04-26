/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import beans.Post;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 *
 */
public class PostCheckForm {

    //variables de classes
    private static final String CHAMP_NOM = "nom_membre";
    private static final String CHAMP_VIDEO = "nom_video";
    private static final String CHAMP_DESCR = "description";
    // L'ATTRIBUT RESULTAT
    private String resultat;
    private final Map<String, String> erreurs = new HashMap<>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    // La méthode centrale contenant la logique de validation :

    public Post checkForm(HttpServletRequest request) {
        String nom_menbre = getValeurChamp(request, CHAMP_NOM);
        String nom_video = getValeurChamp(request, CHAMP_VIDEO);
        String description = getValeurChamp(request, CHAMP_DESCR);

        // VALIDATION DES CHAMPS
        Post post = new Post();
        try {
            validationNom(nom_menbre);
        } catch (Exception e) {
            setErreur(CHAMP_NOM, e.getMessage());
        }
        post.setNom_membre(nom_menbre);

        try {
            validationVideo(nom_video);
        } catch (Exception e) {
            setErreur(CHAMP_VIDEO, e.getMessage());
        }
        post.setNom_video(nom_video);

        try {
            validationDescription(description);
        } catch (Exception e) {
            setErreur(CHAMP_DESCR, e.getMessage());
        }
        post.setDescription(description);

        // resultat
        if (erreurs.isEmpty()) {
            resultat = "Votre video a bien été telechargé.";
        } else {
            resultat = "Échec de telechargement.";
        }
        return post;

    }
    // MES METHODES

    private String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur.trim();
        }
    }

    private void validationNom(String nom_menbre) throws Exception {
        if (nom_menbre != null && nom_menbre.length() < 3) {
            throw new Exception("votre nom doit etre celui renseigné lors de votre inscription.");
        }
    }

    private void validationVideo(String nom_video) throws Exception {
        if (nom_video != null && nom_video.length() < 1) {
            throw new Exception("Veuillez saisir un nom pour votre video.");
        }
    }

    private void validationDescription(String description) throws Exception {

        if (description != null && description.length() < 3) {
            throw new Exception("Veuillez ecrire une briève description de votre video.");
        }
    }

    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
    }

}
