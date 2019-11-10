package ua.khpi.bibik.hospital_system.entity.medcard;

import java.util.List;

import ua.khpi.bibik.hospital_system.entity.Entity;
import ua.khpi.bibik.hospital_system.entity.medcard.appointment.Appointment;

public class MedicalCard extends Entity {
	private int doctorID;

	private List<Appointment> appointments;

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

}
