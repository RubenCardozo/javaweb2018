
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
            <jsp:setProperty name="albert" property="nom" value="Alberto"/>  
            <jsp:setProperty name="albert" property="age" value="45"/>  
        </jsp:useBean>
        <jsp:getProperty name="albert" property="nomComplet"/>
        
        <br>
         <jsp:useBean id="barnabe" scope="request" class="biz.Personne"> 
             <jsp:setProperty name="barnabe" property="nom" param="nom"/>  
             <jsp:setProperty name="barnabe" property="age" param="age"/>  
        </jsp:useBean>
        <jsp:getProperty name="barnabe" property="nomComplet"/>
        
        <br>
         <jsp:useBean id="barnabe2" scope="request" class="biz.Personne"> 
             <jsp:setProperty name="barnabe2" property="*"/>   
        </jsp:useBean>
        <jsp:getProperty name="barnabe2" property="nomComplet"/>
        
        
        <br>
        <a href="cible.jsp">Cible</a>
        
        <jsp:include page="data/footer.jspx"/>
        
        <% if(barnabe2.getAge()<0 || barnabe2.getAge()>150) {%>
        <jsp:forward page="erreur.jsp?msg=Age invalide"/>
        <% } %>
        
    </body>
</html>
