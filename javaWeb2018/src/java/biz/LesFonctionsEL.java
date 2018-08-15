/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz;

import java.util.Random;

/**
 *
 * @author Administrator
 */
public class LesFonctionsEL {
    final static Random r = new Random();
    public static int lanceDe(int max){
        return r.nextInt(max)+1;
    }
    public static Personne createPersonne(String nom, int age){
        return new Personne(nom, age);
    }
}
