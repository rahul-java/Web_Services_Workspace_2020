package readXML;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnmarshellingPensioner {

	public static List<Pensioner_Bean> readXML(String xml)
	{
		
		try {
			
			JAXBContext jb = JAXBContext.newInstance(PensionerList.class);
			Unmarshaller unm = jb.createUnmarshaller();
			StringReader sr = new StringReader(xml);
			PensionerList pensionerList=(PensionerList) unm.unmarshal(sr);
			
			List<Pensioner_Bean> list=pensionerList.getList();
			
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
