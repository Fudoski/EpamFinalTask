package ua.khpi.bibik.hospital_system.command.factory;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.khpi.bibik.hospital_system.command.request.RequestCommand;
import ua.khpi.bibik.hospital_system.command.request.UnknownCommand;
import ua.khpi.bibik.hospital_system.command.request.general.LogOutCommand;
import ua.khpi.bibik.hospital_system.command.request.general.LoginCommand;
import ua.khpi.bibik.hospital_system.command.request.general.ShowHomePageCommand;

public class CommandFactory {
	
	private static CommandFactory instanse;

	private Map<String, RequestCommand> commands;

	private CommandFactory() {
		commands = new HashMap<String, RequestCommand>();
		commands.put("POST/login", new LoginCommand());
		commands.put("POST/logout", new LogOutCommand());
		commands.put("GET/home", new ShowHomePageCommand());
	}

	public static CommandFactory getInstanse() {
		if (instanse == null) {
			instanse = new CommandFactory();
			
		}
		return instanse;
	}

	public RequestCommand getCommand(HttpServletRequest request) {
		String pathInfo = request.getRequestURI().replaceAll(request.getContextPath(), "");
		RequestCommand command = commands.get(request.getMethod() + (pathInfo == null ? "" : pathInfo));
		return (command != null ? command : new UnknownCommand());
	}

}
