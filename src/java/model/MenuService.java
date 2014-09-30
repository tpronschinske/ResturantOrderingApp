/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import controller.MainController;
import java.util.ArrayList;
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

//    public MenuItem getMenuItemsByCategory(String category)throws DataAccessException {
//        return menuDao.getMenuItemsByCategory(category);
//    }
     
    public static void main(String[] args) throws DataAccessException {
        MenuService rms = new MenuService();
        
      List<String> orderedItems = new ArrayList<>();
        try {
            orderedItems.add(rms.getAllMenuItems().toString());
            } 
        catch (DataAccessException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
  
//        /* formats array items - used for output on the order - page */
//        String formatString = orderedItems.toString()
//        .replace(",", "")  //remove the commas
//        .replace("[", "")  //remove the right bracket
//        .replace("]", "")  //remove the left bracket
//        .replace("=", "")
//        .replace("id", "")
//        .replace("itemPrice", "")
//        .replace("itemName", "")
//        .trim();           //remove trailing spaces from partially initialized
//  
//        System.out.println(formatString);
        // for converting decimal from database
//        BigDecimal bg = new BigDecimal();
//        bg.doubleValue();
        
        
    }
    
    
    
}
