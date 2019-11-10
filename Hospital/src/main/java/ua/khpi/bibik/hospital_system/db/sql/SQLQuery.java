package ua.khpi.bibik.hospital_system.db.sql;

public final class SQLQuery {
	public static final String SELECT_USER_BY_LOGIN = "SELECT * FROM user_view WHERE login = ?";
	public static final String SELECT_ALL_DOCTORS = "SELECT * FROM doc_view";
	public static final String SELECT_ALL_PATIENTS = "SELECT * FROM patient_view";
	public static final String SELECT_ALL_DOCTOR_SPEC = "SELECT * FROM doc_spec";
	public static final String ADD_NEW_DOC = "call addDoc(?,?,?,?,?,?,?,?)";
	public static final String SLECT_DOC_PATIENTS = "select user.* from user inner join patient on user.id = patient.u_id inner join med_card on patient.u_id = med_card.p_id where med_card.docr_id = ?";
	public static final String SELECT_DOCTOR_BY_ID = "SELECT * FROM doc_view where id = ?";
	public static final String SELECT_PATIENT_INFO_BY_ID = "select user.*, med_card.id as 'mc_id', med_card.docr_id from user inner join patient on user.id = patient.u_id inner join med_card on user.id = med_card.p_id where patient.u_id = ?";
	public static final String ADD_NEW_PATIENT = "call addPatient(?,?,?,?,?,?,?)";
	public static final String UPDATE_DOCTOR = "update user set login=?, password=?, name=?, sname=?, mname=?, phone_num=?, dob=? where id = ?";
	public static final String UPDATE_PATIENT = "update user set login=?, password=?, name=?, sname=?, mname=?, phone_num=?, dob=? where id = ?";
	public static final String SELECT_MED_CARD_APPOINTMENTS = "select * from appointment where mc_id = ?;";
	public static final String SELECT_APPOINTMENT_MED_LIST = "";
	public static final String SELECT_APPOINTMENT_PROC_LIST = "";
	public static final String SELECT_MEDICINE_FROM_LIST = "select medicine.* from medicine inner join medicine_list on medicine.id = medicine_list.m_id where medicine_list.id = ?";
	public static final String SELECT_PROCEDURE_FROM_LIST = "select proc.* from proc inner join procedure_list on proc.id = procedure_list.p_id where procedure_list.id = ?;";
	public static final String SELECT_OPERATION_BY_ID = "select operation.* from operation inner join appointment on operation.id = appointment.op_id where operation.id = ?;";
	

	private SQLQuery() {
		// empty
	}
}
