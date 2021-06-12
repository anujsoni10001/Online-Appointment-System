package pp;

public class Doctor {
private int DoctorId;
private String SpecialtyId;
private int YearOfExperience;
private double ChargesRM;
private String DcotorName;
private String Description;
private String HospitalName;
private String HospitalId;
public String getHospitalId() {
	return HospitalId;
}
public void setHospitalId(String hospitalId) {
	HospitalId = hospitalId;
}
public String getHospitalName() {
	return HospitalName;
}
public void setHospitalName(String hospitalName) {
	HospitalName = hospitalName;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public int getDoctorId() {
	return DoctorId;
}
public void setDoctorId(int doctorId) {
	DoctorId = doctorId;
}
public String getSpecialtyId() {
	return SpecialtyId;
}
public void setSpecialtyId(String specialtyId) {
	SpecialtyId = specialtyId;
}
public int getYearOfExperience() {
	return YearOfExperience;
}
public void setYearOfExperience(int yearOfExperience) {
	YearOfExperience = yearOfExperience;
}
public double getChargesRM() {
	return ChargesRM;
}
public void setChargesRM(double chargesRM) {
	ChargesRM = chargesRM;
}
public String getDcotorName() {
	return DcotorName;
}
public void setDcotorName(String dcotorName) {
	DcotorName = dcotorName;
}
}
