package ua.khpi.bibik.hospital_system.command.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.khpi.bibik.hospital_system.command.Command;
import ua.khpi.bibik.hospital_system.command.exception.CommandException;
import ua.khpi.bibik.hospital_system.command.exception.CommandNotImplimentedException;
import ua.khpi.bibik.hospital_system.command.exception.CommandNotInitializedException;

public class RequestCommand implements Command {

	protected ServletContext context;
	protected HttpServletRequest request;
	protected HttpServletResponse response;

	private boolean inited;

	public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
		this.context = context;
		this.request = request;
		this.response = response;
		inited = true;
	}

	@Override
	public void execute() throws CommandException, ServletException, IOException {
		throw new CommandNotImplimentedException("Command \"" + getClass().getName() + "\" not implimented");

	}

	protected void include(String target) throws ServletException, IOException, CommandException {
		check();
		getDispatcher(target).include(request, response);
	}

	protected void forward(String target) throws ServletException, IOException, CommandException {
		check();
		getDispatcher(target).forward(request, response);
	}

	private RequestDispatcher getDispatcher(String target) {
		return request.getRequestDispatcher(target);
	}

	private void check() throws CommandNotInitializedException {
		if (!inited) {
			throw new CommandNotInitializedException(
					"Command must be initialized before use forward or include methods");
		}
	}
}
