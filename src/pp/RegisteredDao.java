package pp;
import java.sql.*;
import java.util.*;
import pp.PatientAccountBean;

public class RegisteredDao {
Connection con;
public Connection getConnect() throws ClassNotFoundException, SQLException 
{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/minor","root","root");
return con;
}
public java.util.ArrayList<PatientAccountBean> ShowPro(String email) throws ClassNotFoundException, SQLException
{
java.util.ArrayList<PatientAccountBean> a1=new java.util.ArrayList<pp.PatientAccountBean>();
con=getConnect();
String qr="select * from accounts where Email=?";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1,email);
ResultSet rs=ps.executeQuery();
while(rs.next())
{
pp.PatientAccountBean p=new pp.PatientAccountBean();
p.setFirstName(rs.getString("FirstName"));
p.setLastName(rs.getString("LastName"));
p.setTelephone(rs.getString("Telephone"));
p.setAddress(rs.getString("Address"));
p.setAccountId(rs.getInt("AccountId"));
a1.add(p);
}
con.close();
return a1;
}
public int update(PatientAccountBean p) throws ClassNotFoundException, SQLException
{
int i=0;
con=getConnect();
///Remember Query///
//update table tablename -XXXX...//
//Wrong Syntax Putted...in the Mid-Sam-Exam//
String qr="update accounts set LastName=?,FirstName=?,Telephone=?,Address=? where Email=?";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1,p.getLastName());
ps.setString(2,p.getFirstName());
ps.setString(3,p.getTelephone());
ps.setString(4,p.getAddress());
ps.setString(5,p.getEmail());
i=ps.executeUpdate();
con.close();
return i;
}
public java.util.ArrayList<Doctor> ShowPro() throws ClassNotFoundException, SQLException
{
java.util.ArrayList<Doctor> a1=new java.util.ArrayList<pp.Doctor>();
con=getConnect();
String qr="select * from doctor";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(qr);
while(rs.next())
{
pp.Doctor p=new pp.Doctor();
p.setDoctorId(rs.getInt("DoctorId"));
a1.add(p);
}
con.close();
return a1;
}
public java.util.ArrayList<Doctor> ShowPro(int id) throws ClassNotFoundException, SQLException
{
java.util.ArrayList<Doctor> a1=new java.util.ArrayList<pp.Doctor>();
con=getConnect();
String qr="select * from doctor,specialty,hospital where doctor.SpecialtyId=specialty.SpecialtyId and DoctorId=? and doctor.HospitalId=hospital.HospitalId";
PreparedStatement ps=con.prepareStatement(qr);
ps.setInt(1,id);
ResultSet rs=ps.executeQuery();
while(rs.next())
{
pp.Doctor p=new pp.Doctor();
p.setDcotorName(rs.getString("DcotorName"));
p.setDescription(rs.getString("Description"));
p.setHospitalName(rs.getString("HospitalName"));
p.setHospitalId(rs.getString("HospitalId"));
p.setYearOfExperience(rs.getInt("YearOfExperience"));
a1.add(p);
}
con.close();
return a1;
}
public int addPro(pp.Appointment a) throws ClassNotFoundException, SQLException
{
int i=0;
con=getConnect();
 ///Remember Query///
//insert table tablename -XXXX...Wrong//
//Wrong Syntax Putted...in the Mid-Sam-Exam//
String qr="insert into Appointment(DoctorId,HospitalId,Date,BookedbyAccountId,Status,Time) values(?,?,?,?,?,?)";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1,a.getDoctorId());
ps.setString(2,a.getHospitalId());
ps.setString(3,a.getDate());
ps.setInt(4,a.getBookedbyAccountId());
ps.setString(5,a.getStatus());
ps.setString(6,a.getTime());
i=ps.executeUpdate();
con.close();
return i;
}
public java.util.ArrayList<pp.Appointment> ShowAppoint(int bbyid) throws ClassNotFoundException, SQLException
{
java.util.ArrayList<pp.Appointment> a1=new java.util.ArrayList<pp.Appointment>();
con=getConnect();
String qr="select * from Appointment,doctor,Accounts,Hospital where Appointment.DoctorId=doctor.DoctorId and AccountId=BookedByAccountId and doctor.HospitalId=Hospital.HospitalId and BookedbyAccountId=?";
PreparedStatement ps=con.prepareStatement(qr);
ps.setInt(1,bbyid);
ResultSet rs=ps.executeQuery();
while(rs.next())
{
pp.Appointment a=new Appointment();
a.setAppointmentId(rs.getInt("AppointmentId"));
a.setHospitalName(rs.getString("HospitalName"));
a.setDoctorName(rs.getString("DcotorName"));
a.setDemail(rs.getString("d_email"));
a.setDate(rs.getString("Date"));
a.setTime(rs.getString("Time"));
a.setStatus(rs.getString("Status"));
a.setChargesRM(rs.getDouble("ChargesRM"));
a.setFirstName(rs.getString("FirstName"));
a.setLastName(rs.getString("LastName"));
a1.add(a);
}
con.close();
return a1;
}
public int updateAppoint(pp.Appointment a) throws ClassNotFoundException, SQLException
{
int i=0;
con=getConnect();
///Remember Query///
//update table tablename -XXXX...//
//Wrong Syntax Putted...in the Mid-Sam-Exam//
String qr="update appointment set DoctorId=?,HospitalId=?,Date=?,BookedbyAccountId=?,Time=? where AppointmentId=?";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1,a.getDoctorId());
ps.setString(2,a.getHospitalId());
ps.setString(3,a.getDate());
ps.setInt(4,a.getBookedbyAccountId());
ps.setString(5,a.getTime());
ps.setInt(6,a.getAppointmentId());
i=ps.executeUpdate();
con.close();
return i;
}
public int delete(Appointment a) throws ClassNotFoundException, SQLException
{
int i=0;
con=getConnect();
///Remember Query///
//delete table tablename -XXXX...Wrong//
//Wrong Syntax Putted...in the Mid-Sam-Exam//
String qr="delete from Appointment where AppointmentId=?";
PreparedStatement ps=con.prepareStatement(qr);
ps.setInt(1,a.getAppointmentId());
i=ps.executeUpdate();
con.close();
return i;
}
public boolean VerifyCard(Creditcard c) throws ClassNotFoundException, SQLException
{
con=getConnect();
String qr="select * from creditcard where CardNo=? and ExpiryDate=? and SecurityCode=? and CardType=?";

PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1,c.getCardNo());
ps.setString(2,c.getExpiryDate());
ps.setString(3,c.getSecurityCode());
ps.setString(4,c.getCardType());
ResultSet rs=ps.executeQuery();
if(rs.next())
{
con.close();
return true;
}
else
{
con.close();
return false;
}
}
public int updateAppointStatus(pp.Appointment a) throws ClassNotFoundException, SQLException
{
int i=0;
con=getConnect();
///Remember Query///
//update table tablename -XXXX...//
//Wrong Syntax Putted...in the Mid-Sam-Exam//
String qr="update appointment set Status=? where AppointmentId=?";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1,a.getStatus());
ps.setInt(2,a.getAppointmentId());
i=ps.executeUpdate();
con.close();
return i;
}
public java.util.ArrayList<pp.Appointment> ShowCompletedAppoint(int bbyid) throws ClassNotFoundException, SQLException
{
java.util.ArrayList<pp.Appointment> a1=new java.util.ArrayList<pp.Appointment>();
con=getConnect();
String qr="select * from Appointment,doctor,Accounts,Hospital where Appointment.DoctorId=doctor.DoctorId and AccountId=BookedByAccountId and doctor.HospitalId=Hospital.HospitalId and BookedbyAccountId=? and Status='Completed'";
PreparedStatement ps=con.prepareStatement(qr);
ps.setInt(1,bbyid);
ResultSet rs=ps.executeQuery();
while(rs.next())
{
pp.Appointment a=new Appointment();
a.setAppointmentId(rs.getInt("AppointmentId"));
a.setHospitalName(rs.getString("HospitalName"));
a.setDoctorName(rs.getString("DcotorName"));
a.setDate(rs.getString("Date"));
a.setStatus(rs.getString("Status"));
a.setChargesRM(rs.getDouble("ChargesRM"));
a1.add(a);
}
con.close();
return a1;
}
public int addPro(pp.Rating r) throws ClassNotFoundException, SQLException
{
int i=0;
con=getConnect();
 ///Remember Query///
//insert table tablename -XXXX...Wrong//
//Wrong Syntax Putted...in the Mid-Sam-Exam//
String qr="insert into rating values(?,?)";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1,r.getAppointmentId());
ps.setInt(2,r.getConsultationRating());
i=ps.executeUpdate();
con.close();
return i;
}
public java.util.ArrayList<pp.Hospital> ShowHospital() throws ClassNotFoundException, SQLException
{
java.util.ArrayList<Hospital> a1=new java.util.ArrayList<pp.Hospital>();
con=getConnect();
String qr="select * from hospital";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(qr);
while(rs.next())
{
pp.Hospital h=new pp.Hospital();
h.setHospitalName(rs.getString("HospitalName"));
a1.add(h);
}
con.close();
return a1;
}
public java.util.ArrayList<pp.Hospital> ShowHospitalId(String HospitalName) throws ClassNotFoundException, SQLException
{
java.util.ArrayList<Hospital> a1=new java.util.ArrayList<pp.Hospital>();
con=getConnect();
String qr="select * from hospital where HospitalName=?";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1,HospitalName);
ResultSet rs=ps.executeQuery();
while(rs.next())
{
pp.Hospital h=new pp.Hospital();
h.setHospitalId(rs.getString("HospitalId"));
a1.add(h);
}
con.close();
return a1;
}
public int addStaff(pp.Staff s) throws ClassNotFoundException, SQLException
{
int i=0;
con=getConnect();
 ///Remember Query///
//insert table tablename -XXXX...Wrong//
//Wrong Syntax Putted...in the Mid-Sam-Exam//
String qr="insert into staff values(?,?,?,?,?,?,?,?,?,?)";
PreparedStatement ps=con.prepareStatement(qr);
ps.setInt(1,s.getStaffId());
ps.setString(2,s.getEmail());
ps.setString(3,s.getPassword());
ps.setString(4,s.getFirstName());
ps.setString(5,s.getLastName());
ps.setString(6,s.getICNumber());
ps.setString(7,s.getTelephone());
ps.setString(8,s.getAddress());
ps.setString(9,s.getPosition());
ps.setString(10,s.getHospitalId());
i=ps.executeUpdate();
con.close();
return i;
}
public java.util.ArrayList<PatientAccountBean> ShowallPatient() throws ClassNotFoundException, SQLException
{
java.util.ArrayList<PatientAccountBean> a1=new java.util.ArrayList<pp.PatientAccountBean>();
con=getConnect();
String qr="select * from accounts";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(qr);
while(rs.next())
{
pp.PatientAccountBean p=new pp.PatientAccountBean();
p.setFirstName(rs.getString("FirstName"));
p.setLastName(rs.getString("LastName"));
p.setTelephone(rs.getString("Telephone"));
p.setAddress(rs.getString("Address"));
p.setAccountId(rs.getInt("AccountId"));
p.setEmail(rs.getString("Email"));
a1.add(p);
}
con.close();
return a1;
}
public int updateStaffPatient(PatientAccountBean p) throws ClassNotFoundException, SQLException
{
int i=0;
con=getConnect();
///Remember Query///
//update table tablename -XXXX...//
//Wrong Syntax Putted...in the Mid-Sam-Exam//
String qr="update accounts set LastName=?,FirstName=?,Telephone=?,Address=?,Email=? where AccountId=?";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1,p.getLastName());
ps.setString(2,p.getFirstName());
ps.setString(3,p.getTelephone());
ps.setString(4,p.getAddress());
ps.setString(5,p.getEmail());
ps.setInt(6,p.getAccountId());
i=ps.executeUpdate();
con.close();
return i;
}
public int delete(pp.PatientAccountBean p) throws ClassNotFoundException, SQLException
{
int i=0;
con=getConnect();
///Remember Query///
//delete table tablename -XXXX...Wrong//
//Wrong Syntax Putted...in the Mid-Sam-Exam//
String qr="delete from accounts where AccountId=?";
PreparedStatement ps=con.prepareStatement(qr);
ps.setInt(1,p.getAccountId());
i=ps.executeUpdate();
con.close();
return i;
}
public java.util.ArrayList<pp.Appointment> ShowAppointDoctor(String email) throws ClassNotFoundException, SQLException
{
java.util.ArrayList<pp.Appointment> a1=new java.util.ArrayList<pp.Appointment>();
con=getConnect();
String qr="select * from Appointment,doctor,Accounts,Hospital where Appointment.DoctorId=doctor.DoctorId and AccountId=BookedByAccountId and doctor.HospitalId=Hospital.HospitalId and doctor.d_email=? and appointment.status=?";
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1,email);
ps.setString(2,"Paid");
ResultSet rs=ps.executeQuery();
while(rs.next())
{
pp.Appointment a=new Appointment();
a.setAppointmentId(rs.getInt("AppointmentId"));
a.setHospitalName(rs.getString("HospitalName"));
a.setDoctorName(rs.getString("DcotorName"));
a.setDemail(rs.getString("d_email"));
a.setDate(rs.getString("Date"));
a.setTime(rs.getString("Time"));
a.setStatus(rs.getString("Status"));
a.setChargesRM(rs.getDouble("ChargesRM"));
a1.add(a);
}
con.close();
return a1;
}
}
