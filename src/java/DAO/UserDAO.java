/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import beans.Utilisateur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static util.hachage.hacher;

/**
 *
 * @author Will I Am
 */
public class UserDAO extends DAO<Utilisateur>{
    
    private final String TABLE = "Utilisateur";

    @Override
    public Utilisateur find(Integer id) {
        
        Utilisateur utilisateur = null;
        try {
            String req = "SELECT * FROM Utilisateur WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.first()) {
                utilisateur = new Utilisateur(
                        result.getString("emailMenbre"),
                        result.getString("motDePasse"),
                        id,
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getBoolean("statut"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return utilisateur;
    }

    @Override
    public void create(Utilisateur uti) {
        
        try {
            String req = "INSERT INTO Utilisateur(nom, prenom, motDePasse, emailMenbre) VALUES (?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setString(1, uti.getNom());
            pstmt.setString(2, uti.getPrenom());
            pstmt.setString(3, hacher(uti));
            pstmt.setString(4, uti.getEmail());
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Utilisateur upt) {
        
        try {
            String req = "UPDATE Utilisateur SET motDePasse=?, statut=? WHERE id=?";
        PreparedStatement pstmt = connection.prepareStatement(req);
        pstmt.setString(1, hacher(upt));
        pstmt.setBoolean(2, upt.isOn());
        pstmt.setInt(3, upt.getId());
        pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }  

    @Override
    public void delete(Integer id) {
        
        try {
            String req = "DELETE FROM Utilisateur WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Utilisateur> findAll() {
        
        List<Utilisateur> utilisateurs = new ArrayList();
        
        ResultSet res;
        
        try {
            Statement stmt = connection.createStatement();
            String req = "SELECT * FROM Utilisateur";
            res = stmt.executeQuery(req);
            
            while (res.next()) {
                Utilisateur userdao = new Utilisateur(res);
                utilisateurs.add(userdao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return utilisateurs;
    }

    
    
    public boolean find(String email, String mdp) {
        
        boolean bool = false;
        
        try {
            String req = "SELECT * FROM Utilisateur WHERE emailMenbre=? AND motDePasse=?";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setString(1, email);
            pstmt.setString(2, mdp);
            ResultSet result = pstmt.executeQuery();
            if (result.first()) {
                bool = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bool;
    }
    
}
