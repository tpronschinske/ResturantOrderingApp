<%-- 
    Document   : index
    Created on : Sep 11, 2014, 9:02:23 PM
    Author     : Travis
--%>
    <%
                     MenuService ms = new MenuService();
                     MenuItem mi = new MenuItem();
    %>

<%@page import="model.MenuService"%>
<%@page import="model.MenuItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="controller.MainController"%>        
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurant Ordering Application</title>
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script src="Js/menuscript.js" type="text/javascript"></script>
        <link href="Css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
        <div class="header">  
            <h1>Le Cata</h1>
        </div>
        <div id="gradient-separater"></div>
        <div id="bannerImage">
            <img src="images/3_COUNTER-007.jpg.png" id="imageOne" alt=""/>
            <img src="images/static.squarespace.com.png" id="imageTwo" alt=""/>
        </div>
         <div id="gradient-separater"></div>
        <form id="menuForm" name="menuForm" method="POST" action="MainController">
        <div id="cssmenu">           
	<ul>
            <li><a href="#"><span>Menu</span></a></li>
            <li><a href="#"><span>Appetizer</span></a>             
            <ul>
                <%
                     String app = "appetizer";
                     List<MenuItem> appetizer = ms.getMenuItemsByCategory(app);

                    for(int i = 0; i < appetizer.size(); i++) {
                       String appetizerItem = appetizer.get(i).itemName + " " + appetizer.get(i).itemPrice;
                       out.print("<li>");
                %>
                <input type="checkbox" name="item" value="<%= appetizerItem %>"/><%= appetizerItem %></input>
                <%
                      out.print("</li>");
                     }
                %> 
            </ul>
            </li>
            <li><a href="#"><span>Entree</span></a>
                <ul>
                    <%
                    String entreeString = "entree";
                    List<MenuItem> entree = ms.getMenuItemsByCategory(entreeString);
                    for(int x = 0; x < entree.size(); x++) {
                        String entreeItem = entree.get(x).itemName + " " + entree.get(x).itemPrice;
                        out.print("<li>");
                    %>
                    <input type="checkbox" name="entree" value="<%= entreeItem %>"/><%= entreeItem %></input>
                    <%                         
                            out.print("</li>");
                    }
                    %>       
                </ul>
            </li>
            <li><a href="#"><span>Dessert</span></a>
                <ul>
                    <%                
                    String dessertString = "dessert";
                    List<MenuItem> dessert = ms.getMenuItemsByCategory(dessertString);
                    for(int x = 0; x < dessert.size(); x++) {
                        String dessertItem = dessert.get(x).itemName + " " + dessert.get(x).itemPrice;
                           out.print("<li>");
                    %>
                    <input type="checkbox" name="dessert" value="<%= dessertItem %>"/><%= dessertItem %></input>
                    <%                          
                            out.print("</li>"); 
                    }
                    %>         
                </ul>
            </li>  
            <li><a href="#"><span>Specials</span></a>
            <ul>
                <%       
                    String specialString = "special";
                    List<MenuItem> special = ms.getMenuItemsByCategory(specialString);
                    for(int x = 0; x < special.size(); x++) {
                        String specialItem = special.get(x).itemName + " " + special.get(x).itemPrice;
                        out.print("<li>");
                %>
                <input type="checkbox" name="special" value="<%= specialItem %>"/><%= specialItem %></input>
                <%                       
                        out.print("</li>");
                    }
                %>
            </ul>
            <li><a href="#"><span>Drinks</span></a>             
            <ul>
                <%   
                    String drinkString = "drink";
                    List<MenuItem> drink = ms.getMenuItemsByCategory(drinkString);
                    for(int x = 0; x < drink.size(); x++) {
                        String drinkItem = drink.get(x).itemName + " " + drink.get(x).itemPrice;
                        out.print("<li>");
                %>
                <input type="checkbox" name="drink" value="<%= drinkItem %>"/><%= drinkItem %></input>
                <%
                        out.print("</li>"); 
                    }
                %> 
            </ul>
            </li>
	</ul>
</div>
        
            <center>
            <input id="submitOrder" type="submit" value="Submit Order">
            </center>
          </form> 
         
        </div>
            <div class="footer"></div>
    </body>
</html>
