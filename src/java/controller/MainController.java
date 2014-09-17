/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        String appetizerItem = request.getParameter("item");
        String entreeItem = request.getParameter("entree");
        String dessertItem = request.getParameter("desert");
        String specialItem = request.getParameter("special");
   
        List orderedItems = new ArrayList();
        orderedItems.add(appetizerItem);
        orderedItems.add(entreeItem);
        orderedItems.add(dessertItem);
        orderedItems.add(specialItem);
        
        if(appetizerItem != null && !appetizerItem.isEmpty() && entreeItem != null && !entreeItem.isEmpty() && dessertItem != null && !dessertItem.isEmpty() && specialItem != null && !specialItem.isEmpty()){
            request.setAttribute("orderedItems", orderedItems);   
        }
  
            RequestDispatcher view = request.getRequestDispatcher("order-page.jsp");
        view.forward(request,response);
         response.sendRedirect("order-page.jsp");
  
        }
    } 

