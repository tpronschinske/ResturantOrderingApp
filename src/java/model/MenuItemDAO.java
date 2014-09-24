/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.awt.MenuItem;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Travis
 */
public class MenuItemDAO implements IMenuItemDAO{
    private static final String FIND_ALL_MENUITEMS =
            "SELECT * from MENUITEM";
    private static final String EMP_BY_DEPT_ID =
            "SELECT e.lastname, e.firstname, d.dept_name "
            + "FROM Employee e, Department d "
           + "WHERE e.dept_id = d.dept_id and d.dept_id = ";
           
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
                    "jdbc:mysql://localhost:3306/jsfshowcase",
                    "root", "admin");
        } catch (IllegalArgumentException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        }
    }

     private void openCampusDbConnection() throws DataAccessException {
        try {
            // Each time you perform a new query you must re-open the connection
            db.openConnection(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://bit.glassfish.wctc.edu:3306/jsfshowcase",
                    "advjava", "advjava");
        } catch (IllegalArgumentException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        }
    }


    @Override
    public void save(MenuItem mi) throws DataAccessException {
        this.openLocalDbConnection();
        
        String tableName = "MENUITEMS";
        List<String> fieldNames =
                new ArrayList<String>();
        fieldNames.add("ITEM");
        fieldNames.add("PRICE");

        List fieldValues =
                new ArrayList();
        //fieldValues.add();
       // fieldValues.add();
       

        try {
            // if the id is null, it's a new record, else it's an update
            if (mi.getId() == null) {
                db.insertRecord(
                        tableName, fieldNames,
                        fieldValues, true);
            } else {
                db.updateRecords(
                        tableName, fieldNames,
                        fieldValues, "ID", emp.getId(), true);
            }
        } catch (SQLException e1) {
            throw new DataAccessException(e1.getMessage(), e1);

        } catch (Exception e2) {
            throw new DataAccessException(e2.getMessage(), e2);
        }
    }

    /**
     * Delete an employee by entity.
     *
     * @param employee - the entity to be deleted.
     * @throws DataAccessException - if sql or I/O errors
     */
    @Override
    public void deleteMenuItem(MenuItem menuItem) throws DataAccessException {
        this.openLocalDbConnection();
        
        try {
            db.deleteRecords("Employee", "ID", menuItem.getId(), true);
        } catch (SQLException e1) {
            throw new DataAccessException(e1.getMessage(), e1);

        } catch (Exception e2) {
            throw new DataAccessException(e2.getMessage(), e2);
        }
    }

    /**
     * Retrieve all employee records and package the data up as a collection of
     * entity objects.
     *
     * @return - collection of entity objects
     * @throws DataAccessException - if sql or I/O errors
     */
    @Override
    public List<MenuItem> getAllMenuItems() throws DataAccessException {
        openLocalDbConnection();
//        openCampusDbConnection();        
        List<Map> rawData = new ArrayList<Map>();
        List<MenuItem> records = new ArrayList<MenuItem>();
        try {
            rawData = db.findRecords(FIND_ALL_MENUITEMS, true);
        } catch (SQLException e1) {
            throw new DataAccessException(e1.getMessage(), e1);

        } catch (Exception e2) {
            throw new DataAccessException(e2.getMessage(), e2);
        }

        MenuItem menuItem = null;

        // Translate List<Map> into List<Employee>
        for (Map m : rawData) {
            menuItem = new MenuItem();

            String id = m.get("ID").toString();
            menuItem.setId(new Long(id));
            String firstName = m.get("ITEMNAME").toString();
            menuItem.setFirstName(firstName);
            String lastName = m.get("PRICE").toString();
            menuItem.setLastName(lastName);
     
            records.add(menuItem);
        }

        return records;
    }

    /**
     * This method retrieves employee and department data using an sql join.
     * Because the data returned is combined from two database tables we cannot
     * convert the data directly into employee or department entities. Instead
     * we will use a custom "DTO (Data Transfer Object)" class whose job it is
     * to consolidate the data from the two tables.
     *
     * @param id - the department id
     * @return a DTO containing the consolidated data from the join query
     * @throws DataAccessException - if sql or I/O errors
     
    @Override
    public List<EmployeeDeptDTO> getEmployeeByDeptId(String id) throws DataAccessException {
        this.openLocalDbConnection();
        
        List<Map> rawData = new ArrayList<Map>();
        List<EmployeeDeptDTO> records = new ArrayList<EmployeeDeptDTO>();
        try {
            rawData = db.findRecords(EMP_BY_DEPT_ID + id, true);
        } catch (SQLException e1) {
            throw new DataAccessException(e1.getMessage(), e1);

        } catch (Exception e2) {
            throw new DataAccessException(e2.getMessage(), e2);
        }

        EmployeeDeptDTO dto = null;

        // Translate List<Map> into List<Employee>
        for (Map m : rawData) {
            dto = new EmployeeDeptDTO();
            String firstName = m.get("FIRSTNAME").toString();
            dto.setFirstName(firstName);
            String lastName = m.get("LASTNAME").toString();
            dto.setLastName(lastName);
            String deptName = m.get("dept_name").toString();
            dto.setDeptName(deptName);
            records.add(dto);
        }

        return records;
    }
*/
    /**
     * Finds an employee entity by its id.
     *
     * @param id - the primary key
     * @return the entity object
     * @throws DataAccessException - if sql or I/O errors
     */
    @Override
    public MenuItem findEmployeeById(String id) throws DataAccessException {
        this.openLocalDbConnection();
        
        Map rec;
        try {
            rec = db.getRecordByID("MENUITEM", "ID", new Long(id), true);
        } catch (SQLException e1) {
            throw new DataAccessException(e1.getMessage(), e1);

        } catch (Exception e2) {
            throw new DataAccessException(e2.getMessage(), e2);
        }

        MenuItem menuItem = new menuItem();
        menuItem.setId(new Long(rec.get("ID").toString()));
        menuItem.setFirstName(rec.get("ITEMNAME").toString());
        menuItem.setLastName(rec.get("PRICE").toString());
     

        return menuItem;
    }

    @Override
    public DatabaseAccess getDb() {
        return this.db;
    }

    @Override
    public void setDb(DatabaseAccess db) {
        this.db = db;
    }





    
}
