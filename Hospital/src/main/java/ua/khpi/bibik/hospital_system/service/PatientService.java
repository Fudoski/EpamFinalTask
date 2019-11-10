package ua.khpi.bibik.hospital_system.service;

import ua.khpi.bibik.hospital_system.db.dao.MedicalCardDAO;
import ua.khpi.bibik.hospital_system.db.dao.PatientDAO;
import ua.khpi.bibik.hospital_system.db.dao.exception.DAOException;
import ua.khpi.bibik.hospital_system.db.dao.factory.MySQLDAOFactory;
import ua.khpi.bibik.hospital_system.entity.medcard.MedicalCard;
import ua.khpi.bibik.hospital_system.entity.user.Patient;

public class PatientService {
	
	public Patient getPatientById(int id) {
		Patient patient = null;
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			PatientDAO dao = (PatientDAO) factory.getDao(Patient.class);
			patient =  dao.selectById(id);
			MedicalCard card = new MedicalCard();
			card = getCardFullDataByID(patient.getCard().getId());
			
			
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return patient;
	}
	
	public MedicalCard getCardFullDataByID(int id) {
		MedicalCard card = null;
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			MedicalCardDAO dao = (MedicalCardDAO) factory.getDao(MedicalCard.class);
			card = dao.selectById(id);
		} catch (DAOException e){
			e.printStackTrace();
		}
		return card;
	}

	public void createNewPatient(Patient patient) {
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			PatientDAO dao = (PatientDAO) factory.getDao(Patient.class);
			dao.insert(patient);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
	}

	public void updatePatient(Patient patient) {
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			PatientDAO dao = (PatientDAO) factory.getDao(Patient.class);
			dao.update(patient);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
	}

}
