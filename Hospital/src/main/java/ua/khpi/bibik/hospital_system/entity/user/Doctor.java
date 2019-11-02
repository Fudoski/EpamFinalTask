package ua.khpi.bibik.hospital_system.entity.user;

public class Doctor extends User {
	private int doctorSpecialisation;

	public Doctor() {
		super();
	}

	public Doctor(int doctorSpecialisation) {
		super();
		this.doctorSpecialisation = doctorSpecialisation;
	}

	public int getDoctorSpecialisation() {
		return doctorSpecialisation;
	}

	public void setDoctorSpecialisation(int doctorSpecialisation) {
		this.doctorSpecialisation = doctorSpecialisation;
	}

}
