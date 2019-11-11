package ua.khpi.bibik.hospital_system.service;

import java.util.ArrayList;
import java.util.List;

import ua.khpi.bibik.hospital_system.db.dao.AppointmentDAO;
import ua.khpi.bibik.hospital_system.db.dao.DoctorDAO;
import ua.khpi.bibik.hospital_system.db.dao.DoctorSpecializationDAO;
import ua.khpi.bibik.hospital_system.db.dao.MedicalCardDAO;
import ua.khpi.bibik.hospital_system.db.dao.MedicineDAO;
import ua.khpi.bibik.hospital_system.db.dao.PatientDAO;
import ua.khpi.bibik.hospital_system.db.dao.ProcedureDAO;
import ua.khpi.bibik.hospital_system.db.dao.exception.DAOException;
import ua.khpi.bibik.hospital_system.db.dao.factory.MySQLDAOFactory;
import ua.khpi.bibik.hospital_system.entity.DoctorSpecialization;
import ua.khpi.bibik.hospital_system.entity.medcard.MedicalCard;
import ua.khpi.bibik.hospital_system.entity.medcard.appointment.Appointment;
import ua.khpi.bibik.hospital_system.entity.medcard.appointment.Medicine;
import ua.khpi.bibik.hospital_system.entity.medcard.appointment.Procedure;
import ua.khpi.bibik.hospital_system.entity.model.MedicineDataModel;
import ua.khpi.bibik.hospital_system.entity.model.ProcedureDataModel;
import ua.khpi.bibik.hospital_system.entity.user.Doctor;
import ua.khpi.bibik.hospital_system.entity.user.Patient;
import ua.khpi.bibik.hospital_system.entity.user.User;

public class DoctorService {

	public List<DoctorSpecialization> getDoctorSpecList() {
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
			doctor = dao.selectById(id);
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

	public List<Appointment> getMedCardAppointments(MedicalCard card) {
		List<Appointment> appointments = null;
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			AppointmentDAO dao = (AppointmentDAO) factory.getDao(Appointment.class);
			appointments = dao.select(card);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return appointments;
	}

	public List<Medicine> getMedicinesFromList(int medListID) {
		List<Medicine> medicines = null;
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			MedicineDAO dao = (MedicineDAO) factory.getDao(Medicine.class);
			medicines = dao.selectFromList(medListID);

		} catch (DAOException e) {
			e.printStackTrace();
		}
		return medicines;
	}

	public List<Procedure> getProceduresFromList(int procListID) {
		List<Procedure> procedures = null;
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			ProcedureDAO dao = (ProcedureDAO) factory.getDao(Procedure.class);
			procedures = dao.selectFromList(procListID);

		} catch (DAOException e) {
			e.printStackTrace();
		}
		return procedures;
	}

	public MedicalCard getMedCardOfPatient(int patientId) {
		MedicalCard medcard = null;
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			MedicalCardDAO dao = (MedicalCardDAO) factory.getDao(MedicalCard.class);
			medcard = dao.selectByPatientId(patientId);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return medcard;
	}

	public int addMedicines(String[] medicines) {
		List<Medicine> mList = new ArrayList<Medicine>();
		if (medicines != null) {
			for (String med : medicines) {
				Medicine medicine = new Medicine();
				medicine.setDiscription(med);
				mList.add(medicine);
			}
		}
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			MedicineDAO dao = (MedicineDAO) factory.getDao(Medicine.class);
			for (Medicine m : mList) {
				dao.insert(m);
			}
			return dao.insertToList(mList);
		} catch (DAOException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int addProcedures(String[] procedures) {
		List<Procedure> pList = new ArrayList<Procedure>();
		if (procedures != null) {
			for (String proc : procedures) {
				Procedure procedure = new Procedure();
				procedure.setDiscription(proc);
				pList.add(procedure);
			}
		}
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			ProcedureDAO dao = (ProcedureDAO) factory.getDao(Procedure.class);
			for (Procedure p : pList) {
				dao.insert(p);
			}
			return dao.insertToList(pList);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void addAppointment(Appointment appointment) {
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			AppointmentDAO dao = (AppointmentDAO) factory.getDao(Appointment.class);
			dao.insert(appointment);
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

	public void dischargePatient(MedicalCard card) {
		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			MedicalCardDAO dao = (MedicalCardDAO) factory.getDao(MedicalCard.class);
			dao.update(card);
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

	public List<ProcedureDataModel> getAppointmentProcedures() {
		List<ProcedureDataModel> procedureDataModels = new ArrayList<ProcedureDataModel>();

		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			ProcedureDAO dao = (ProcedureDAO) factory.getDao(Procedure.class);
			procedureDataModels = dao.selectFromProcView();

			for (ProcedureDataModel model : procedureDataModels) {

				Doctor doctor = getDoctorById(model.getDoctorID());

				model.setDocName(doctor.getName());
				model.setDocSname(doctor.getSname());
				model.setDocMname(doctor.getMname());

				PatientDAO pDao = (PatientDAO) factory.getDao(Patient.class);
				Patient patient = pDao.selectById(model.getPatientID());

				model.setpName(patient.getName());
				model.setpSname(patient.getSname());
				model.setpMname(patient.getMname());

			}
		} catch (DAOException e) {
			e.printStackTrace();
		}

		return procedureDataModels;
	}

	public List<MedicineDataModel> getAppointmentMedicines() {
		List<MedicineDataModel> medicineDataModels = new ArrayList<MedicineDataModel>();

		MySQLDAOFactory factory = MySQLDAOFactory.getInstance();
		try {
			MedicineDAO dao = (MedicineDAO) factory.getDao(Medicine.class);
			medicineDataModels = dao.selectFromProcView();

			for (MedicineDataModel model : medicineDataModels) {

				Doctor doctor = getDoctorById(model.getDoctorID());

				model.setDocName(doctor.getName());
				model.setDocSname(doctor.getSname());
				model.setDocMname(doctor.getMname());

				PatientDAO pDao = (PatientDAO) factory.getDao(Patient.class);
				Patient patient = pDao.selectById(model.getPatientID());

				model.setpName(patient.getName());
				model.setpSname(patient.getSname());
				model.setpMname(patient.getMname());

			}
		} catch (DAOException e) {
			e.printStackTrace();
		}

		return medicineDataModels;
	}

}
