<%
String apt_id=request.getParameter("a_id");
int aptid=Integer.parseInt(apt_id);
pp.RegisteredDao rd=new pp.RegisteredDao();
pp.Appointment a=new pp.Appointment();
a.setStatus("Completed");
a.setAppointmentId(aptid);
int i=rd.updateAppointStatus(a);
if(i!=0)
{
RequestDispatcher rd5=request.getRequestDispatcher("mypatients.jsp");
rd5.include(request, response);
out.println("<script type=\"text/javascript\">");
out.println("alert('Completed Successfully');");
out.println("</script>");
}
else
{
	RequestDispatcher rd5=request.getRequestDispatcher("mypatients.jsp");
	rd5.include(request, response);
    out.println("<script type=\"text/javascript\">");
    out.println("alert('Not Completed Successfully');");
    out.println("</script>");
}
%>