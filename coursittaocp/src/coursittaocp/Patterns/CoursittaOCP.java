package coursittaocp.Patterns;

public class CoursittaOCP {

    public static void main(String[] args) {
        Single s1 = Single.getInstance();

        Immuable2 i2 = new Immuable2(new char[]{'a', 'b', 'c'});

        char[] tc = i2.getContenu();
        tc[1] = 'Z';

        System.out.println(i2.getContenu());

        Immuable3 i3 = new Immuable3(new StringBuilder[]{
            new StringBuilder("a"),
            new StringBuilder("b"),
            new StringBuilder("c")
        }
        );
            
        
        System.out.println(i3.getContenu()[1]);
    }
}
