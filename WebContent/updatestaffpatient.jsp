<%
String a_id=request.getParameter("a_id");
		int accountid=Integer.parseInt(a_id);
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String telephone=request.getParameter("telephone");
		String address=request.getParameter("address");
		pp.PatientAccountBean p=new pp.PatientAccountBean();
		p.setAccountId(accountid);
		p.setFirstName(fname);
		p.setLastName(lname);
		p.setEmail(email);
		p.setTelephone(telephone);
		p.setAddress(address);
		pp.RegisteredDao r=new pp.RegisteredDao();
		try
		{
		int i=r.updateStaffPatient(p);
		if(i!=0)
		{
		RequestDispatcher rd=request.getRequestDispatcher("patientrecord2.jsp");
		rd.include(request, response);
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Patient Updation Succesful...');");
		out.println("</script>");
		}
		else
		{
		RequestDispatcher rd=request.getRequestDispatcher("patientrecord2.jsp");
		rd.include(request, response);
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Patient Updation Not Succesful...');");
		out.println("</script>");
		}
	    }
		catch(Exception e)
		{
		out.println(e);
		}
		%>