package max.unmarsh;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import max.bean.MemberNBean;
import max.bean.SHGBean;

@XmlRootElement(name="shgDetails")
@XmlAccessorType(XmlAccessType.FIELD)
public class DetailList {

	@XmlElement(name="shg")
	List<SHGBean> shgList;
	
	public List<SHGBean> getShgList() {
		return shgList;
	}
	public void setShgList(List<SHGBean> shgList) {
		this.shgList = shgList;
	}
	
	@XmlElementWrapper(name="memberDetails")
    @XmlElement(name="member")
		List<MemberNBean> mlist;
	

	public List<MemberNBean> getMlist()
	{
		return mlist;
	}

	public void setMlist(List<MemberNBean> mlist) 
	{
		this.mlist = mlist;
	}
	
 
	
}
