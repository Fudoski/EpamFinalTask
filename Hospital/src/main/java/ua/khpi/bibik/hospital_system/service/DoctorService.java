package ua.khpi.bibik.hospital_system.service;

import java.util.List;

import ua.khpi.bibik.hospital_system.db.dao.DoctorDAO;
import ua.khpi.bibik.hospital_system.db.dao.DoctorSpecializationDAO;
import ua.khpi.bibik.hospital_system.db.dao.PatientDAO;
import ua.khpi.bibik.hospital_system.db.dao.exception.DAOException;
import ua.khpi.bibik.hospital_system.db.dao.factory.MySQLDAOFactory;
import ua.khpi.bibik.hospital_system.entity.DoctorSpecialization;
import ua.khpi.bibik.hospital_system.entity.user.Doctor;
import ua.khpi.bibik.hospital_system.entity.user.Patient;
import ua.khpi.bibik.hospital_system.entity.user.User;

public class DoctorService {
	
	public List<DoctorSpecialization> getDoctorSpecList(){
		List<DoctorSpecialization> specializations = null;
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			DoctorSpecializationDAO dao = (DoctorSpecializationDAO) factory.getDao(DoctorSpecialization.class);
			specializations = dao.select(null);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		return specializations;
		
	}

	public void createNewDoctor(Doctor doctor) {
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			DoctorDAO dao = (DoctorDAO) factory.getDao(Doctor.class);
			dao.insert(doctor);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
	}

	public List<Patient> getDoctorPatients(User doctor) {
		List<Patient> patients = null;
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			PatientDAO dao = (PatientDAO) factory.getDao(Patient.class);
			Doctor doc = new Doctor();
			doc.setId(doctor.getId());
			patients = dao.select(doc);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return patients;
	}
	
	public Doctor getDoctorById(int id) {
		Doctor doctor = null;
		if (id <= 0) {
			return null;
		}
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			DoctorDAO dao = (DoctorDAO) factory.getDao(Doctor.class);
			doctor =  dao.selectById(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return doctor;
	}

	public void updateDoctor(Doctor doctor) {
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			DoctorDAO dao = (DoctorDAO) factory.getDao(Doctor.class);
			dao.update(doctor);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
	}

}
