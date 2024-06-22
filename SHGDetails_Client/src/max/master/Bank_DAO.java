package max.master;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import max.bean.Bank_Bean;
import max.utility.JDBCUtility;

public class Bank_DAO {
	static Connection con=null;
	
	
	public static Bank_Bean getBankDetails(String ifsc)
	{
		try {
			
		    con =JDBCUtility.getConn();
		     PreparedStatement ps = con.prepareStatement("select * from bank_details where ifsc=?");
		     ps.setString(1, ifsc);
		     ResultSet rs = ps.executeQuery();
		     
		     while(rs.next())
		     {
		    	 Bank_Bean bank_Bean=new Bank_Bean();
		    	 bank_Bean.setIfsc(rs.getString(1));
		    	 bank_Bean.setBank_name(rs.getString(2));
		    	 bank_Bean.setBranch_address(rs.getString(3));
		    	 bank_Bean.setBranch_name(rs.getString(4));
		    	 //System.out.println(rs.getString(2));
		    	 return bank_Bean;
		     }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
		
	}
	public static boolean check_IFSC(String ifsc)
	{
	
       try {
			
		    con =JDBCUtility.getConn();
		     PreparedStatement ps = con.prepareStatement("select * from bank_details where ifsc=?");
		     ps.setString(1, ifsc);
		     ResultSet rs = ps.executeQuery();
		     
		     while(rs.next())
		     {
		    	// System.out.println(rs.getString(2));
		    	 return true;
		     }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
