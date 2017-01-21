package com.project.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.Registration;

public class LoggingWebInterceptor implements HandlerInterceptor {

	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        Registration registration = (Registration) request.getSession().getAttribute("registration");
	        if (registration == null || registration.equals("")) {
	            response.sendRedirect("login");
	            return false;
	        }
	        return true;
	 }
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--------------between  method executed-------------------");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		  System.out.println("-------------Request Completed------------------------");
		
	}

	
	
	
}
