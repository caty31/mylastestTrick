/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Will I Am
 * @param <T>
 */
public abstract class DAO<T> {
    
    protected Connection connection = SQLConnection.getInstance();

    
    //fonction de recherche dans la table
    public abstract T find(Integer id);
    
    
    //fonction permettant de creer un inscrit
    public abstract void create(T uti);
    
    //permet de mettre à jour les données dans la database
    public abstract void update(T upt);
    
    //permet de supprimer des données de la database
    public abstract void delete(Integer id);
    
    //permet de récupérer toutes les données de la database
    public abstract List<T> findAll();
}
