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
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
          <script type="text/javascript">
          $(document).ready(function(){
                 
              var bill =  $('#bill').text();
              var billFloat = parseFloat(bill);
              var tip = $('#tipBox').val();
              var tipFloat = parseFloat(tip);
              var billTotal = tipFloat + billFloat;
  
            $("#calculate").click(function() {
              $("#totalPlusTip").text(billTotal);
             
              });
            });
            

        </script>
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
        
        <p>Total: $ ${billTotal}</p>
        <p>Tax:$ ${billTax}</p>
        <p>Bill Total Plus Tax:$ <span id="bill">${billTotalPlusTax}</span>
        </p>
        
        <form id="tipForm" name="tipForm">
         Please Enter Tip Amount:<input id="tipBox" type="text"/><br />
         <button id="calculate" type="button">Calculate Tip</button> 
            
         <p>Total Plus Tip:$ <span id="totalPlusTip"></span></p>     
                
            
            </form>    
        
      
          <p><a href="index.jsp">Back</a></p>
        </div>
            <div class="footer"></div>
</body>
</html>
