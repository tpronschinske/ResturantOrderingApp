/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Travis
 */
public class BillCalculator {

    private double finalBill = 0.0;
    private double finalCalculateBillTotal = 0.0;
    private double calculateBillTax = 0.0;
    private double roundedTax = 0.0;
    private double billTotalPlusTax = 0.0;       
            
            
    public BillCalculator(List<String> list , String billFormat){
         String formatForBill = list.toString()
        .replace(",", "")  //remove the commas
        .replace("[", "")  //remove the right bracket
        .replace("]", "")  //remove the left bracket
        .trim();         
        
        for (Iterator<String> it = list.iterator(); it.hasNext();) {
            String element = it.next();
            if ("null".equals(element)) {
                it.remove();
            }
        }
        
        List<Double> bill = new ArrayList<>();
        String billItems = formatForBill;
        
        /* pulls out the double values from the string and adds them to the array*/
        String expression = "(?!=\\d\\.\\d\\.)([\\d.]+)";
        Matcher matcher = Pattern.compile(expression).matcher(billItems);
        while (matcher.find()) {
            String doubleAsString = matcher.group();
            finalBill = Double.valueOf(doubleAsString);
            bill.add(finalBill); 
        }
        
        double calculateBill = 0.0;
        for(int i = 0; i < bill.size(); i++){
            calculateBill = calculateBill + bill.get(i);         
        }
        
        finalCalculateBillTotal = (double)(Math.round(calculateBill * 100))/ 100.00;
        calculateBillTax = (calculateBill * 1.055) - calculateBill;
        roundedTax = (double)(Math.round(calculateBillTax * 100))/ 100.00;
        billTotalPlusTax = (double)(Math.round((finalCalculateBillTotal + roundedTax) * 100)) / 100.00;
        
    }

    public BillCalculator() {
        
    }

    public double getFinalBill() {
        return finalBill;
    }

    public void setFinalBill(double finalBill) {
        this.finalBill = finalBill;
    }

    public double getFinalCalculateBillTotal() {
        return finalCalculateBillTotal;
    }

    public void setFinalCalculateBillTotal(double finalCalculateBillTotal) {
        this.finalCalculateBillTotal = finalCalculateBillTotal;
    }

    public double getCalculateBillTax() {
        return calculateBillTax;
    }

    public void setCalculateBillTax(double calculateBillTax) {
        this.calculateBillTax = calculateBillTax;
    }

    public double getRoundedTax() {
        return roundedTax;
    }

    public void setRoundedTax(double roundedTax) {
        this.roundedTax = roundedTax;
    }

    public double getBillTotalPlusTax() {
        return billTotalPlusTax;
    }

    public void setBillTotalPlusTax(double billTotalPlusTax) {
        this.billTotalPlusTax = billTotalPlusTax;
    }
    
    
    
}
