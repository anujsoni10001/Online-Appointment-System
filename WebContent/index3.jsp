<!-- 
Property	Description
onreadystatechange	Defines a function to be called when the readyState property changes
readyState	Holds the status of the XMLHttpRequest.
0: request not initialized 
1: server connection established
2: request received 
3: processing request 
4: request finished and response is ready
 -->
<%@page import="pp.RegisteredDao"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Dr.care - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
<%
String s=request.getParameter("val");
int i=Integer.parseInt(s);
if(s==null || s.trim().equals(""))
{
out.println("Select the State:-");	
}
else
{ 
try 
{
RegisteredDao rd=new RegisteredDao();
java.util.ArrayList<pp.Doctor> a1=rd.ShowPro(i);
for(pp.Doctor d:a1)
{
%>
<div class="d-md-flex">
		    				<div class="form-group">
		    					Doctor Name<input type="text" class="form-control" placeholder=<%=d.getDcotorName()%>>
		    				</div>
		    				<div class="form-group ml-md-4">
		    					Doctors-Specialty<input type="text" class="form-control" placeholder=<%=d.getDescription()%>>
		    				</div>
	    				</div>
<div class="d-md-flex">
		    				<div class="form-group">
		    					Work in Hospital<input type="text" class="form-control" placeholder=<%=d.getHospitalName()%>>
		    				</div>
		    				<div class="form-group ml-md-4">
		    					Year of Experience<input type="text" class="form-control" placeholder=<%=d.getYearOfExperience()%>>
		    				</div>
	    				</div>
<%
}
}
catch(Exception e)
{
e.printStackTrace();
}
}
%>
</body>
</html>