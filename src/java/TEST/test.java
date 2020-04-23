/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TEST;

import DAO.UserDAO;
import beans.Utilisateur;

/**
 *
 * @author Will I Am
 */
public class test {

    public static void main(String[] args) {
        
        
        UserDAO udao = new UserDAO();
        
        udao.create(new Utilisateur("dessinanime@gmail.com",
                "Tartantion", null, "Martin", "Matin", true));
        /*
        Utilisateur u1 = udao.find(4);
        u1.setOn(false);
        udao.update(u1);
        
        udao.delete(1);
        */
        
    }
}
