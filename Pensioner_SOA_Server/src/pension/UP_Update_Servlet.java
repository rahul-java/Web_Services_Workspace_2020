package pension;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import readXML.Pensioner_Bean;
import validate.Validate_List;

@WebServlet("/UP_Update_Servlet")
public class UP_Update_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		HttpSession s = request.getSession();
		List<Pensioner_Bean>  list = (List<Pensioner_Bean>) s.getAttribute("pensioner_list");
		if(Validate_List.check_List(list))
		{
			out.println("Data added to server side database Successfully...");
			request.getRequestDispatcher("index.html").forward(request, response);
		}else
		{
			out.println("Something went wrong...");
			request.getRequestDispatcher("index.html").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
