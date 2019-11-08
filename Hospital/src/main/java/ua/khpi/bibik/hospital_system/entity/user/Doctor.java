package ua.khpi.bibik.hospital_system.entity.user;

public class Doctor extends User {
	private String doctorSpecialisation;

	public Doctor() {
		super();
	}

	public Doctor(String doctorSpecialisation) {
		super();
		this.doctorSpecialisation = doctorSpecialisation;
	}

	public String getDoctorSpecialisation() {
		return doctorSpecialisation;
	}

	public void setDoctorSpecialisation(String doctorSpecialisation) {
		this.doctorSpecialisation = doctorSpecialisation;
	}


}
