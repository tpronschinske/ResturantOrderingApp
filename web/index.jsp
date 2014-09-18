<%-- 
    Document   : index
    Created on : Sep 11, 2014, 9:02:23 PM
    Author     : Travis
--%>
<%
     OrderingMenu orderMenu = new OrderingMenu();
 %>
                
<%@page import="model.OrderingMenu"%>
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
        <form id="menuForm" name="menuForm" method="POST" action="MainController">
        <div id="cssmenu">           
	<ul>
            <li><a href="#"><span>Menu</span></a></li>
            <li><a href="#"><span>Appetizer</span></a>             
            <ul>
                <% 
                    String [] items = orderMenu.getAppetizerMenu();
                    int i = 0;
                    for(String item : items){  
                       
                        out.print("<li>");
                %>
                <input type="checkbox" name="item<%= i %>" value="<%= item %>"/><%= item %></input>
                <%
                        i++;
                        out.print("</li>");
                     }
                %> 
            </ul>
            </li>
            <li><a href="#"><span>Entree</span></a>
                <ul>
                    <%
                        int x = 0;
                        String[] entreeItems = orderMenu.getEntreMenu();
                        for (String entree : entreeItems) {
                            out.print("<li>");
                    %>
                    <input type="checkbox" name="entree<%= x%>" value="<%= entree%>"/><%= entree%></input>
                    <%
                            x++;
                            out.print("</li>");
                        }

                    %>       
                </ul>
            </li>
            <li><a href="#"><span>Dessert</span></a>
                <ul>
                    <%                
                        int s = 0;
                        String[] dessertItems = orderMenu.getDesertMenu();
                        for (String dessert : dessertItems) {
                            out.print("<li>");
                    %>
                    <input type="checkbox" name="dessert<%= s%>" value="<%= dessert%>"/><%= dessert%></input>
                    <%
                            s++;
                            out.print("</li>");
                        }

                    %>         
                </ul>
            </li>  
            <li><a href="#"><span>Specials</span></a>
            <ul>
                <%                    
                    int z = 0;    
                    String[] specialItems = orderMenu.getSpecialMenu();
                    for (String special : specialItems) {
                        out.print("<li>");
                %>
                <input type="checkbox" name="special<%= z%>" value="<%= special%>"/><%= special%></input>
                <%
                        z++;
                        out.print("</li>");
                    }

                %>
            </ul>
            
	</ul>
</div>
            <p>&nbsp;</p>
            <center>
            <input id="submitOrder" type="submit" value="Submit Order">
            </center>
          </form> 
    </body>
</html>
