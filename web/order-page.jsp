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
    </head>
    <body>
        <div id="wrapper">
        <p class="header">&nbsp;
        </p>
        <h1>Your Order</h1>
        <hr/>
        <c:forEach var="item" items="${orderedItems}" varStatus="rowCount">
          <br>${item}
        </c:forEach>
          
          <p><a href="index.jsp">Back</a></p>
        </div>
        <p id="footer">&nbsp;
</body>
</html>
