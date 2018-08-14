<%-- 
    Document   : testStandard
    Created on : Aug 14, 2018, 4:06:10 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Standard Actions</title>
    </head>
    <body>
        <h1>Standard Actions</h1>
        <jsp:useBean id="albert" scope="session" class="biz.Personne"> 
            <jsp:setProperty name="albert" property="nom" value="Albert"/>  
            <jsp:setProperty name="albert" property="age" value="45"/>  
        </jsp:useBean>
        
        ${albert.nom}
        <br>
        <a href="cible.jsp">Cible</a>
        
    </body>
</html>
