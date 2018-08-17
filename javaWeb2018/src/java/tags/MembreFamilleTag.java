
package tags;

import biz.Personne;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.*;

public class MembreFamilleTag extends TagSupport {
    
    private Personne personne;
    private String nom;
    private int age;
    private int compteurEnfant;
    @Override
    public int doStartTag() throws JspException {
//        JspTag famille = getParent();
//        if (famille instanceof FamilleTag) {
//            FamilleTag ft = (FamilleTag) famille;
//            personne= new Personne(nom, age);
//            ft.addMembre(personne);
//        }

        FamilleTag ft = (FamilleTag)findAncestorWithClass(this, FamilleTag.class);
        
        if (ft != null) {
            personne= new Personne(nom, age);
            ft.addMembre(personne);
        }
        return SKIP_BODY;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
}
