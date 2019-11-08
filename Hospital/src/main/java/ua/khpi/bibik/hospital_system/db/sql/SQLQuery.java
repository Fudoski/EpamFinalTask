package ua.khpi.bibik.hospital_system.db.sql;

public final class SQLQuery {
	public static final String SELECT_USER_BY_LOGIN = "SELECT * FROM user_view WHERE login = ?";
	public static final String SELECT_ALL_DOCTORS = "SELECT * FROM doc_view";

	private SQLQuery() {
		// empty
	}
}
