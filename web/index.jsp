<%-- 
    Document   : index
    Created on : Sep 11, 2014, 9:02:23 PM
    Author     : Travis
--%>

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
                <li name="item" onclick="myFunction()"><a href="#">Blooming Onion</a><span>7.50</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Pan Fried Calamari with Peppers and Chipotle Sauce</a><span>11.50</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Mozzarella Sticks with Marinara Sauce</a><span>8.50</span></li>
            </ul>
            </li>
            <li><a href="#"><span>Entree</span></a>
                <ul>
                    <li name="item" onclick="myFunction()"><a href="#">Grilled & Blackened Tilapia</a><span>14.50</span></li>
                    <li name="item" onclick="myFunction()"><a href="#">New Your Strip Steak</a><span>19.50</span></li>
                    <li name="item" onclick="myFunction()"><a href="#">Rack of Lamb</a><span>19.50</span></li>
                </ul>
            </li>
            <li><a href="#"><span>Dessert</span></a>
                <ul>
                    <li name="item" onclick="myFunction()"><a href="#">Deep Fried Cheese Cake</a><span>12.99</span></li>
                    <li name="item" onclick="myFunction()"><a href="#">Banana Split</a><span>9.99</span></li>
                </ul>
            </li>
            <li><a href="#"><span>Drink Menu</span></a>
            <ul>
                <li>Beer</li>
                <li id="item" name="item" onclick="myFunction()"><a href="#">Samuel Adams</a><span>3.99</span></li>
                <li id="item" name="item" onclick="myFunction()" ><a href="#">Bud Light</a><span>3.99</span></li>
                <li id="item" name="item" onclick="myFunction()"><a href="#">Miller Lite</a><span>2.99</span></li>
                <li id="item" name="item" onclick="myFunction()"><a href="#">Spotted Cow</a><span>3.99</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Fat Tire</a><span>4.99</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Corona</a><span>4.99</span></li>
                <li>Mixed Drinks</li>
                <li name="item" onclick="myFunction()"><a href="#">Brandy Old Fashioned</a><span>10.00</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Martini</a><span>11.50</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Margarita</a><span>9.50</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Bloody Mary</a><span>8.99</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Mai Tai</a><span>12.99</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Bahama Bomb</a><span>8.00</span></li>
            </ul>
            <li><a href="#"><span>Specials</span></a>
            <ul>
                <li name="item" onclick="myFunction()"><a href="#">Half Rack BBQ Ribs</a><span>19.99</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Filet Mignon</a><span>29.99</span></li>
                <li name="item" onclick="myFunction()"><a href="#">Lemon Pepper Salmon</a><span>19.99</span></li>
            </ul>
                <li><a href="#"><h3>Items Ordered</h3></a></li>
	</ul>
            
            <p id="items"></p>
</div>

    </body>
</html>
