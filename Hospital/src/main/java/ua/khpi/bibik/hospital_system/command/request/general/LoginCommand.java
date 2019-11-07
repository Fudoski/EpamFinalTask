package ua.khpi.bibik.hospital_system.command.request.general;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import ua.khpi.bibik.hospital_system.command.exception.CommandException;
import ua.khpi.bibik.hospital_system.command.request.RequestCommand;
import ua.khpi.bibik.hospital_system.entity.user.User;
import ua.khpi.bibik.hospital_system.entity.user.UserType;
import ua.khpi.bibik.hospital_system.hash.HashConverter;
import ua.khpi.bibik.hospital_system.page.constant.Attribute;
import ua.khpi.bibik.hospital_system.page.constant.Parameter;
import ua.khpi.bibik.hospital_system.page.constant.Redirect;
import ua.khpi.bibik.hospital_system.service.UserService;

public class LoginCommand extends RequestCommand {

	String login;
	String password;
	User user;

	@Override
	public void execute() throws CommandException, ServletException, IOException {
		login = request.getParameter(Parameter.LOGIN);
		password = request.getParameter(Parameter.PASSWORD);

		user = UserService.getUserByLogin(login);

		if (user != null && user.getId() != 0) {
			String passwordHash = HashConverter.sha256(password);

			if (passwordHash.equals(user.getPassword())) {
				checkUserPrivileges();
			}
		} else {
			response.sendRedirect(Redirect.getUrl(request, Redirect.ROOT));
		}
	}

	private void checkUserPrivileges() throws ServletException, IOException, CommandException {

		int type = UserService.getUserType(user);
		UserType userType = UserType.getType(type);

		HttpSession session = request.getSession();
		session.setAttribute(Attribute.USER, user);
		switch (userType) {
		case ADMIN:
			session.setAttribute(Attribute.USER_TYPE, Attribute.USER_TYPE_ADMIN);
			break;
		case DOCTOR:
			session.setAttribute(Attribute.USER_TYPE, Attribute.USER_TYPE_DOCTOR);
			break;
		case PATIENT:
			session.setAttribute(Attribute.USER_TYPE, Attribute.USER_TYPE_PATIENT);
			break;
		}

		String url = Redirect.getUrl(request, Redirect.HOME);
		response.sendRedirect(url);

	}

}
