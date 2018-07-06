package coursittaocp.threads;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LesThreads {

    public static void main(String[] args) {

        
            
    }

    private static void ProdConsV2() {
        BlockingQueue<Date> bl = new ArrayBlockingQueue<Date>(20);
        Producer p= new Producer();
        Consomer c = new Consomer();
        p.bqd=c.bqd=bl;
                
        new Thread(p).start();
        new Thread(c).start();
    }

    private static void ProdConsV1() {
        Producteur pr = new Producteur();
        Consommateur co = new Consommateur();
        co.prod=pr;
        final Object o= new Object();
        pr.verrou=co.verrou=o;
        
        
        pr.start();
        co.start();
    }

    private static void Synchron() {
        CompteBancaire cb = new CompteBancaire();
        List<Thread> lt = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            lt.add(new Thread(() -> {
                cb.crediter(2000);
            }, "t1-" + i
            ));

            lt.add(new Thread(() -> {
                cb.debiter(3000);
            }, "t2-" + i
            ));

            lt.add(new Thread(() -> {
                cb.debiter(1000);
            }, "t3-" + i
            ));
        }

        lt.forEach(t -> t.start());
        
        lt.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        });
        
        System.out.println("Solde final= " + cb.solde);
        //System.out.println("Fin de Main");
    }

    private static void AnonymAndLambda() {
        new Thread("tache2") {
            @Override
            public void run() {
                Thread courant = Thread.currentThread();
                System.out.println("-Id: " + courant.getId() + "\n-Nom: " + courant.getName() + "\n-Priorité: " + courant.getPriority());
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread courant = Thread.currentThread();
                System.out.println("-Id: " + courant.getId() + "\n-Nom: " + courant.getName() + "\n-Priorité: " + courant.getPriority());
            }
        }, "Anonymous").start();

        new Thread(() -> {
            Thread courant = Thread.currentThread();
            System.out.println("-Id: " + courant.getId() + "\n-Nom: " + courant.getName() + "\n-Priorité: " + courant.getPriority());
        }, "Dans lambda"
        ).start();
    }

    private static void ClassicLaunch() {
        System.out.println("-----MAIN--------");
        Thread courant = Thread.currentThread();
        System.out.println("-Id: " + courant.getId() + "\n-Nom: " + courant.getName() + "\n-Priorité: " + courant.getPriority());
        System.out.println("Fin de " + courant.getName());

        System.out.println("");
        System.out.println("-----MON THREAD--------");
        Thread t = new MonThread("tache1");
        t.setPriority(Thread.MIN_PRIORITY);
        t.setDaemon(false);
        t.start(); //Pas de run()

        try {
            //t.sleep(2000);
            t.join(2000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println("Fin de " + courant.getName());
    }
}
