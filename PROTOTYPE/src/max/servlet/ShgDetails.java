package max.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.bean.MemberNBean;
import max.bean.SHGBean;
import max.marsh.DetailList;
import max.marsh.MarshlingClass;
import max.marsh.MemberDetails;


@WebServlet("/ShgDetails")
public class ShgDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		///DetailList detailList=new DetailList();
		///detailList.setShgList(new ArrayList<SHGBean>());
		///detailList.getShgList().add(sHGBean);
		
		String[] mname = request.getParameterValues("mname");
		String[] mage = request.getParameterValues("mage");
		String[] madhar = request.getParameterValues("madhar");
		
		MemberNBean memberNBean=new MemberNBean();
		memberNBean.setMname(mname);
		memberNBean.setMage(mage);
		memberNBean.setMadhar(madhar);
		//List<MemberNBean> memberNBean_List=new ArrayList<MemberNBean>();
		//memberNBean_List.add(memberNBean);
		//detailList.setMemberDetails(new ArrayList<MemberNBean>());
		//detailList.getMemberDetails().add(memberNBean);
		
		////detailList.setMlist(new ArrayList<MemberNBean>());
		////detailList.getMlist().add(memberNBean);
		
		MemberDetails memberDetails=new MemberDetails();
		memberDetails.setMlist(new ArrayList<MemberNBean>());
		memberDetails.getMlist().add(memberNBean);
		
		//detailList.setMemberDetails(memberDetails);
		
		//MarshlingClass.getData(sHGList,memberNBean_List);
		MarshlingClass.getData(sHGList,memberDetails);
	}

}
