<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="ob" class="max.master.StateDAO">
    </jsp:useBean>
    <%@ page import="java.util.List" %>
    <%@ page import="max.master.StateBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script language="javascript">

   function addRow()
   {
   var table=document.getElementById("member");
   var rowCount=document.getElementById("member").rows.length;
   var row=table.insertRow(rowCount);
   var cell1=row.insertCell(0);
   cell1.innerHTML=rowCount-1;
   
   var cell2=row.insertCell(1);
   var element2=document.createElement("input");
   element2.type="checkbox";
   element2.name="chk";
   cell2.appendChild(element2);
   
   var cell3=row.insertCell(2);
   var element3=document.createElement("input");
   element3.type="text";
   element3.name="mname";
   cell3.appendChild(element3);
   
   var cell4=row.insertCell(3);
   var element4=document.createElement("input");
   element4.type="text";
   element4.name="mage";
   cell4.appendChild(element4);
   
   var cell5=row.insertCell(4);
   var element5=document.createElement("input");
   element5.type="text";
   element5.name="madhar";
   cell5.appendChild(element5);
   }
   
   
   function deleteRow()
   {
     var table=document.getElementById("child");
	 var i=1;
	 if(chkbox==cheked)
	 {
	   table.deleteRow(i);
	   i++;
	 }
	
   }
   
   function getAllDistrict(stCode)
   {
	   var req;    
		 
		  if (window.XMLHttpRequest)
		  	{
		  	     // code for IE7+, Firefox, Chrome, Opera, Safari
		  	     req=new XMLHttpRequest();
		  	}
		  	else
		  	{    // code for IE6, IE5
		  	     req=new ActiveXObject("Microsoft.XMLHTTP");
		  	 }
			  
			  req.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			      document.getElementById("select_District").innerHTML = this.responseText;
			    }
			  };
			  req.open("GET", "District_Servlet?stCode="+stCode, true);
			  req.send();
   }
   function getBankDetail(ifsc)
   {
	   var req;    
		 
		  if (window.XMLHttpRequest)
		  	{
		  	     // code for IE7+, Firefox, Chrome, Opera, Safari
		  	     req=new XMLHttpRequest();
		  	}
		  	else
		  	{    // code for IE6, IE5
		  	     req=new ActiveXObject("Microsoft.XMLHTTP");
		  	 }
			  
			  req.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			      document.getElementById("bankDetail").innerHTML = this.responseText;
			    }
			  };
			  req.open("GET", "Bank_Detail_Servlet?ifsc="+ifsc, true);
			  req.send();
   }
   
</script>
</head>
<body>
<form action="ShgDetails">
<table id="parent" bgcolor="skyblue" border ="3">
<tr bgcolor="green">
   <th colspan="4" align="center">SHGs Details</th>
</tr>



<tr >    
<th>Group Name :</th><td><input type="text" name="gname" ></td></tr>
<tr><th>Account No :</th><td><input type="text" name="an"></td>
<th>IFSC :</th><td><input type="text" name="ifsc"  id="ifsc" onblur="getBankDetail(this.value);"></td></tr>
<tr id="bankDetail"></tr>
<tr><th>State Name :</th>


<td><select name="stCode" onchange="getAllDistrict(this.value)">
                                  <option value="">Select State</option>
                                  
                                  <%

         List<StateBean> list=ob.getStateDetails();
                                  
                                  for(StateBean p:list)
                                  {                         
%>

<option value="<%=p.getStCode()%>" > <%=p.getStName()%> </option>
                                  
                                  <%} %>
                                  
</select></td>


<th>District Name :</th>
                      <td>
                      <select name="districtCode" id="select_District">
                      
                                   <option value="0" id="option_District">Select District</option>
                           
                       
								    
								  </select></td>
</tr>

</table>
<table id="member" bgcolor="yellow" border ="3">
  <tr bgcolor="green">
   <th colspan="4" align="center">Member's Detail</th><td align="right"> <input type="button"  value ="ADD Member" id="b1"  onclick="addRow();"></td>
</tr>
  <tr>
     <th>S.No.</th><th>Select</th><th>Member Name</th><th>Age</th><th>Adhar</th>
  </tr>
  <tr>
     <td>1</td><td><input type="checkbox" name="chk"></td>
     <td><input type="text" name="mname"></td>
     <td><input type="text" name="mage"></td>
     <td><input type="text" name="madhar"></td>
  </tr>
  
</table>
<table>
<tr><td><input type="submit" value="Save"></td>
<td><a href=view.html>View</a></td>
</tr>
</table>

</form>
</body>
</html>