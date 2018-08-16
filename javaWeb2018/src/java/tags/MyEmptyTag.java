/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.*;

public class MyEmptyTag extends TagSupport {

    String _case="";
    String content="";
    
    @Override
    public int doStartTag() throws JspException {
       try {
            String s = "Debut de: "+this.content;
            
            if (this._case.equals("upper")) {
                s = s.toUpperCase();
            } else  {
                if (this._case.equals("lower")) {
                    s = s.toLowerCase();
                }
            }
            
            pageContext.getOut().println(s);
        } catch (IOException ex) {
            throw new JspException(ex);
        }   
        return SKIP_BODY;//ou SKIP_PAGE
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            String s = "Fin de: "+content;
            if (this._case.equals("upper")) {
                s = s.toUpperCase();
            } else {
                if (this._case.equals("lower")) {
                    s = s.toLowerCase();
                }
            }
            pageContext.getOut().println(s);
        } catch (IOException ex) {
            throw new JspException(ex);
        }
        return EVAL_PAGE;
    }

    public void setCase(String _case) {
        this._case = _case;
    }
    public void setContent(String content) {
         this.content = content;
    }
}
