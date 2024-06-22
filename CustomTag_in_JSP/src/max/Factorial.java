package max;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Factorial extends TagSupport{
	
	int no;
	
	public void setNo(String no) {
		this.no = Integer.parseInt(no);
	}



	public int doStartTag()
	{  int f=1;
		try {
			
			JspWriter out = pageContext.getOut();
			
			if(no==1 || no==0)
			{
				out.println("Result is "+f);
			}
			else
			{
				for(int i=no; i>1;i--)
				{
					f*=i;
				}
				out.println("Result is "+f);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return Tag.SKIP_BODY;
	}

	
	
	
	
	
	
}
