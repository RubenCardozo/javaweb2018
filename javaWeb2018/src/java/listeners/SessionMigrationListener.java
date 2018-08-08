/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 *
 * @author Administrator
 */
public class SessionMigrationListener implements HttpSessionActivationListener{

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        
    }
    
}
