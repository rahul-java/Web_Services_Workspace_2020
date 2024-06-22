package max.marsh;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import max.bean.SHGBean;

@XmlRootElement(name="shgDetails")
@XmlAccessorType(XmlAccessType.FIELD)
public class DetailList {

	MemberDetails memberDetails;
	@XmlElement(name="shg")
	List<SHGBean> shgList;
	public MemberDetails getMemberDetails() {
		return memberDetails;
	}
	public void setMemberDetails(MemberDetails memberDetails) {
		this.memberDetails = memberDetails;
	}
	public List<SHGBean> getShgList() {
		return shgList;
	}
	public void setShgList(List<SHGBean> shgList) {
		this.shgList = shgList;
	}
	
	
	
}
