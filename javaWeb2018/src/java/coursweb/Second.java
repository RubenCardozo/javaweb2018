/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class Second extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(response.getHeaderNames().size()+" response headers");
        response.getHeaderNames().stream().forEach(h->
                System.out.println(h+response.getHeader(h))
        );
        
        System.out.println("********* Request headers *********");
        Enumeration<String> req = request.getHeaderNames();
        while (req.hasMoreElements()) {
            String n = req.nextElement();
            System.out.println(n +"= "+ request.getHeader(n)); 
        }
        
        System.out.println("Local= "+request.getLocale());
        
        System.out.println("********* Parameters *********");
//        Enumeration<String> reqPar = request.getParameterNames();
//        while (reqPar.hasMoreElements()) {
//            String n = reqPar.nextElement();
//            System.out.println(n +"= "+ request.getParameter(n)); 
//        }
        //System.out.println(request.getParameterValues()); 
//        Enumeration<String> par = request.getParameterNames();
//        while (par.hasMoreElements()) {
//            String n = par.nextElement();
//            Stream.of(request.getParameterValues(n)).forEach(v->
//                    System.out.println(n +"= "+v));  
//        }
        request.getParameterMap().forEach(
        (s,ts)->{
            Stream.of(ts).forEach(v-> System.out.println(s+"="+v));
    
    });
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Second</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Second at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
