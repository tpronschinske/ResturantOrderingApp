<%-- 
    Document   : index
    Created on : Sep 11, 2014, 9:02:23 PM
    Author     : Travis
--%>
<%
     MenuItems menuItems = new MenuItems();
 %>
                
<%@page import="model.MenuItems"%>
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
                    String [] items = menuItems.getAppetizerMenu();
                    for(String item : items){  
                        out.print("<li>");
                %>
                <input type="checkbox" name="item" value="<%= item %>"/><%= item %></input>
                <%
                        out.print("</li>");
                     }
                %> 
            </ul>
            </li>
            <li><a href="#"><span>Entree</span></a>
                <ul>
                    <%
                       
                        String[] entreeItems = menuItems.getEntreMenu();
                        for (String entree : entreeItems) {
                            out.print("<li>");
                    %>
                    <input type="checkbox" name="entree" value="<%= entree%>"/><%= entree%></input>
                    <%                         
                            out.print("</li>");
                        }
                    %>       
                </ul>
            </li>
            <li><a href="#"><span>Dessert</span></a>
                <ul>
                    <%                
                      
                        String[] dessertItems = menuItems.getDesertMenu();
                        for (String dessert : dessertItems) {
                            out.print("<li>");
                    %>
                    <input type="checkbox" name="dessert" value="<%= dessert%>"/><%= dessert%></input>
                    <%                          
                            out.print("</li>");
                        }
                    %>         
                </ul>
            </li>  
            <li><a href="#"><span>Specials</span></a>
            <ul>
                <%                    
                        
                    String[] specialItems = menuItems.getSpecialMenu();
                    for (String special : specialItems) {
                        out.print("<li>");
                %>
                <input type="checkbox" name="special" value="<%= special%>"/><%= special%></input>
                <%
                       
                        out.print("</li>");
                    }

                %>
            </ul>
            <li><a href="#"><span>Drinks</span></a>             
            <ul>
                <% 
                    String [] drinks = menuItems.getDrinkMenu();
                    for(String drink : drinks){  
                        out.print("<li>");
                %>
                <input type="checkbox" name="drink" value="<%= drink %>"/><%= drink %></input>
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
