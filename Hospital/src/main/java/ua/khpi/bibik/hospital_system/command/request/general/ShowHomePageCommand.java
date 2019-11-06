package ua.khpi.bibik.hospital_system.command.request.general;

import java.io.IOException;

import javax.servlet.ServletException;

import ua.khpi.bibik.hospital_system.command.exception.CommandException;
import ua.khpi.bibik.hospital_system.command.request.RequestCommand;
import ua.khpi.bibik.hospital_system.page.constant.Page;
import ua.khpi.bibik.hospital_system.page.resource.AppConfigReader;

public class ShowHomePageCommand extends RequestCommand {

	@Override
	public void execute() throws CommandException, ServletException, IOException {
		AppConfigReader configReader = AppConfigReader.getInstance();
		String jsp = configReader.getProperty(Page.HOME);
	}
	
	

}
