<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="readXML.Pensioner_Bean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UP_Update_Servlet">
<div style="background-color:lightgreen; align:center"><h2 align="center">Update Details to the Server</h2> </div>
<table align="center" bgcolor="skyblue" border="2">
<tr bgcolor="yellow"><th>Adhar No</th><th>Scheme</th><th>Name</th><th>DOB</th><th>Address</th><th>Gender</th></tr>
<%
List<Pensioner_Bean> list=(List<Pensioner_Bean>) request.getAttribute("pensioner_list");
request.setAttribute("pensioner_data", list);
for(Pensioner_Bean pnr:list)
{
%>
<tr>
<td><%=pnr.getAdhar() %></td>
<td><%=pnr.getScheme() %></td>
<td><%=pnr.getName() %></td>
<td><%=pnr.getDob() %></td>
<td><%=pnr.getAddress() %></td>
<td><%=pnr.getGender() %></td>
</tr>
<%
}
%>
<tr align="center"><td colspan="6"><input type="submit" value="Update Details"></td></tr>
</table>
</body>
</html>