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

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String url = Redirect.getUrl(req, Redirect.ROOT);
		if (isUserExists(req) | isRootOrLoginPage(req)) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			httpServletResponse.sendRedirect(url);
		}
	}

	private boolean isUserExists(HttpServletRequest request) {
		boolean exists = false;

		HttpSession httpSession = request.getSession(false);

		if (httpSession != null) {
			User user = (User) httpSession.getAttribute(Attribute.USER);
			exists = user != null;
		}

		return exists;
	}

	private boolean isRootOrLoginPage(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		
		String rootUrl = Redirect.getUrl(request, Redirect.ROOT);
		String loginUrl = Redirect.getUrl(request, "/login");
		
		return requestURI.equals(rootUrl) | requestURI.equals(loginUrl);

	}

}
