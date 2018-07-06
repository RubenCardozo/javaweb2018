package coursittaocp.concurrency;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread courant = Thread.currentThread();
        System.out.println("Id:" + courant.getId() + "\t*Nom: " + courant.getName() + "\t*Priorité:" + courant.getPriority());
        return (int)courant.getId()*10;
    }
}
