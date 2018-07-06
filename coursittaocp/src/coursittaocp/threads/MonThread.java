
package coursittaocp.threads;

public class MonThread extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            throw new InterruptedException("Mort prématurée");
        }  catch (InterruptedException ex) {
            System.out.println(ex);
        }
        Thread courant= Thread.currentThread();
        //System.out.println(courant.getState());
        System.out.println("-Id: "+courant.getId()+"\n-Nom: "+courant.getName()+"\n-Priorité: "+courant.getPriority());
        System.out.println("Fin de "+courant.getName());
        //System.out.println("-Id: "+this.getId()+"\n-Nom: "+this.getName()+"\n-Priorité: "+this.getPriority());
    }

    public MonThread() {
    }

    public MonThread(Runnable target) {
        super(target);
    }

    public MonThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MonThread(String name) {
        super(name);
    }

    public MonThread(ThreadGroup group, String name) {
        super(group, name);
    }

    
    
}
