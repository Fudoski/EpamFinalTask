package ua.khpi.bibik.hospital_system.entity.user;

public class Doctor extends User {
	private String doctorSpecialisation;
	private int amountOfPatients;

	public Doctor() {
		super();
	}

	public Doctor(String doctorSpecialisation) {
		super();
		this.doctorSpecialisation = doctorSpecialisation;
	}

	public int getAmountOfPatients() {
		return amountOfPatients;
	}

	public String getDoctorSpecialisation() {
		return doctorSpecialisation;
	}

	public void setAmountOfPatients(int amountOfPatients) {
		this.amountOfPatients = amountOfPatients;
	}

	public void setDoctorSpecialisation(String doctorSpecialisation) {
		this.doctorSpecialisation = doctorSpecialisation;
	}

	@Override
	public String toString() {
		return "Doctor [doctorSpecialisation=" + doctorSpecialisation + ", amountOfPatients=" + amountOfPatients + "]";
	}
	
	
}
