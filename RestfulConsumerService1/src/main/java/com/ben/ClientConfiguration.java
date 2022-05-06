package com.ben;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import com.ben.model.ValoAgent;

@Configuration
public class ClientConfiguration {
	
	@Bean
	public JaxWsPortProxyFactoryBean serviceProxy() {
		JaxWsPortProxyFactoryBean proxyFactory = new JaxWsPortProxyFactoryBean();
		
		try {
			proxyFactory.setWsdlDocumentUrl(new URL("http://localhost:8081/soap-service/valoagent-service?wsdl"));
			proxyFactory.setServiceInterface(ValoAgent.class);
			
			proxyFactory.setServiceName("ValoAgentServiceImpl");
			proxyFactory.setPortName("ValoAgentServiceImplPort");
			proxyFactory.setNamespaceUri("http://service.ben.com/");
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
		return proxyFactory;
	}
	
	


}
