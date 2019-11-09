package ua.khpi.bibik.hospital_system.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.khpi.bibik.hospital_system.entity.user.Doctor;
import ua.khpi.bibik.hospital_system.entity.user.Patient;
import ua.khpi.bibik.hospital_system.page.constant.Attribute;
import ua.khpi.bibik.hospital_system.page.constant.Page;
import ua.khpi.bibik.hospital_system.page.constant.Parameter;
import ua.khpi.bibik.hospital_system.page.resource.AppConfigReader;
import ua.khpi.bibik.hospital_system.service.AdministratorService;

public class AdminUserController implements UserController {
	private List<Doctor> doctors;
	private List<Patient> patients;
	AppConfigReader configReader;
	AdministratorService service;
	HttpServletRequest req;

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		configReader = AppConfigReader.getInstance();
		service = new AdministratorService();
		req = request;
		String processType = (String) request.getAttribute(Attribute.CONTROLL_PROCESS);
		if (processType == null) {
			processType = "";
		}
		switch (processType) {
		case Attribute.CONTROLL_PROCESS_DATA:
			patients = service.getAllPatients();
			request.setAttribute(Attribute.PATIENT_LIST, patients);
			sortIfPramExist(request);
			return configReader.getProperty(Page.PATIENT_USER_LIST);
		case Attribute.CONTROLL_PROCESS_CREATE:
			String createUserType = request.getParameter(Parameter.CREATE_USER_TYPE);
			String jsp = getCreateUserPageForType(createUserType);
			return jsp;
		default:
			doctors = service.getAllDoctors();
			sortIfPramExist(request);
			request.setAttribute(Attribute.DOCTOR_LIST, doctors);

			return configReader.getProperty(Page.ADMIN);
		}
	}

	private String getCreateUserPageForType(String userType) {
		String jsp = null;
		switch (userType) {
		case Attribute.USER_TYPE_DOCTOR:
			jsp = configReader.getProperty(Page.NEW_DOCTOR);
			
			
			
			break;
		case Attribute.USER_TYPE_PATIENT:
			jsp = configReader.getProperty(Page.NEW_PATIENT);
			break;
		}
		return jsp;
	}

	private void sortIfPramExist(HttpServletRequest request) {
		String sortBy = request.getParameter(Parameter.SORT);
		if (sortBy != null) {
			switch (sortBy) {
			default:
				sortBy = Parameter.SORT_ALPHABET;
			case Parameter.SORT_ALPHABET:
				Collections.sort(doctors, (o1, o2) -> {
					String doc1FullName = o1.getName() + o1.getSname() + o1.getMname();
					String doc2FullName = o2.getName() + o2.getSname() + o2.getMname();

					return doc1FullName.compareToIgnoreCase(doc2FullName);
				});
				break;
			case Parameter.SORT_DOC_SPEC:
				Collections.sort(doctors,
						(o1, o2) -> o1.getDoctorSpecialisation().compareToIgnoreCase(o2.getDoctorSpecialisation()));
				break;

			case Parameter.SORT_DOC_PATIENTS:
				Collections.sort(doctors,
						(o1, o2) -> Integer.compare(o1.getAmountOfPatients(), o2.getAmountOfPatients()));
				break;
			}
		}
		request.setAttribute(Parameter.SORT, sortBy);
	}
}
