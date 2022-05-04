package com.ben;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JaxWsConfiguration {
	
	/*
	 * This bean name is "cxfServlet" if only @Bean annotation used without (name = "bob")
	 * has to be in container
	 */
	@Bean
	public ServletRegistrationBean<CXFServlet> cxfServlet() {
		return new ServletRegistrationBean<CXFServlet>(new CXFServlet(), "/soap-service/*");
	}
	
	/*
	 * This bean MUST be named cxf
	 * has to be in container
	 */
	@Bean(name = "cxf")
	public SpringBus springBus() {
		return new SpringBus();
	}
	
	
	
	

}
