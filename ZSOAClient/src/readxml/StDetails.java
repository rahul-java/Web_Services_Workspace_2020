package readxml;

public class StDetails implements Comparable<StDetails>
{
  String shortName;
  String stateCode;
  String stateName;
  
public String getShortName() {
	return shortName;
}
public void setShortName(String shortName) {
	this.shortName = shortName;
}
public String getStateCode() {
	return stateCode;
}
public void setStateCode(String stateCode) {
	this.stateCode = stateCode;
}
public String getStateName() {
	return stateName;
}
public void setStateName(String stateName) {
	this.stateName = stateName;
}
@Override
public int compareTo(StDetails d) {
	
	return stateName.compareTo(d.getStateName());
}
  
}
