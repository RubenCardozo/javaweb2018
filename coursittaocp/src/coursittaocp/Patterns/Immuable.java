package coursittaocp.Patterns;

final class Immuable {
    
    private final String contenu;

    public String getContenu() {
        return contenu;
    }

    public Immuable(String contenu) {
        this.contenu = contenu;
    }
}
