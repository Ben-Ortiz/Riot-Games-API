package com.ben;

import javax.xml.ws.Endpoint;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ben.service.ValoAgentServiceImpl;
/**
 * This file is needed to allow the soap service to be configured correctly.
 * 
 * Creates a link that can be used to check if service is working under:
 * http://localhost:8081/soap-service/
 * 
 * Creates the wsdl under the url
 * http://localhost:8081/soap-service/valoagent-service?wsdl
 * 
 * @author benor
 *
 */
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
	public ValoAgentServiceImpl valoAgentServiceImpl() {
		return new ValoAgentServiceImpl();
	}
	
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), valoAgentServiceImpl());
		/*
		 * expose endpoint with address
		 */
		endpoint.publish("/valoagent-service");
		return endpoint;
	}
	
	

}
