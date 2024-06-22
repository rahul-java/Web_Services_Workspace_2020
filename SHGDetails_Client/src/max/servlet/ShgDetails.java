package max.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import max.RequestHandlerSoaProxy;
import max.bean.MemberNBean;
import max.bean.SHGBean;
import max.marsh.MarshlingClass;


@WebServlet("/ShgDetails")
public class ShgDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String gname=request.getParameter("gname");
		String an=request.getParameter("an");
		String ifsc=request.getParameter("ifsc");
		String bankName=request.getParameter("bank_name");
		String branchName=request.getParameter("branch_name");
		String stCode=request.getParameter("stCode");
		String districtCode=request.getParameter("districtCode");
		
		SHGBean sHGBean=new SHGBean();
		sHGBean.setGname(gname);
		sHGBean.setAn(an);
		sHGBean.setIfsc(ifsc);
		sHGBean.setBankName(bankName);
		sHGBean.setBranchName(branchName);
		sHGBean.setStCode(stCode);
		sHGBean.setDistrictCode(districtCode);
		List<SHGBean> sHGList=new ArrayList<SHGBean>();
		sHGList.add(sHGBean);
		
		String[] mname = request.getParameterValues("mname");
		String[] mage = request.getParameterValues("mage");
		String[] madhar = request.getParameterValues("madhar");
		
		MemberNBean memberNBean=new MemberNBean();
		memberNBean.setMname(mname);
		memberNBean.setMage(mage);
		memberNBean.setMadhar(madhar);
		List<MemberNBean> memberNBean_List=new ArrayList<MemberNBean>();
		memberNBean_List.add(memberNBean);
		
		String xml=MarshlingClass.getData(sHGList,memberNBean_List);
		String remarked_xml=null;
    try {
	   RequestHandlerSoaProxy requestHandlerSoaProxy=new	RequestHandlerSoaProxy();
	   remarked_xml = requestHandlerSoaProxy.getData(xml);
	   System.out.println("client side after returning from the server side after insertion into server side database:::: \n"+remarked_xml);
       } catch (Exception e) 
         {
	       e.printStackTrace();
          }
	    request.setAttribute("xml", xml);
	    HttpSession s=request.getSession();
	    s.setAttribute("xml", xml);
	    s.setAttribute("remarked_xml", remarked_xml);
		request.getRequestDispatcher("display.jsp").forward(request, response);
	}

}
