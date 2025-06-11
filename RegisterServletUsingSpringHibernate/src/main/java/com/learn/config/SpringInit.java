package com.learn.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

public class SpringInit implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();

		applicationContext.register(WebAppConfig.class);

		servletContext.addServlet("dispatcher", new DispatcherServlet(applicationContext)).addMapping("/");
	}

}
