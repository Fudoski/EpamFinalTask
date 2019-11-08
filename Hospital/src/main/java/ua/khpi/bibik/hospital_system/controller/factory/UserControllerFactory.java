package ua.khpi.bibik.hospital_system.controller.factory;

import java.util.HashMap;
import java.util.Map;

import ua.khpi.bibik.hospital_system.controller.AdminUserController;
import ua.khpi.bibik.hospital_system.controller.UserController;
import ua.khpi.bibik.hospital_system.entity.user.Administrator;
import ua.khpi.bibik.hospital_system.entity.user.User;

public class UserControllerFactory {
	
	private Map<Class<? extends User>, UserController> controllers;
	
	private UserControllerFactory() {
		controllers = new HashMap<Class<? extends User>, UserController>();
		controllers.put(Administrator.class, new AdminUserController());
	}
	
	private static final UserControllerFactory instanse = new UserControllerFactory(); 

	public static UserControllerFactory getInstanse() {
		return instanse;
	}
	
	
}
