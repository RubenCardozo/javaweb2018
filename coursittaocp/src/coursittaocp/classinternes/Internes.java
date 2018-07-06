package coursittaocp.classinternes;

import coursittaocp.collection.*;

public class Internes {

    public static void main(String[] args) {
        Outer o = new Outer();
        Outer.Inner oi = o.new Inner();

        Outer.Inner oi2 = new Outer().new Inner();
        Outer.SInner osi = new Outer.SInner();
        //o.DoIt();
        JusteFaitLe i4 = o.DoIt();
        i4.JustDoIt();

        JusteFaitLe i5 = new JusteFaitLe() {
            @Override
            public void JustDoIt() {
                System.out.println("JustDoIt annonime");
            }
        };
        i5.JustDoIt();

        JusteFaitLe i6 = () -> {
            System.out.println("JustDoIt lambda");
        };
        i6.JustDoIt();

        Personne pp = new Personne("Paul", 11, 6, 1970, 6000) {
            @Override
            public String getNom() {
                return getNomComplet();
            }

            private String getNomComplet() {
                return (super.getNom() + " " + "Le grand ".toUpperCase() + super.getNaissance());
            }
        };
        System.out.println(pp.getNom());
    }
}
