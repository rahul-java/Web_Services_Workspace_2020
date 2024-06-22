package max.unmarsh;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import max.bean.MemberNBean;
import max.bean.SHGBean;
import max.marsh.DetailList;


public class UnmarshlingClass {

	public static List<SHGBean> readXML_SHGBean(String xml)
	{
		try {
			
			JAXBContext jb = JAXBContext.newInstance(DetailList.class);
			Unmarshaller ucm = jb.createUnmarshaller();
			StringReader sr = new StringReader(xml);
			DetailList detailList = (DetailList)ucm.unmarshal(sr);
			
			List<SHGBean> t1 = detailList.getShgList();
			
			if(t1.size()>0)
			{
				return t1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public static List<MemberNBean> readXML_MemberNBean(String xml)
	{
		try {
			
			JAXBContext jb = JAXBContext.newInstance(DetailList.class);
			Unmarshaller ucm = jb.createUnmarshaller();
			StringReader sr = new StringReader(xml);
			DetailList detailList = (DetailList)ucm.unmarshal(sr);
			
			List<MemberNBean> t2 = detailList.getMlist();
			
			if(t2.size()>0)
			{
				return t2;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
