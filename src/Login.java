import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String email=request.getParameter("email");
		String password=request.getParameter("pwd");
		String choice=request.getParameter("cars");
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/minor","root","root");
		if(choice.equals("Patient"))
		{
		String qr="select * from accounts where Email=? and Password=?";
		PreparedStatement ps=con.prepareStatement(qr);
		ps.setString(1,email);
		ps.setString(2,password);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
		con.close();
		///Concept of HttpSession Interface
		HttpSession session=request.getSession();
		//UpCasting
		session.setAttribute("p_id",email);
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
		rd.include(request,response);
		pw.println("<script type=\"text/javascript\">");
		pw.println("alert('Login Succesful...');");
		pw.println("</script>");
		}
		else
		{
		RequestDispatcher rd=request.getRequestDispatcher("login.html");
		rd.include(request,response);
		pw.println("<script type=\"text/javascript\">");
		pw.println("alert('Incorrect Username or Password...');");
		pw.println("</script>");
		con.close();
	    }
        }
		else if(choice.equals("Staff"))
		{
		String qr="select * from Staff where Email=? and Password=?";
		PreparedStatement ps=con.prepareStatement(qr);
		ps.setString(1,email);
		ps.setString(2,password);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
		con.close();
		///Concept of HttpSession Interface
		HttpSession session=request.getSession();
		//UpCasting
		session.setAttribute("s_id",email);
		 RequestDispatcher rd=request.getRequestDispatcher("staffhome.jsp");
			rd.include(request,response);
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Login Succesful...');");
			pw.println("</script>");
		}
		else
		{
		con.close();
		RequestDispatcher rd=request.getRequestDispatcher("login.html");
		rd.include(request,response);
		pw.println("<script type=\"text/javascript\">");
		pw.println("alert('Incorrect Username or Password...');");
		pw.println("</script>");
		}
		}
		else if(choice.equals("Doctor"))
		{
			String qr="select * from doctor where d_email=? and pass=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
			con.close();
			///Concept of HttpSession Interface
			HttpSession session=request.getSession();
			//UpCasting
			session.setAttribute("d_id",email);
			 RequestDispatcher rd=request.getRequestDispatcher("doctorhome.jsp");
				rd.include(request,response);
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Login Succesful...');");
				pw.println("</script>");
			}
			else
			{
			con.close();
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request,response);
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Incorrect Username or Password...');");
			pw.println("</script>");
			}
		}
		else{
			if(email.equals("admin@drcare.com") && password.equals("root"))
			{
			HttpSession session=request.getSession();
			session.setAttribute("admin_session","admin@drcare.com");
            RequestDispatcher rd=request.getRequestDispatcher("adminhome.jsp");
			rd.include(request,response);
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Login Succesful...');");
			pw.println("</script>");
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
				rd.include(request,response);
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Incorrect Username or Password...');");
				pw.println("</script>");
			}
		}
		}
		catch(Exception e)
		{
		pw.println(e);
		}
	}
}