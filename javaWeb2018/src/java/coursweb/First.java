/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursweb;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class First extends HttpServlet {

    //int i=10;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getScheme());
        Integer i = (Integer) getServletContext().getAttribute("a1");

        if (i == null) {
            getServletContext().setAttribute("a1", 10);
        } else {
            getServletContext().setAttribute("a1", i + 1);
        }

        resp.getWriter().print("<html>"
                + "<body>"
                + "<h1>Hello from " + getServletContext().getAttribute("a1") + " doGet Servlet</h1>"
                + "</body>"
                + "</html>");

//        resp.getWriter().print("<htmtl>"
//               + "<body>"
//               + "<h1>Hello from "+ ++i +" doGet Servlet</h1>"
//               + "</body>"
//               + "</html>");
        if (i > 15) {
            getServletContext().removeAttribute("a1");
        }
        Enumeration<String> en = getServletContext().getAttributeNames();
        while (en.hasMoreElements()) {
            String n = en.nextElement();
            //System.out.println(n +" = "+ getServletContext().getAttribute(n)); 
        }

        String path = "/data/config.txt";
        try {
            //path = getServletContext().getRealPath(path);
            System.out.println("Lecture de: "+path);
            //Files.lines(Paths.get(path)).forEach(System.out::println);
            try (InputStream is = getServletContext().getResourceAsStream(path)) {
                int ci = -1;
                while ((ci = is.read()) > -1) {
                    System.out.print((char) ci);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        ServletContext myApp = getServletContext().getContext("/javaweb2018");
        System.out.println("ContextPath= "+myApp.getContextPath());
        System.out.println("ContextName= "+myApp.getServletContextName());
        
        String confiparam = getServletContext().getInitParameter("configparam");
        System.out.println("configparam= "+confiparam);
        
        Enumeration<String> pis = getServletContext().getInitParameterNames();
        while (pis.hasMoreElements()) {
            String n = pis.nextElement();
            System.out.println(n +"= "+ getServletContext().getInitParameter(n)); 
        }
        
        System.out.println(getServletContext() == getServletConfig().getServletContext());
        
        
    }

    @Override
    public void init() throws ServletException {
        //i=10;
        System.out.println("Nom: " + this.getServletConfig().getServletName());
    }

    @Override
    public void destroy() {
        System.out.println("Destroy ");
    }

}
