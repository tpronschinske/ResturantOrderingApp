/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Travis
 */
public class MenuItems {
    
    public String [] appetizerMenu = {"Blooming Onion $9.50","Calamari $10.50","Mozzarella Sticks $12.50","Mushrooms $6.50","Zingin Wings $7.00","Pepper Rings $7.25","Fried Veggie Combo $9.95","Spinach and Artichoke Dip $7.95"};
    public String [] entreMenu = {"Grilled & Blackened Tilapia $19.99","New Your Strip Steak $22.45","Rack of Lamb $17.50","Chicken Caesar Salad $8.50","Cheeseburger $8.95","Swiss-Bacon Burger $9.55","Grilled Chicken Sandwich $8.75","The Prospect Ave Sandwich $9.50"};
    public String [] desertMenu = {"Deep Fried Cheese Cake $9.99","Banana Split $12.45","Deep Fried Ice Cream $5.00","Chocolate Mousse Cake $5.95","Turtle CheeseCake $4.50"};
    public String [] specialMenu = {"Half Rack BBQ Ribs $19.99","Filet Mignon $22.45","Lemon Pepper Salmon $24.50"};


    public MenuItems() {
    }

    public String[] getAppetizerMenu() {
        return appetizerMenu;
    }

    public void setAppetizerMenu(String[] appetizerMenu) {
        this.appetizerMenu = appetizerMenu;
    }

    public String[] getEntreMenu() {
        return entreMenu;
    }

    public void setEntreMenu(String[] entreMenu) {
        this.entreMenu = entreMenu;
    }

    public String[] getDesertMenu() {
        return desertMenu;
    }

    public void setDesertMenu(String[] desertMenu) {
        this.desertMenu = desertMenu;
    }

    public String[] getSpecialMenu() {
        return specialMenu;
    }

    public void setSpecialMenu(String[] specialMenu) {
        this.specialMenu = specialMenu;
    }


    
    
    
    
    
}