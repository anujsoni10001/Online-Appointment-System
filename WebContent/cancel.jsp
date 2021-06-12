<%@page import="pp.Appointment"%>
<%
String a_id=request.getParameter("a_id");
int u=Integer.parseInt(a_id);
pp.RegisteredDao rd=new pp.RegisteredDao();
Appointment p=new Appointment();
p.setAppointmentId(u);
int i=rd.delete(p);
if(i!=0)
{
RequestDispatcher rd1=request.getRequestDispatcher("login2.jsp");
rd1.include(request,response);
out.println("<script type=\"text/javascript\">");
out.println("alert('Deleted');");
out.println("</script>");
}
else
{
	RequestDispatcher rd1=request.getRequestDispatcher("login2.jsp");
	rd1.include(request,response);
	out.println("<script type=\"text/javascript\">");
	out.println("alert('Not Deleted');");
	out.println("</script>");
}
%>