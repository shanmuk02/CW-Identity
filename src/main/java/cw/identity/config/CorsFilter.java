package cw.identity.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import cw.identity.data.dao.SessionDAO;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {
	
	@Autowired SessionDAO sessionDao;
	@Value("#{new Integer('${session.maxInteractiveTime}')}")
	private int maxInteractiveTime;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        
		httpResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		httpResponse.setHeader("Access-Control-Max-Age", "4800");
		httpResponse.setHeader("Access-Control-Allow-Headers", "authorization,Content-Type, Accept, X-Requested-With, remember-me");
		
		//Code added by Pranav
		String applicationId = httpRequest.getHeader("applicationId") != null ? httpRequest.getHeader("applicationId").toString() : "";
		CWIdentity.setSessionMaxInteractiveTime(maxInteractiveTime);
		CWIdentity.setSessionDao(sessionDao);
		CWIdentity.setApplicationId(applicationId);
	    //Code end by Pranav
		
		if("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
			httpResponse.setStatus(HttpServletResponse.SC_OK);
		}else {
			chain.doFilter(request, response);
		}
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	
	}
	
	@Override
	public void destroy() {
		
	}
} 