/* * To change this license header, chose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Objects;

/**
 *
 * @author Travis
 */
public class MenuItem {
    private Long id;
    private String itemName;
    private String itemPrice;
    private String category;

    
    public MenuItem() {
    }
    
    public MenuItem(String itemName, String itemPrice, String category) {
        this.itemPrice = itemPrice;
        this.itemName = itemName;
        this.category = category;
    }

    public MenuItem(Long id, String itemName, String itemPrice, String category) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.category = category;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuItem other = (MenuItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "id=" + id + ", itemName=" + itemName + ", itemPrice=" + itemPrice + '}';
    }

   
    
    
    
    
    
    
}
