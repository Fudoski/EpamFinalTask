package ua.khpi.bibik.hospital_system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserController {
	
	String process(HttpServletRequest request, HttpServletResponse response);
	
}
