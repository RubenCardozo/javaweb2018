package coursittaocp.collection;

import Bundles.traduction_de;
import java.util.*;

public class MesCollections {

    public static void main(String[] args) {
       
        mesPriority();
        
        
    }

    private static void mesPriority() {
        System.out.println("-------------------ArrayDequeue------------------------");
        ArrayDeque<String> dqs = new ArrayDeque<>(8);
        dqs.add("A");
        dqs.addFirst("B");
        dqs.addLast("C");
        dqs.push("D");
        dqs.offer("E");
        dqs.offerFirst("F");
        dqs.offerLast("G");
        
        System.out.println(dqs);
        
        System.out.println(dqs.remove()); ;//A
        System.out.println("Reponse de remove('B'): "+dqs.remove("B"));//B et returne 'true'
        System.out.println(dqs.removeFirst());//D
        System.out.println(dqs.removeLast());//G
        //dqs.removeFirstOccurrence("F");
        //dqs.removeLastOccurrence("E");
        System.out.println(dqs.poll());//A
        
        System.out.println(dqs.peek());//C
        System.out.println(dqs.peekFirst());//C
        System.out.println(dqs.peekLast());//E
        
        System.out.println(dqs.pollLast());//E
        System.out.println(dqs.pollFirst());//C
        
        
        
        System.out.println("");
        System.out.println("-------------------PriorityQueue------------------------");
        
        PriorityQueue pqs = new PriorityQueue();
        pqs.offer("A");
        pqs.offer("E");
        pqs.offer("B");
        pqs.offer("C");
        pqs.offer("c");
        pqs.offer("a");
        System.out.println(pqs);
        
        System.out.println("Poll:");
        while (!pqs.isEmpty()) {            
            System.out.println(pqs.poll());
        }
        
        System.out.println("");
        System.out.println("------------------emptyList------------------------");
        Collection<String> cs= Collections.emptyList();
        System.out.println(cs==Collections.EMPTY_LIST);//true
        
        //cs.add("a");//Error l' emptylist(); est un Factory imuable
        List<String> ls = Arrays.asList("a","b","c");
        //ls.add("oups");
        
        List<Integer> li = new ArrayList<>();
        li.add(25);
        li.add(10);
        List tricheur = li;
        li.add(2);
        tricheur.add("NTM");
        
        System.out.println("");
        System.out.println("-----------tricheur----------------");
        System.out.println(li);
        
        li.remove("NTM");
        
        System.out.println("");
        System.out.println("----------tricheur2----------------");
        List tricheur2 = Collections.checkedList(li, Integer.class);
        //tricheur2.add("NTM");//Exception
        //System.out.println(li);
        
        List<Integer> ROli = Collections.unmodifiableList(li);
        //ROli.add(45);//Exception
        
        System.out.println(Collections.disjoint(ROli, li));

        Set<String> sto= Collections.singleton("o");
        //sto.remove("o");//Exception
        
        Collections.sort(li, Collections.reverseOrder());
    }

    private static void mesMaps() {
        Map<String, Personne> msp = new HashMap<>();
        msp.put("a", new Personne("aaaaa", 25, 12, 1980, 2000));
        msp.put("f", new Personne("fffff", 25, 12, 1980, 2000));
        msp.put("s", new Personne("sssss", 25, 12, 1980, 2000));
        msp.put("d", new Personne("ddddd", 25, 12, 1980, 2000));
        
        System.out.println("-------------------keySet------------------------");
        msp.keySet().forEach(
                k -> System.out.println(k + " " + msp.get(k))
        );
        
        System.out.println("");
        System.out.println("-------------------values------------------------");
        msp.values().forEach(
                v -> System.out.println(v)
        );
        
        System.out.println("");
        System.out.println("-------------------entrySet------------------------");
        msp.entrySet().forEach(entry->System.out.println(entry.getKey()+" : "+entry.getValue()));
        
        System.out.println("");
        System.out.println("-------------------Entrée de une même clé------------------------");
        msp.put("a",new Personne("a a a a a", 25, 12, 1980, 2000));
        msp.entrySet().forEach(entry->System.out.println(entry.getKey()+" : "+entry.getValue()));//Remplace la premier entröe
        
        
        NavigableMap<String,Personne> tmp = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        tmp.put("a", new Personne("aaaaa", 25, 12, 1980, 2000));
        tmp.put("f", new Personne("fffff", 25, 12, 1980, 2000));
        tmp.put("s", new Personne("sssss", 25, 12, 1980, 2000));
        tmp.put("d", new Personne("ddddd", 25, 12, 1980, 2000));
        System.out.println("");
        System.out.println("-------------------tmp------------------------");

        tmp.headMap("d").put("c", new Personne("ccccc", 25, 12, 1980, 2000));
        
        tmp.entrySet().forEach(entry->System.out.println(entry.getKey()+" : "+entry.getValue()));
        System.out.println("");
        System.out.println("-------------------ceiling (Top ciel)------------------------");
        System.out.println(tmp.ceilingEntry("e"));//Superior ou egal ä la clé
        

        System.out.println("");
        System.out.println("-------------------floor (soul)------------------------");
        System.out.println(tmp.ceilingEntry("e"));//Inferieur ou egal ä la clé
        
       
        System.out.println("");
        System.out.println("-------------------higher (Superieur)------------------------");
        System.out.println(tmp.higherEntry("d"));//Strictament Superieur ä la clé
        
        
        System.out.println("");
        System.out.println("-------------------lower (Inferieur)------------------------");
        System.out.println(tmp.lowerEntry("d"));//Strictament inferieur ä la clé
        
        System.out.println("");
        System.out.println("-------------------descending (Navegation a l'inverse)------------------------");
        tmp.descendingMap().forEach((k,v)->System.out.println(k+" "+v));
    }

