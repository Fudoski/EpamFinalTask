package ua.khpi.bibik.hospital_system.entity.model;

public class ProcedureDataModel {
	private int procID;
	private String procDesc;
	
	private int doctorID;
	private String docName;
	private String docSname;
	private String docMname;
	

	private int patientID;
	private String pName;
	private String pSname;
	private String pMname;
	
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public int getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	public String getProcDesc() {
		return procDesc;
	}
	public void setProcDesc(String procDesc) {
		this.procDesc = procDesc;
	}
	public int getProcID() {
		return procID;
	}
	public void setProcID(int procID) {
		this.procID = procID;
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
