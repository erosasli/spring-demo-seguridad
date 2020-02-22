package com.springsecurity.demo.config;

import javax.servlet.ServletRegistration;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Representa el xml de configuracion
 * @author erosas
 *
 */
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { DemoAppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	 @Override
	  protected FrameworkServlet createDispatcherServlet (WebApplicationContext wac) {
	      DispatcherServlet ds = new DispatcherServlet(wac);
	      //setting this flag to true will throw NoHandlerFoundException instead of 404 page
	      ds.setThrowExceptionIfNoHandlerFound(true);
	      return ds;
	 }
}






