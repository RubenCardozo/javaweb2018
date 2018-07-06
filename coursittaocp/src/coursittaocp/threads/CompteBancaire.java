package coursittaocp.threads;

public class CompteBancaire {

    int solde;

    synchronized public void crediter(int montant) {

        System.out.println("credit de= " + montant + " par " + Thread.currentThread().getName());

        solde += montant;
        System.out.println("solde= " + solde);

    }

    public void debiter(int montant) {
        synchronized (this) {

            System.out.println("debit de= " + montant + " par " + Thread.currentThread().getName());

            if (solde >= montant) {
                solde -= montant;
                System.out.println("solde= " + solde);
            } else {
                System.out.println("debit de= " + montant + " imposible");
            }
        }
    }
    synchronized static void afficher(CompteBancaire cb){
        System.out.println("affichage");
    }
    
    static void afficher2(CompteBancaire cb){
        
        synchronized(CompteBancaire.class){
        System.out.println("affichage2");
        }
    }
}
