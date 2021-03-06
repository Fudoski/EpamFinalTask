package ua.khpi.bibik.hospital_system.command.request.admin;

import java.io.IOException;

import javax.servlet.ServletException;

import ua.khpi.bibik.hospital_system.command.exception.CommandException;
import ua.khpi.bibik.hospital_system.command.request.RequestCommand;
import ua.khpi.bibik.hospital_system.controller.UserController;
import ua.khpi.bibik.hospital_system.entity.user.User;
import ua.khpi.bibik.hospital_system.page.constant.Attribute;
import ua.khpi.bibik.hospital_system.page.constant.Parameter;
import ua.khpi.bibik.hospital_system.page.constant.Redirect;
import ua.khpi.bibik.hospital_system.utils.RequestObjectHelper;

public class SubmitUserCreateCommand extends RequestCommand {
	
	@Override
	public void execute() throws CommandException, ServletException, IOException {
		
		User user = null;
		String url = null;
		String userType = getUserType(request);
		String createUserType = request.getParameter(Parameter.CREATE_USER_TYPE);
		UserController controller = getController(userType);
		if (createUserType.equals(Attribute.USER_TYPE_DOCTOR)) {
			user = RequestObjectHelper.getDoctor(request);
			url = Redirect.getUrl(request, Redirect.HOME);
		}
		if (createUserType.equals(Attribute.USER_TYPE_PATIENT)) {
			user = RequestObjectHelper.getPatient(request);
			url = Redirect.getUrl(request, Redirect.PATIENTS);
		}
		
		request.setAttribute(Attribute.USER, user);
		request.setAttribute(Attribute.CONTROLL_PROCESS, Attribute.CONTROLL_PROCESS_SUBMIT);
		controller.process(request, response);
		
		response.sendRedirect(url);
	}

}
