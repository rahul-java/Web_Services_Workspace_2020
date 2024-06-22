package max;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Addition extends TagSupport{
 int n1;
 int n2;
public void setN1(String n1) {
	this.n1 = Integer.parseInt(n1);
}
public void setN2(String n2) {
	this.n2 =Integer.parseInt(n2);
}
public int doStartTag()
{
	try {
	JspWriter out = pageContext.getOut();
	
	    int n3=n1+n2;
	   out.println("addd "+n3);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return Tag.SKIP_BODY;
}
 
}
