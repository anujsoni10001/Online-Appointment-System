import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pp.Appointment;
import pp.Doctor;
import pp.PatientAccountBean;
import pp.RegisteredDao;

/**
 * Servlet implementation class Appoint
 */
@WebServlet("/Appoint2")
public class Appoint2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Appoint2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String d_id=request.getParameter("t1");
		int did=Integer.parseInt(d_id);
		String date=request.getParameter("Date");
		String time=request.getParameter("Time");
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("p_id");
		pp.RegisteredDao rd=new RegisteredDao();
		try{
		java.util.ArrayList<PatientAccountBean> a1=rd.ShowPro(email);
		PatientAccountBean p=a1.get(0);
		int a_id=p.getAccountId();
		java.util.ArrayList<Doctor> a2=rd.ShowPro(did);
		Doctor d=a2.get(0);
		String h_id=d.getHospitalId();
		pp.Appointment pa=new Appointment();
		pa.setDoctorId(d_id);
		pa.setHospitalId(h_id);
		pa.setDate(date);
		pa.setBookedbyAccountId(a_id);
		pa.setTime(time);
		pa.setStatus("Unpaid");
	    int i=rd.addPro(pa);
	    if(i!=0)
	    {
	    RequestDispatcher rd5=request.getRequestDispatcher("home.jsp");
	    rd5.include(request, response);
	    out.println("<script type=\"text/javascript\">");
	    out.println("alert('Appointment Done(Proceed For Payment)...');");
	    out.println("</script>");
	    }
	    else
	    {
		RequestDispatcher rd5=request.getRequestDispatcher("home.jsp");
		rd5.include(request, response);
	    out.println("Booking Not Successful...");
	    }
		}
		catch(Exception e)
		{
		out.println(e);
		}
		}

}
