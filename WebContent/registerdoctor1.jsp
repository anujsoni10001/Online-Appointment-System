<%
String hname=request.getParameter("hname");
out.println(hname);
// *
/*/String position=request.getParameter("pos");
String fname=request.getParameter("fname");
String lname=request.getParameter("lname");
String nric=request.getParameter("nric");
String phone=request.getParameter("phone");
String address=request.getParameter("address");
String email=request.getParameter("email");
String pwd=request.getParameter("pwd");
pp.RegisteredDao rd=new pp.RegisteredDao();
try
{
java.util.ArrayList<pp.Hospital> h=rd.ShowHospitalId(hname);
pp.Hospital hos=h.get(0);
String hos_id=hos.getHospitalId();
pp.Staff s=new pp.Staff();
s.setEmail(email);
s.setPassword(pwd);
s.setFirstName(fname);
s.setLastName(lname);
s.setICNumber(nric);
s.setTelephone(phone);
s.setAddress(address);
s.setPosition(position);
s.setHospitalId(hos_id);
int i=rd.addStaff(s);
if(i!=0)
{
RequestDispatcher rd5=request.getRequestDispatcher("adminhome.jsp");
rd5.include(request, response);
out.println("<script type=\"text/javascript\">");
out.println("alert('Registered...');");
out.println("</script>");

}
else
{
	RequestDispatcher rd5=request.getRequestDispatcher("adminhome.jsp");
	rd5.include(request, response);
	out.println("<script type=\"text/javascript\">");
	out.println("alert('Not Registered...');");
	out.println("</script>");	
}
}
catch(Exception e)
{
out.println(e);
} /* /

/ */
%>