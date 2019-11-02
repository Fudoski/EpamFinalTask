package ua.khpi.bibik.hospital_system.entity.medcard.appointment;

import ua.khpi.bibik.hospital_system.entity.Entity;

public class Medicine extends Entity {

	private String discription;
	private int medStaffID;

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public int getMedStaffID() {
		return medStaffID;
	}

	public void setMedStaffID(int medStaffID) {
		this.medStaffID = medStaffID;
	}

}
