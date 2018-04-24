
package LesFonctions;

import cours.Abstract.*;
import cours.*;
import java.util.*;
import java.util.function.Consumer;

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
        
        
        
        Consumer<Lievre> affiche= (l)->System.out.println(l.getNom()+", "+l.getAge());
        
        affiche.accept(terrier.get(0));
        
        terrier.forEach(affiche);
    }
}
