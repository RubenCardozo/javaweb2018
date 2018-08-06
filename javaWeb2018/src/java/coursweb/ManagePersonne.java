package coursweb;

import biz.Personne;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagePersonne extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String nom = request.getParameter("nom");
            String str_age = request.getParameter("age");
            int age = Integer.parseInt(str_age);
            Personne p = new Personne(nom, age);
            request.setAttribute("personne", p);
            RequestDispatcher rd = request.getRequestDispatcher("/personnes");
            rd.forward(request, response);

        } catch (Exception ex) {
            String message = "Parametres invalides";
            response.sendRedirect("Formulaire.html?msg=" + message);

            //               response.setHeader("Location", "Formulaire.html");
            //               response.sendError(302);
        }
    }
}
