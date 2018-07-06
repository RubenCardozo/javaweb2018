package coursittaocp.Patterns;

final class Immuable2 {
    private final char[] contenu;

    public char[] getContenu() {
        return contenu.clone();
    }

    public Immuable2(char[] contenu) {
        this.contenu = contenu;
    }
}
