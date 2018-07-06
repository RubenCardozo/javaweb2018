
package coursittaocp.lambdas;


interface Moteur {
    boolean Chercher(String quoi);
}
interface Moteur2<T> {
    boolean Chercher(T quoi);
}