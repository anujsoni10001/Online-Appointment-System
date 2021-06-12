<%@page import="java.sql.*"%>
<% 
   
        String email=request.getParameter("email");
		String Password=request.getParameter("pwd");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/minor","root","root");
		String qr="insert into accounts(Email,Password) values(?,?)";
		PreparedStatement ps=con.prepareStatement(qr);
		ps.setString(1,email);
		ps.setString(2,Password);
		int i=ps.executeUpdate();
		if(i!=0)
		{
		con.close();
		response.sendRedirect("login.html");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("register.html");
			rd.include(request,response);
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Not Registered !! try Again');");
			out.println("</script>");
		}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
		out.println(e);
		}
		%>