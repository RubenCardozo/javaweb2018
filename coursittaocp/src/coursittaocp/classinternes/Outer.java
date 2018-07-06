package coursittaocp.classinternes;


public class Outer {

    private int iInO = 15;
    static private int siInO = 50;

    class Inner {

        private int iInO = 20;

        public Inner() {
            System.out.println(Outer.this.iInO + this.iInO);
            new Inner2();
        }
    }

    private class Inner2 {

        int iInInner2 = 25;
    }

    protected class Inner3 extends Outer {

    }

    static class SInner extends Inner2 {

        private int iInO = 20 + iInInner2;

        public SInner() {
            System.out.println(iInO + Outer.siInO);
        }

    }
    
    JusteFaitLe DoIt(){
        int LiInO=100;//Consideré comme final de fait
        class Inner4 implements JusteFaitLe{
            int iInInner4 = 60;
            int iTnO =14;
            int siInO =13;
            public Inner4() {
                //LiInO++;// Pas posible
                int LiInO = 200; //legal mais cache de DoIt()
                System.out.println(iInInner4 +this.iTnO+ Outer.this.iInO + Outer.siInO +LiInO);
            }
            
            @Override
            public void JustDoIt() {
                System.out.println("Victoire");
            }       
        }
        //LiInO++;// Si on la modifie ici, dans la clase sera imposible de l'utiliser dans Inner4
        //new Inner4().JusDoIt();//Functione cool
        return new Inner4();
    }  
    
}
