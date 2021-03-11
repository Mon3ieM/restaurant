package com.restaurant.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.restaurant.utils.SessionData;

@Component
@Order(1)
public class RequestFilter implements Filter {

	@Autowired
	private SessionData sessionData;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
	

		if (!req.getRequestURI().contains("/resources") && !req.getRequestURI().contains("/LoginPage")) {
			if ((sessionData.getLoggedUser() == null || sessionData.getLoggedUser().getId() == null))
				res.sendRedirect("/LoginPage");
			else
				chain.doFilter(request, response);
		} else
			chain.doFilter(request, response);
	}

}
