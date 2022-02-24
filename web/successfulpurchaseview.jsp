
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchase completed view</title>
    </head>
    <body>
            <link rel="stylesheet" href="style.css">
           <jsp:include page="Header.jsp"></jsp:include>
        <div class="thanks">
        <img src="resources/thanks.png" width="570" height="512" alt="thanks"/>
        
        <a href="index.jsp">
        <img src="${pageContext.request.contextPath}/resources/continueShopping.png" height="50" width="160"></a>
        
        </div>


    </body>
    <jsp:include page="Footer.jsp"></jsp:include> 
</html>
