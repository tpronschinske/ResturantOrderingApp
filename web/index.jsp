<%-- 
    Document   : index
    Created on : Sep 11, 2014, 9:02:23 PM
    Author     : Travis
--%>


 <%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
        
        <div id="cssmenu">           
	<ul>
            <li><a href="#"><span>Menu</span></a></li>
            <li><a href="#"><span>Appetizer</span></a>             
            <ul>
                <% 
     
                    String [] items = orderMenu.getAppetizerMenu();
                    for(String item : items){  
                        out.print("<li><a>");
                        out.print(item);
                        out.print("</a></li>");
                    }
                      
                %>
            </ul>
            </li>
            <li><a href="#"><span>Entree</span></a>
                <ul>
                <% 
     
                    String [] entreeItems = orderMenu.getEntreMenu();
                    for(String item : entreeItems){  
                        out.print("<li><a>");
                        out.print(item);
                        out.print("</a></li>");
                    }
                      
                %>       
                </ul>
            </li>
            <li><a href="#"><span>Dessert</span></a>
                <ul>
                <% 
     
                    String [] dessertItems = orderMenu.getDesertMenu();
                    for(String item : dessertItems){  
                        out.print("<li><a>");
                        out.print(item);
                        out.print("</a></li>");
                    }
                      
                %>         
                </ul>
            </li>  
            <li><a href="#"><span>Specials</span></a>
            <ul>
                <% 
                    double [] specialPrices = orderMenu.getSpecialPrices();
                    String [] specialItems = orderMenu.getSpecialMenu();
                    for(int item = 0; item < specialItems.length; item++){  
                        out.print("<li><a>");
                        out.print(specialItems[item]);
                        out.print("</a></li>");         
                    }
                    
                %>
            </ul>
                <li><a href="#"><h3>Items Ordered</h3></a></li>
	</ul>
</div>
            <p>&nbsp;</p>
            <input id="submitOrder" type="submit" value="Submit Order">
            
    </body>
</html>
