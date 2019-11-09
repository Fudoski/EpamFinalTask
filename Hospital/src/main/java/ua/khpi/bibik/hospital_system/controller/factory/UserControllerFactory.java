package ua.khpi.bibik.hospital_system.controller.factory;

import java.util.HashMap;
import java.util.Map;

import ua.khpi.bibik.hospital_system.controller.AdminUserController;
import ua.khpi.bibik.hospital_system.controller.DoctorUserController;
import ua.khpi.bibik.hospital_system.controller.UserController;
import ua.khpi.bibik.hospital_system.page.constant.Attribute;

public class UserControllerFactory {
	
	private Map<String, UserController> controllers;
	
	private UserControllerFactory() {
		controllers = new HashMap<String, UserController>();
		controllers.put(Attribute.USER_TYPE_ADMIN, new AdminUserController());
		controllers.put(Attribute.USER_TYPE_DOCTOR, new DoctorUserController());
	}
	
	private static final UserControllerFactory instanse = new UserControllerFactory(); 

	public static UserControllerFactory getInstanse() {
		return instanse;
	}

	public UserController getController(String userType) {
		return controllers.get(userType);
	}
	
	
}
