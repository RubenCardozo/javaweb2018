/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursweb;

import biz.Personne;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Personnes extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Personnes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Personnes</h1>");

            //Personne p = (Personne) request.getAttribute("personne");
            List<Personne> peuple = null;
            HttpSession s = request.getSession();
            peuple = (List<Personne>) s.getAttribute("peuple");
            
            if (peuple instanceof List) {
                peuple = new ArrayList<>();
            }
            
            Personne p = (Personne)request.getAttribute("personne");
            
            if (p != null) {
                s.setAttribute("peuple", peuple);
                peuple.add(p);
            }

            out.println("<ul>");
            peuple.forEach(pe-> out.println("<li>" + pe.getNom() + " " + pe.getAge()));
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
