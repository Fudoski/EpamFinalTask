package ua.khpi.bibik.hospital_system.command.request;

import java.io.IOException;

import javax.servlet.ServletException;

import ua.khpi.bibik.hospital_system.command.exception.CommandException;

public class UnknownCommand extends RequestCommand {

	@Override
	public void execute() throws CommandException, ServletException, IOException {
		response.getWriter().append("Whoops, error page!");
	}

}
