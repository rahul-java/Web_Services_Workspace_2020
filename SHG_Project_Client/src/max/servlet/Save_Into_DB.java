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
import max.unmarsh.UnmarshlingClass;

@WebServlet("/Save_Into_DB")
public class Save_Into_DB extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		List<SHGBean> shgList=(List<SHGBean>) request.getAttribute("SHG");
		HttpSession s= request.getSession();
		String xml=(String) s.getAttribute("xml");
		List<SHGBean> sHGList=UnmarshlingClass.readXML_SHGBean(xml);
		List<MemberNBean> memberList=UnmarshlingClass.readXML_MemberNBean(xml);
		for(SHGBean sHGBean:sHGList)
		{
			if(DAO_Class.insert_SHGDetails(sHGBean))
			{
				System.out.println("Inserted SHG Details Successfully....\n");
				for(MemberNBean memberNBean:memberList)
				{
					String[] mName= memberNBean.getMname();
					String[] mAge=memberNBean.getMage();
				 	String[] mAdhar=memberNBean.getMadhar() ;
				 	
				 	for(int i=0;i<mName.length;i++)
				 	{
				 		if(DAO_Class.insert_MemberDetails(mName[i],mAge[i],mAdhar[i],sHGBean.getAn()))
				 		{
				 			System.out.println("Inserted Member "+(i+1)+"Successfully");
				 		}
				 		else
				 		{
				 			System.out.println("Something went wrong in isertion of member "+(i+1));
				 		}
				 	}
				}
			}
			else
			{
				System.out.println("Something went WRONG...in insertion SGH Details");
			}
		}
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
