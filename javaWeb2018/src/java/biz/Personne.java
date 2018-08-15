/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz;

import java.io.Serializable;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Personne implements  Serializable,  HttpSessionBindingListener,   IPersonne{
    private String nom;
    private int age;

    @Override
    public String getNom() {
        return nom;
    }
    @Override
    public String getNom(boolean upper) {
        return upper?nom.toUpperCase():nom.toLowerCase();
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Personne() {
    }
    
    public Personne(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println(event.getName()+" ajoutée: "+this.getNom());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
         System.out.println(event.getName()+" suprimée: "+this.getNom());
    }

    @Override
    public String getNomComplet(){
    return "Je suis "+nom+", j'ai "+age+" ans";
    }
}
