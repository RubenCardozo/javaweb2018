package coursittaocp.LesStreams;

import coursittaocp.collection.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

public class LesStreams {

    public static void main(String[] args) {

        long debug = System.nanoTime();

        Stream.of(4, 5, 6, 7, 10, 8, 9, 4, 6, 8)
                .distinct()
                .forEach((i) -> System.out.print("i= " + i + ", "));
        System.out.println("//forEach() sans parallel()\n" + (System.nanoTime() - debug));

        System.out.println();

        debug = System.nanoTime();
        Stream.of(4, 5, 6, 7, 10, 8, 9, 4, 6, 8)
                .parallel()
                .distinct()
                .forEachOrdered((i) -> System.out.print("i= " + i + ", "));
        System.out.println("//forEachOrdered()\n" + (System.nanoTime() - debug));

        IntStream asi = Arrays.stream(new int[]{});
        Stream<Integer> asI = Arrays.stream(new Integer[]{4, 8, 9, 6, 3, 5});

        OptionalInt oi = asi.max();
        if (oi.isPresent()) {
            System.out.println(oi.getAsInt());
        } else {
            System.out.println("Stream vide");
        }

        System.out.println(oi.orElse(0));
        oi.ifPresent(i -> System.out.println(i));

        System.out.println(asI
                .mapToInt(I -> I.intValue())
                .sequential()
                .filter(i -> i % 2 == 0)
                .count()
        );

        asi = Arrays.stream(new int[]{4, 5, 6});
        Stream<Integer> si = asi.mapToObj(i -> i);

        asi = Arrays.stream(new int[]{4, 5, 6});
        System.out.println("asi.allMatch()= " + asi.allMatch(i -> i > 0));

        asi = Arrays.stream(new int[]{4, 5, 6});
        System.out.println("asi.anyMatch()= " + asi.anyMatch(i -> i == 5));

        asi = Arrays.stream(new int[]{4, 5, 6});
        System.out.println("Collectors.toList()= "+asi
                .mapToObj(i -> i)
                .collect(Collectors.toList())
        );

        asi = Arrays.stream(new int[]{4, 5, 6});
        System.out.println("Collectors.reducing()= " + asi
                .mapToObj(i -> i)
                .collect(Collectors.reducing((i, j) -> i - j)).get()
        );

        asi = Arrays.stream(new int[]{4, 5, 6});
        System.out.println("reduce()= " + asi
                .reduce((i, j) -> i * j)
                .getAsInt()
        );

        asi = Arrays.stream(new int[]{4, 5, 6, 7, 8, 9, 10});
        Map<Boolean, List<Integer>> mbI = asi
                .mapToObj(i -> i)
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("Collectors.partitioningBy()= " + mbI);

        asi = Arrays.stream(new int[]{4, 5, 6, 7, 8, 9, 10});
        Map<Integer, List<Integer>> mbI2 = asi
                .mapToObj(i -> i)
                .collect(Collectors.groupingBy(i -> i % 3));
        System.out.println("Collectors.groupingBy()= " + mbI2);

        asI = Arrays.stream(new Integer[]{4, 5, 6, 7, 8, 9, 10});
        List<Float> lf= asI.collect(Collectors.mapping(i->i*2.5f, Collectors.toList()));
        System.out.println("Collectors.mapping()= "+lf);

        asI = Arrays.stream(new Integer[]{4, 5, 6, 7, 8, 9, 10});
        Integer ii= asI.collect(Collectors.mapping(i->i%5, Collectors.maxBy(Integer::compare))).get();
        System.out.println("Collectors.maxBy()= "+ii);

        asI = Arrays.stream(new Integer[]{4, 5, 6, 7, 8, 9, 10});
        System.out.println("count: "+ asI
                .peek(System.out::println)
                .count());

        System.out.println("----------------");
        asI = Arrays.stream(new Integer[]{4, 5, 6, 7, 8, 9, 10});
        System.out.println("sum: "+ asI
                .peek(i->System.out.println("base  : "+i))
                .mapToInt(i->i*2)
                .peek(i->System.out.println("base*2: "+i))
                .sum());

        System.out.println("----------------");
        asI = Arrays.stream(new Integer[]{4, 5, 6, 7, 8, 9, 10});
        IntSummaryStatistics stats= asI.mapToInt(i->i).summaryStatistics();
        System.out.println("Min:"+ stats.getMin()+
                " Max:"+ stats.getMax()+
                " Sum:"+ stats.getSum()
        );

        System.out.println("----------------");
        asI = Arrays.stream(new Integer[]{8, 9, 10,10,4,6, 6});
        System.out.println("nb uniq: "+asI
                .sorted()
                .peek(System.out::println)
                .distinct()
                .peek(i->System.out.println("uniq: "+i))
                .count()
        );

        System.out.println("----------------");
        asI = Arrays.stream(new Integer[]{3,4,5,6,7,8,9});
        asI.limit(5)
            .skip(2)
            .forEach(System.out::println);
        
        System.out.println("----------------");
        "qwertzuio\n".chars().forEach(i->System.out.print((char)i));
        
        SortedSet<Personne> ssparage = new TreeSet<>(new AgeComparateur());
        Personne paul = new Personne("Paul", 25, 12, 1980, 2000);
        Personne pierre = new Personne("Pierre", 25, 12, 1990, 2000);
        Personne michel = new Personne("Michel", 25, 12, 1991, 2000);
        Personne jacques = new Personne("Jacques", 25, 12, 1999, 2000);
        Personne ives = new Personne("Ives", 25, 12, 1982, 2000);
        Personne jules = new Personne("Jules", 25, 12, 1971, 2000);
        Personne henri = new Personne("Henri", 25, 12, 1970, 2000);
        
        ssparage.add(paul);
        ssparage.add(pierre);
        ssparage.add(michel);
        ssparage.add(jacques);
        ssparage.add(ives);
        ssparage.add(jules);
        ssparage.add(henri);
        
        System.out.println("Moyenne du salaire: "+
        ssparage.stream()
                .mapToDouble(p->p.getSalaire())
                .average()
                .getAsDouble()
        );
        System.out.println("Moyenne du salaire: "+
        ssparage.stream()
                .collect(Collectors.averagingDouble(p->p.getSalaire()))   
        );
        
        System.out.println("Prenoms des salariés: "+
        ssparage.stream()
                .map(Personne::getNom)
                .collect(Collectors.joining(", "))
        );
        
        try {
            System.out.println("numero de lignes: "+ Files.lines(Paths.get("c://toto.txt")).count());
        } catch (Exception ex) {
            System.out.println("");
        }
    }

}
