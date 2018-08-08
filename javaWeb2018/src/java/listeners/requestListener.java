/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;


public class requestListener implements ServletRequestListener, ServletRequestAttributeListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println(((HttpServletRequest)sre.getServletRequest()).getSession());
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        srae.getServletRequest().getAttribute("toto");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
