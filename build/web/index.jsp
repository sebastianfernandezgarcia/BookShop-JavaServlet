<%@page import="model.Cart"%>
<%@page import="model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Catalogue"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book catalogue</title>

            <link rel="stylesheet" href="style.css">

    </head>
    <body>
 
    <jsp:include page="Header.jsp"></jsp:include>

           <%! 
            Catalogue catalogue = new Catalogue("C:/Users/Sebastián Fernández/OneDrive - Universidad de Las Palmas de Gran Canaria/Informatica_2021_2022/Segundo Cuatrimestre/PS/Practicas/TiendaDeLibrosOtros/OnlineStore/OnlineStore/books_ulr.json");
        %>
        
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null){
                cart = new Cart();
                session.setAttribute("cart", cart);
            }

            session.setAttribute("catalogue", catalogue);
            %>
            
        <table class="tablote">
        <%
            for (Book book : catalogue.getCatalogue()) { 
        %>
 
            <tr class="table">
                <td class="tablita">
                    <img src="<%= book.getThumbnailUrl() %>" width="150" height="250"/>
                </td>
                <td>
                    <ul>
                        <li>Title: <%= book.getTitle() %></li>
                        <li>Author: <%= book.getAuthors()%></li>
                        <li>Price: <%= book.getPrice() %> €</li>
                    </ul>
                    
                    <div style="margin-top: 20px; text-align: center">
            <form action="FrontServlet">
                <input type="hidden" name="command" value="AddToCartCommand" />
                <input type="hidden" name="isbn" value=<%= book.getIsbn() %> />
                <input type="submit" value="Add to cart" />
            </form>
                   </div>
                </td>
            </tr>

        <% }%>
        </table>
        
    <jsp:include page="Footer.jsp"></jsp:include>  
    </body>
      
</html>
