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
public class MenuService {
    
    private final IMenuItemDAO menuDao;
    
    
    public MenuService() {
      
        DatabaseAccess db = new DB_MySQL();
        menuDao = new MenuItemDAO(db);
    }
    
    public List<MenuItem> getAllMenuItems() throws DataAccessException {
        return menuDao.getAllMenuItems();
    }
    
    public List<MenuItem> getMenuItemsByCategory(String category) throws DataAccessException {      
        return menuDao.getMenuItemsByCategory(category);
    }
        
    }
    
    
    
