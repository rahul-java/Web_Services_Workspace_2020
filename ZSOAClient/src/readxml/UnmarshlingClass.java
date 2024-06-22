package readxml;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class UnmarshlingClass {

	public static List<StDetails> readXML(String xml)
	{
		try {
			
			JAXBContext jb = JAXBContext.newInstance(ALState.class);
			Unmarshaller ucm = jb.createUnmarshaller();
			StringReader sr = new StringReader(xml);
			ALState al = (ALState)ucm.unmarshal(sr);
			
			List<StDetails> t = al.getList();
			if(t.size()>0)
			{
				return t;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
