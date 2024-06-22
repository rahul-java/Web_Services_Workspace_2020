package max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import max.bean.MemberNBean;
import max.bean.SHGBean;
import max.utility.JDBCUtility;

public class DAO_Class {
	
	static Connection con=null;
	
	public static boolean insert_SHGDetails(SHGBean sHGBean)
	{
		con=JDBCUtility.getConn();
		try {
			PreparedStatement ps = con.prepareStatement("insert into shg_details values(?,?,?,?,?,?,?)");
			ps.setString(1, sHGBean.getAn());
			ps.setString(2, sHGBean.getGname());
			ps.setString(3, sHGBean.getIfsc());
			ps.setString(4, sHGBean.getBankName());
			ps.setString(5, sHGBean.getBranchName());
			ps.setString(6, sHGBean.getStCode());
			ps.setString(7, sHGBean.getDistrictCode());
			
			int n=ps.executeUpdate();
			if(n>0)
			{
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean insert_MemberDetails(String name,String age,String adhar,String an)
	{
		con=JDBCUtility.getConn();
		try {
			PreparedStatement ps = con.prepareStatement("insert into member_details values(?,?,?,?)");
			ps.setString(1, adhar);
			ps.setString(2, name);
			ps.setString(3, age);
			ps.setString(4, an);
			
			int n=ps.executeUpdate();
			if(n>0)
			{
				return true;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

}
