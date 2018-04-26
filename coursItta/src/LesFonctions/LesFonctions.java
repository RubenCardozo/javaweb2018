
package LesFonctions;

import cours.Abstract.*;
import cours.*;
import java.util.*;
import java.util.function.*;

public class LesFonctions {
    public static void main(String[] args) {
        
        List<Lievre> terrier = new ArrayList<>();
        terrier.add(new Lievre("lapineu",5));
        terrier.add(new Lievre("pierre",2));
        terrier.add(new Lievre("bugs",8));
        terrier.add(new Lievre("ruben",15));
        terrier.add(new Lievre("sofia",12));
        terrier.add(new Lievre("roger",2));
        terrier.add(new Lievre("jessica",8));
        
        
        System.out.println("\n********************Consumer*********************************");
        Consumer<Lievre> affiche= (l)->System.out.println(l.getNom()+", "+l.getAge());
        Consumer<Lievre> ligne= (l)->System.out.println("--------------------------");
        
        affiche.accept(terrier.get(0));
        //affiche.andThen(ligne).accept(terrier.get(1));
        //terrier.forEach(affiche);
        
        affiche.andThen(ligne)
               .andThen((li)->System.out.println("------------suite--------------\n"))
               .accept(terrier.get(2));
        
        System.out.println("\n********************Predicate*********************************");
        //Predicate
        terrier.removeIf((liev) -> liev.getAge()>10);
        terrier.forEach(affiche);
        
//        Predicate<Lievre> pre = (lie)-> lie.getAge()>10;
//        terrier.removeIf(pre);
//        terrier.forEach(affiche);
        
        
        //UnaryOperator
        System.out.println("\n********************Comparator: sort / age*********************************");
        
        terrier.replaceAll((li) -> new Lievre(li.getNom().toUpperCase(), li.getAge()+1));

        terrier.sort(new Comparator<Lievre> () {
            @Override
            public int compare(Lievre o1, Lievre o2) {
               //return ((Integer)o1.getAge()).compareTo(o2.getAge());
               return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        terrier.forEach(affiche);
        
        System.out.println("\n*******************Comparator: sort / nom*********************************");
        terrier.sort((o1,o2)->o1.getNom().compareTo(o2.getNom()));
        terrier.forEach(affiche);
    }
}
