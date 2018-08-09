/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 *
 * @author Administrator
 */
public class MonResponseWrapper extends HttpServletResponseWrapper{
    
    StringWriter out;
    public MonResponseWrapper(HttpServletResponse response) {
        super(response);
        out = new StringWriter();
    }
    
    public String getContenu(){
        return out.toString();
    }
    
    @Override
    public PrintWriter getWriter() throws IOException{
        return new PrintWriter(out);
    }
    
    public PrintWriter getOriginalWriter(){
        try {
            return getResponse().getWriter();
        } catch (IOException ex) {
            return null;
        }  
    }
}
