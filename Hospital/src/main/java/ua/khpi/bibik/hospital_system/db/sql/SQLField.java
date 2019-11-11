package ua.khpi.bibik.hospital_system.db.sql;

public final class SQLField {

	public static final String USER_ID = "id";
	public static final String USER_LOGIN = "login";
	public static final String USER_PASSWORD = "password";
	public static final String USER_NAME = "name";
	public static final String USER_SURNAME = "sname";
	public static final String USER_MIDDLENAME = "mname";
	public static final String USER_PHONE_NUM = "phone_num";

	public static final String USER_TYPE = "type";

	public static final String DOCTOR_SPEC = "spec";
	public static final String DOCTOR_SPEC_ID = "id";
	public static final String DOCTOR_SPEC_NAME = "name";
	public static final String DOCTOR_PATIENTS = "patients";
	public static final String USER_DOB = "dob";
	public static final String MED_CARD_ID = "mc_id";
	public static final String MED_CARD_DOC_ID = "docr_id";

	public static final String APPOINTMENT_ID = "id";
	public static final String APPOINTMENT_DOC_ID = "doc_id";
	public static final String APPOINTMENT_MC_ID = "mc_id";
	public static final String APPOINTMENT_MEDLIST_ID = "ml_id";
	public static final String APPOINTMENT_PROCLIST_ID = "pl_id";
	public static final String APPOINTMENT_OPERATION_ID = "op_id";
	public static final String APPOINTMENT_DATE = "ap_dt";
	public static final String MEDICINE_ID = "id";
	public static final String MEDICINE_DESCRIPTION = "text";
	public static final String MEDICINE_MED_STAFF_ID = "med_staff_u_id";
	public static final String PROCEDURE_MED_STAFF_ID = "ms_id";
	public static final String PROC_ID = "id";
	public static final String PROC_DESCRIPTION = "description";
	public static final String OPERATION_DESCRIPTION = "description";
	public static final String OPERATION_ID = "id";
	public static final String OPERATION_STAR_DT = "op_dt_start";
	public static final String OPERATION_ENT_DT = "op_dt_end";
	public static final String OPERATION_DOC_ID = "doc_id";
	public static final String APPOINTMENT_DIAGNOSIS = "diagnosis";
	public static final String MED_CARD_ONLY_ID = "id";
	public static final String VIEW_MODEL_PATIEN_ID = "p_id";
	public static final String VIEW_MODEL_DOC_ID = "doc_id";
	public static final String VIEW_MODEL_DESCRIPTION = "desc";
	public static final String VIEW_MODEL_APPOINTMENT_ID = "id";

	private SQLField() {
		// empty
	}

}
