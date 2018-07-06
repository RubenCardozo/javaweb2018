
package coursittaocp.LesStreams;

import coursittaocp.collection.AgeComparateur;
import coursittaocp.collection.Personne;
import java.sql.Array;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.*;




public class ExoStreams {
    public static void main(String[] args) {
        List<Personne> people = new ArrayList<>();
        Personne paul = new Personne("Paul", 05, 02, 1980, 2600);
        Personne pierre = new Personne("Pierre", 15, 11, 1993, 2700);
        Personne michel = new Personne("Michel", 25, 07, 1991, 2800);
        Personne jacques = new Personne("Jacques", 30, 06, 1999, 2900);
        Personne ives = new Personne("Ives", 03, 10, 1982, 3000);
        Personne jules = new Personne("Jules", 07, 11, 1971, 3100);
        Personne henri = new Personne("Henri", 10, 04, 1970, 5000);
        Personne pierre2 = new Personne("Pierre", 11, 12, 1975, 4000);
        Personne pierre3 = new Personne("Pierre", 21, 04, 1989, 5000);
        
        people.add(paul);
        people.add(pierre);
        people.add(pierre2);
        people.add(pierre3);
        people.add(michel);
        people.add(jacques);
        people.add(ives);
        people.add(jules);
        people.add(henri);
        
        
        //tous les "pierre"
        System.out.println("Liste de tous les 'Pierre'");
        people.stream()
                .filter(x->x.getNom().equalsIgnoreCase("pierre"))
                .forEach(System.out::println);
        
        
        //la liste triée par salaire / nom / age
        System.out.println();
        System.out.println("La liste triée par nom");
        List<Personne> ltn =people.stream()
                .sorted(Comparator.comparing(Personne::getNom))
                .collect(Collectors.toList());
        ltn.forEach(System.out::println);
        
        System.out.println();
        System.out.println("La liste triée par salaire");
        List<Personne> lts =people.stream()
                .sorted(Comparator.comparing(Personne::getSalaire))
                .collect(Collectors.toList());
        lts.forEach(System.out::println);
        
        System.out.println();
        System.out.println("La liste triée par age du plus jaune au plus agée");
        List<Personne> lta =people.stream()
                .sorted(Comparator.comparing(Personne::getNaissance).reversed())
                .collect(Collectors.toList());
        lta.forEach(System.out::println);
        
        
        //personne.s l.a.es mieux payee.s
        System.out.println();
        System.out.println("Le meilleur salaire");
        Float ms =people.stream()
                .map(Personne::getSalaire)
                .reduce((a, b) -> (a > b) ? a : b)
                .get();
        people.stream()
                .filter(x->x.getSalaire()==ms)
                .forEach(System.out::println);
        
        //personne.s l.a.es plus âgée.s
        System.out.println();
        System.out.println("La plus agée");
        Date d =people.stream()
                .map(Personne::getNaissance)
                .min((p1,p)->p1.compareTo(p))
                .get();
        people.stream()
                .filter(x->x.getNaissance()==d)
                .forEach(System.out::println);
        //System.out.println("d= "+d);
        //les personne par décennie de naissance; 
        System.out.println();
        System.out.println("Groupé par décenie");
        Map<Integer,List<Personne>>  mip =people.stream()
                .collect(Collectors.groupingBy(p-> p.getNaissance()
                        .toInstant()
                        .atZone(ZoneId.systemDefault()).toLocalDate()
                        .getYear()/10));
        mip.forEach((k,v)->{
            System.out.println(k*10);
            v.forEach(System.out::println);
        });
    }
}
