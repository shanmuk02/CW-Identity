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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

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
		httpResponse.setHeader("Access-Control-Allow-Headers",
				"authorization,Content-Type, Accept, X-Requested-With, remember-me, ApplicationId, "
						+ "LocalIPAddress, PublicIPAddress, SystemInformation, Browser, BrowserVersion, TillId, deviceType, deviceUID");

		// Code added by Pranav
		String applicationId = httpRequest.getHeader("ApplicationId") != null
				? httpRequest.getHeader("ApplicationId").toString()
				: "";
		String localIPAddress = httpRequest.getHeader("LocalIPAddress") != null
				? httpRequest.getHeader("LocalIPAddress").toString()
				: "";
		String publicIPAddress = httpRequest.getHeader("PublicIPAddress") != null
				? httpRequest.getHeader("PublicIPAddress").toString()
				: "";
		String systemInformation = httpRequest.getHeader("SystemInformation") != null
				? httpRequest.getHeader("SystemInformation").toString()
				: "";
		String browser = httpRequest.getHeader("Browser") != null ? httpRequest.getHeader("Browser").toString() : "";
		String browserVersion = httpRequest.getHeader("BrowserVersion") != null
				? httpRequest.getHeader("BrowserVersion").toString()
				: "";
		String tillId = httpRequest.getHeader("TillId") != null ? httpRequest.getHeader("TillId").toString() : "";
		String deviceType = httpRequest.getHeader("deviceType") != null ? httpRequest.getHeader("deviceType").toString()
				: "";
		String deviceUID = httpRequest.getHeader("deviceUID") != null ? httpRequest.getHeader("deviceUID").toString()
				: "";

		CWIdentity.setSessionMaxInteractiveTime(maxInteractiveTime);
		CWIdentity.setApplicationId(applicationId);
		CWIdentity.setLocalIPAddress(localIPAddress);
		CWIdentity.setPublicIPAddress(publicIPAddress);
		CWIdentity.setSystemInformation(systemInformation);
		CWIdentity.setBrowser(browser);
		CWIdentity.setBrowserVersion(browserVersion);
		CWIdentity.setTillId(tillId);
		CWIdentity.setDeviceType(deviceType);
		CWIdentity.setDeviceUID(deviceUID);
		// Code end by Pranav

		if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
			httpResponse.setStatus(HttpServletResponse.SC_OK);
		} else {
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