<%@page import="java.util.*"%>
<%
String lname=request.getParameter("lname");
String fname=request.getParameter("fname");
String telephone=request.getParameter("telephone");
String a=request.getParameter("address");
String email=(String)session.getAttribute("p_id");
pp.PatientAccountBean pb=new pp.PatientAccountBean();
pb.setLastName(lname);
pb.setFirstName(fname);
pb.setTelephone(telephone);
pb.setAddress(a);
pb.setEmail(email);
pp.RegisteredDao rd=new pp.RegisteredDao();
try {
	int i=rd.update(pb);
	if(i!=0)
	{
		RequestDispatcher rd1=request.getRequestDispatcher("home.jsp");
		rd1.include(request,response);
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Updation Succesful...');");
		out.println("</script>");
	}
	else
	{
		RequestDispatcher rd1=request.getRequestDispatcher("home.jsp");
		rd1.include(request,response);
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Updation Not Succesful...');");
		out.println("</script>");
	}
} 
catch (Exception e) {
	// TODO Auto-generated catch block
out.println(e);
} 
%>