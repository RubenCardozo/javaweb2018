/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursweb;

import biz.Personne;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
            HttpSession s = request.getSession(false);
            List<Personne> peuple;
            if (s == null) {
                s = request.getSession(true);
                //response.sendRedirect("Formulaire.html");
                response.encodeRedirectURL("Formulaire.html");
                return;
            } else {
                peuple = (List<Personne>) s.getAttribute("peuple");
                if (!(peuple instanceof List)) {
                    peuple = new ArrayList<>();
                    s.setAttribute("peuple", peuple);
                }
            }
            //Partie ADD
            Personne p = (Personne) request.getAttribute("personne");
            if (p != null) {
                s.setAttribute("peuple", peuple);
                peuple.add(p);
            }

            

            if (peuple.size() > 4) {
                s.invalidate();
            }

            if (peuple.size() == 1) {
                Cookie c = new Cookie("evenement", peuple.get(0).getNom());
                c.setMaxAge(120);
                //c.setPath("/javaweb2018/toto/");
                response.addCookie(c);
            }
            
            out.println(request.getRequestedSessionId() + "<br>");
            //out.println(s.getId()+"<br>");
            out.println("Max Inactive Interval= " + s.getMaxInactiveInterval() + "<br>");
            if (s.isNew()) {
                out.println("Bienvenue<br>");
            }
            
            out.println("URL Demandé: "+request.getRequestURI()+"<br>");
            out.println("request URI: "
                    +request.getAttribute("javax.servlet.forward.request_uri")+"<br>"
                    +request.getAttribute("javax.servlet.forward.context_path")+"<br>"
                    +request.getAttribute("javax.servlet.forward.servlet_path")+"<br>"
                    +request.getAttribute("javax.servlet.forward.query_string")+"<br>"
            );
            
            out.println("Première personne ajoutée: ");
            if(request.getCookies()!=null){
            Optional<Cookie> oc = Stream.of(request.getCookies()).filter(c -> c.getName().equals("evenement"))
                    .findFirst();
            out.println(oc.isPresent() ? oc.get().getValue() : "Pas de cookie evenement");
            }
            out.println(" <form action=\"managepersonne\">");
            out.println("<ul>");
            
            

                
//            for (int i = 0; i < peuple.size(); i++) {
//                Personne pe = peuple.get(i);
//                 try {
//                    out.println("<li>" + pe.getNom() + " " + pe.getAge() + "</li>"
//                            + "<button id=\"del\" name=\"del\" value=\"" + URLEncoder.encode(pe.getNom(), "UTF-8") + "\" type=\"submit\">DEL</button>" + "</li>"
//                            + "<button id=\"maj\" name=\"maj\" value=\""+ i +"\" type=\"submit\">EDIT</button>" + "</li>");
//                } catch (UnsupportedEncodingException ex) {
//                    Logger.getLogger(Personnes.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
            //include Liste
            request.setAttribute("peuple", peuple);
            getServletContext().getRequestDispatcher("/liste").include(request, response);

            out.println("</ul>");
            out.println("</form> ");

            out.println("<a href=\"" + response.encodeURL("Formulaire.html") + "\">Formulaire</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
