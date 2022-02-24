<%@page import="model.Book"%>
<%@page import="model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchase Page</title>
        

    </head>
    <body>
        
    <link rel="stylesheet" href="style.css">
    
    <jsp:include page="Header.jsp"></jsp:include>
    
        
        <%  
            Cart cart = (Cart) session.getAttribute("cart");
 %>
        <div class="finalPurchase">
        <h1>Confirm Payment</h1>
        Total (no taxes): <%= cart.getTotalPrice() %>€<br> 
        Taxes Included (7%): <%= cart.getTotalPriceWithIgic() %>€ 
        <form action="FrontServlet">
                <input type="hidden" name="command" value="PerformPurchaseCommand" />
                <input type="image" src="${pageContext.request.contextPath}/resources/buyNow.png"  value="Complete purchase"/>
         </form>
    </div> 
    </body>
        <jsp:include page="Footer.jsp"></jsp:include> 
</html>
