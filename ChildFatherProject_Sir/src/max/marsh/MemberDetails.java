package max.marsh;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import max.bean.MemberNBean;

@XmlRootElement(name="shgMember")
@XmlAccessorType(XmlAccessType.FIELD)
public class MemberDetails {
  @XmlElement(name="member")
	List<MemberNBean> mlist;
}
