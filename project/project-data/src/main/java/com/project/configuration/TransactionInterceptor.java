/*package com.project.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.project.model.Registration;

public class TransactionInterceptor extends HandlerInterceptorAdapter {

	
	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        Registration registration = (Registration) request.getSession().getAttribute("registration");
	        if (registration == null || registration.equals("")) {
	            response.sendRedirect("login");
	            return false;
	        }
	        return true;
	    }
	
	
}
*/