package ua.khpi.bibik.hospital_system.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.khpi.bibik.hospital_system.entity.user.User;
import ua.khpi.bibik.hospital_system.page.constant.Attribute;
import ua.khpi.bibik.hospital_system.page.constant.Redirect;

public class UserFilter extends AbstractFilter {
	HttpServletRequest req;
	HttpServletResponse res;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		req = (HttpServletRequest) request;
		res = (HttpServletResponse) response;
		
		if (isStyleResourceRequest()) {
			chain.doFilter(request, response);
			return;
		}
		
		boolean loginOrRoot = isRootOrLoginPage();
		boolean userExists = isUserExists();
		String url = Redirect.getUrl(req, Redirect.ROOT);
		
		if (userExists && loginOrRoot) {
			res.sendRedirect(Redirect.getUrl(req, Redirect.HOME));
		} else if (userExists | loginOrRoot) {
			chain.doFilter(request, response);
		}else {
			res.sendRedirect(url);
		}
	}

	private boolean isUserExists() {
		boolean exists = false;

		HttpSession httpSession = req.getSession(false);

		if (httpSession != null) {
			User user = (User) httpSession.getAttribute(Attribute.USER);
			exists = user != null;
		}

		return exists;
	}

	private boolean isRootOrLoginPage() {
		String requestURI = req.getRequestURI();
		
		String rootUrl = Redirect.getUrl(req, Redirect.ROOT);
		String loginUrl = Redirect.getUrl(req, "/login");
		
		return requestURI.equals(rootUrl) | requestURI.equals(loginUrl);

	}
	
	private boolean isStyleResourceRequest() {
		String resourceURI = req.getRequestURI().replace(req.getContextPath(), "");
		return resourceURI.startsWith("/resource/");
	}

}
