package coursittaocp.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consommateur extends Thread {

    Object verrou;
    Producteur prod = new Producteur();

    @Override
    public void run() {
        while (true) {

            supprime();

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

    public void supprime() {
        synchronized (verrou) {
            while (prod.liste.isEmpty()) {
                try {
                    verrou.wait();
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
            System.out.println(prod.liste.remove(0) + " -> reste " + prod.liste.size());
            verrou.notify();
        }

    }

}
