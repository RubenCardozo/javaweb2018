package coursweb;

import biz.Personne;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ManagePersonne extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            if (!delete(request, response)) {
                if (!add(request, response)) {
                    edit(request, response);
                    return;
                }
            }
            //Le troids produit les meme resultat
            request.getRequestDispatcher(response.encodeURL("/personnes"))
                    .forward(request, response);
//            
//            getServletContext().getRequestDispatcher("/personnes")
//                    .forward(request, response);
            
//            getServletContext().getNamedDispatcher("/personnes")
//                    .forward(request, response);

        } catch (IOException | NumberFormatException | ServletException ex) {
            String message = "Parametres invalides";
            response.sendRedirect("Formulaire.html?msg" + message);
        }

    }

    private boolean add(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, ServletException, IOException {
        String nom = request.getParameter("nom");
        String str_age = request.getParameter("age");
        String maj = request.getParameter("maj");
        if (nom != null && str_age != null) {
            int age = Integer.parseInt(str_age);

            if (request.getParameter("add") != null) {
                Personne p = new Personne(nom, age);
                request.setAttribute("personne", p);
                request.getSession().setAttribute("derniere", p);
            } else if (maj != null) {
                Cookie c = new Cookie("personEdit", "");
                c.setMaxAge(0);
                response.addCookie(c);
                int i = Integer.parseInt(maj);
                HttpSession s = request.getSession(false);
                List<Personne> peuple = (List<Personne>) s.getAttribute("peuple");
                peuple.get(i).setNom(nom);
                peuple.get(i).setAge(age);
                request.getRequestDispatcher(response.encodeURL("/personnes"))
                        .forward(request, response);
            }

            return true;
        }
        return false;
    }

    private boolean delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String nomd = request.getParameter("del");
        if (nomd != null) {
            HttpSession s = request.getSession(false);
            List<Personne> peuple;
            if (s != null && (peuple = (List<Personne>) s.getAttribute("peuple")) != null) {
                String n = URLDecoder.decode(nomd, "UTF-8");
                return peuple.removeIf(p -> p.getNom().equals(n));
            }
        }
        return false;
    }

    private boolean edit(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, ServletException, IOException {
        String maj = request.getParameter("maj");
        if (maj != null) {

            try {
                int i = Integer.parseInt(maj);
                HttpSession s = request.getSession(false);
                List<Personne> peuple = (List<Personne>) s.getAttribute("peuple");
                Cookie c = new Cookie("personEdit", i + "|" + peuple.get(i).getNom() + "|" + peuple.get(i).getAge());
                response.addCookie(c);
                request.getRequestDispatcher(response.encodeURL("/Formulaire.html"))
                        .forward(request, response);
                return true;
            } catch (Exception e) {
                response.sendRedirect("Formulaire.html?msg=" + e);
            }

        }
        return false;
    }

}
