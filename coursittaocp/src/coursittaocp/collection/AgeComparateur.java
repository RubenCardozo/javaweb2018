package coursittaocp.collection;

import java.util.Comparator;


public class AgeComparateur implements Comparator<Personne>{

    @Override
    public int compare(Personne p1, Personne p2) {
        return p1.getNaissance().compareTo(p2.getNaissance());
    }
    
}
