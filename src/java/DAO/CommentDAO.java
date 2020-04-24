/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Commentaire;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Will I Am
 */
public class CommentDAO extends DAO<Commentaire> {

    @Override
    public Commentaire find(Integer id) {

        Commentaire commentaire = null;
        try {
            String req = "SELECT * FROM Commentaire WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.first()) {
                commentaire = new Commentaire(
                        id,
                        result.getString("nom_menbre"),
                        result.getString("contenu"),
                        result.getBoolean("statut"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return commentaire;
    }

    @Override
    public void create(Commentaire uti) {
        try {
            String req = "INSERT INTO Utilisateur(nom_menbre, contenu, statut) VALUES (?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setString(1, uti.getNom_membre());
            pstmt.setString(2, uti.getContenu());
            pstmt.setBoolean(3, uti.isStatut());

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void update(Commentaire upt) {

        try {
            String req = "UPDATE Commentaire SET nom_menbre=?, contenu=?,statut=? WHERE id=?";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setString(1, upt.getNom_membre());
            pstmt.setString(2, upt.getContenu());
            pstmt.setBoolean(3, upt.isStatut());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String req = "DELETE FROM Commentaire WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Commentaire> findAll() {

        List<Commentaire> commentaires = new ArrayList();

        ResultSet res;

        try {
            Statement stmt = connection.createStatement();
            String req = "SELECT * FROM Utilisateur";
            res = stmt.executeQuery(req);

            while (res.next()) {
                Commentaire commentdao = new Commentaire(res);
                commentaires.add(commentdao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return commentaires;

    }
}
