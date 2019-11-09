package ua.khpi.bibik.hospital_system.entity;

public class DoctorSpecialization extends Entity {
	private String name;

	public DoctorSpecialization() {
		super();
	}

	@Override
	public String toString() {
		return "DoctorSpecialization [name=" + name + ", id=" + id + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
