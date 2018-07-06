package coursittaocp.Patterns;


public class Immuable3 {
     private final StringBuilder[] contenu;

    public StringBuilder[] getContenu() {
        StringBuilder[] copie = new StringBuilder[contenu.length];
        for (int i = 0; i < contenu.length; i++) {
            copie[i] = new StringBuilder(contenu[i].toString());   
        }
        return copie;
    }

    public Immuable3(StringBuilder[] contenu) {
        this.contenu = contenu;
    }
}
