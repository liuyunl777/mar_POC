package com.demo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.demo.account.AppInterceptor;
//
//@Configuration
//@EnableWebMvc
public class InterceptorConfig implements WebMvcConfigurer{

	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("works");
		registry.addInterceptor(new AppInterceptor()).addPathPatterns("/**").excludePathPatterns("/timeOut.html");		
		System.out.println("works2");
	}
	
}
