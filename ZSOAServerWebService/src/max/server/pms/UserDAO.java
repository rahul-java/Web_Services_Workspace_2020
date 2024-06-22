package max.server.pms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {
	
	public AllStateList getUserDeatails(String stateCode)
	{
		AllStateList allStateList=	new AllStateList();
		allStateList.setList(new ArrayList<StateBean>());
		try {
			String q="select * from mst_state";
			Connection con = JDBCUtility.getConn();
			 PreparedStatement ps=null;
			   if(stateCode.equalsIgnoreCase("All"))
			   {
			    ps = con.prepareStatement(q);
			   }
			   else
			   {
				  ps= con.prepareStatement(q+ " where state_code = ?");
			      ps.setInt(1, Integer.parseInt(stateCode));
			   }
			   ResultSet rs = ps.executeQuery();
			   
			   while(rs.next())
			   {
				   StateBean stateBean= new  StateBean ();
				 
				 stateBean.setStateCode(rs.getInt(1));
				 stateBean.setStateName(rs.getString(2));
				 stateBean.setShortName(rs.getString(3));
				 allStateList.getList().add(stateBean);
			   }
			   
			   
		} catch (Exception e) {
			// TODO: handle exception
		}
		return allStateList;
	}

}
