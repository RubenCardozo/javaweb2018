package coursittaocp.entreesortie;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.GregorianCalendar;

class Personne implements Serializable{
    
    private String nom;
    
    private Date naissence;
    
    private transient float salaire;
    
    private static final long serialVersionUID = 1L;
    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getNaissence() {
        return naissence;
    }

    public void setNaissence(Date naissence) {
        this.naissence = naissence;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public Personne(String nom, int jour, int mois, int annee, float salaire) {
        this.nom = nom;
        this.naissence = Date.from(LocalDateTime.of(annee, mois, jour, 0, 0).toInstant(ZoneOffset.UTC));
        //this.naissence = new GregorianCalendar(annee, (mois-1), jour).getTime();
        this.salaire = salaire;
    }
    
    private void writeObject (ObjectOutputStream oos) throws IOException{
        oos.defaultWriteObject();
        oos.writeFloat(salaire*1.2f);    
    }
    
    private void readObject (ObjectInputStream ois) throws IOException, ClassNotFoundException{
        ois.defaultReadObject();
        salaire= ois.readFloat();
    }
}
