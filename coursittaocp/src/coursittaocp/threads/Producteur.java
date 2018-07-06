package coursittaocp.threads;

import java.util.*;
import java.util.logging.*;


public class Producteur extends Thread {

    LinkedList<Date> liste = new LinkedList<>();
    Object verrou;

    @Override
    public void run() {
        while (true) {
            ajoute();
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

    public void ajoute() {
        synchronized (verrou) {
            
            while (liste.size() >= 20) {
                try {
                    verrou.wait();
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
            liste.addLast(new Date());
            verrou.notify();
            System.out.println("Date ajoutée");
            
        }

//        if (liste.size() < 20) {
//            synchronized (verrou) {
//                liste.addLast(new Date());
//                //verrou.notify();
//                verrou.notifyAll();
//                System.out.println("Date ajoutée");
//            }
//        }
    }

}
