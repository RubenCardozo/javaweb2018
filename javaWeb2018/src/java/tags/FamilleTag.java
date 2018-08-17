package tags;

import biz.Personne;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.*;

public class FamilleTag extends TagSupport {

    private List<Personne> membre;
    private int nombreEnfants;
    
    public FamilleTag() {  
    }
    
    void addMembre(Personne p){
        membre.add(p);
    }
    
    public float getMoyenneAge(){
        return (float)membre.stream().mapToInt(p->p.getAge()).average().getAsDouble();
    }
    public float getNombre(){
        return membre.size();
    }
    
    
    @Override
    public int doStartTag() throws JspException {
        try {
            membre = new ArrayList<>();
            pageContext.getOut().println("Famille: ");
        } catch (IOException ex) {
            throw new JspException(ex);
        }
        
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().println("Nombre= "+(getNombre()-nombreEnfants)+", moy. age= "+getMoyenneAge()+", nb enfants="+nombreEnfants);
        } catch (IOException ex) {
            throw new JspException(ex);
        }
        nombreEnfants=0;
        return EVAL_PAGE;
    }  

    void addEnfant() {
        nombreEnfants++;
    }
}
