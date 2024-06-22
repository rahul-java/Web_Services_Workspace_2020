<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Map" %>
    <%@ page import="java.util.Map.Entry" %>
    <%@ page import="java.util.Set" %>
    <%@ page import="max.bean.SHG_View_Bean" %>
    <%@ page import="max.bean.Member_View_Bean" %>
    <%@ page import="max.dao.DAO_Class" %>
    <jsp:useBean id="ob" class="max.dao.DAO_Class">
    </jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="background-color:">
<div align="center" style="background-color:lightgreen"><h2>All Self Help Groups And Their Member Details</h2></div>
<br>
<br>

<table bgcolor="" border="3" align="center">
<%
Map<SHG_View_Bean, Set<Member_View_Bean>> map=DAO_Class.view_Allshg_Member_details();
Set<Entry<SHG_View_Bean,Set<Member_View_Bean>>> es=map.entrySet();
for(Entry<SHG_View_Bean,Set<Member_View_Bean>> e:es)
{
%>
<tr><th colspan="8" align="center" bgcolor="yellowgreen">SHG Details</th></tr>
<tr bgcolor="lightgreen"><th>Account Number</th><th>SHG Name</th><th>IFSC</th><th>Bank Name</th><th>Branch Name</th><th>State</th><th>District</th><th>Remarks</th></tr>

<tr bgcolor="skyblue"><td><%=e.getKey().getAcct() %></td><td><%=e.getKey().getGname() %></td><td><%=e.getKey().getIfsc() %></td><td><%=e.getKey().getBank_name() %></td><td><%=e.getKey().getBranch_name() %></td><td><%=e.getKey().getState_name() %></td><td><%=e.getKey().getDistrict_name() %></td><td><%=e.getKey().getRemarks() %></td></td>
<tr><th colspan="4" align="center" bgcolor="yellowgreen">Member's Details</th></tr>
<tr bgcolor=lightgreen><th>Adhar No.</th><th>Name</th><th>Age</th><th>Remarks</th></tr>
<%
for(Member_View_Bean member_View_Bean:e.getValue())
{
%>

<tr bgcolor="yellow"><td><%=member_View_Bean.getAdhar() %></td><td><%=member_View_Bean.getName() %></td><td><%=member_View_Bean.getAge() %></td><td><%=member_View_Bean.getRemarks()%></td></tr>
<%
   }
      }%>
<tr></tr>

</table>


</div>
</body>
</html>