package max.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import max.bean.MemberNBean;
import max.bean.SHGBean;
import max.dao.DAO_Class;
import max.unmarsh.UnmarshallingClass_afterRemark;
import max.unmarsh.UnmarshlingClass;

@WebServlet("/Save_Into_DB")
public class Save_Into_DB extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int flag=0;
		PrintWriter out = response.getWriter();
		HttpSession s= request.getSession();
		String xml=(String) s.getAttribute("remarked_xml");
		List<SHGBean> sHGList=UnmarshallingClass_afterRemark.readXML_SHGBean(xml);
		List<MemberNBean> memberList=UnmarshallingClass_afterRemark.readXML_MemberNBean(xml);
		String remark=UnmarshallingClass_afterRemark.readXML_Remark(xml);
		for(SHGBean sHGBean:sHGList)
		   {
			   for(MemberNBean memberNBean :memberList)
			   {
				   if(DAO_Class.insert_AllDetails_AtClientSide(sHGBean, memberNBean, remark))
				   {
					   flag=1;
					   System.out.println("Successfully inserted into database at Client side...");
				   }else
				   {
					   System.out.println("Error Something went wrong in insertion into database at Client Side...");
				   }
			   }
		   }
		if(flag==1)
		{
			request.getRequestDispatcher("display_with_remark.jsp").forward(request, response);
		}
		else
		{
			out.println("Error In Insertion at Client Side with REMARK....");
		}
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
