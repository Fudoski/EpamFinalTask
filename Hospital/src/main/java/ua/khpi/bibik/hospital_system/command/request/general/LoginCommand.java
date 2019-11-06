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

	@Override
	public void execute() throws CommandException, ServletException, IOException {
		String login = request.getParameter(Parameter.LOGIN);
		String password = request.getParameter(Parameter.PASSWORD);

		User user = UserService.getUserByLogin(login);

		if (user.getId() != 0) {
			String passwordHash = HashConverter.sha256(password);

			if (passwordHash.equals(user.getPassword())) {
				checkUserPrivileges(user);
			} else {
				response.sendRedirect("/");
			}
		}

	}

	private void checkUserPrivileges(User user) throws ServletException, IOException, CommandException {

		int type = UserService.getUserType(user);
		UserType userType = UserType.getType(type);

		HttpSession session = request.getSession();
		session.setAttribute(Attribute.USER, user);
		switch (userType) {
		case ADMIN:
			session.setAttribute(Attribute.USER_TYPE, user.toString());
			break;
		}
		
		String url = Redirect.getUrl(request, Redirect.HOME);
		response.sendRedirect(url);

	}

}
