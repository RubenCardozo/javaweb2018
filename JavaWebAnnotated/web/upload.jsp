<%-- 
    Document   : upload
    Created on : Aug 10, 2018, 11:08:37 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload</title>
    </head>
    <body>
        <h1>Upload</h1>
        <form action="files/upload" enctype="multipart/form-data" method="post">
            
            Fichier: <input type="file" name="file1"><br>
            <input type="submit" value="Envoi Fichier">
        </form>
    </body>
</html>
