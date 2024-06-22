package max;

import java.util.List;

//import javafx.geometry.Side;
import max.bean.MemberNBean;
import max.bean.SHGBean;
import max.dao.DAO_Class;
import max.marsh.MarshlingClass;
import max.unmarsh.UnmarshlingClass;

public class RequestHandlerSoa {
	
	public String getData(String xml)
	{
		int flag=0;
		try {
			   System.out.println("Server side before isertion into server side ::: \n"+xml);
			   List<SHGBean> sHGList=UnmarshlingClass.readXML_SHGBean(xml);
			   List<MemberNBean> memberList=UnmarshlingClass.readXML_MemberNBean(xml);
			   for(SHGBean sHGBean:sHGList)
			   {
				   for(MemberNBean memberNBean :memberList)
				   {
					   if(DAO_Class.insert_AllDetails(sHGBean, memberNBean,"Verified"))
					   {
						   flag=1;
						   System.out.println("Successfully inserted into database at server side...");
					   }else
					   {
						   System.out.println("Error Something went wrong in insertion into database at Server Side...");
					   }
				   }
			   }
			   if(flag==1)
			   {
				 return MarshlingClass.getData(sHGList, memberList, "Successfully Inserted");
			   }
			   
			   
			
		  } catch (Exception e) 
		   {
			e.printStackTrace();
		    }
		return xml;
	}

}
