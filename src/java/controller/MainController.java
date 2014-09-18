/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
     

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        String RESULT_PAGE = "order-page.jsp";
        List<String> appetizerItem = new ArrayList(); 
        for(int i = 0; i < 3; i++){
            appetizerItem.add(request.getParameter("item"+i));
        }
        
        List<String> entreeItem = new ArrayList(); 
        for(int i = 0; i < 3; i++){
            appetizerItem.add(request.getParameter("entree"+i));
        }
        
        List<String> dessertItem = new ArrayList(); 
        for(int i = 0; i < 3; i++){
            appetizerItem.add(request.getParameter("desert"+i));
        }
      
        List<String> specialItem = new ArrayList(); 
        for(int i = 0; i < 3; i++){
            appetizerItem.add(request.getParameter("special"+i));
        }
        
        List orderedItems = new ArrayList();
        orderedItems.add(appetizerItem);
        orderedItems.add(entreeItem);
        orderedItems.add(dessertItem);
        orderedItems.add(specialItem);
        
        
        request.setAttribute("orderedItems", orderedItems);   
       
  
        RequestDispatcher view = request.getRequestDispatcher("order-page.jsp");
        view.forward(request,response);
         
  
        }
    } 

