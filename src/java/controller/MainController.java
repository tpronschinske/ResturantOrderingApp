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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BillCalculator;
import model.TipCalculator;


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
     //  double finalBill = 0.0;
        
        /* retrieves the items selected */
        String[] appetizerItem = request.getParameterValues("item");
        String[] entreeItem = request.getParameterValues("entree");
        String[] dessertItem = request.getParameterValues("dessert");
        String[] specialItem = request.getParameterValues("special");

        /* adds items to an array */
        List<String> orderedItems = new ArrayList<>();
        orderedItems.add(Arrays.toString(appetizerItem));
        orderedItems.add(Arrays.toString(entreeItem));
        orderedItems.add(Arrays.toString(dessertItem));
        orderedItems.add(Arrays.toString(specialItem));
        
        /* removes null */
        for (Iterator<String> it = orderedItems.iterator(); it.hasNext();) {
            String element = it.next();
            if ("null".equals(element)) {
                it.remove();
            }
        }
        /* formats array items - used for output on the order - page */
        String formatString = orderedItems.toString()
        .replace(",", "<br>")  //remove the commas
        .replace("[", "")  //remove the right bracket
        .replace("]", "")  //remove the left bracket
        .trim();           //remove trailing spaces from partially initialized 
        
        BillCalculator billCalculator = new BillCalculator(orderedItems, formatString);
        /* setting attributes for the page */
        request.setAttribute("orderedItems", formatString);
        request.setAttribute("billTotal", billCalculator.getFinalCalculateBillTotal());
        request.setAttribute("billTax", billCalculator.getRoundedTax());
        request.setAttribute("billTotalPlusTax", billCalculator.getBillTotalPlusTax());
        
        
        String tip = request.getParameter("tip");
        if(tip != null && !tip.isEmpty()){
            TipCalculator tc = new TipCalculator(tip);
            request.setAttribute("totalPlusTip", tc.getTotalPlusTip());
        }
        RequestDispatcher view = request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);

    }
    
    
}

