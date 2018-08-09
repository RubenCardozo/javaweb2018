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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.xml.ws.ResponseWrapper;

import coursweb.*;
/**
 *
 * @author Administrator
 */
public class HeadingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       
        MonResponseWrapper rw= new MonResponseWrapper((HttpServletResponse)response);
        
        chain.doFilter(request, rw);
        String contenu = rw.getContenu();
        contenu = contenu.replaceAll("Hello", "<div>Replace by Heading Filter: Bonjour</div>");
        
        //rw.getResponse().getWriter().println("<div>Added by Heading Filter</div>"+contenu);
        rw.getOriginalWriter().println("<div>Added by Heading Filter with getOriginalWriter</div>"+contenu);
    }

    @Override
    public void destroy() {
        
    }
    
}
