<%-- 
    Document   : order-page
    Created on : Sep 14, 2014, 10:12:16 PM
    Author     : Travis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
    </head>
    <body>
        <h1>Your Orders</h1>
       <%
            Object obj = request.getAttribute("Item Ordered");
            if(obj == null){
                out.println("Sorry None Selected");
            }else {
                out.println(obj.toString());
            }
         %>

        
    </body>
</html>
