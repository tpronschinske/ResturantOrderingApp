/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Travis
 */
public class OrderingMenu {
    
    public String [] appetizerMenu = {"Blooming Onion","Pan Fried Calamari with Peppers and Chipotle Sauce","Mozzarella Sticks with Marinara Sauce"};
    public String [] entreMenu = {"Grilled & Blackened Tilapia","New Your Strip Steak","Rack of Lamb"};
    public String [] desertMenu = {"Deep Fried Cheese Cake","Banana Split"};
    public String [] specialMenu = {"Half Rack BBQ Ribs","Filet Mignon","Lemon Pepper Salmon"};

    public OrderingMenu() {
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
