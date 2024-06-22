package max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import max.bean.MemberNBean;
import max.bean.SHGBean;
import max.utility.JDBCUtility;

public class DAO_Class {
	
	static Connection con=null;
	static PreparedStatement ps=null;
	
	/*
	public static boolean insert_SHGDetails(SHGBean sHGBean)
	{
		con=JDBCUtility.getConn();
		try {
		    ps = con.prepareStatement("insert into shg_details values(?,?,?,?,?,?,?)");
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
		    ps = con.prepareStatement("insert into member_details values(?,?,?,?)");
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
	
	*/

	public static boolean insert_AllDetails(SHGBean sHGBean,MemberNBean memberNBean,String remark)
	{
		try {
			   con=JDBCUtility.getConn();
			   con.setAutoCommit(false);
			   
			    ps = con.prepareStatement("insert into shg_details_server values(?,?,?,?,?,?,?,?)");
				ps.setString(1, sHGBean.getAn());
				ps.setString(2, sHGBean.getGname());
				ps.setString(3, sHGBean.getIfsc());
				ps.setString(4, sHGBean.getBankName());
				ps.setString(5, sHGBean.getBranchName());
				ps.setString(6, sHGBean.getStCode());
				ps.setString(7, sHGBean.getDistrictCode());
				ps.setString(8, remark);
				
				int n=ps.executeUpdate();
				
				if(n>0)
				{
					ps = con.prepareStatement("insert into member_details_server values(?,?,?,?,?)");
					
					String[] mName= memberNBean.getMname();
					String[] mAge=memberNBean.getMage();
				 	String[] mAdhar=memberNBean.getMadhar();
				 	
				 	int k=0;
				 	
				 	for(int i=0; i<mName.length;i++)
				    {
				     ps.setString(1, mAdhar[i]);
					 ps.setString(2, mName[i]);
					 ps.setString(3, mAge[i]);
					 ps.setString(4, sHGBean.getAn());
					 ps.setString(5, remark);
				     
				     k =k+ ps.executeUpdate();
				     }
				 	
				 	 if(k==mName.length)
				     {
				    	 con.commit();
				    	 return true;
				     }
				}
			
		     } catch (Exception e)
		      {
		    	 try {
						con.rollback();
						System.out.println("roll back");
						con.close();
					  } catch (SQLException e1)
		    	         {
						  e1.printStackTrace();
					      }
			   e.printStackTrace();
		      }
		return false;
	}

}
