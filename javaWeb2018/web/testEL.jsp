<%-- 
    Document   : testEL
    Created on : Aug 14, 2018, 10:15:24 AM
    Author     : Administrator
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="biz.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Expression language</h1>
        <%="z"+(2+5) +session.getAttribute("titi") %>
        
        ${"toto "}  ${"titi"}
        <% 
            int vzozo =14;
            pageContext.setAttribute("zozo", vzozo);
            session.setAttribute("zozo", vzozo*10);
            session.setAttribute("lui", new Personne("Paul",45));
            int[] ti= {10,20,30,40,50,60};
            pageContext.setAttribute("tableau", ti);
            Map lemap = new HashMap();
            lemap.put("jean", new Personne("Jean",45));
            lemap.put("pierre", new Personne("Pierre",35));
            lemap.put("leon", new Personne("Leon",40));
            lemap.put("marcel", new Personne("Marcel",25));
            pageContext.setAttribute("peuple", lemap);
        %>
        <br>
        ${"\""} ${zozo} ${'"'} ${' ${}'} ${" ${}"} ${'\''}
        <br>
        ${sessionScope.zozo}
        <br>
        ${lui.getNom()}${ lui.age}<br>
        ${lui.nomComplet}<br>
        ${lui.getNom(true)}<br>
        
        ${ lui.age>40}<br>
        ${ lui.age gt 70 ? "Vieux ": "Jeune"}<br>
        
        ${empty lui}<br>
        ${tableau[2]}-<br>
        ${empty tableau[6]}-<br>
        ${empty tableau}-<br>
        ${empty tableau[0]}-<br>
        ${tableau[0]==null}+<br>
        ${tableau['3']}+<br>
        ${lui['nom']}<br>
        ${lui['age']}<br>
        
        <h3>PEUPLE</h3><br>
        ${empty peuple}<br>
        ${peuple.pierre}<br>
        ${peuple['pierre']}<br>
        ${peuple.pierre eq peuple['pierre']}<br>
        ${peuple.pierre.nom} ${peuple.pierre.age}
        
        <h3>Objets implicites</h3><br>
        ${pageContext.session.getAttribute("zozo")}<br>
        ${pageContext.request.parameterMap.size[0]}<br>
        ${pageContext.request.getParameter("size")}<br>
        ${param.size}<br>
        ${paramValues.size[0]}
        
    </body>
</html>
