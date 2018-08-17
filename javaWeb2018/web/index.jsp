<%--Code template Commentaire Java JSP--%>

<%--Directive de JSP--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.io.*, java.util.*"%>
<%@page session="true" language="java"  buffer="4kb" autoFlush="false" errorPage="Error.jsp" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Java</title>
    </head>
    <body>
        <h1>
            <%--Expression JSP--%>
            <%= "Hello World!!!"
            
            %>
            
            
            
            <%--Declaration JSP--%>
            <%!
               
                int j =15;
                void doit(JspWriter out, int k)throws IOException {
                out.print("<br> i= "+k);
                
            }   
                
            %>
            
            <%--Scriptlets JSP--%>
            <% 
               
                //int i =10;
                pageContext.setAttribute("monInt", 10);
                Integer i = (Integer)pageContext.getAttribute("monInt");
                out.print("<br> j= "+j++);
                doit(out, i);
                                
                int l= session.getAttribute("L")==null?i:(Integer)session.getAttribute("L");
                out.print("<br>session= "+ l++);
                session.setAttribute("L",l );

                String cm = util.Utils.getCookieValue("M",request);
                Integer m = cm==null?i:Integer.parseInt(cm);
                out.print("<br>cookie m= "+ m++);
                response.addCookie(new Cookie("M", m.toString()));
                
                String pn = request.getParameter("m")==null || request.getParameter("m").isEmpty() ?i+"": 
                            request.getParameter("m");
                Integer n =Integer.parseInt(pn);
                out.print("<br>param m"+ n++);
                out.print("<a href=\"?m=" +n+ "\">goto next</a>");
            %>
            
            <%@include file="/Footer.jspf" %>
            
        </h1>
    </body>
</html>