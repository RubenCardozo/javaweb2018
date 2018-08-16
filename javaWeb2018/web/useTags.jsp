<%-- 
    Document   : useTags
    Created on : Aug 16, 2018, 10:05:21 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="hasard" uri="/WEB-INF/tlds/hasard" %>
<%@taglib prefix="my" uri="/mytags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tags Page</title>
    </head>
    <body>
        <h1>Tags page</h1>
        <c:set var="nom" value="Ma"/>
        
        <c:set var="p" value="${ hasard:createPersonne("Albert", 65) }"/>
        <my:myempty case="upper" content="${p.nomComplet}"/><br>
        <my:myempty  content="Papa"/><br>
        
        <my:body nombre="2">
        <br><%= 25*6 %> ${p.nom}<br>
        </my:body> <br> 
        <my:famille>
            <my:enfant nom="albert" age="12"/>
            <my:enfant nom="andrea" age="18"/>
            <my:mari nom="pierre" age="50"/>
            <my:femme nom="annette" age="45"/>
        </my:famille><br>
        <my:famille>
            <my:enfant nom="albert" age="15"/>
            <my:enfant nom="andrea" age="20"/>
            <my:enfant nom="marie" age="18"/>
            <my:mari nom="pierre" age="55"/>
            <my:femme nom="annette" age="50"/>
        </my:famille><br>
        
        <my:dynatt a="14" b="15" c="12" />
        
    </body>
</html>
