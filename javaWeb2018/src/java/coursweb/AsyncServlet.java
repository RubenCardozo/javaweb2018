/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import listeners.AsyncTaskListener;

/**
 *
 * @author Administrator
 */
public class AsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
        Tache t = new Tache(response);
        Thread tr = new Thread(t);
        tr.start();
        
        AsyncContext context = request.startAsync();
        context.addListener(new AsyncTaskListener());
        
        context.setTimeout(2000);
        Tache2 t2 = new Tache2(context);
        Thread tr2 = new Thread(t2);
        tr2.start();
        
        response.getWriter().println("<div>Généré par la Servlet dans Thread: "+Thread.currentThread().getId()+"</div><br>");
    }
}
