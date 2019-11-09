package ua.khpi.bibik.hospital_system.db.sql;

public final class SQLQuery {
	public static final String SELECT_USER_BY_LOGIN = "SELECT * FROM user_view WHERE login = ?";
	public static final String SELECT_ALL_DOCTORS = "SELECT * FROM doc_view";
	public static final String SELECT_ALL_PATIENTS = "SELECT * FROM patient_view";
	public static final String SELECT_ALL_DOCTOR_SPEC = "SELECT * FROM doc_spec";
	public static final String ADD_NEW_DOC = "call addDoc(?,?,?,?,?,?,?,?);";
	public static final String SLECT_DOC_PATIENTS = "select user.* from user inner join patient on user.id = patient.u_id inner join med_card on patient.u_id = med_card.p_id where med_card.docr_id = ?";

	private SQLQuery() {
		// empty
	}
}
