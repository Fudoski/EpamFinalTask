package ua.khpi.bibik.hospital_system.command.request.general;

import java.io.IOException;

import javax.servlet.ServletException;

import ua.khpi.bibik.hospital_system.command.exception.CommandException;
import ua.khpi.bibik.hospital_system.command.request.RequestCommand;
import ua.khpi.bibik.hospital_system.controller.UserController;

public class ShowHomePageCommand extends RequestCommand {

	@Override
	public void execute() throws CommandException, ServletException, IOException {
		String userType = getUserType(request);
		UserController controller = getController(userType);
		
		String jsp = controller.process(request, response);
		forward(jsp);
		
	}
}
