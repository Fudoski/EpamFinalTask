package ua.khpi.bibik.hospital_system.command.request.admin;

import java.io.IOException;

import javax.servlet.ServletException;

import ua.khpi.bibik.hospital_system.command.exception.CommandException;
import ua.khpi.bibik.hospital_system.command.request.RequestCommand;
import ua.khpi.bibik.hospital_system.controller.UserController;
import ua.khpi.bibik.hospital_system.page.constant.Attribute;
import ua.khpi.bibik.hospital_system.page.constant.Redirect;

public class CreateNewUserCommand extends RequestCommand {

	@Override
	public void execute() throws CommandException, ServletException, IOException {
		String userType = getUserType(request);
		UserController controller = getController(userType);
		
		request.setAttribute(Attribute.CONTROLL_PROCESS, Attribute.CONTROLL_PROCESS_CREATE );
		String jsp = controller.process(request, response);
		if (jsp == null) {
			response.sendRedirect(Redirect.getUrl(request, Redirect.HOME));
		}else {
			forward(jsp);	
		}
	}
	
}
