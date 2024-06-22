package student.server;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import student.server.UserDAO;

public class RequestHandlerService {

	public String getData(String rollno)
	{
		return generateXML(new UserDAO().getStudentDeatails(rollno));
		
	}
	
	private static String generateXML(AllStudentList allStudentList)
	{
		try {
			 JAXBContext jb = JAXBContext.newInstance(AllStudentList.class);
			 Marshaller cm = jb.createMarshaller();
			 cm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			 StringWriter sw=new StringWriter();
			 cm.marshal(allStudentList, sw);
			 System.out.println("Server Side : "+sw.toString());
			 
			 return sw.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
		
	}
	
}
