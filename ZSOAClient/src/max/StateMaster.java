package max;

import java.io.IOException;

import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import readxml.StDetails;
import readxml.UnmarshlingClass;
import max.server.pms.RequestHandlerServicesProxy;


@WebServlet("/StateMaster")
public class StateMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String stateCode = request.getParameter("stateCode");
	 try {
		
		 RequestHandlerServicesProxy ob= new RequestHandlerServicesProxy();
	     
		 String xml = ob.getData(stateCode);
		List<StDetails> list = UnmarshlingClass.readXML(xml);
		Collections.sort(list);
		request.setAttribute("lst", list);
		request.getRequestDispatcher("v.jsp").forward(request, response);
	 } catch (Exception e) {
		// TODO: handle exception
	}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
