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
public class RestaurantMenuService {
    
    private IMenuItemDAO menuDao;

    
    public RestaurantMenuService() {
        DatabaseAccess db = new DB_MySQL();
        menuDao = new MenuItemDAO(db);
    }
    
    public List<MenuItem> getAllMenuItems() throws DataAccessException {
        return menuDao.getAllMenuItems();
    }

//    public MenuItem getMenuItemsByCategory(String category)throws DataAccessException {
//        return menuDao.getMenuItemsByCategory(category);
//    }
     
//    public static void main(String[] args) throws DataAccessException {
//        RestaurantMenuService rm = new RestaurantMenuService();
//        
//        System.out.println("ALL MENU ITEMS");
//        System.out.println(rm.getAllMenuItems());
//        
//        System.out.println("CATEGORY ITEMS");
//        rm.getMenuItemsByCategory("Drink");
////        
//        
//    }
//    
}
