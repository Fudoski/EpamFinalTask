package ua.khpi.bibik.hospital_system.command.request.general;

import java.io.IOException;

import javax.servlet.ServletException;

import ua.khpi.bibik.hospital_system.command.exception.CommandException;
import ua.khpi.bibik.hospital_system.command.request.RequestCommand;
import ua.khpi.bibik.hospital_system.entity.user.User;
import ua.khpi.bibik.hospital_system.hash.HashConverter;
import ua.khpi.bibik.hospital_system.page.constant.Page;
import ua.khpi.bibik.hospital_system.page.constant.Parameter;
import ua.khpi.bibik.hospital_system.page.resource.AppConfigReader;
import ua.khpi.bibik.hospital_system.service.UserService;

public class LoginCommand extends RequestCommand {

	private enum USER_TYPE {

		ADMIN;

		public static USER_TYPE getType(int index) {
			return USER_TYPE.values()[index];
		}
	}

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
		USER_TYPE userType = USER_TYPE.getType(type);

		switch (userType) {
		
		case ADMIN:
			forward(AppConfigReader.getInstance().getProperty(Page.ADMIN));
			break;

		}

	}

}
