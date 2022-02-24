<%@page import="model.Book"%>
<%@page import="model.Cart"%>
<%@page import="model.Catalogue"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% Cart shoppingcart = (Cart) session.getAttribute("cart");%>

<jsp:scriptlet>
    if(session.getAttribute("cart") == null){ 
               session.setAttribute("cart", new Cart());
   }
</jsp:scriptlet>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart Page</title>
        <link rel="stylesheet" href="style.css">
    </head>
    
    <body>
        <jsp:include page="Header.jsp"></jsp:include>
    
        <% if (shoppingcart.getCart().size() == 0) { %>
            
            <div class="cart">
                <p class="cart" >Your shopping cart is empty. Add some books to continue.</p>
                <a href="index.jsp">
                <img src="${pageContext.request.contextPath}/resources/continueShopping.png" height="50" width="160"></a>
            </div>
            
        <% } else { %>  

        <div class="shopingProduct">
        <%  
            Cart cart = (Cart) session.getAttribute("cart");
            for (Book book : shoppingcart.getCart().keySet()) { 
        %>

            <br><strong> Title: <%= book.getTitle() %> </strong><br>
            <img src=<%= book.getThumbnailUrl() %> /><br>
            ISBN: <%= book.getIsbn() %><br>
            Authors: <%= book.getAuthors()%><br>
            Price: <%= book.getPrice() * shoppingcart.getUnitsBook(book) %><br>
            Quantity: <%= shoppingcart.getUnitsBook(book) %><br>
            <form action="FrontServlet">
                <input type="hidden" name="command" value="AddToCartCommand" />
                <input type="hidden" name="isbn" value=<%= book.getIsbn() %> />
                <input type="submit" value="+" />
            </form>
                
            <form action="FrontServlet">
                <input type="hidden" name="command" value="RemoveFromCartCommand" />
                <input type="hidden" name="isbn" value=<%= book.getIsbn() %> />
                <input type="submit" value="-" />
            </form>
        <% }%>

        <div class="finalCheckout"> 
        <a href="purchaseview.jsp">
            <img src="${pageContext.request.contextPath}/resources/checkOut.png" height="50" width="160"></a>
            
        <a href="index.jsp">
                <img src="${pageContext.request.contextPath}/resources/continueShopping.png" height="50" width="160"></a>
        <form action="FrontServlet">
                <input type="hidden" name="command" value="EmptyCartCommand" />
                <button class="emptyCart" type="submit" value="Empty cart"/>Empty Cart</button>
        </form>
               </div>   
             </div> 
        <% }%>
        
        <jsp:include page="Footer.jsp"></jsp:include>
        
    </body>
</html>
