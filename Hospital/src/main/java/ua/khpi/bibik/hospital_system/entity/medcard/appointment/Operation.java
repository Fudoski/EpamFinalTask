package ua.khpi.bibik.hospital_system.entity.medcard.appointment;

import ua.khpi.bibik.hospital_system.entity.Entity;

public class Operation extends Entity {
	private String discription;
	private int doctorID;
	private String operationStartDateTime;
	private String operationEndDateTime;

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public String getOperationStartDateTime() {
		return operationStartDateTime;
	}

	public void setOperationStartDateTime(String operationStartDateTime) {
		this.operationStartDateTime = operationStartDateTime;
	}

	public String getOperationEndDateTime() {
		return operationEndDateTime;
	}

	public void setOperationEndDateTime(String operationEndDateTime) {
		this.operationEndDateTime = operationEndDateTime;
	}

}
