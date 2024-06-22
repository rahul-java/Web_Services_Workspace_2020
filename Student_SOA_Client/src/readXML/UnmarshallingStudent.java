package readXML;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnmarshallingStudent
{

	public static List<StudentDetailsBean> readXML(String xml)
	{
		
		try {
			
			JAXBContext jb = JAXBContext.newInstance(StudentList.class);
			Unmarshaller unm = jb.createUnmarshaller();
			StringReader sr = new StringReader(xml);
			StudentList std_list=(StudentList) unm.unmarshal(sr);
			
			List<StudentDetailsBean> list=std_list.getList();
			
			if(list.size()>0)
			{
				return list;
			}
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
