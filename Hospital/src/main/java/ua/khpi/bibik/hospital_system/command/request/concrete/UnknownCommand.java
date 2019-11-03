package ua.khpi.bibik.hospital_system.command.request.concrete;

import java.io.IOException;

import javax.servlet.ServletException;

import ua.khpi.bibik.hospital_system.command.exception.CommandException;
import ua.khpi.bibik.hospital_system.command.request.RequestCommand;

public class UnknownCommand extends RequestCommand {

	@Override
	public void execute() throws CommandException, ServletException, IOException {
		response.getWriter().append("Whoops, error page!");
	}

}
