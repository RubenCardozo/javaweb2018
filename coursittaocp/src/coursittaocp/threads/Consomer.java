
package coursittaocp.threads;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

public class Consomer implements Runnable{
    BlockingQueue<Date> bqd;
    
    @Override
    public void run() {
        while (true) {            
            try {
                Thread.sleep(200);
                System.out.println("consomé: "+ bqd.take() + " sur "+bqd.size());
                
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            System.out.println("date supprimée");
        }
    }
}
