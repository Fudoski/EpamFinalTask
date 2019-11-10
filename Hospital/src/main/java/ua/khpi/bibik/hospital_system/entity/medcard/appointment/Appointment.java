package ua.khpi.bibik.hospital_system.entity.medcard.appointment;

import java.util.List;

import ua.khpi.bibik.hospital_system.entity.Entity;

public class Appointment extends Entity {
	private int doctorID;
	private int medcardID;
	private List<Procedure> procList;
	private List<Medicine> medList;
	private String operatineDate;
	private Operation operation;
	private String diagnosis;
	
	
	
	public Appointment() {
		super();
		operation = new Operation();
	}

	private int procListID;
	private int medListID;

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

	public int getMedcardID() {
		return medcardID;
	}

	public void setMedcardID(int medcardID) {
		this.medcardID = medcardID;
	}

	public String getOperatineDate() {
		return operatineDate;
	}

	public void setOperatineDate(String operatineDate) {
		this.operatineDate = operatineDate;
	}

	public int getProcListID() {
		return procListID;
	}

	public void setProcListID(int procListID) {
		this.procListID = procListID;
	}

	public int getMedListID() {
		return medListID;
	}

	public void setMedListID(int medListID) {
		this.medListID = medListID;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

}
