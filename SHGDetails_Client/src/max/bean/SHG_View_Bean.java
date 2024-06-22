package max.bean;

import java.util.Comparator;

public class SHG_View_Bean implements Comparator<SHG_View_Bean>
{
String acct;
String gname;
String ifsc;
String bank_name;
String branch_name;
String state_name;
String district_name;
String remarks;

public String getAcct() {
	return acct;
}
public void setAcct(String acct) {
	this.acct = acct;
}
public String getGname() {
	return gname;
}
public void setGname(String gname) {
	this.gname = gname;
}
public String getIfsc() {
	return ifsc;
}
public void setIfsc(String ifsc) {
	this.ifsc = ifsc;
}
public String getBank_name() {
	return bank_name;
}
public void setBank_name(String bank_name) {
	this.bank_name = bank_name;
}
public String getBranch_name() {
	return branch_name;
}
public void setBranch_name(String branch_name) {
	this.branch_name = branch_name;
}
public String getState_name() {
	return state_name;
}
public void setState_name(String state_name) {
	this.state_name = state_name;
}
public String getDistrict_name() {
	return district_name;
}
public void setDistrict_name(String district_name) {
	this.district_name = district_name;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
@Override
public int compare(SHG_View_Bean ob1, SHG_View_Bean ob2) {
	if(Integer.parseInt(ob1.getAcct())>Integer.parseInt(ob2.getAcct()))
		return 1;
	else
		if(Integer.parseInt(ob1.getAcct())<Integer.parseInt(ob2.getAcct()))
			return -1;
		else
	return 0;
}


}
