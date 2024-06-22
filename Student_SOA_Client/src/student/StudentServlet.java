package student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import readXML.StudentDetailsBean;
import readXML.UnmarshallingStudent;
import student.server.RequestHandlerServiceProxy;


@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String rollno=request.getParameter("rollno");
		try {
			
			RequestHandlerServiceProxy ob=new RequestHandlerServiceProxy();
			String xml = ob.getData(rollno);
			List<StudentDetailsBean> list = UnmarshallingStudent.readXML(xml);
			
			request.setAttribute("std_list", list);
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
