/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Will I Am
 */
public class Post {
    
    //variables de classes
    private Integer id;
    private String nom_membre;
    private String nom_video;
    private String description;
    private Integer note_globale;
    
    
    //constructeurs

    public Post() {
    }

    public Post(Integer id, String nom_membre, String nom_video, String description, Integer note_globale) {
        this.id = id;
        this.nom_membre = nom_membre;
        this.nom_video = nom_video;
        this.description = description;
        this.note_globale = note_globale;
    }
    
    public Post(ResultSet set) {
        try {
            this.id = set.getInt("id");
            this.nom_membre = set.getString("nomMenbre");
            this.nom_video = set.getString("nomVideo");
            this.description = set.getString("description");
            this.note_globale = set.getInt("noteGlobale");
        } catch (SQLException ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // getters et setters

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

    public String getNom_video() {
        return nom_video;
    }

    public void setNom_video(String nom_video) {
        this.nom_video = nom_video;
    }

    public Integer getNote_globale() {
        return note_globale;
    }

    public void setNote_globale(Integer note_globale) {
        this.note_globale = note_globale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

}
