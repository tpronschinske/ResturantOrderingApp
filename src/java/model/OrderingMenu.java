/* * To change this license header, choose License Headers in Project Properties.
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
    public double [] appetizerPrices = {9.99,12.45,14.50};
    public String [] entreMenu = {"Grilled & Blackened Tilapia","New Your Strip Steak","Rack of Lamb"};
    public double [] entrePrices = {19.99,22.45,17.50};
    public String [] desertMenu = {"Deep Fried Cheese Cake","Banana Split"};
    public double [] desertPrices = {9.99,12.45};
    public String [] specialMenu = {"Half Rack BBQ Ribs","Filet Mignon","Lemon Pepper Salmon"};
    public double [] specialPrices = {19.99,22.45,24.50};

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

    public double[] getAppetizerPrices() {
        return appetizerPrices;
    }

    public void setAppetizerPrices(double[] appetizerPrices) {
        this.appetizerPrices = appetizerPrices;
    }

    public double[] getEntrePrices() {
        return entrePrices;
    }

    public void setEntrePrices(double[] entrePrices) {
        this.entrePrices = entrePrices;
    }

    public double[] getDesertPrices() {
        return desertPrices;
    }

    public void setDesertPrices(double[] desertPrices) {
        this.desertPrices = desertPrices;
    }

    public double[] getSpecialPrices() {
        return specialPrices;
    }

    public void setSpecialPrices(double[] specialPrices) {
        this.specialPrices = specialPrices;
    }
    
    
    
    
    
}
