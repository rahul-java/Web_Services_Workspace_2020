package max.master;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import max.utility.JDBCUtility;

public class StateDAO {
public List<StateBean> getStateDetails()
{
	List<StateBean> l=new ArrayList<StateBean>();
	try {
		Connection con = JDBCUtility.getConn();
		PreparedStatement ps = con.prepareStatement("select * from mst_state order by state_name");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{       StateBean sb = new StateBean ();
		
			sb.setStCode(""+rs.getInt(1));
			sb.setStName(rs.getString(2));
			sb.setShortName(rs.getString(3));
			l.add(sb);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return l;
}
}
