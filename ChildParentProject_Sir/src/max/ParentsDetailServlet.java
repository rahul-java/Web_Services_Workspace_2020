package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ParentsDetailServlet")
public class ParentsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try
		{
		String adhar = request.getParameter("adhar");
		String fname = request.getParameter("fname");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String stateCode = request.getParameter("stateCode");
		String districtCode = request.getParameter("districtCode");
		
		String[] cname = request.getParameterValues("cname");
		String[] age = request.getParameterValues("age");
		String[] cadhar = request.getParameterValues("cadhar");
		
		FatherDTO fdao=new FatherDTO();
		fdao.setAdhar(adhar);
		fdao.setFname(fname);
		fdao.setDob(dob);
		fdao.setGender(gender);
		fdao.setStateCode(stateCode);
		fdao.setDistrictCode(districtCode);
		
		ChildDTO cdto=new ChildDTO();
		cdto.setAge(age);
		cdto.setCadhar(cadhar);
		cdto.setCname(cname);
		
		ParentsDAO b = new ParentsDAO ();
		if(b.insertPDetails(fdao, cdto))
		{
			out.print("successs");
		}
		else
		{
			out.println("Fail");
		}
		
		
	}
		catch(Exception e)
		{
			
		}
	}
	

}


