/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursittaocp.concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Administrator
 */
public class MaTache extends RecursiveTask<Integer>{
    int[] data;
    int limGauche;
    int limDroit;
    Random r = new Random();

    public MaTache(int[] data, int limGauche, int limDroit) {
        this.data = data;
        this.limGauche = limGauche;
        this.limDroit = limDroit;
    }

    @Override
    protected Integer compute() {
        if ((limDroit-limGauche) > 10) {//fork
            int moitie =((limDroit-limGauche)/2)+limGauche;
            MaTache m1 = new MaTache(data, limGauche, moitie);
            m1.fork();
            MaTache m2 = new MaTache(data, moitie, limDroit);
            return m2.compute()+m1.join();
           
        } else {// Tache à effectuer
            //return Arrays.stream(Arrays.copyOfRange(data, limDroit, limDroit)).sum();
            int sum = 0;
            for (int i = limGauche; i < limDroit; i++) {
                sum+=data[i]; 
            }
            return sum;
        }
        
    }
}
