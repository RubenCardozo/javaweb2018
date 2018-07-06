/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursittaocp.concurrency;

import java.util.Random;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author Administrator
 */
public class MonAction extends RecursiveAction {

    int[] data;
    int limGauche;
    int limDroit;
    Random r = new Random();

    public MonAction(int[] data, int limGauche, int limDroit) {
        this.data = data;
        this.limGauche = limGauche;
        this.limDroit = limDroit;
    }

    @Override
    protected void compute() {
        if ((limDroit-limGauche) > 10) {//fork
            int moitie =((limDroit-limGauche)/2)+limGauche;
            
            MonAction m1 = new MonAction(data, limGauche, moitie);
            m1.fork();
            MonAction m2 = new MonAction(data, moitie, limDroit);
            m2.compute();
            m1.join();
        } else {// Tache à effectuer
            Thread courant = Thread.currentThread();
            System.out.println("Id:" + courant.getId() + "\t*Nom: " + courant.getName() + "\t*Priorité:" + courant.getPriority());
            for (int i = limGauche; i < limDroit; i++) {
                data[i] = r.nextInt(100);
            }
        }
    }
}
