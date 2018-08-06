/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Administrator
 */
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("denmarrage en context");
        sce.getServletContext().setAttribute("demarage", "je suis en train de demarrer");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("arret de l'app en cours");
    }
}
