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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BillCalculator;
import model.DataAccessException;
import model.MenuItem;
import model.MenuService;



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
        
        HttpSession session = request.getSession();
        MenuService ms = new MenuService();
        
        String[] appetizerItem = request.getParameterValues("item");
        String[] entreeItem = request.getParameterValues("entree");
        String[] dessertItem = request.getParameterValues("dessert");
        String[] specialItem = request.getParameterValues("special");
        String[] drinkItem = request.getParameterValues("drink");
        
        
        String app = "appetizer";
        try {
            List<MenuItem> appetizer = ms.getMenuItemsByCategory(app);
            
        } catch (DataAccessException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }

//        /* formats array items - used for output on the order - page */
         List<String> orderedItems = new ArrayList<>();
         orderedItems.add(Arrays.toString(appetizerItem));
         orderedItems.add(Arrays.toString(entreeItem));
         orderedItems.add(Arrays.toString(dessertItem));
         orderedItems.add(Arrays.toString(specialItem));
         orderedItems.add(Arrays.toString(drinkItem));
         
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
//        
        BillCalculator billCalculator = new BillCalculator(orderedItems, formatString);
        
        
        /* setting attributes for the order page */
        session.setAttribute("orderedItems", formatString);
        session.setAttribute("billTotal", billCalculator.getFinalCalculateBillTotal());
        session.setAttribute("billTax", billCalculator.getRoundedTax());
        session.setAttribute("billTotalPlusTax", billCalculator.getBillTotalPlusTax());

        response.sendRedirect(RESULT_PAGE);
        

    }
 
    
    
}

