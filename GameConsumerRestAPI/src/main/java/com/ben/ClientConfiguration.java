package com.ben;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import com.ben.service.ValoAgentService;
/**
 * this file allows the soap service to act like a rest api when implementing methods for requests to the soap api through
 * this rest consumer api. 
 * Allows GetMapping, PostMapping, DeleteMapping, PutMapping to the soap service because of this file.
 * Without this file ValoAgentController.java, and the ValoAgentService.java would not be able to work.
 * @author benor
 *
 */
@Configuration
public class ClientConfiguration {
	
	/*
	 * this bean is how soap service talks to this rest consumer service
	 */
	@Bean
	public JaxWsPortProxyFactoryBean serviceProxy() {
		JaxWsPortProxyFactoryBean proxyFactory = new JaxWsPortProxyFactoryBean();
		
		try {
			proxyFactory.setWsdlDocumentUrl(new URL("http://localhost:8081/soap-service/valoagent-service?wsdl"));
			proxyFactory.setServiceInterface(ValoAgentService.class);
			
			proxyFactory.setServiceName("ValoAgentServiceImplService");
			proxyFactory.setPortName("ValoAgentServiceImplPort");
			proxyFactory.setNamespaceUri("http://service.ben.com/");
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
		return proxyFactory;
	}
	
	
	
	


}
