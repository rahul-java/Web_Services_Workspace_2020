package pensionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import readXML.Pensioner_Bean;
public class Pensioner_DAO 
{
	static Connection con=null;

	
public static boolean insert_Pensioner(readXML.Pensioner_Bean pnr)
{
		con=JDBCUtility.getConn();
		
	
	try {
		PreparedStatement ps = con.prepareStatement("insert into up_pensioner_server values(?,?,?,?,?,?,?)");
		ps.setInt(1, pnr.getAdhar());
		ps.setString(2, pnr.getScheme());
		ps.setString(3, pnr.getName());
		ps.setString(4, pnr.getDob());
		ps.setString(5, pnr.getAddress());
		ps.setString(6, pnr.getGender());
		ps.setString(7, "verified");
		
		int n=ps.executeUpdate();
		if(n>0)
		{
			return true;
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return false;
}
}
