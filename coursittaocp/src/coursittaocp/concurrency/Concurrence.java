package coursittaocp.concurrency;

import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Concurrence {

    public static void main(String[] args) {
        
        int[] tabi = new int[1000000];

        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        MonAction m = new MonAction(tabi, 0, tabi.length);
        pool.invoke(m);
        //System.out.println(Arrays.toString(tabi));
        
        long lo = System.nanoTime();
        MaTache mt = new MaTache(tabi, 0, tabi.length);
        System.out.println("sum: " + pool.invoke(mt));
        System.out.println("temps: " +NumberFormat.getInstance().format(System.nanoTime() - lo));
        pool.shutdown();

        lo = System.nanoTime();
        System.out.println("sum 2: " + Arrays.stream(tabi).parallel().sum());
        System.out.println("temps 2: " + NumberFormat.getInstance().format(System.nanoTime() - lo));

        lo = System.nanoTime();
        int sum = 0;
        for (int i : tabi) {
            sum += i;
        }
        System.out.println("sum: 3 = " + sum);
        System.out.println("temps 3: " + NumberFormat.getInstance().format(System.nanoTime() - lo));

    }

    private static void futures() {
        ExecutorService exe = Executors.newCachedThreadPool();
        //Future<Integer> fi = exe.submit(new MyCallable());
        Future<Integer> fi = exe.submit(() -> {
            Thread courant = Thread.currentThread();
            System.out.println("Id:" + courant.getId() + "\t*Nom: " + courant.getName() + "\t*Priorité:" + courant.getPriority());
            return (int) courant.getId() * 10;
        });

        try {
            System.out.println(fi.get());
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println(ex);
        }
        exe.shutdown();

        List<Callable<Integer>> lc = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            lc.add(() -> r.nextInt(50));
        }
        exe = Executors.newCachedThreadPool();
        try {
            List<Future<Integer>> lfi = exe.invokeAll(lc);
            lfi.forEach(fin -> {
                try {
                    System.out.println(fin.get());

                } catch (InterruptedException | ExecutionException ex) {
                    System.out.println(ex);
                }
            });
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        exe.shutdown();

        new Thread(
                new FutureTask<>(
                        new MyCallable()
                )
        ).start();
    }

    private static void executeurs() {
        //        ExecutorService exe = Executors.newFixedThreadPool(4);
//        for (int i = 0; i < 50; i++) {
//            exe.submit(() -> {
//                Thread courant = Thread.currentThread();
//                System.out.println("Id: " + courant.getId() + " *Nom: " + courant.getName() + " *Priorité: " + courant.getPriority());
//                try {
//                    Thread.sleep(100); 
//                } catch (InterruptedException ex) {
//                    System.out.println(ex);
//                }
//            });
//        }
//        exe.shutdown();

        ScheduledExecutorService exes = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 3; i++) {
            exes.scheduleAtFixedRate(
                    () -> {
                        Thread courant = Thread.currentThread();
                        System.out.println("Id:" + courant.getId() + "\t*Nom: " + courant.getName() + "\t*Priorité:" + courant.getPriority());
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                    }, 2, 3, TimeUnit.SECONDS);
        }
        try {
            exes.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        exes.shutdown();
    }

    private static void barrieres() {
        CyclicBarrier cb = new CyclicBarrier(2);
        CyclicBarrier cb2 = new CyclicBarrier(2);

        new Thread(() -> {
            try {
                System.out.println("affiche 1");
                cb.await();
                System.out.println("affiche 2");
                Thread.sleep(1000);
                cb2.await();
                System.out.println("affiche 3");
            } catch (InterruptedException | BrokenBarrierException ex) {
                System.out.println(ex);

            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("affiche 10");
                cb.await();
                System.out.println("affiche 20");
                Thread.sleep(1000);
                cb2.await();
                System.out.println("affiche 30");
            } catch (InterruptedException | BrokenBarrierException ex) {
                System.out.println(ex);
            }
        }).start();
    }

    private static void locks() {
        ListeBloquee lb = new ListeBloquee();
        AtomicInteger ai = new AtomicInteger();

        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                lb.ajoute(new Date());

            }, "Thread Add" + ai.addAndGet(1)).start();
            new Thread(() -> {
                try {
                    lb.suprime();
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }, "Thread Supp" + ai.addAndGet(1)).start();
        }
    }

}
