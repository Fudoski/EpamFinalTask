package ua.khpi.bibik.hospital_system.entity.model;

public class MedicineDataModel {
	private int medicineID;
	private String medicineDesc;
	
	private int doctorID;
	private String docName;
	private String docSname;
	private String docMname;
	

	private int patientID;
	private String pName;
	private String pSname;
	private String pMname;
	public int getMedicineID() {
		return medicineID;
	}
	public void setMedicineID(int medicineID) {
		this.medicineID = medicineID;
	}
	public String getMedicineDesc() {
		return medicineDesc;
	}
	public void setMedicineDesc(String medicineDesc) {
		this.medicineDesc = medicineDesc;
	}
	public int getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocSname() {
		return docSname;
	}
	public void setDocSname(String docSname) {
		this.docSname = docSname;
	}
	public String getDocMname() {
		return docMname;
	}
	public void setDocMname(String docMname) {
		this.docMname = docMname;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpSname() {
		return pSname;
	}
	public void setpSname(String pSname) {
		this.pSname = pSname;
	}
	public String getpMname() {
		return pMname;
	}
	public void setpMname(String pMname) {
		this.pMname = pMname;
	}
	
	

}
