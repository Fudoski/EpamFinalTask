package ua.khpi.bibik.hospital_system.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.khpi.bibik.hospital_system.command.exception.CommandException;
import ua.khpi.bibik.hospital_system.command.factory.CommandFactory;
import ua.khpi.bibik.hospital_system.command.request.RequestCommand;

/**
 * Servlet implementation class FrontServletController
 */
public final class FrontServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontServletController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processGetAndPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processGetAndPost(request, response);
	}

	private void processGetAndPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommandFactory commandFactory = CommandFactory.getInstanse();
		RequestCommand requestCommand = commandFactory.getCommand(request);
		requestCommand.init(getServletContext(), request, response);
		try {
			requestCommand.execute();
		} catch (CommandException e) {
			e.printStackTrace();
		}

	}

}
