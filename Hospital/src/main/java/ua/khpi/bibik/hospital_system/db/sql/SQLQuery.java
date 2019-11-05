package ua.khpi.bibik.hospital_system.db.sql;

public final class SQLQuery {
	public static final String SELECT_USER_BY_LOGIN = "SELECT * FROM user WHERE login = ?";
	public static final String SELECT_USER_TYPE = "SELECT * FROM user_x_type WHERE User_id = ?";

	private SQLQuery() {
		// empty
	}
}
