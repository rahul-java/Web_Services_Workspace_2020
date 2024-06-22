<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
     <%@ page import="readxml.StDetails" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table bgcolor="yellow" align="center" border="5">
<tr bgcolor="skyblue" align="center"><th>State_ShortName</th><th>State_Name</th><th>State_Code</th></tr>
<%

List<StDetails> list=(List<StDetails>) request.getAttribute("lst");
      for(StDetails p:list)
      {
%>

<tr><td><%=p.getShortName() %></td> 
<td><%=p.getStateName() %></td>
<td><%=p.getStateCode() %></td>
 </tr>

<%} %>

</table>

</body>
</html>