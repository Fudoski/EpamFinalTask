package ua.khpi.bibik.hospital_system.page.resource;

import java.util.ResourceBundle;

/**
 * @author Lafan
 *
 */
public class AppConfigReader {

	private static final String RESOURCE = "configuration.appConfig";
	private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE);

	private static AppConfigReader instance = new AppConfigReader();

	private AppConfigReader() {
		// empty
	}

	public static AppConfigReader getInstance() {
		return instance;
	}

	public String getProperty(String key) {
		return resourceBundle.getString(key);
	}

}
