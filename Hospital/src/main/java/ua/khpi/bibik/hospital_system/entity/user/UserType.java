package ua.khpi.bibik.hospital_system.entity.user;

public enum UserType {
	ADMIN, DOCTOR, PATIENT;

	public static UserType getType(int typeID) {
		return UserType.values()[typeID - 1];
	}

}
