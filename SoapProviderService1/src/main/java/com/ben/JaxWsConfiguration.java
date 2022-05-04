package com.ben;

import javax.xml.ws.Endpoint;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ben.service.ValoAgentServiceImpl;

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
	
	
	@Bean
	public ValoAgentServiceImpl valoAgentServiceImple() {
		return new ValoAgentServiceImpl();
	}
	
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), valoAgentServiceImple());
		/*
		 * expose endpoint with address
		 */
		endpoint.publish("/valoagent-service");
		return endpoint;
	}
	
	

}
