/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.*;

public class MyBodyTag extends TagSupport {

    private int nombre;
    private int compteur;

    public void setNombre(int nombre) {
        this.nombre = nombre;
        this.compteur = nombre;
        pageContext.setAttribute("nombre", nombre);
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().println("debut ");
        } catch (IOException ex) {
            throw new JspException(ex);
        }
        if (nombre <= 0) {
            return SKIP_BODY;
        }
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().println(" fin");
        } catch (IOException ex) {
            throw new JspException(ex);
        }
        pageContext.removeAttribute("nombre");

        return EVAL_PAGE;
    }

    @Override
    public int doAfterBody() throws JspException {
        if (--compteur >0) {
            return EVAL_BODY_AGAIN;
        }
        return SKIP_BODY;
    }   
}
