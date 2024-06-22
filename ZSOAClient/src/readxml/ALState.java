package readxml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="allState")
@XmlAccessorType(XmlAccessType.FIELD)
public class ALState {
@XmlElement(name="state")
	List<StDetails> list;

public List<StDetails> getList() {
	return list;
}

public void setList(List<StDetails> list) {
	this.list = list;
}
	
}
