package coursittaocp.Generique;

import java.util.ArrayList;
import java.util.List;

public class Generique {

    public static void main(String[] args) {

        Voiture<Diesel> vc = new Voiture<>(new Diesel());
        System.out.println( vc.getPrixAu100km());

        Voiture aquoi = new Voiture();//????Voiture<Object>

        aquoi = vc;//Oups!
        vc = aquoi;//Oups!
        Voiture<Diesel> vo = new Voiture<>();
        //vo = vc;//Oups! Incompatible Voiture<Carburant> n'est pas Voiture<Object>
        //vc = vo;//Oups! Incompatible Voiture<Carburant> n'est pas Voiture<Object>
        List<Number> li = new ArrayList<>();
        li.add(12);
        li.add(5f);
        li.add(8f);

        Affiche(li);
        Affiche2(li);
        Affiche3(li);
        Affiche4(li);
    }

    static void Affiche(List l) {//raw type!! beurk
        System.out.println("****Affiche***");
        l.forEach(System.out::println);
    }
    static void Affiche2(List<?> l) {//Liste en lecture seulement
        //l.add(45);
        System.out.println("****Affiche2***");
        l.remove((Integer)12);
        l.forEach(System.out::println);
    }
    static void Affiche3(List<? extends Number> l) {//Liste en supression seulement mais n'accepte que les listes <sous number>
        System.out.println("****Affiche3***");
        //l.add(45);
        l.remove((Integer)12);
        l.forEach(System.out::println);
    }
    static void Affiche4(List<? super Integer> l) {//Liste qui n'accepte que les listes <au dessus Integer> mais n'ajoute que les Integers
        System.out.println("****Affiche4***");
        l.add(45);//mais n'ajoute que des Integers ou sous-type
        l.remove((Integer)12);
        l.forEach(System.out::println);
    }
}
