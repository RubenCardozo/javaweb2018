package tags;

import biz.Personne;
import javax.servlet.jsp.JspException;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import static javax.servlet.jsp.tagext.TagSupport.findAncestorWithClass;

public class EnfantTag extends MembreFamilleTag {


    @Override
    public int doEndTag() throws JspException {
        FamilleTag ft = (FamilleTag)findAncestorWithClass(this, FamilleTag.class);
        ft.addEnfant();
        return super.doStartTag();
    }

}
