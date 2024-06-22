package student.server;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="allstudent")
@XmlAccessorType(XmlAccessType.FIELD)
public class AllStudentList 
{
	@XmlElement(name="student")
	List<StudentBean> list;

	public List<StudentBean> getList() {
		return list;
	}

	public void setList(List<StudentBean> list) {
		this.list = list;
	}

	
}
