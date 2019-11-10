package ua.khpi.bibik.hospital_system.utils;

import javax.servlet.http.HttpServletRequest;

import ua.khpi.bibik.hospital_system.entity.user.Doctor;
import ua.khpi.bibik.hospital_system.entity.user.Patient;
import ua.khpi.bibik.hospital_system.hash.HashConverter;
import ua.khpi.bibik.hospital_system.page.constant.Parameter;

public class RequestObjectHelper {

	public static Doctor getDoctor(HttpServletRequest request) {
		Doctor doctor = new Doctor();
		String id = request.getParameter(Parameter.ID);
		String login = request.getParameter(Parameter.LOGIN);
		String password = request.getParameter(Parameter.PASSWORD);
		String name = request.getParameter(Parameter.NAME);
		String surname = request.getParameter(Parameter.SURNAME);
		String middlename = request.getParameter(Parameter.MIDDLENAME);
		String birthday = request.getParameter(Parameter.BIRTHDAY);
		String phone = request.getParameter(Parameter.PHONE);
		int specID = Integer.parseInt(request.getParameter(Parameter.DOCTOR_SPEC));

		doctor.setName(name);
		doctor.setSname(surname);
		doctor.setMname(middlename);
		doctor.setDob(birthday);
		doctor.setLogin(login);
		doctor.setPassword(HashConverter.sha256(password));
		doctor.getDoctorSpecialisation().setId(specID);
		doctor.setPhoneNum(phone);
		if (id != null) {
			doctor.setId(Integer.parseInt(id));	
		}

		return doctor;
	}

	public static Patient getPatient(HttpServletRequest request) {
		Patient patient = new Patient();
		String sId = request.getParameter(Parameter.ID);
		String login = request.getParameter(Parameter.LOGIN);
		String password = request.getParameter(Parameter.PASSWORD);
		String name = request.getParameter(Parameter.NAME);
		String surname = request.getParameter(Parameter.SURNAME);
		String middlename = request.getParameter(Parameter.MIDDLENAME);
		String birthday = request.getParameter(Parameter.BIRTHDAY);
		String phone = request.getParameter(Parameter.PHONE);

		patient.setLogin(login);
		patient.setPassword(HashConverter.sha256(password));
		patient.setName(name);
		patient.setSname(surname);
		patient.setMname(middlename);
		patient.setDob(birthday);
		patient.setPhoneNum(phone);
		if (sId!= null) {
			patient.setId(Integer.parseInt(sId));
		}

		return patient;
	}

}
