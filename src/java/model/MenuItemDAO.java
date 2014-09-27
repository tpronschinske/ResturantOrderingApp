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
        List<String> fieldNames = new ArrayList<>();
        fieldNames.add("ITEMNAME");
        fieldNames.add("ITEMPRICE");

        List fieldValues = new ArrayList();
        fieldValues.add(menu.getId());
        fieldValues.add(menu.getItemName());
        fieldValues.add(menu.getItemPrice());

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
        List<MenuItem> records = new ArrayList<>();
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
            
            String id = m.get("ID").toString();
            menuItem.setId(new Long(id));
            
            String itemName = m.get("ITEMNAME").toString();
            menuItem.setItemName(itemName);
            
            String price = m.get("PRICE").toString();
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
    
    // Test harness only -- remove in production version
    public static void main(String[] args) throws Exception {
        MenuItemDAO dao = new MenuItemDAO (new DB_MySQL());

        // Test get all menu items...
        List<MenuItem> records = dao.getAllMenuItems();

        System.out.println("Found Menu records...\n");
          for (MenuItem menuItem : records) {
            System.out.println(menuItem);
        }



    }
    
}