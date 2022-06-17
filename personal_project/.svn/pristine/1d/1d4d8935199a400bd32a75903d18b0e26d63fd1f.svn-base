package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;

@WebFilter("/*")
public class CharsetFilter implements Filter{
	private String charset = "utf-8";
	private FilterConfig fc;
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		fc = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		req.setCharacterEncoding(charset);
		
		req.setAttribute("cp", req.getServletContext().getContextPath() + "/");
		
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
