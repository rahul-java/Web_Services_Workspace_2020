package max;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtility 
{
	
	
	private JDBCUtility()
	{
		
	}
	static Connection cn=null;
	static
	{
		try {
			Class.forName("org.postgresql.Driver");
			cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/prashant","postgres","2311");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn()
	{
		return cn;
	}
	
	public static int getFID(Connection con)
	{
		try {
			PreparedStatement ps = con.prepareStatement("select max(fid) as fd from f_detail");
			ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			int id=rs.getInt("fd");
			return id+1;
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int getCID(Connection con)
	{
		try {
			PreparedStatement ps = con.prepareStatement("select max(cid) as cd from c_detail");
			ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			int id=rs.getInt("cd");
			return id+1;
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
