<%
String d_id=request.getParameter("t1");
int did=Integer.parseInt(d_id);
String date=request.getParameter("Date");
String time=request.getParameter("Time");
String email=(String)session.getAttribute("p_id");
pp.RegisteredDao rd=new pp.RegisteredDao();
pp.RegisteredDao rd1=new pp.RegisteredDao();
pp.RegisteredDao rd2=new pp.RegisteredDao();
String apointment_id=request.getParameter("a_id");
int apoint_id=Integer.parseInt(apointment_id);
try{
java.util.ArrayList<pp.PatientAccountBean> a1=rd.ShowPro(email);
pp.PatientAccountBean p=a1.get(0);
int bookedbya_id=p.getAccountId();
java.util.ArrayList<pp.Doctor> a2=rd1.ShowPro(did);
pp.Doctor d=a2.get(0);
String h_id=d.getHospitalId();
pp.Appointment pa=new pp.Appointment();
pa.setDoctorId(d_id);
pa.setHospitalId(h_id);
pa.setDate(date);
pa.setTime(time);
pa.setBookedbyAccountId(bookedbya_id);
pa.setAppointmentId(apoint_id);
int i=rd2.updateAppoint(pa);
if(i!=0)
{
RequestDispatcher rd8=request.getRequestDispatcher("login2.jsp");
rd8.include(request,response);
out.println("<script type=\"text/javascript\">");
out.println("alert('Booking Done...');");
out.println("</script>");
}
else
{
	
}
}
catch(Exception e)
{
out.println(e);
}
%>