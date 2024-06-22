package max.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JDBCUtility {
	
	
	
	private JDBCUtility()
	{
		
	}
	static Connection cn=null;
	static
	{
		try {
			Class.forName("org.postgresql.Driver");
cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Self_Help_Group","postgres","postgres");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn()
	{
		return cn;
	}
	
	
	public static int getSHGID(Connection con)
	{
		try {
			PreparedStatement ps = con.prepareStatement("select max(shg_id) as id from shg_details_server");
			ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			int id=rs.getInt("id");
			return id+1;
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int getMemberID(Connection con)
	{
		try {
			PreparedStatement ps = con.prepareStatement("select max(member_id) as id from member_details_server");
			ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			int id=rs.getInt("id");
			return id+1;
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


}
