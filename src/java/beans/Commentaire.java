/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.ResultSet;

/**
 *
 * @author Will I Am
 */
public class Commentaire {

    //variables de classes
    private Integer id;
    private String nom_membre;
    private String contenu;
    private boolean statut;

    //constructeurs
    public Commentaire() {
    }

    public Commentaire(Integer id, String nom_membre, String contenu, boolean statut) {
        this.id = id;
        this.nom_membre = nom_membre;
        this.contenu = contenu;
        this.statut = statut;
    }

    public Commentaire(ResultSet res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom_membre() {
        return nom_membre;
    }

    public void setNom_membre(String nom_membre) {
        this.nom_membre = nom_membre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

}
