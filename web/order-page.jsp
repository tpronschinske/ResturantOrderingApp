<%-- 
    Document   : order-page
    Created on : Sep 14, 2014, 10:12:16 PM
    Author     : Travis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
        <link href="Css/style.css" rel="stylesheet" type="text/css"/>
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script src="Js/menuscript.js" type="text/javascript"></script>
        <link href="Css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
        <div class="header"><h1>Le Cata</h1></div>
        <h2>Your Order</h2>
        <hr/>
        
        <c:forEach var="item" items="${orderedItems}" varStatus="rowCount">
          ${orderedItems}
        </c:forEach>
       
        <hr>
        
        <p>Total: $ ${billTotal}<br>
        Tax:$ ${billTax}<br>
        Bill Total Plus Tax:$ ${billTotalPlusTax}
        </p>
        
        
        
        
          <p><a href="index.jsp">Back</a></p>
        </div>
        <p>&nbsp;</p>
    
            <div class="footer"></div>
</body>
</html>
