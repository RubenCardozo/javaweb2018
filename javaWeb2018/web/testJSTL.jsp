<%-- 
    Document   : testJSTL
    Created on : Aug 15, 2018, 11:18:50 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="hasard" uri="/WEB-INF/tlds/hasard" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Page</title>
    </head>
    <body>
        <h1>Hello JSTL</h1>

        <c:set var="test" value="${ '<a>Aide à:</a>' }" scope="request"></c:set>
        <c:set var="albert" scope="request" value="${ hasard:createPersonne("Albert", 65) }"/>        

        <c:out value="${ test }" default="Pas de test, désolé" escapeXml="false"/> 
        <c:set target="${ albert }" property="nom" value="Alberto"/>
        ${albert.nom}<br>

        <c:set var="albert" scope="session" value="${ albert }"/>
        <c:set target="${ albert }" property="nom" value="Albertine"/>
        ${sessionScope.albert.nom}<br>

        <c:set var="etat" scope="page" value="Alberta"/>
        <c:set target="${ albert }" property="nom" value="${etat}"/>
        ${albert.nom}<br>

        <c:set var="name" scope="page" value="nom"/>
        <c:set target="${ albert }" property="${name}" value="Alberti"/>
        ${albert.nom}<br>

        <c:if test="${albert.nom eq 'Alberti'}" var="EstI" scope="request"/>
        <c:if test="${EstI}">OUI</c:if>
        <c:if test="${not EstI}">NON</c:if><br>

        <c:choose>
            <c:when test="${albert.nom eq 'Alberti'}">Italien</c:when>
            <c:when test="${albert.nom eq 'Alberta'}">Espagnol</c:when>
            <c:when test="${albert.nom eq 'Albertine'}">Francais</c:when>
            <c:otherwise>Autre nacionalité</c:otherwise>
        </c:choose><br>

        <p>Premier forEach</p>
        <c:forEach var="i" begin="1" end="10" step="2">
            i= ${i}<br>
        </c:forEach>

        <p>Deuxième forEach</p>
        <%
            int[] ti = {8, 2, 3, 9, 5, 6, 10, 7, 4};
            pageContext.setAttribute("ti", ti);
        %>
        <c:forEach items="${ti}" var="i" step="2" varStatus="vs">
            <c:if test="${vs.first}">-------tableau-------<br></c:if>

            ${vs.count} = ti[${vs.index}]:i= ${i}<br>

            <c:if test="${vs.last}">
                -------last-------<br>
                <c:remove var="ti" scope="page"/>
            </c:if>

        </c:forEach>
                
        <c:forTokens items="s,_6,_a,_3,_b,h_r" delims=",_" var="j">
            ${j.toUpperCase()} - 
        </c:forTokens><br>
        <c:url value="/un espace/Rubén" context="/"/>
        <c:url value="/un espace/Rubén" var="ur"/>
            <c:param name="toto" value="45"/>
        ${ur}<br>
        <c:import url="/data/footer.jspx" var="foot" scope="request">
            <c:param name="toto" value="15"/>
        </c:import>
        <%
            String s= (String)request.getAttribute("foot");
            out.write(s.toUpperCase());
        %>
    </body>
</html>
