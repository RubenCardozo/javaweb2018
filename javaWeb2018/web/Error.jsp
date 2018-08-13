<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>

<html>

    <head>
        <title>Erreur</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>

    <body>

        <h1>Erreur!!!</h1>
        Exception=
        <%
            if (exception instanceof StringIndexOutOfBoundsException) {
        %>

        <p>Apprend à compter</p>
        s!=4;

        <%} else {%>
        <%="Verifier le code:"%>
        <%}%>

        <%= pageContext.findAttribute("monInt") %>
        
        <%= exception.getMessage()%>

    </body>

</html>
