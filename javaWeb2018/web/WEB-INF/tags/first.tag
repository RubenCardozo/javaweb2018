<%-- 
    Document   : first
    Created on : Aug 17, 2018, 10:07:25 AM
    Author     : Administrator
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8" body-content="scriptless" import="java.io.*" dynamic-attributes="attrs"%>

<%@attribute name="message"%>
<%@attribute name="personne" type="biz.Personne" rtexprvalue="true" required="true"%>


<%@variable name-given="titi" variable-class="java.lang.String" scope="AT_END"%>



<c:set var="titi" value="Glominet"/>


<jsp:doBody var = "contenu"/>

<c:set target="${personne}" property="age" value="${attrs.age}"/>


<h2>${message} ${personne.nomComplet} (${attrs.nombre} ${attrs.age}) in this ${contenu.toUpperCase()}
</h2>

