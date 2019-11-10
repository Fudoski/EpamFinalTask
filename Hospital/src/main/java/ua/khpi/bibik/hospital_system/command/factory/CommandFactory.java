package ua.khpi.bibik.hospital_system.command.factory;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.khpi.bibik.hospital_system.command.request.RequestCommand;
import ua.khpi.bibik.hospital_system.command.request.UnknownCommand;
import ua.khpi.bibik.hospital_system.command.request.admin.CreateNewUserCommand;
import ua.khpi.bibik.hospital_system.command.request.admin.ShowEditDoctorPageCommand;
import ua.khpi.bibik.hospital_system.command.request.admin.ShowEditPatientPageCommand;
import ua.khpi.bibik.hospital_system.command.request.admin.SubmitUserCreateCommand;
import ua.khpi.bibik.hospital_system.command.request.admin.UpdateDoctorDataCommand;
import ua.khpi.bibik.hospital_system.command.request.admin.UpdatePatientDataCommand;
import ua.khpi.bibik.hospital_system.command.request.doctor.ShowPatientInfoCommand;
import ua.khpi.bibik.hospital_system.command.request.general.LogOutCommand;
import ua.khpi.bibik.hospital_system.command.request.general.LoginCommand;
import ua.khpi.bibik.hospital_system.command.request.general.ShowHomePageCommand;
import ua.khpi.bibik.hospital_system.command.request.general.ShowPatientListCommand;

public class CommandFactory {
	
	private static CommandFactory instanse;

	public static CommandFactory getInstanse() {
		if (instanse == null) {
			instanse = new CommandFactory();
			
		}
		return instanse;
	}

	private Map<String, RequestCommand> commands;

	private CommandFactory() {
		commands = new HashMap<String, RequestCommand>();
		commands.put("POST/login", new LoginCommand());
		commands.put("POST/logout", new LogOutCommand());
		commands.put("GET/home", new ShowHomePageCommand());
		commands.put("GET/patients", new ShowPatientListCommand());
		commands.put("GET/newUser", new CreateNewUserCommand());
		commands.put("POST/newUser", new SubmitUserCreateCommand());
		commands.put("GET/doctor/info", new ShowEditDoctorPageCommand());
		commands.put("GET/patient/info", new ShowEditPatientPageCommand());
		commands.put("POST/update/doctor", new UpdateDoctorDataCommand());
		commands.put("POST/update/patient", new UpdatePatientDataCommand());
		commands.put("GET/medcard", new ShowPatientInfoCommand());
	}

	public RequestCommand getCommand(HttpServletRequest request) {
		String pathInfo = request.getRequestURI().replaceAll(request.getContextPath(), "");
		RequestCommand command = commands.get(request.getMethod() + (pathInfo == null ? "" : pathInfo));
		return (command != null ? command : new UnknownCommand());
	}

}
