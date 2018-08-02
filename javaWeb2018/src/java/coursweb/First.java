/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class First extends HttpServlet {

    int i;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getScheme());
        resp.getWriter().print("<htmtl>"
               + "<body>"
               + "<h1>Hello from "+ ++i +" doGet Servlet</h1>"
               + "</body>"
               + "</html>");
        
        
    }

    @Override
    public void init() throws ServletException {
        i=10;
        System.out.println("Nom: "+this.getServletConfig().getServletName());
    }

    @Override
    public void destroy() {
        System.out.println("Destroy ");
    }

    
  
}
