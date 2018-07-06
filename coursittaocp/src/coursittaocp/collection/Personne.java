package coursittaocp.collection;

import coursittaocp.entreesortie.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Objects;

public class Personne implements Serializable, Comparable<Personne> {

    private String nom;

    private Date naissance;

    private transient float salaire;

    private static final long serialVersionUID = 1L;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getNaissance() {
        return naissance;
    }

    public void setNaissence(Date naissance) {
        this.naissance = naissance;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public Personne(String nom, int jour, int mois, int annee, float salaire) {
        this.nom = nom;
        this.naissance = Date.from(LocalDateTime.of(annee, mois, jour, 0, 0).toInstant(ZoneOffset.UTC));
        //this.naissence = new GregorianCalendar(annee, (mois-1), jour).getTime();
        this.salaire = salaire;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeFloat(salaire * 1.2f);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        salaire = ois.readFloat();
    }

    @Override
    public int compareTo(Personne p) {
        
        if (p.nom != null) {
            if ((this.nom.equals(p.nom) && this.naissance.equals(p.naissance))) {
                return 0;
            }
            return this.nom.compareTo(p.nom); 
        }
        return -1;   
    }

    @Override
    public String toString() {
        return "\nPersonne=( " + "Prenom: " + this.getNom() + ", naissance: " + this.naissance + ", salaire:" + this.salaire + ", hashCode: " + this.hashCode() + " )";
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Personne && obj.getClass() == this.getClass()) {
            Personne p1 = (Personne) obj;
            return this.nom.equals(p1.nom) && this.naissance.equals(p1.naissance);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int no = 17 * Objects.hashCode(nom);
        int na = 13 * Objects.hashCode(naissance);
        int n = no + na;
        return n;
    }

    public Personne(String nom, Date naissance, float salaire) {
        this.nom = nom;
        this.naissance = naissance;
        this.salaire = salaire;
    }

}
