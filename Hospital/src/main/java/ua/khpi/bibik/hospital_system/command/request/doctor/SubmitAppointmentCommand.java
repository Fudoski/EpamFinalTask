package ua.khpi.bibik.hospital_system.command.request.doctor;

import java.io.IOException;

import javax.servlet.ServletException;

import ua.khpi.bibik.hospital_system.command.exception.CommandException;
import ua.khpi.bibik.hospital_system.command.request.RequestCommand;
import ua.khpi.bibik.hospital_system.controller.UserController;
import ua.khpi.bibik.hospital_system.page.constant.Attribute;
import ua.khpi.bibik.hospital_system.page.constant.Redirect;

public class SubmitAppointmentCommand extends RequestCommand {
	@Override
	public void execute() throws CommandException, ServletException, IOException {
		String userType = getUserType(request);
		UserController controller = getController(userType);
		if (!Attribute.USER_TYPE_DOCTOR.equals(userType)) {
			response.sendRedirect(Redirect.getUrl(request, Redirect.HOME));
			return;
		}
		request.setAttribute(Attribute.CONTROLL_PROCESS, Attribute.CONTROLL_PROCESS_SUBMIT );
		String jsp = controller.process(request, response);
		if (jsp == null) {
			response.sendRedirect(Redirect.getUrl(request, Redirect.HOME));
		}else {
			forward(jsp);	
		}
	}
}
