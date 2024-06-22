package pension.up;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Pensioner_DAO 
{
	static Connection con=null;
	
	public static PensionerList getPensionerDetails()
	{
		con=JDBCUtility.getConn();
		//List<Pensioner_Bean> list=new ArrayList<Pensioner_Bean>();
		PensionerList pensionerList=new PensionerList();
		pensionerList.setList(new ArrayList<Pensioner_Bean>());
		try {
			PreparedStatement ps = con.prepareStatement("select * from up_pensioner where cflag=?");
			ps.setString(1, "yes");
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next())
			{
				Pensioner_Bean pensioner_Bean=new Pensioner_Bean();
				pensioner_Bean.setAdhar(rs.getInt(1));
				pensioner_Bean.setScheme(rs.getString(2));
				pensioner_Bean.setName(rs.getString(3));
				pensioner_Bean.setDob(rs.getString(4));
				pensioner_Bean.setAddress(rs.getString(5));
				pensioner_Bean.setGender(rs.getString(6));
				
				pensionerList.getList().add(pensioner_Bean);
				//list.add(pensioner_Bean);
			}
		} catch (Exception e) {
			e.printStackTrace();		}
		return pensionerList;
	}

	
}
