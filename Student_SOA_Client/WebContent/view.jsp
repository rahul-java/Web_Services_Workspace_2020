<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
     <%@ page import="readXML.StudentDetailsBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table bgcolor="yellow" align="center" border="5">
<tr bgcolor="skyblue" align="center"><th>Std_RollNo</th><th>Std_Name</th><th>Std_Address</th></tr>
<%

List<StudentDetailsBean> list=(List<StudentDetailsBean>) request.getAttribute("std_list");
      for(StudentDetailsBean std:list)
      {
%>

<tr><td><%=std.getRollno() %></td> 
<td><%=std.getName() %></td>
<td><%=std.getAddress() %></td>
 </tr>

<%} %>

</table>

</body>
</html>