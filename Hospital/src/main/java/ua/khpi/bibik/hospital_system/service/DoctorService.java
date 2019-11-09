package ua.khpi.bibik.hospital_system.service;

import java.util.List;

import ua.khpi.bibik.hospital_system.db.dao.DoctorSpecializationDAO;
import ua.khpi.bibik.hospital_system.db.dao.exception.DAOException;
import ua.khpi.bibik.hospital_system.db.dao.factory.MySQLDAOFactory;
import ua.khpi.bibik.hospital_system.entity.DoctorSpecialization;

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

}
