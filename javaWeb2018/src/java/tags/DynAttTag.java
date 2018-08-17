
package tags;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.*;

public class DynAttTag extends TagSupport implements DynamicAttributes{

    @Override
    public int doStartTag() throws JspException {
        
       try {
            pageContext.getOut().println("somme= "+valeur.toString()+"= "+valeur.values().stream().mapToInt(c->c).sum());    
        } catch (IOException ex) {
            throw new JspException(ex);
        }   
        return SKIP_BODY;//ou SKIP_PAGE
    }
    
    Map<String, Integer> valeur= new HashMap<>();
    
    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        valeur.put(localName, Integer.parseInt((String)value));
    }

    @Override
    public int doEndTag() throws JspException {
        valeur.clear();
        return super.doEndTag(); 
    }
    
}
