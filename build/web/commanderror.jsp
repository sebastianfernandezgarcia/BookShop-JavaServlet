<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Command Error Page</title>
    </head>
    <body>
            <link rel="stylesheet" href="style.css">
           <jsp:include page="Header.jsp"></jsp:include>
           

        It seems that some engineer plugged a cable in a wrong place.<br>
               <div class="error">
                <img class="error" src="${pageContext.request.contextPath}/resources/somethingwentwrong.png">
            </div>
            <a href="index.jsp">          </a>
            <a href="index.jsp"><input type="submit" value="Click HERE to reload" /></a>

    </body>
    <jsp:include page="Footer.jsp"></jsp:include> 
</html>
