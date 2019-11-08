package ua.khpi.bibik.hospital_system.command.request.general;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.khpi.bibik.hospital_system.command.exception.CommandException;
import ua.khpi.bibik.hospital_system.command.request.RequestCommand;
import ua.khpi.bibik.hospital_system.controller.UserController;
import ua.khpi.bibik.hospital_system.controller.factory.UserControllerFactory;
import ua.khpi.bibik.hospital_system.entity.user.Doctor;
import ua.khpi.bibik.hospital_system.page.constant.Attribute;

public class ShowHomePageCommand extends RequestCommand {

	@Override
	public void execute() throws CommandException, ServletException, IOException {		
		String userType = getUserType(request);
		UserControllerFactory factory = UserControllerFactory.getInstanse();
		UserController controller = factory.getController(userType);
		
		String jsp = controller.process(request, response);
		forward(jsp);
		
	}
	
	private String getUserType(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String type = null;
		if (session != null) {
			type = (String) session.getAttribute(Attribute.USER_TYPE);
		}
		return type;
	}

}
