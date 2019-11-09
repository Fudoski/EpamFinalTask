package ua.khpi.bibik.hospital_system.entity.user;

public class Patient extends User {
	
	public Patient() {
		super();
	}
	
	public Patient(int patientID) {
		this.id = patientID;
	}
}
