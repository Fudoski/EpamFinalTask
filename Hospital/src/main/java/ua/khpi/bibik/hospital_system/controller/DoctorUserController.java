package ua.khpi.bibik.hospital_system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.khpi.bibik.hospital_system.entity.user.Doctor;
import ua.khpi.bibik.hospital_system.entity.user.Patient;
import ua.khpi.bibik.hospital_system.entity.user.User;
import ua.khpi.bibik.hospital_system.page.constant.Attribute;
import ua.khpi.bibik.hospital_system.page.constant.Page;
import ua.khpi.bibik.hospital_system.page.constant.Parameter;
import ua.khpi.bibik.hospital_system.page.resource.AppConfigReader;
import ua.khpi.bibik.hospital_system.service.AdministratorService;
import ua.khpi.bibik.hospital_system.service.DoctorService;

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
		case Attribute.CONTROLL_PROCESS_DATA:
			return configReader.getProperty(Page.PATIENT_USER_LIST);
		case Attribute.CONTROLL_PROCESS_CREATE:
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

}
