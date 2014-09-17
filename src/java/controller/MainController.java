/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
     private static final String RESULT_PAGE = "/order-page.jsp";

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
        response.setContentType("text/html;charset=UTF-8");
        
        String appetizerItem = request.getParameter("item");
        String entreeItem = request.getParameter("entree");
        String dessertItem = request.getParameter("desert");
        String specialItem = request.getParameter("special");
   
        
        
        if(appetizerItem != null && !appetizerItem.isEmpty()){
            request.setAttribute("appetizerItem", appetizerItem);   
        }
         if(entreeItem != null && !entreeItem.isEmpty()){
            request.setAttribute("entreeItem", entreeItem);   
        }
          if(dessertItem != null && !dessertItem.isEmpty()){
            request.setAttribute("dessertItem", dessertItem);   
        }
           if(specialItem != null && !specialItem.isEmpty()){
            request.setAttribute("specialItem", specialItem);   
        }
  
         response.sendRedirect("/order-page.jsp");
  
        }
    } 

