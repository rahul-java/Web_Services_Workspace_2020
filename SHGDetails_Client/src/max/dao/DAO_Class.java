package max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import max.bean.MemberNBean;
import max.bean.Member_View_Bean;
import max.bean.SHGBean;
import max.bean.SHG_View_Bean;
import max.utility.JDBCUtility;

public class DAO_Class {
	
	static Connection con=null;
	static PreparedStatement ps=null;
	static PreparedStatement ps1=null;
	
	
	
	public static boolean insert_AllDetails_AtClientSide(SHGBean sHGBean,MemberNBean memberNBean, String remark)
	{
		try {
			   con=JDBCUtility.getConn();
			   con.setAutoCommit(false);
			   
			    ps = con.prepareStatement("insert into shg_details values(?,?,?,?,?,?,?,?)");
			    //ps.setInt(1, JDBCUtility.getSHGID(con));
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
					ps = con.prepareStatement("insert into member_details values(?,?,?,?,?)");
					
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
						System.out.println("Roll Back");
						con.close();
					  } catch (SQLException e1)
		    	         {
						  e1.printStackTrace();
					      }
			   e.printStackTrace();
		      }
		return false;
		
	}
	
	public static Map<SHG_View_Bean, Set<Member_View_Bean>> view_Allshg_Member_details()
	{
		Map<SHG_View_Bean,Set<Member_View_Bean>> map=new TreeMap<SHG_View_Bean,Set<Member_View_Bean>>(new SHG_View_Bean());
		
		try {
			con=JDBCUtility.getConn();
			ps=con.prepareStatement("select * from shg_details");
			
			 ResultSet rs = ps.executeQuery();
			 while(rs.next())
			 {
				 SHG_View_Bean sHG_View_Bean=new SHG_View_Bean();
				 sHG_View_Bean.setAcct(rs.getString(1));
				 sHG_View_Bean.setGname(rs.getString(2));
				 sHG_View_Bean.setIfsc(rs.getString(3));
				 sHG_View_Bean.setBank_name(rs.getString(4));
				 sHG_View_Bean.setBranch_name(rs.getString(5));
				 sHG_View_Bean.setState_name(getState(Integer.parseInt(rs.getString(6))));
				 sHG_View_Bean.setDistrict_name(getDistrict(Integer.parseInt(rs.getString(7))));
				 sHG_View_Bean.setRemarks(rs.getString(8));
				 
				 Set<Member_View_Bean> member_View_Bean_Set=new HashSet<Member_View_Bean>();
				 
				 ps1=con.prepareStatement("select * from member_details where shg_acct_no=?");
				 ps1.setString(1, rs.getString(1));
				  ResultSet rs_member = ps1.executeQuery();
				  while(rs_member.next())
				  {
					  Member_View_Bean member_View_Bean=new Member_View_Bean();
					  member_View_Bean.setAdhar(rs_member.getString(1));
					  member_View_Bean.setName(rs_member.getString(2));
					  member_View_Bean.setAge(rs_member.getString(3));
					  member_View_Bean.setRemarks(rs_member.getString(5));
					  member_View_Bean_Set.add(member_View_Bean);
				  }
				  
				  map.put(sHG_View_Bean, member_View_Bean_Set);
				 
			 }
			 return map;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String getState(int stcode)
	{
		try {
			con=JDBCUtility.getConn();
			ps=con.prepareStatement("select * from mst_state where state_code=?");
			ps.setInt(1, stcode);
			
			 ResultSet rs = ps.executeQuery();
			 while(rs.next())
			 {
				 return rs.getString("state_name");
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "Invalid State";
		
	}
	
	private static String getDistrict(int dist_code)
	{
		try {
			con=JDBCUtility.getConn();
			ps=con.prepareStatement("select * from mst_district where dist_code=?");
			ps.setInt(1, dist_code);
			
			 ResultSet rs = ps.executeQuery();
			 while(rs.next())
			 {
				 return rs.getString("dist_name");
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Invalid District";
		
	}
	

}
