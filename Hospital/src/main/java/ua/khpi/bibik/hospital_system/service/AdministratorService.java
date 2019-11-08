package ua.khpi.bibik.hospital_system.service;

import java.util.List;

import ua.khpi.bibik.hospital_system.db.dao.DoctorDAO;
import ua.khpi.bibik.hospital_system.db.dao.exception.DAOException;
import ua.khpi.bibik.hospital_system.db.dao.factory.MySQLDAOFactory;
import ua.khpi.bibik.hospital_system.entity.user.Doctor;

public class AdministratorService {
	
	public List<Doctor> getAllDoctors(){
		List<Doctor> doctors = null;
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			DoctorDAO dao = (DoctorDAO) factory.getDao(Doctor.class);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		return doctors;
	}
}
