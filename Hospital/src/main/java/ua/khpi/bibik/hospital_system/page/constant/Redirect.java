package ua.khpi.bibik.hospital_system.page.constant;

import javax.servlet.http.HttpServletRequest;

public final class Redirect {
	
	public static final String ROOT = "/";
	public static final String HOME = "/home";
	public static final String PATIENTS = "/patients";
	
	public static String getUrl(HttpServletRequest request,String redirectConstant) {
		return request.getContextPath() + redirectConstant;
	}

}
