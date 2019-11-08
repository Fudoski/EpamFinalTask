package ua.khpi.bibik.hospital_system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.khpi.bibik.hospital_system.entity.user.Doctor;
import ua.khpi.bibik.hospital_system.page.constant.Attribute;
import ua.khpi.bibik.hospital_system.page.constant.Page;
import ua.khpi.bibik.hospital_system.page.resource.AppConfigReader;
import ua.khpi.bibik.hospital_system.service.AdministratorService;

public class AdminUserController implements UserController {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		AppConfigReader configReader = AppConfigReader.getInstance();
		AdministratorService service = new AdministratorService();
		List<Doctor> doctors = service.getAllDoctors();
		request.setAttribute(Attribute.DOCTOR_LIST, doctors);
		
		return configReader.getProperty(Page.ADMIN);
	}
}
