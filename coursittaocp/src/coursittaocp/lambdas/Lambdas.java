package coursittaocp.lambdas;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.*;

public class Lambdas {

    public static void main(String[] args) {

        ArrayList<Integer> ali = new ArrayList<>();
        ali.add(4);
        ali.add(8);
        ali.add(5);
        ali.add(3);
        ali.add(2);
        ali.add(8);

        ali.forEach(i -> System.out.print(i + ", "));
        System.out.println("");
        
        ali.forEach(System.out::print);
        System.out.println("");

        ali.sort((i, j) -> j.compareTo(i));
        ali.forEach(i -> System.out.print(i + ", "));
        System.out.println("");

        ali.removeIf(i -> i >= 8);
        ali.forEach(i -> System.out.print(i + ", "));
        System.out.println("");

        ali.replaceAll(i -> i * 2);
        ali.forEach(i -> System.out.print(i + ", "));
        System.out.println("");
        
        Map<String, String> mss= new TreeMap<>();
        mss.put("jo", "Joseph");
        mss.put("bill", "William");
        mss.put("pete", "Peter");
        mss.put("al", "Albert");
        
        mss.forEach((k,v)-> System.out.print(k+" = "+v+", "));
        System.out.println("");
        mss.computeIfAbsent("gu",(s)->"Guiseppe" );
        System.out.println(mss);
        
        mss.computeIfPresent("jo",(s,t)->"Josepha" );
        System.out.println(mss);
        
        mss.replaceAll((s,t)->t.toUpperCase());
        System.out.println(mss);
        
        
        
    }

    private static void ClassicLambdas() {
        Predicate<String> po = s -> s.contains("toto");
        Predicate<String> pi = s -> s.contains("titi");
        System.out.println(po.and(pi).test("toto titi"));
        System.out.println(po.negate().test("toto"));

        Function<String, Boolean> f = s -> s.contains("toto");
        System.out.println(f.apply("toto and titi"));
        System.out.println(f.andThen(b -> b.toString().toUpperCase()).apply("toto and titi"));

        Function<Integer, Integer> plus5 = s -> s + 5;
        Function<Integer, Integer> fois4 = s -> s * 4;

        System.out.println(plus5.andThen(fois4).apply(2));//(2+5)*4 function andThen()
        System.out.println(plus5.compose(fois4).apply(2));//(2*4)+5 function compose
        System.out.println(plus5.compose((Integer x) -> x * 3).apply(2));

        Supplier<String> su = () -> "toto and titi";
        String ss = su.get();

        Consumer<String> print = (s) -> System.out.println(ss);

        print.andThen(
                s -> System.out.println(s.toUpperCase()))
                .accept(ss);

        BiPredicate<String, Integer> bp = (s, i) -> i.toString().equals(s);
        System.out.println(bp.test("7", 7));

        BiFunction<String, String, Boolean> eq = (s1, s2) -> String.CASE_INSENSITIVE_ORDER.compare(s1, s2) == 0;
        System.out.println(eq.apply("toto", "Toto"));

        BinaryOperator<String> uppers = (s, t) -> (s + t).toUpperCase();
        System.out.println(uppers.apply("titi ", "toto"));

        BiConsumer<Integer, Integer> add = (i, j) -> System.out.println(i + j);
        add.accept(45, 12);

        int v = 10;//Considerée comme final de fait
        BiConsumer<Integer, Integer> addOups = (i, j) -> {
            //v=i++;// On ne peut pas affecter v. Illegal
            i += v;
            System.out.println(v + j);
        };
        addOups.accept(45, 12);

        Consumer<Integer> magic = System.out::println;//Function reference ou reference de mèthode
        magic.accept(12);
        magic = Test::imprime;

        Supplier<Object> magig2 = Test::imprime;
        System.out.println(magig2.get());

        UnaryOperator<Integer> uoi = new Test()::calc;//Function<Integer, Integer>
        System.out.println(uoi.apply(5));

        Supplier<Test> c = Test::new;
        Test t = c.get();
    }

    private static void syntaxeLambda() {
        Moteur c0 = new Moteur() {
            int i;

            @Override
            public boolean Chercher(String q) {
                return q.contains("toto" + (i++));
            }
        };

        Moteur c1 = q -> q.contains("toto");
        System.out.println(c1.Chercher("titi"));

        Moteur c2 = (q) -> q.contains("toto");

        Moteur c3 = (q) -> {
            return q.contains("toto");
        };

        Moteur c4 = (String q) -> {
//            int i=0;// Variable locale je peut la modifier comme je veux.
//            i++;
            return q.contains("toto");
        };

        //Moteur2<Integer> m= s -> s.contains(12);
    }
}