package com.employee.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * 
 * @author Vivekananda Murthy
 * 
 * DispatcherServlet configuration for Controller defined in WebConfig.class 
 * 
 * Any request from "/" triggers the DispatcherServlet 
 *
 */

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	protected Class<?>[] getServletConfigClasses() {
		return new Class[0];
	}

	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}
