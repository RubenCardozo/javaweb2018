
package coursweb;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletResponse;

public class Tache2 implements Runnable{
    AsyncContext context;
    
    public Tache2(AsyncContext context) {
        this.context = context;
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            context.getResponse().getWriter().println("<div>Généré par la Thread2: "+Thread.currentThread().getId()+"</div><br>");
            context.getResponse().flushBuffer();
            context.complete();
        } catch (IOException ex) {
            System.out.println(ex);
        }catch (InterruptedException ex) {
            System.out.println(ex);;
        }
    }
    
}
