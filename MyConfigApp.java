package com.qsp.task_management_project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration

@ComponentScan(basePackages = "com.qsp.task_management_project")
public class MyConfigApp {
    
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		
		return vr;
	}
	
	
}
