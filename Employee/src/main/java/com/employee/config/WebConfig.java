package com.employee.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * 
 * @author Vivekananda Murthy
 * 
 *         WebConfig is a MVC configuration.Any request from "/" triggers the
 *         DispatcherServlet
 *
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.employee")
public class WebConfig extends WebMvcConfigurerAdapter {
}
