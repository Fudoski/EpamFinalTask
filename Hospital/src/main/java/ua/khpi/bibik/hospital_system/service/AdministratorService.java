package ua.khpi.bibik.hospital_system.service;

import java.util.List;

import ua.khpi.bibik.hospital_system.db.dao.DoctorDAO;
import ua.khpi.bibik.hospital_system.db.dao.PatientDAO;
import ua.khpi.bibik.hospital_system.db.dao.exception.DAOException;
import ua.khpi.bibik.hospital_system.db.dao.factory.MySQLDAOFactory;
import ua.khpi.bibik.hospital_system.entity.user.Doctor;
import ua.khpi.bibik.hospital_system.entity.user.Patient;

public class AdministratorService {
	
	public List<Doctor> getAllDoctors(){
		List<Doctor> doctors = null;
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			DoctorDAO dao = (DoctorDAO) factory.getDao(Doctor.class);
			doctors = dao.select(null);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		return doctors;
	}

	public List<Patient> getAllPatients() {
		List<Patient> patients = null;
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			PatientDAO dao = (PatientDAO) factory.getDao(Patient.class);
			patients = dao.select(null);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return patients;
	}
}
