/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import beans.Post;
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
public class PostDAO extends DAO<Post>{
    
    private final String TABLE = "Post";


    @Override
    public Post find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Post uti) {
        
        try {
            String req = "INSERT INTO Post(nomMenbre, nomVideo, description) VALUES (?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setString(1, uti.getNom_membre());
            pstmt.setString(2, uti.getNom_video());
            pstmt.setString(3, uti.getDescription());
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Post upt) {
        
        try {
            String reg = "UPDATE Post SET nomVideo=?, description=? WHERE id=?";
            PreparedStatement pstmt = connection.prepareStatement(reg);
            pstmt.setString(1, upt.getNom_video());
            pstmt.setString(2, upt.getDescription());
            
            pstmt.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String req = "DELETE FROM Post WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(req);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Post> findAll() {
        
    List<Post> posts = new ArrayList();
        
        ResultSet res;
        
        try {
            Statement stmt = connection.createStatement();
            String req = "SELECT * FROM Post";
            res = stmt.executeQuery(req);
            
            while (res.next()) {
                Post postdao = new Post(res);
                posts.add(postdao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return posts;    }

}
