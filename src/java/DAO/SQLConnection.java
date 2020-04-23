/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Will I Am
 */

public class SQLConnection {

    private static Connection connection;
    
    //contructeur par defaut en privé pour empécher de créer une nouvelle
    //connection via le constructeur

    private SQLConnection() {
    }
    
    
    //fonction de connection à la database avec un fichier properties
    public static final Connection getInstance() {
        if (connection == null) {
            try (InputStream in = SQLConnection.class.getResourceAsStream("/ressources/config.properties")) {
                Properties config = new Properties();
                config.load(in);
                String url = "jdbc:" + config.getProperty("sgbd") + "://"
                        + config.getProperty("host")
                        + ":" + config.getProperty("port")
                        + "/" + config.getProperty("database");
                connection = DriverManager.getConnection(url, config);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | SQLException ex) {
                Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return connection;
    }
    
    
}