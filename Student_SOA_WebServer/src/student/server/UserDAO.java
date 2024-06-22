package student.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {
	
	public AllStudentList getStudentDeatails(String rollno)
	{
		AllStudentList allStudentList=	new AllStudentList();
		allStudentList.setList(new ArrayList<StudentBean>());
		try {
			String q="select * from student";
			Connection con = JDBCUtility.getConn();
			 PreparedStatement ps=null;
			   if(rollno.equalsIgnoreCase("All"))
			   {
			    ps = con.prepareStatement(q);
			   }
			   else
			   {
				  ps= con.prepareStatement(q+ " where rollno = ?");
			      ps.setInt(1, Integer.parseInt(rollno));
			   }
			   ResultSet rs = ps.executeQuery();
			   
			   while(rs.next())
			   {
				   StudentBean studentBean= new  StudentBean ();
				 
				   studentBean.setRollno(rs.getInt(1));
				   studentBean.setName(rs.getString(2));
				   studentBean.setAddress(rs.getString(3));
				   allStudentList.getList().add(studentBean);
			   }
			   
			   
		} catch (Exception e) {
			// TODO: handle exception
		}
		return allStudentList;
	}

}
