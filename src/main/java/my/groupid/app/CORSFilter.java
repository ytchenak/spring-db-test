package my.groupid.app;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter {

	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletResponse response = (HttpServletResponse) res;
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type, server-name, user-id"); 		

		
		response.addHeader("Cache-Control", "no-cache, no-store"); 		
		chain.doFilter(req, res);	
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}
	
	
	@Override
	public void destroy() {}

}
