package ua.khpi.bibik.hospital_system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Param;

import ua.khpi.bibik.hospital_system.entity.medcard.MedicalCard;
import ua.khpi.bibik.hospital_system.entity.medcard.appointment.Appointment;
import ua.khpi.bibik.hospital_system.entity.medcard.appointment.Medicine;
import ua.khpi.bibik.hospital_system.entity.medcard.appointment.Procedure;
import ua.khpi.bibik.hospital_system.entity.user.Doctor;
import ua.khpi.bibik.hospital_system.entity.user.Patient;
import ua.khpi.bibik.hospital_system.entity.user.User;
import ua.khpi.bibik.hospital_system.page.constant.Attribute;
import ua.khpi.bibik.hospital_system.page.constant.Page;
import ua.khpi.bibik.hospital_system.page.constant.Parameter;
import ua.khpi.bibik.hospital_system.page.resource.AppConfigReader;
import ua.khpi.bibik.hospital_system.service.DoctorService;
import ua.khpi.bibik.hospital_system.service.PatientService;

public class DoctorUserController implements UserController {
	private AppConfigReader configReader;
	private DoctorService doctorService;
	private HttpServletRequest req;
	private List<Patient> patients;

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		configReader = AppConfigReader.getInstance();
		req = request;
		String jsp = null;
		String processType = (String) request.getAttribute(Attribute.CONTROLL_PROCESS);
		if (processType == null) {
			processType = "";
		}
		switch (processType) {
		case Attribute.CONTROLL_PROCESS_DATA_EDIT:
			return jsp;
		case Attribute.CONTROLL_PROCESS_DATA:
			prepareInfo();
			return configReader.getProperty(Page.PATIENT_INFO);
		case Attribute.CONTROLL_PROCESS_CREATE:
			String patientID = request.getParameter(Parameter.ID);

			req.setAttribute(Attribute.PATIENT_ID, patientID);
			jsp = configReader.getProperty(Page.NEW_APPOINTMENT);
			return jsp;
		case Attribute.CONTROLL_PROCESS_SUBMIT:
			return null;
		default:
			doctorService = new DoctorService();
			HttpSession session = request.getSession(false);
			User doctor = (User) session.getAttribute(Attribute.USER);
			patients = doctorService.getDoctorPatients(doctor);
			request.setAttribute(Attribute.PATIENT_LIST, patients);

			return configReader.getProperty(Page.DOCTOR);
		}
	}

	private void prepareInfo() {
		String patientID = req.getParameter(Parameter.ID);
		int pID = Integer.parseInt(patientID);

		Patient patient = null;
		PatientService patientService = new PatientService();
		patient = patientService.getPatientById(pID);

		Doctor doctor = doctorService.getDoctorById(patient.getCard().getDoctorID());

		MedicalCard card = patient.getCard();

		List<Appointment> applist = doctorService.getMedCardAppointments(patient.getCard());
		card.setAppointments(applist);

		for (Appointment app : card.getAppointments()) {
			List<Medicine> medicines = null;
			List<Procedure> procedures = null;

			medicines = doctorService.getMedicinesFromList(app.getMedListID());
			app.setMedList(medicines);

			procedures = doctorService.getProceduresFromList(app.getProcListID());
			app.setProcList(procedures);
		}

		req.setAttribute(Attribute.PATIENT, patient);
		req.setAttribute(Attribute.DOCTOR, doctor);

	}

}
