/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Travis
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    } // </editor-fold>

    //DAO - Data Access Object
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        String RESULT_PAGE = "order-page.jsp";
        double finalBill = 0;
        
        String[] appetizerItem = request.getParameterValues("item");
        String[] entreeItem = request.getParameterValues("entree");
        String[] dessertItem = request.getParameterValues("dessert");
        String[] specialItem = request.getParameterValues("special");

        List<String> orderedItems = new ArrayList<>();
        
        orderedItems.add(Arrays.toString(appetizerItem));
        orderedItems.add(Arrays.toString(entreeItem));
        orderedItems.add(Arrays.toString(dessertItem));
        orderedItems.add(Arrays.toString(specialItem));
        for (Iterator<String> it = orderedItems.iterator(); it.hasNext();) {
            String element = it.next();
            if ("null".equals(element)) {
                it.remove();
            }
        }
        String formatString = orderedItems.toString()
        .replace(",", "<br>")  //remove the commas
        .replace("[", "")  //remove the right bracket
        .replace("]", "")  //remove the left bracket
        .trim();           //remove trailing spaces from partially initialized 
        
         String formatForBill = orderedItems.toString()
        .replace(",", "")  //remove the commas
        .replace("[", "")  //remove the right bracket
        .replace("]", "")  //remove the left bracket
        .trim();           //remove trailing spaces from partially initialized 
        
        List<Double> bill = new ArrayList<>();
        String billItems = formatForBill;
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
        double finalCalculateBillTotal = (double)(Math.round(calculateBill * 100))/ 100.00;
        double calculateBillTax = (calculateBill * 1.055) - calculateBill;
        double roundedTax = (double)(Math.round(calculateBillTax * 100))/ 100.00;
        double billTotalPlusTax = (double)(Math.round((finalCalculateBillTotal + roundedTax) * 100)) / 100.00;
        
        request.setAttribute("orderedItems", formatString);
        request.setAttribute("billTotal", finalCalculateBillTotal);
        request.setAttribute("billTax", roundedTax);
        request.setAttribute("billTotalPlusTax", billTotalPlusTax);
        

        RequestDispatcher view = request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);

    }
    
    
}

