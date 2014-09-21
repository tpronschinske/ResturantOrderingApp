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
public class TipCalculator {
    
    BillCalculator bc = new BillCalculator();
    public double billTotal = 0.0;
    public double totalPlusTip = 0.0;
   
    public TipCalculator(){
    }

    public TipCalculator(String tip){
        double stringToDouble = Double.parseDouble(tip);
        billTotal = bc.getFinalCalculateBillTotal();
        totalPlusTip = stringToDouble + billTotal;
    }
    
    public BillCalculator getBc() {
        return bc;
    }

    public void setBc(BillCalculator bc) {
        this.bc = bc;
    }

    public double getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(double billTotal) {
        this.billTotal = billTotal;
    }

    public double getTotalPlusTip() {
        return totalPlusTip;
    }

    public void setTotalPlusTip(double totalPlusTip) {
        this.totalPlusTip = totalPlusTip;
    }
    
    
    
}
