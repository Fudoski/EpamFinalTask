package ua.khpi.bibik.hospital_system.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public final class EncodingFilter extends AbstractFilter implements Filter {

	private static final String FILTERABLE_CONTENT_TYPE = "application/x-www-form-urlencoded";

	private static final String ENCODING_DEFAULT = "UTF-8";

	private static final String ENCODING_INIT_PARAM_NAME = "encoding";

	private String encoding;

	/**
	 * Default constructor.
	 */
	public EncodingFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String contentType = request.getContentType();
		if (contentType != null && contentType.startsWith(FILTERABLE_CONTENT_TYPE)) {
			request.setCharacterEncoding(encoding);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter(ENCODING_INIT_PARAM_NAME);
		if (encoding == null)
			encoding = ENCODING_DEFAULT;
	}

}
