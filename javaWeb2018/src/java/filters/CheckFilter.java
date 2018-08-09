/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class CheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        System.out.println("avant checkFilter");
        
        if (request.getParameter("add").equals("add")) {
            if (request.getParameter("nom")==null || request.getParameter("age")==null || request.getParameter("nom").length()==0 || request.getParameter("age").length()==0) {
                ((HttpServletResponse)response).sendRedirect("Formulaire.html?msg=Nom et age obligatoires");    
             return;
            }     
        }
        
        chain.doFilter(request, response);
        
        System.out.println("après checkFilter");
    }

    @Override
    public void destroy() {
       
    }
    
    
    
   
}
