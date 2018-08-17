/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Administrator
 */
public class MySimpleTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException {
        try {
            StartTag();
            StringWriter writer = new StringWriter();
            getJspBody().invoke(writer);
            getJspContext().getOut().print(writer.toString().toUpperCase());
            EndTag();
        } catch (IOException ex) {
            throw new JspException(ex);
        }
    }

    private void EndTag() throws IOException {
        getJspContext().getOut().print(". get out from getJspContext after");
    }

    private void StartTag() throws IOException {
        getJspContext().getOut().print("get out from getJspContext before:");
    }
    
}
