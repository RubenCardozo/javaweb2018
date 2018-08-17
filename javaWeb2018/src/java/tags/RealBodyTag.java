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
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 *
 * @author Administrator
 */
public class RealBodyTag extends BodyTagSupport {

    String casse;

//    @Override
//    public int doStartTag() throws JspException {
//        return EVAL_BODY_BUFFERED;
//    }
    
    @Override
    public int doAfterBody() throws JspException {
        BodyContent bc = getBodyContent();
        String contenu = bc.getString();

        if (casse.equals("upper")) {
            contenu = contenu.toUpperCase();
        } else {

            if (casse.equals("lower")) {
                contenu = contenu.toLowerCase();
            }
        }
        try {
            bc.getEnclosingWriter().print(contenu);
        } catch (IOException ex) {
            throw new JspException(ex);
        }
        return SKIP_BODY;
    }

    public void setCasse(String casse) {
        this.casse = casse;
    }
}
