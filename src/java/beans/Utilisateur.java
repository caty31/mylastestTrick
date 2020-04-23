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
public class Utilisateur {

    //variables de classe
    private String email;
    private String motDePasse;
    private Integer id;
    private String nom;
    private String prenom;
    private boolean on = true; 
    
    
    //constructeur
    public Utilisateur() {
        
    }

    public Utilisateur(String email, String motDePasse, Integer id, String nom, String prenom, boolean on) {
        this.email = email;
        this.motDePasse = motDePasse;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.on = on;
    }
    
    public Utilisateur(ResultSet set) {
        try {
            this.email = set.getString("emailMenbre");
            this.id = set.getInt("id");
            this.motDePasse = set.getString("motDePasse");
            this.nom = set.getString("nom");
            this.prenom = set.getString("prenom");
            this.on = set.getBoolean("statut");
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    //getters et setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
    
    
}
