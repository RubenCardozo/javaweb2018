
package listeners;

import javax.servlet.MultipartConfigElement;
import javax.servlet.Servlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class MonServletListener implements ServletContextListener, ServletRequestListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletRegistration.Dynamic srd = sce.getServletContext().addServlet("UploadServlet", servlets.UploadServlet.class);
        srd.addMapping("/files/upload");
        MultipartConfigElement mce = new MultipartConfigElement("", 1000_000L, 1000_000, 50000);
        srd.setMultipartConfig(mce);
        srd.setInitParameter("dirname", "data");
           
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

    }

}
