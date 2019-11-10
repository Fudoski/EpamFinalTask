package ua.khpi.bibik.hospital_system.jsp.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import ua.khpi.bibik.hospital_system.entity.user.Doctor;

public class UserNameFormat extends SimpleTagSupport {

	private Doctor doctor;

	@Override
	public void doTag() throws JspException, IOException {
		JspContext context = getJspContext();
		JspWriter out = context.getOut();
		if (doctor!= null) {
			String formatName = String.format("%s %s.%s.", doctor.getSname(), doctor.getName().subSequence(0, 1),
					doctor.getMname().subSequence(0, 1));
			out.append(formatName);
		}
		super.doTag();
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
