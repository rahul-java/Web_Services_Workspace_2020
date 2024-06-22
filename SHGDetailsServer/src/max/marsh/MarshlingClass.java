package max.marsh;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import max.bean.MemberNBean;
import max.bean.SHGBean;

public class MarshlingClass {

	
	public static String getData(List<SHGBean> sHGList, List<MemberNBean> memberList, String remark) 
	{
		DetailList_Remark detailList = new DetailList_Remark();
		
		try {
			 detailList.setShgList(sHGList);
			 detailList.setMlist(memberList);
			 detailList.setRemark(remark);
		   } catch (Exception e)
		    {
			  e.printStackTrace();
		     }
		return generateXML(detailList);
	}
	
	private static String generateXML(DetailList_Remark detailList)
	{
		
      try {
			
			JAXBContext jb = JAXBContext.newInstance(DetailList_Remark.class);
			Marshaller cm = jb.createMarshaller();
			cm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			StringWriter sw = new StringWriter();
			cm.marshal(detailList, sw);
			//System.out.println("Marshalling at server side inside generatexml ::: \n"+sw.toString());
			return sw.toString();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
