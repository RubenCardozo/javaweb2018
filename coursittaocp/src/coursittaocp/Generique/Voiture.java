package coursittaocp.Generique;

class Voiture<C extends Carburant> implements Vehicule<C>{

    public Voiture() {
    }
   
    C carburant ;
    
    //Constructeur
    public Voiture(C carburant){
        this.carburant =carburant;
    }

    @Override
    public float getPrixAu100km() {
        return carburant.getPrix();
    }
}
