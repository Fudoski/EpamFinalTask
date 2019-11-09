package ua.khpi.bibik.hospital_system.entity.user;

import ua.khpi.bibik.hospital_system.entity.DoctorSpecialization;

public class Doctor extends User {
	private DoctorSpecialization doctorSpecialisation;
	private int amountOfPatients;

	public Doctor() {
		super();
		doctorSpecialisation = new DoctorSpecialization();
	}

	public int getAmountOfPatients() {
		return amountOfPatients;
	}

	public void setAmountOfPatients(int amountOfPatients) {
		this.amountOfPatients = amountOfPatients;
	}

	public DoctorSpecialization getDoctorSpecialisation() {
		return doctorSpecialisation;
	}

	public void setDoctorSpecialisation(DoctorSpecialization doctorSpecialisation) {
		this.doctorSpecialisation = doctorSpecialisation;
	}

	@Override
	public String toString() {
		return "Doctor [doctorSpecialisation=" + doctorSpecialisation + ", amountOfPatients=" + amountOfPatients
				+ ", name=" + name + ", sname=" + sname + ", mname=" + mname + ", id=" + id + "]";
	}

}
