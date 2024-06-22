package readXML;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="allstudent")
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentList
{

	@XmlElement(name="student")
	List<StudentDetailsBean> list;

	public List<StudentDetailsBean> getList() {
		return list;
	}

	public void setList(List<StudentDetailsBean> list) {
		this.list = list;
	}
	
}
