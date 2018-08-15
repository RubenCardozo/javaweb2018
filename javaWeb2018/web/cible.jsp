<%-- 
    Document   : cible
    Created on : Aug 14, 2018, 4:27:04 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cible</title>
    </head>
    <body>
        <h1>Cible</h1>
        <jsp:useBean id="albert" scope="session" type="biz.IPersonne">
            <jsp:setProperty name="albert" property="age" value="60"/>  
        </jsp:useBean>
        
        <jsp:setProperty name="albert" property="nom" value="Albert"/>  
        <br>
        <jsp:getProperty name="albert" property="nomComplet"/>
        
        
        <br>
        <a href="testStandard.jsp">Standard</a>
    </body>
</html>
