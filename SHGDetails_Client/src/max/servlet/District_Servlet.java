package max.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.bean.DistrictBean;
import max.master.StateDAO;


@WebServlet("/District_Servlet")
public class District_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
	    String stCode=request.getParameter("stCode");
	    System.out.println(stCode);
		StateDAO stateDAO=new StateDAO();
		 List<DistrictBean> l = stateDAO.getAllDistrictOfState(stCode);
		 if (stCode =="")
		  {
			 out.println("<html><body>");
			    out.println("<select name='districtCode' id='district'>");
			    out.println("<option value='0'><br>Select State First</option>");
			 out.println("</body></html>");
		  }
		 else
		 {
		out.println("<html><body>");
	    out.println("<select name='districtCode' id='district'>");
	    out.println("<option value='0'>Select District</option>");
	    for(DistrictBean dist:l)
	    {
	    	System.out.println("Inside Servlet Options extraction :  "+dist.getDist_name());
	    	
	    out.println("<option value='"+dist.getDist_code()+"'>"+dist.getDist_name()+"</option>");
	    }
	   out.println("</body></html>");
		
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
