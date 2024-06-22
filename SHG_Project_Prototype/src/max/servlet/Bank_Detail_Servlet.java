package max.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.bean.Bank_Bean;
import max.bean.DistrictBean;
import max.master.Bank_DAO;
import max.master.StateDAO;


@WebServlet("/Bank_Detail_Servlet")
public class Bank_Detail_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
	    String ifsc=request.getParameter("ifsc");
	    //System.out.println(ifsc);
		
	    Bank_Bean bank_Bean=Bank_DAO.getBankDetails(ifsc);	
		 if (Bank_DAO.check_IFSC(ifsc))
		 {
			
			 out.println("<html><body><table>");
			   out.println("<tr><td>Bank Name :</td><td><input type='text' name='bank_name' value='"+bank_Bean.getBank_name()+"' readonly></td>");
			   out.println("<tr><td>Branch Name :</td><td><input type='text' name='branch_name' value='"+bank_Bean.getBranch_name()+"' readonly></td>");

			   
			   out.println("</table></body></html>");
			}
		 else
		 {
			 out.println("<html><body><table>");
			 out.println("<tr><td>Bank Name :</td><td><input type='text' name='bank_name' value='Invalid IFSC Code' readonly></td>");
			   out.println("<tr><td>Branch Name :</td><td><input type='text' name='branch_name' value='Invalid IFSC Code' readonly></td>");

			 out.println("</table></body></html>");
		  }
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
