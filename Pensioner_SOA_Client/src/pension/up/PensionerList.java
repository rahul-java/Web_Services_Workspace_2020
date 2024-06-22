package pension.up;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="allpensioner")
@XmlAccessorType(XmlAccessType.FIELD)
public class PensionerList {
	
	@XmlElement(name="pensioner")
	List<Pensioner_Bean> list;

	public List<Pensioner_Bean> getList() {
		return list;
	}

	public void setList(List<Pensioner_Bean> list) {
		this.list = list;
	}

}
