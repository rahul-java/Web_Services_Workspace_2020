package max.marsh;

import max.bean.MemberNBean;
import max.bean.SHGBean;

public class MarshlingClass {

	public static String getData(SHGBean shgList,MemberNBean memberDetails)
	{
		
		try {
			DetailList detailList=	new DetailList();
			detailList.setShgList(shgList);
			detailList.setMemberDetails(memberDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
