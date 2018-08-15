<%-- 
    Document   : error
    Created on : Aug 15, 2018, 10:29:45 AM
    Author     : Administrator
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>Erreur!!!</h1>
        ${param.msg}
    </body>
</html>
