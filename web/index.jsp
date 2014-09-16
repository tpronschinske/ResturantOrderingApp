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
        
        <div id="cssmenu">           
	<ul>
            <li><a href="#"><span>Menu</span></a></li>
            <li><a href="#"><span>Appetizer</span></a>             
            <ul>
                <% 
                    for(int x = 0; x < orderMenu.getAppetizerMenu().length; x++){  
                      
                %>
                 
            </ul>
            </li>
            <li><a href="#"><span>Entree</span></a>
                <ul>
                     <% 
                         for(int i = 0; i < orderMenu.getEntreMenu().length; i++){  
                      
                     %>
                    <li name="item" onclick="myFunction()"><a href="#">Grilled & Blackened Tilapia</a><span name="price">14.50</span></li>
                    <li name="item" onclick="myFunction()"><a href="#">New Your Strip Steak</a><span name="price">19.50</span></li>
                    <li name="item" onclick="myFunction()"><a href="#">Rack of Lamb</a><span name="price">19.50</span></li>
                </ul>
            </li>
            <li><a href="#"><span>Dessert</span></a>
                <ul>
                  <% 
                         for(int z = 0; z < orderMenu.getDesertMenu().length; z++){  
                      
                     %>
                  
                    <li name="item" onclick="myFunction()"><a href="#">Deep Fried Cheese Cake</a><span name="price">12.99</span></li>
                    <li name="item" onclick="myFunction()"><a href="#">Banana Split</a><span name="price">9.99</span></li>
                            
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
                         for(int s = 0; s < orderMenu.getDesertMenu().length; s++){  
                      
                     %>
                
                <li name="item" onclick="myFunction()"><a href="#">Half Rack BBQ Ribs</a><span name="price">19.99</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Filet Mignon</a><span name="price">29.99</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Lemon Pepper Salmon</a><span name="price">19.99</span></li>
            </ul>
                <li><a href="#"><h3>Items Ordered</h3></a></li>
	</ul>
            
            <li id="items"></li>
</div>

    </body>
</html>
