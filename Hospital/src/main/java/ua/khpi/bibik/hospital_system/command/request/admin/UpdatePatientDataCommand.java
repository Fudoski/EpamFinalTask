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

public class UpdatePatientDataCommand extends RequestCommand {
	
	@Override
	public void execute() throws CommandException, ServletException, IOException {
		String userType = getUserType(request);
		UserController controller = getController(userType);
		if (!Attribute.USER_TYPE_ADMIN.equals(userType)) {
			response.sendRedirect(Redirect.getUrl(request, Redirect.HOME));
			return;
		}
		User user = null;
		String url = null;
		String updateUserType = request.getParameter(Parameter.CREATE_USER_TYPE);
		if (updateUserType.equals(Attribute.USER_TYPE_DOCTOR)) {
			user = RequestObjectHelper.getDoctor(request);
			url = Redirect.getUrl(request, Redirect.HOME);
		}
		if (updateUserType.equals(Attribute.USER_TYPE_PATIENT)) {
			user = RequestObjectHelper.getPatient(request);
			url = Redirect.getUrl(request, Redirect.PATIENTS);
		}
		

		request.setAttribute(Attribute.USER, user);
		request.setAttribute(Attribute.CONTROLL_PROCESS, Attribute.CONTROLL_PROCESS_DATA_UPDATE);
		request.setAttribute(Attribute.USER_TYPE, Attribute.USER_TYPE_PATIENT);
		String jsp = controller.process(request, response);
		if (jsp == null) {
			response.sendRedirect(Redirect.getUrl(request, Redirect.HOME));
		} else {
			forward(jsp);
		}
	}
}
