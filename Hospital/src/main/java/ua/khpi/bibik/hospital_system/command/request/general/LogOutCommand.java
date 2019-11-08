package ua.khpi.bibik.hospital_system.command.request.general;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import ua.khpi.bibik.hospital_system.command.exception.CommandException;
import ua.khpi.bibik.hospital_system.command.request.RequestCommand;
import ua.khpi.bibik.hospital_system.page.constant.Redirect;

public class LogOutCommand extends RequestCommand {
	
	@Override
	public void execute() throws CommandException, ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			session.invalidate();
			session.setMaxInactiveInterval(0);
		}
		
		response.sendRedirect(Redirect.getUrl(request, Redirect.ROOT));
	}
}
