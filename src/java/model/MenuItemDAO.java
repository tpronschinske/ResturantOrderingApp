/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Travis
 */
public class MenuItemDAO implements IMenuItemDAO {
    private static final String FIND_ALL_MENUITEMS =
            "SELECT * FROM menu_item";
    private static final String FIND_ITEMS_BY_CATEGORY = "SELECT item_name, price FROM menu_item WHERE category = ";
    private DatabaseAccess db;

    public MenuItemDAO() {
    }

    public MenuItemDAO(DatabaseAccess db) {
        this.db = db;
    }

    private void openLocalDbConnection() throws DataAccessException {
        try {
            // Each time you perform a new query you must re-open the connection
            db.openConnection(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/restaurant",
                    "root", "admin");
        } catch (IllegalArgumentException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        }
    }
     
    @Override
    public void save(MenuItem menu) throws DataAccessException {
        this.openLocalDbConnection();
        
        String tableName = "MENUITEMS";
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("ITEMNAME");
        fieldNames.add("ITEMPRICE");
        fieldNames.add("CATEGORY");

        List fieldValues = new ArrayList();
        fieldValues.add(menu.getItemName());
        fieldValues.add(menu.getItemPrice());
        fieldValues.add(menu.getCategory());

        try {
            // if the id is null, it's a new record, else it's an update
            if (menu.getId() == null) {
                db.insertRecord(
                        tableName, fieldNames,
                        fieldValues, true);
            } else {
                db.updateRecords(
                        tableName, fieldNames,
                        fieldValues, "ID", menu.getId(), true);
            }
        } catch (SQLException e1) {
            throw new DataAccessException(e1.getMessage(), e1);

        } catch (Exception e2) {
            throw new DataAccessException(e2.getMessage(), e2);
        }
    }

    @Override
    public void deleteMenuItem(MenuItem menuItem) throws DataAccessException {
        this.openLocalDbConnection();
        
        try {
            db.deleteRecords("Menu Item", "ID", menuItem.getId(), true);
        } catch (Exception e2) {
            throw new DataAccessException(e2.getMessage(), e2);
        }
    }

    @Override
    public List<MenuItem> getAllMenuItems() throws DataAccessException {
        openLocalDbConnection();      
        List<Map> rawData = new ArrayList<>();
        List<MenuItem> records = new ArrayList<MenuItem>();
        try {
            rawData = db.findRecords(FIND_ALL_MENUITEMS, true);
        } catch (SQLException e1) {
            throw new DataAccessException(e1.getMessage(), e1);

        } catch (Exception e2) {
            throw new DataAccessException(e2.getMessage(), e2);
        }

        MenuItem menuItem = null;
        // Translate List<Map> into List<MenuItem>
        for (Map m : rawData) {
            menuItem = new MenuItem();
            
            String id = m.get("menu_item_id").toString();
            menuItem.setId(new Long(id));
            
            String itemName = m.get("item_name").toString();
            menuItem.setItemName(itemName);
            
            String price = m.get("price").toString();
            menuItem.setItemPrice(price);
     
            String category = m.get("category").toString();
            menuItem.setCategory(category);
            
            records.add(menuItem);
        }

        return records;
    }
    
    @Override
    public List<MenuItem> getMenuItemsByCategory(String category)throws DataAccessException {
       this.openLocalDbConnection();
        
        List<Map> rawData = new ArrayList<>();
        List<MenuItem> records = new ArrayList<>();
        
        try {
            rawData = db.findRecords(FIND_ITEMS_BY_CATEGORY + "'" + category + "'" , true);
        } catch (SQLException e1) {
            throw new DataAccessException(e1.getMessage(), e1);

        } catch (Exception e2) {
            throw new DataAccessException(e2.getMessage(), e2);
        }
        
        MenuItem menuItem = null;
        
        for(Map m : rawData){
            menuItem = new MenuItem();
           
            String itemName = m.get("item_name").toString();
            menuItem.setItemName(itemName);
            
            String price = m.get("price").toString();
            menuItem.setItemPrice(price);

            records.add(menuItem);
        }

        return records;
    }
 
    @Override
    public DatabaseAccess getDb() {
        return this.db;
    }

    @Override
    public void setDb(DatabaseAccess db) {
        this.db = db;
    }

//    public static void main(String[] args) throws Exception {
//        MenuItemDAO dao = new MenuItemDAO (new DB_MySQL());
//        List<MenuItem> drinks = dao.getMenuItemsByCategory("drink");
//        for(int i = 0; i < drinks.size(); i++){
//            System.out.println(drinks.get(i).itemName);
//        }
//        
//        List<MenuItem> entree = dao.getMenuItemsByCategory("entree");
//        for(int i = 0; i < entree.size(); i++){
//            System.out.println(entree.get(i).itemName);
//        }
//    }
}
