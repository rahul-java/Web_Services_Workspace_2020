package max;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParentsDAO {
	public boolean insertPDetails(FatherDTO fatherDTO,ChildDTO childDTO)
	{  Connection con=null;
	PreparedStatement ps=null;
		try {
			con = JDBCUtility.getConn();
			con.setAutoCommit(false);
	ps = con.prepareStatement("insert into f_detail values (?,?,?,?,?,?,?)");
	  ps.setInt(1, JDBCUtility.getFID(con));	
	ps.setString(2, fatherDTO.getFname());
	ps.setString(3, fatherDTO.getAdhar());
	ps.setString(4, fatherDTO.getDob());
	ps.setString(5, fatherDTO.getStateCode());
	ps.setString(6, fatherDTO.getDistrictCode());
	ps.setString(7, fatherDTO.getGender());
	   int i = ps.executeUpdate();
	   if(i>0)
	   {
		     ps=con.prepareStatement("insert into c_detail values(?,?,?,?,?)");
		    String[] n = childDTO.getCname();
		     String[] a = childDTO.getAge();
		     String[] ad = childDTO.getCadhar();
		     int k=0;
		    for(int j=0; j<n.length;j++)
		    {
		     ps.setInt(1, JDBCUtility.getCID(con));
		     ps.setString(2, n[j]);
		     ps.setString(3, a[j]);
		     ps.setString(4, ad[j]);
		     ps.setInt(5, JDBCUtility.getFID(con)-1);
		     
		     
		  k =k+ ps.executeUpdate();
		  
		    }
		     if(k==ad.length)
		     {
		    	 con.commit();
		    	 return true;
		     }
		    }
	   
		} catch (Exception e) {
			try {
				con.rollback();
				System.out.println("roll back");
				con.close();
			    } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return false;
	}

}
