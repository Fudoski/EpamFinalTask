package ua.khpi.bibik.hospital_system.entity.user;

import ua.khpi.bibik.hospital_system.entity.medcard.MedicalCard;

public class Patient extends User {
	
	private MedicalCard card;
	
	public Patient() {
		super();
	}
	
	public Patient(int patientID) {
		this.id = patientID;
	}

	public MedicalCard getCard() {
		return card;
	}

	public void setCard(MedicalCard card) {
		this.card = card;
	}
	
	
}
