
<%@ page import="java.util.*,javax.mail.*"%>

<%@ page import="javax.mail.internet.*" %>
<%
String doctor_name=request.getParameter("doctor_name");
String pemail=(String)session.getAttribute("p_id");
String f_name=request.getParameter("f_name");
String l_name=request.getParameter("l_name");
String date=request.getParameter("date");
String time=request.getParameter("time");
String f_email=request.getParameter("d_email");
String apt_id=request.getParameter("a_id");
int aptid=Integer.parseInt(apt_id);
String chargesRM=request.getParameter("charges");
String CardNo=request.getParameter("card_number");
String cvv=request.getParameter("cvv");
String CardType=request.getParameter("card_type");
String ExpiryDate=request.getParameter("expiry_date");
System.out.println("card number"+CardNo);
System.out.println("Security Code"+cvv);
System.out.println("Card Type"+CardType);
System.out.println("Expiry Date"+ExpiryDate);
pp.Creditcard c1=new pp.Creditcard();
c1.setCardNo(CardNo);
c1.setExpiryDate(ExpiryDate);
c1.setCardType(cvv);
c1.setSecurityCode(CardType);
pp.RegisteredDao rd=new pp.RegisteredDao();
try{
if(rd.VerifyCard(c1))
{

    //Creating a result for getting status that messsage is delivered or not!

    String result;

    // Get recipient's email-ID, message & subject-line from index.html page

    final String to =f_email;

    final String subject ="Appointment Has Been Booked..";

    final String messg ="Appointment of Has Been Booked of The Patient having Name "+f_name+" "+l_name +" and Appointment Id "+apt_id+" with date and time " +date+" "+time+" Login to Check Further details..";

 

    // Sender's email ID and password needs to be mentioned

    final String from = "anujsoni10001@gmail.com";

    final String pass = "i#b#a#success#just#ahead@1965";

 

    // Defining the gmail host

    String host = "smtp.gmail.com";

 

    // Creating Properties object

    Properties props = new Properties();

 

    // Defining properties

    props.put("mail.smtp.host", host);

    props.put("mail.transport.protocol", "smtp");

    props.put("mail.smtp.auth", "true");

    props.put("mail.smtp.starttls.enable", "true");

    props.put("mail.user", from);

    props.put("mail.password", pass);

    props.put("mail.smtp.port","587");

 

    // Authorized the Session object.

    Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {

        @Override

        protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication(from, pass);

        }

    });

 

    try {

        // Create a default MimeMessage object.

        MimeMessage message = new MimeMessage(mailSession);

        // Set From: header field of the header.

        message.setFrom(new InternetAddress(from));

        // Set To: header field of the header.

        message.addRecipient(Message.RecipientType.TO,

                new InternetAddress(to));

        // Set Subject: header field

        message.setSubject(subject);

        // Now set the actual message

        message.setText(messg);

        // Send message

        Transport.send(message);

        result = "Your mail sent successfully....";

    } catch (MessagingException mex) {

        mex.printStackTrace();

        result = "Error: unable to send mail....";

    } 
    //Creating a result for getting status that messsage is delivered or not!

    String result1;

    // Get recipient's email-ID, message & subject-line from index.html page

    final String to1 =pemail;

    final String subject1 ="Appointment Has Been Booked..";

    final String messg1 ="Appointment Has Been Booked of The Patient having Name "+f_name+" "+l_name +" and Appointment Id "+apt_id+" with date and time " +date+" "+time+" & Doctor name "+doctor_name;

 

    // Sender's email ID and password needs to be mentioned

    final String from1 = "anujsoni10001@gmail.com";

    final String pass1 = "i#b#a#success#just#ahead@1965";

 

    // Defining the gmail host

    String host1 = "smtp.gmail.com";

 

    // Creating Properties object

    Properties props1 = new Properties();

 

    // Defining properties

    props.put("mail.smtp.host", host1);

    props.put("mail.transport.protocol", "smtp");

    props.put("mail.smtp.auth", "true");

    props.put("mail.smtp.starttls.enable", "true");

    props.put("mail.user", from1);

    props.put("mail.password", pass1);

    props.put("mail.smtp.port","587");

 

    // Authorized the Session object.

    Session mailSession1 = Session.getInstance(props, new javax.mail.Authenticator() {

        @Override

        protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication(from1, pass1);

        }

    });

 

    try {

        // Create a default MimeMessage object.

        MimeMessage message = new MimeMessage(mailSession);

        // Set From: header field of the header.

        message.setFrom(new InternetAddress(from));

        // Set To: header field of the header.

        message.addRecipient(Message.RecipientType.TO,

                new InternetAddress(to1));

        // Set Subject: header field

        message.setSubject(subject);

        // Now set the actual message

        message.setText(messg1);

        // Send message

        Transport.send(message);

        result1 = "Your mail sent successfully....";

    } catch (MessagingException mex) {

        mex.printStackTrace();

        result1 = "Error: unable to send mail....";

    }
pp.Appointment a=new pp.Appointment();
a.setStatus("Paid");
a.setAppointmentId(aptid);
int i=rd.updateAppointStatus(a);
if(i!=0)
{
RequestDispatcher rd5=request.getRequestDispatcher("login2.jsp");
rd5.include(request, response);
out.println("<script type=\"text/javascript\">");
out.println("alert('Paid Successfully');");
out.println("</script>");
}
}
else
{
	RequestDispatcher rd5=request.getRequestDispatcher("login2.jsp");
	rd5.include(request, response);
    out.println("<script type=\"text/javascript\">");
    out.println("alert('Not Paid ');");
    out.println("</script>");
}
}
catch(Exception e)
{
out.println(e);
}
%>