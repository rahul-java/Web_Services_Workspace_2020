package pension;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import readXML.Pensioner_Bean;
import readXML.UnmarshellingPensioner;
import pension.up.RequestHandlerServiceProxy;


@WebServlet("/UP_Servlet")
public class UP_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	 try {
		

			RequestHandlerServiceProxy ob=new RequestHandlerServiceProxy();
			String xml = ob.getData();
			List<Pensioner_Bean> list = UnmarshellingPensioner.readXML(xml);
			
			request.setAttribute("pensioner_list", list);
			HttpSession s = request.getSession();
			s.setAttribute("pensioner_list", list);
			request.getRequestDispatcher("view.jsp").forward(request, response);
			
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
