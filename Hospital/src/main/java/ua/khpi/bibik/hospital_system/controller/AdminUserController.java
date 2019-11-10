package ua.khpi.bibik.hospital_system.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.khpi.bibik.hospital_system.entity.DoctorSpecialization;
import ua.khpi.bibik.hospital_system.entity.user.Doctor;
import ua.khpi.bibik.hospital_system.entity.user.Patient;
import ua.khpi.bibik.hospital_system.entity.user.User;
import ua.khpi.bibik.hospital_system.page.constant.Attribute;
import ua.khpi.bibik.hospital_system.page.constant.Page;
import ua.khpi.bibik.hospital_system.page.constant.Parameter;
import ua.khpi.bibik.hospital_system.page.resource.AppConfigReader;
import ua.khpi.bibik.hospital_system.service.AdministratorService;
import ua.khpi.bibik.hospital_system.service.DoctorService;
import ua.khpi.bibik.hospital_system.service.PatientService;

public class AdminUserController implements UserController {
	private List<Doctor> doctors;
	private List<Patient> patients;
	private AppConfigReader configReader;
	private AdministratorService service;
	private DoctorService doctorService;
	private HttpServletRequest req;

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		configReader = AppConfigReader.getInstance();
		service = new AdministratorService();
		req = request;
		String createUserType = null;
		String jsp = null;
		String processType = (String) request.getAttribute(Attribute.CONTROLL_PROCESS);
		if (processType == null) {
			processType = "";
		}
		String userType = (String) request.getAttribute(Attribute.USER_TYPE);
		switch (processType) {
		case Attribute.CONTROLL_PROCESS_DATA_UPDATE:
			userType = request.getParameter(Parameter.CREATE_USER_TYPE);
			User user = (User) request.getAttribute(Attribute.USER);
			jsp = updateDataForType(userType, user);
			return jsp;
		case Attribute.CONTROLL_PROCESS_DATA_EDIT:
			jsp = getEditUserPageForType(userType);
			return jsp;

		case Attribute.CONTROLL_PROCESS_DATA:
			patients = service.getAllPatients();
			request.setAttribute(Attribute.PATIENT_LIST, patients);
			sortIfPramExist(request);
			return configReader.getProperty(Page.PATIENT_USER_LIST);

		case Attribute.CONTROLL_PROCESS_CREATE:
			createUserType = request.getParameter(Parameter.CREATE_USER_TYPE);
			jsp = getCreateUserPageForType(createUserType);
			return jsp;

		case Attribute.CONTROLL_PROCESS_SUBMIT:
			createUserType = request.getParameter(Parameter.CREATE_USER_TYPE);
			user = (User) request.getAttribute(Attribute.USER);
			submitCreateUserForType(createUserType, user);
			return null;

		default:
			doctors = service.getAllDoctors();
			sortIfPramExist(request);
			request.setAttribute(Attribute.DOCTOR_LIST, doctors);

			return configReader.getProperty(Page.ADMIN);
		}
	}

	private String updateDataForType(String userType, User user) {
		switch (userType) {
		case Attribute.USER_TYPE_DOCTOR:
			Doctor doctor = (Doctor) user;
			doctorService = new DoctorService();
			doctorService.updateDoctor(doctor);
			break;
		case Attribute.USER_TYPE_PATIENT:
			Patient patient = (Patient) user;
			PatientService pService = new PatientService();
			pService.updatePatient(patient);
			break;
		}
		return null;
	}

	private String getEditUserPageForType(String userType) {
		String jsp = null;
		Doctor doctor = null;
		doctorService = new DoctorService();
		switch (userType) {
		case Attribute.USER_TYPE_DOCTOR:
			int doctorID = Integer.parseInt(req.getParameter(Parameter.ID));
			doctor = doctorService.getDoctorById(doctorID);

			req.setAttribute(Attribute.DOCTOR, doctor);

			List<DoctorSpecialization> specList = doctorService.getDoctorSpecList();
			req.setAttribute(Attribute.DOCTOR_SPEC_LIST, specList);

			jsp = configReader.getProperty(Page.EDIT_DOCTOR);
			break;
		case Attribute.USER_TYPE_PATIENT:
			PatientService pService = new PatientService();
			int patientID = Integer.parseInt(req.getParameter(Parameter.ID));
			Patient patient = pService.getPatientById(patientID);
			doctor = doctorService.getDoctorById(patient.getCard().getDoctorID());
			List<Doctor> docList = service.getAllDoctors();
			
			req.setAttribute(Attribute.DOCTOR_LIST, docList);
			req.setAttribute(Attribute.DOCTOR, doctor);
			req.setAttribute(Attribute.PATIENT, patient);
			jsp = configReader.getProperty(Page.EDIT_PATIENT);
			break;
		}
		return jsp;
	}

	private void submitCreateUserForType(String userType, User user) {
		switch (userType) {
		case Attribute.USER_TYPE_DOCTOR:
			Doctor doctor = (Doctor) user;
			doctorService = new DoctorService();
			doctorService.createNewDoctor(doctor);
			break;
		case Attribute.USER_TYPE_PATIENT:
			Patient patient = (Patient) user;
			PatientService pService = new PatientService();
			pService.createNewPatient(patient);
			break;
		}
	}

	private String getCreateUserPageForType(String userType) {
		String jsp = null;
		switch (userType) {
		case Attribute.USER_TYPE_DOCTOR:
			jsp = configReader.getProperty(Page.NEW_DOCTOR);
			DoctorService docService = new DoctorService();

			List<DoctorSpecialization> specList = docService.getDoctorSpecList();
			req.setAttribute(Attribute.DOCTOR_SPEC_LIST, specList);

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
				Collections.sort(doctors, (o1, o2) -> o1.getDoctorSpecialisation().getName()
						.compareToIgnoreCase(o2.getDoctorSpecialisation().getName()));
				break;

			case Parameter.SORT_DOC_PATIENTS:
				Collections.sort(doctors,
						(o1, o2) -> Integer.compare(o2.getAmountOfPatients(), o1.getAmountOfPatients()));
				break;
			}
		}
		request.setAttribute(Parameter.SORT, sortBy);
	}
}
