package ua.khpi.bibik.hospital_system.command.request.general;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.khpi.bibik.hospital_system.command.exception.CommandException;
import ua.khpi.bibik.hospital_system.command.request.RequestCommand;
import ua.khpi.bibik.hospital_system.page.constant.Attribute;
import ua.khpi.bibik.hospital_system.page.constant.Page;
import ua.khpi.bibik.hospital_system.page.resource.AppConfigReader;

public class ShowHomePageCommand extends RequestCommand {

	@Override
	public void execute() throws CommandException, ServletException, IOException {
		AppConfigReader configReader = AppConfigReader.getInstance();
		String jsp = null;
		
		String userType = getUserType(request);
		
		switch(userType) {
		
		case Attribute.USER_TYPE_ADMIN:
			jsp = configReader.getProperty(Page.ADMIN);
			break;
		case Attribute.USER_TYPE_DOCTOR:
			jsp = configReader.getProperty(Page.DOCTOR);
			break;
		case Attribute.USER_TYPE_PATIENT:
			jsp = configReader.getProperty(Page.PATIENT);
			break;
		}
		
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
