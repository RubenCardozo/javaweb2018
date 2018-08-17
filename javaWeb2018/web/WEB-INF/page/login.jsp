<%-- 
    Document   : login
    Created on : Aug 17, 2018, 2:41:01 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="j_security_check">
            Nom:<input type="text" name="j_username"/><br>
            Password:<input type="password" name="j_password"/><br>
            <input type="submit" value="login"/>
                
        </form>
        <a href="/index.deb"></a>
    </body>
</html>
