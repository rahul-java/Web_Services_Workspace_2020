package pension.up;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import pension.up.PensionerList;
import pension.up.Pensioner_DAO;

public class RequestHandlerService 
{

	public String getData()
	{
		return generateXML(Pensioner_DAO.getPensionerDetails());
		
	}
	
	private static String generateXML(PensionerList pensionerList)
	{
		try {
			 JAXBContext jb = JAXBContext.newInstance(PensionerList.class);
			 Marshaller cm = jb.createMarshaller();
			 cm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			 StringWriter sw=new StringWriter();
			 cm.marshal(pensionerList, sw);
			 System.out.println("Server Side : "+sw.toString());
			 return sw.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
		
	}
}