    private static void monTreeSet() {
        HashSet<Personne> hp = new HashSet<>();

        Personne paul = new Personne("Paul", 25, 12, 1980, 2000);
        Personne pierre = new Personne("Pierre", 25, 12, 1990, 2000);
        Personne pierre2 = new Personne("Pierre", 25, 12, 1991, 3000);
        Personne jacques = new Personne("Jacques", 25, 12, 2000, 2000);
        Personne paul2 = new Personne(null, 25, 12, 1980, 2000);
        Personne henri = new Personne("Henri", 25, 12, 1971, 2000);
        Personne henri2 = new Personne("Henri", 25, 12, 1970, 2000);

        hp.add(paul);
        hp.add(pierre);
        hp.add(pierre2);
        hp.add(jacques);
        hp.add(paul2);
        hp.add(henri);
        hp.add(henri2);
        hp.add(null);

        hp.remove(jacques);

        if (paul.equals(paul2)) {
            System.out.println("Ils sont egaux");
        } else {
            System.out.println("ils sont diferents");
        }

        for (Personne p : hp) {
            System.out.println(p);
        }

        System.out.println("   ");

        System.out.println("-------------------TreeSet------------------------");
        SortedSet<Personne> ssp = new TreeSet<>();

        ssp.add(paul2);
        ssp.add(pierre);
        ssp.add(paul);
        ssp.add(jacques);
        ssp.add(henri);
        ssp.add(pierre2);
        ssp.add(henri2);

        for (Personne p : ssp) {
            System.out.println(p);
        }

        System.out.println("   ");

        System.out.println("----------------TreeSet----AGE--------------------");
        SortedSet<Personne> ssparage = new TreeSet<>(new AgeComparateur());
        ssparage.add(pierre);
        ssparage.add(paul);
        ssparage.add(jacques);
        ssparage.add(henri);

        for (Personne p : ssparage) {
            System.out.println(p);
        }

        System.out.println("   ");

        SortedSet<Personne> ssparage2 = new TreeSet<>(
                (p1, p2) -> p1.getNaissance().compareTo(p2.getNaissance())
        );

        System.out.println("   ");
        System.out.println("----------------Liste Complète--------------------");
        SortedSet<String> tsString = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        tsString.add("aa");
        tsString.add("BB");
        tsString.add("cc");
        tsString.add("dd");
        tsString.add("EE");
        tsString.add("HH");
        tsString.add("TT");
        tsString.add("CC");//pas inseré!
        tsString.add("RR");
        tsString.forEach(System.out::println);
        System.out.println("----------------jusquaD--------------------");
        SortedSet<String> jusquaD = tsString.headSet("dd");//Limit de notre list de base
        jusquaD.add("11");
        //jusquaD.add("dc");

        tsString.remove("aa");
        tsString.add("22");

        jusquaD.forEach(System.out::println);

        System.out.println("   ");
        System.out.println("----------------apartir de L--------------------");
        SortedSet<String> apartir_de_L = tsString.tailSet("L");
        apartir_de_L.forEach(System.out::println);

        System.out.println("   ");
        System.out.println("----------------entre dd et TT--------------------");
        SortedSet<String> entreDetT = tsString.subSet("dd", "TT");
        entreDetT.add("ss");
        entreDetT.forEach(System.out::println);
    }
}
