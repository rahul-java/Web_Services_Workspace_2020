package max.server.pms;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class RequestHandlerServices {
	
	public String getData(String stateCode)
	{
	return generateXml(new UserDAO().getUserDeatails(stateCode));
	
	}
	
	private static String generateXml(AllStateList allstlist)
	{
		try {
			
			JAXBContext jb = JAXBContext.newInstance(AllStateList.class);
			Marshaller cm = jb.createMarshaller();
			cm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			StringWriter sw = new StringWriter();
			cm.marshal(allstlist, sw);
			System.out.println("server "+sw.toString());
			return sw.toString();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}

}
