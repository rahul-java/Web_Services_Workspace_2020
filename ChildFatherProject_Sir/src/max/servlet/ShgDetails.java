package max.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.marsh.MarshlingClass;


@WebServlet("/ShgDetails")
public class ShgDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gname=request.getParameter("gname");
		String an=request.getParameter("an");
		String ifsc=request.getParameter("ifsc");
		String stCode=request.getParameter("stCode");
		String districtCode=request.getParameter("districtCode");
		
		String[] mname = request.getParameterValues("mname");
		String[] mage = request.getParameterValues("mage");
		String[] madhar = request.getParameterValues("madhar");
		
		
		MarshlingClass.getData();
	}

}
