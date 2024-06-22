<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/WEB-INF/f.tld" prefix="addddd"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

  String n1=request.getParameter("n1");
String n2=request.getParameter("n2");
%>

<addddd:ad n2="<%=n2%>" n1="<%=n1%>"/>

</body>
</html>