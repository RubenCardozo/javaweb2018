package coursittaocp.concurrency;

import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListeBloquee {

    final LinkedList<Date> liste = new LinkedList<>();

    private final Lock verrou = new ReentrantLock(true);
    private final Condition pasVide = verrou.newCondition();
    private final Condition pasPlein = verrou.newCondition();

    void ajoute(Date d) {
        boolean l=verrou.tryLock();
        try {
            l = verrou.tryLock(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        try {
            
            if (l) {
                while (liste.size() >= 20) {
                    pasVide.await();
                }
                liste.add(d);
                System.out.println("ajouté reste " + liste.size());
                pasPlein.signalAll();
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        } finally {
            if(l){
            verrou.unlock();
            }
        }

    }

    Date suprime() {
        Date d = null;
        try {
            verrou.lock();
            while (liste.isEmpty()) {
                pasPlein.await();
            }
            d = liste.remove();

            pasVide.signalAll();
            System.out.println("suprimé " + d + " reste " + liste.size());
            return d;
        } catch (InterruptedException ex) {
            System.out.println(ex);
        } finally {
            verrou.unlock();

        }
        return d;

    }
}
