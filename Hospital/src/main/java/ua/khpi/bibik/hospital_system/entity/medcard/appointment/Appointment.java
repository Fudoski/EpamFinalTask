package ua.khpi.bibik.hospital_system.entity.medcard.appointment;

import java.util.List;

import ua.khpi.bibik.hospital_system.entity.Entity;

public class Appointment extends Entity {
	private int doctorID;
	private List<Procedure> procList;
	private List<Medicine> medList;
	private Operation operation;

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public List<Procedure> getProcList() {
		return procList;
	}

	public void setProcList(List<Procedure> procList) {
		this.procList = procList;
	}

	public List<Medicine> getMedList() {
		return medList;
	}

	public void setMedList(List<Medicine> medList) {
		this.medList = medList;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

}
