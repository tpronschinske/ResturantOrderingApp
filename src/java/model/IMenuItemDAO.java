/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import java.util.List;

/**
 *
 * @author Travis
 */
public interface IMenuItemDAO {
   
    public abstract void save(MenuItem menu) throws DataAccessException;
    
    public abstract void deleteMenuItem(MenuItem menuItem) throws DataAccessException;
    
    public abstract List<MenuItem> getAllMenuItems() throws DataAccessException;

    public abstract DatabaseAccess getDb();

    public abstract void setDb(DatabaseAccess db);
    
    public List<MenuItem> getMenuItemsByCategory(String category)throws DataAccessException; 


}
