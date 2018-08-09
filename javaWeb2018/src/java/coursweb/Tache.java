/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursweb;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

public class Tache implements Runnable{
    
    HttpServletResponse response;

    public Tache(HttpServletResponse response) {
        this.response = response;
    }
    
    @Override
    public void run() {
        try {
            response.getWriter().println("<div>Généré par la Thread: "+Thread.currentThread().getId()+"</div><br>");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}
