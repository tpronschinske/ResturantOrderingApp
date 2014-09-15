/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        ServletContext ctx = request.getServletContext();
        String itemOrdered = request.getParameter("item");
        
  
            String item = request.getParameter("item");
            // Session scope is per user
            session.setAttribute("item", item);
            
            // in JSP the ServletContext is referred to as 'application'
            // and as applicatio-wide scope
            if(itemOrdered != null && itemOrdered.length() > 0) {
                ctx.setAttribute("itemOrdered", itemOrdered);
            }
            
            response.sendRedirect("order-page.jsp");
        }
    } 

