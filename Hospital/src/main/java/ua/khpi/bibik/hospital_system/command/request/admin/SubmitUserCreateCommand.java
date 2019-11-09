package ua.khpi.bibik.hospital_system.command.request.admin;

import java.io.IOException;

import javax.servlet.ServletException;

import ua.khpi.bibik.hospital_system.command.exception.CommandException;
import ua.khpi.bibik.hospital_system.command.request.RequestCommand;
import ua.khpi.bibik.hospital_system.controller.UserController;
import ua.khpi.bibik.hospital_system.entity.user.Doctor;
import ua.khpi.bibik.hospital_system.hash.HashConverter;
import ua.khpi.bibik.hospital_system.page.constant.Attribute;
import ua.khpi.bibik.hospital_system.page.constant.Parameter;
import ua.khpi.bibik.hospital_system.page.constant.Redirect;

public class SubmitUserCreateCommand extends RequestCommand {
	
	@Override
	public void execute() throws CommandException, ServletException, IOException {
		Doctor doctor = getDoctor();
		
		String userType = getUserType(request);
		UserController controller = getController(userType);
		
		request.setAttribute(Attribute.USER, doctor);
		request.setAttribute(Attribute.CONTROLL_PROCESS, Attribute.CONTROLL_PROCESS_SUBMIT);
		controller.process(request, response);
		
		response.sendRedirect(Redirect.getUrl(request, Redirect.HOME));
	}

	private Doctor getDoctor() {
		Doctor doctor = new Doctor();
		String login = request.getParameter(Parameter.LOGIN);
		String password = request.getParameter(Parameter.PASSWORD);
		String name = request.getParameter(Parameter.NAME);
		String surname = request.getParameter(Parameter.SURNAME);
		String middlename = request.getParameter(Parameter.MIDDLENAME);
		String birthday = request.getParameter(Parameter.BIRTHDAY);
		String phone = request.getParameter(Parameter.PHONE);
		int specID = Integer.parseInt(request.getParameter(Parameter.DOCTOR_SPEC));
		
		doctor.setName(name);
		doctor.setSname(surname);
		doctor.setMname(middlename);
		doctor.setDob(birthday);
		doctor.setLogin(login);
		doctor.setPassword(HashConverter.sha256(password));
		doctor.getDoctorSpecialisation().setId(specID);
		doctor.setPhoneNum(phone);
		
		return doctor;
	}

}
