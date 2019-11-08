package ua.khpi.bibik.hospital_system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.khpi.bibik.hospital_system.page.constant.Page;
import ua.khpi.bibik.hospital_system.page.resource.AppConfigReader;
import ua.khpi.bibik.hospital_system.service.AdministratorService;

public class AdminUserController implements UserController {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		AppConfigReader configReader = AppConfigReader.getInstance();
		AdministratorService service = new AdministratorService();
		
		
		return configReader.getProperty(Page.ADMIN);
	}
}
