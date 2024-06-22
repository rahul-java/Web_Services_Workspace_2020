<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="max.unmarsh.UnmarshlingClass" %>
    <%@ page import="max.bean.SHGBean" %>
    <%@ page import="max.bean.MemberNBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Save_Into_DB">
<div style="background-color:cyan" align="center"><h2>Self Help Group Details</h2> </div>
<br>
<br>
<table id="sHGDetail" align="center" bgcolor="skyblue" border="2">
<%
String xml=(String)request.getAttribute("xml");
List<SHGBean> sHGList=UnmarshlingClass.readXML_SHGBean(xml);
for(SHGBean sHGBean:sHGList)
{
%>
<tr><th>SelfHelpGroup Name:</th><td><input type="text" name="sHGName" value="<%= sHGBean.getGname() %>" readonly></td></tr>
<tr><th>Account Number:</th><td><input type="text" name="an" value="<%=sHGBean.getAn() %>" r/eadonly></td></tr>
<tr><th>IFSC:</th><td><input type="text" name="ifsc" value="<%= sHGBean.getIfsc() %>" readonly></td></tr>
<tr><th>Bank Name:</th><td><input type="text" name="bankName" value="<%= sHGBean.getBankName() %>" readonly></td></tr>
<tr><th>Branch Name:</th><td><input type="text" name="branchName" value="<%= sHGBean.getBranchName() %>" readonly></td></tr>
<tr><th>State Code:</th><td><input type="text" name="stateCode" value="<%= sHGBean.getStCode() %>" readonly></td></tr>
<tr><th>District Code:</th><td><input type="text" name="districtCode" value="<%= sHGBean.getDistrictCode() %>" readonly></td></tr>
<%} %>
</table>
<br>
<br>

<div style="background-color:cyan" align="center"><h2>Members Details</h2> </div>

<table id="memberDetail" align="center" bgcolor="yellow" border="2">
<tr bgcolor="skyblue"><th>S.No.</th><th>Name</th><th>Age</th><th>Adhar No.</th></tr>
<%
List<MemberNBean> memberList=UnmarshlingClass.readXML_MemberNBean(xml);

for(MemberNBean memberNBean:memberList)
{ 
	String[] mName= memberNBean.getMname();
	String[] mAge=memberNBean.getMage();
 	String[] mAdhar=memberNBean.getMadhar() ;
 	
   for(int i=0;i<mName.length;i++)
   {
%>

<tr><td><%=i+1 %></td><td><%= mName[i] %></td> <td> <%= mAge[i] %> </td><td><%= mAdhar[i] %></td></tr>
<% 
}
   }
   
   %>
</table>
<br>
<br>
<div align="center"><input type="submit" value="I Confirm and Save "></div>
</form>
</body>
</html>