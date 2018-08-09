/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.io.IOException;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrator
 */
public class AsyncTaskListener implements AsyncListener{
    
    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {
        System.out.println(((HttpServletRequest)event.getAsyncContext().getRequest()).getRequestURL()
                +" in thread: "+Thread.currentThread().getId() +" à terminé"       
        );
        
    }
    @Override
    public void onComplete(AsyncEvent event) throws IOException {
       System.out.println(((HttpServletRequest)event.getAsyncContext().getRequest()).getRequestURL()
                +" in thread: "+Thread.currentThread().getId() +" à demarré"     
        );
       event.getAsyncContext().getResponse().getWriter().print("Fin");
    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {
        
    }

    @Override
    public void onError(AsyncEvent event) throws IOException {
        
    }

    
    
}
