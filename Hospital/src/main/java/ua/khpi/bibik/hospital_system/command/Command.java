package ua.khpi.bibik.hospital_system.command;

import java.io.IOException;

import javax.servlet.ServletException;

import ua.khpi.bibik.hospital_system.command.exception.CommandException;

public interface Command {
	void execute() throws CommandException, ServletException, IOException;
}
