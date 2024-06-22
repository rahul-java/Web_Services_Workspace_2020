package max.marsh;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import max.bean.MemberNBean;
import max.bean.SHGBean;

public class MarshlingClass {

	public static String getData(List<SHGBean> shgList,List<MemberNBean> memberDetails)
	{
		DetailList detailList=	new DetailList();
		
		try {
			
			detailList.setShgList(shgList);
			detailList.setMlist(memberDetails);;
		   } catch (Exception e)
		  {
			e.printStackTrace();
		   }
		return generateXML(detailList);
	}
	private static String generateXML(DetailList detailList)
	{
		
      try {
			
			JAXBContext jb = JAXBContext.newInstance(DetailList.class);
			Marshaller cm = jb.createMarshaller();
			cm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			StringWriter sw = new StringWriter();
			cm.marshal(detailList, sw);
			System.out.println("server "+sw.toString());
			return sw.toString();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
