package com.demo.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.handler.Handler;

import org.springframework.web.servlet.HandlerInterceptor;

public class AppInterceptor implements HandlerInterceptor{
	

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("passing interceptor.....");
		
		if(request.getSession()==null||request.getSession().getAttribute("user")==null) {
			System.out.println("taken out by interceptor!");
			response.sendRedirect("/MyEducation/timeOut.html");
			return false;
		}
		return true;
		
	}
}
