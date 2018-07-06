
package coursittaocp.threads;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable{
    
    BlockingQueue<Date> bqd;
    
    @Override
    public void run() {
        while (true) {            
            try {
                bqd.put(new Date());
                
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            System.out.println("date ajoutée");
        }
    }  
}
