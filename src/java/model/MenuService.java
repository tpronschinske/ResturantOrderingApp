/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import controller.MainController;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Travis
 */
public class MenuService {
    
    private IMenuItemDAO menuDao;

    
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




                
        // for converting decimal from database
//        BigDecimal bg = new BigDecimal();
//        bg.doubleValue();
        
        
    }
    
    
    
