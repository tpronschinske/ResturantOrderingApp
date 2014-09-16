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
            <li><a href="#"><span>Drink Menu</span></a>
            <ul>
                <li>Beer</li>
                <li id="item" name="item" onclick="myFunction()"><a href="#">Samuel Adams</a><span name="price">3.99</span></li>
                <li id="item" name="item" onclick="myFunction()" ><a href="#">Bud Light</a><span name="price">3.99</span></li>
                <li id="item" name="item" onclick="myFunction()"><a href="#">Miller Lite</a><span name="price">2.99</span></li>
                <li id="item" name="item" onclick="myFunction()"><a href="#">Spotted Cow</a><span name="price">3.99</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Fat Tire</a><span name="price">4.99</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Corona</a><span name="price">4.99</span></li>
                <li>Mixed Drinks</li>
                <li name="item" onclick="myFunction()"><a href="#">Brandy Old Fashioned</a><span name="price">10.00</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Martini</a><span name="price">11.50</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Margarita</a><span name="price">9.50</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Bloody Mary</a><span name="price">8.99</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Mai Tai</a><span name="price">12.99</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Bahama Bomb</a><span name="price">8.00</span></li>
            </ul>
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
            
            <li id="items"></li>
</div>

    </body>
</html>
