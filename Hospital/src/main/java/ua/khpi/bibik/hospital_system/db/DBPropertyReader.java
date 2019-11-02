package ua.khpi.bibik.hospital_system.db;

import java.util.ResourceBundle;

public class DBPropertyReader {

	private static final String RESOURCE_PATH = "configuration.dbConfig";

	private static final DBPropertyReader INSTANSE = new DBPropertyReader();

	private ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE_PATH);

	public static DBPropertyReader getInstanse() {
		return INSTANSE;
	}

	public String getValue(String key) {
		return bundle.getString(key);
	}

}
