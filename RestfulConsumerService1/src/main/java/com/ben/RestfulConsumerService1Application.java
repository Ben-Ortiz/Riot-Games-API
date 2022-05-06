package com.ben;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.ben.model.ValoAgent;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ben.service"})
public class RestfulConsumerService1Application {

	public static void main(String[] args) {
		SpringApplication.run(RestfulConsumerService1Application.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public RestTemplate restTemplateXML() {
		final String BASE_URL = "http://localhost:8081/soap-service";
		DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(BASE_URL);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setUriTemplateHandler(uriBuilderFactory);
		return restTemplate;
	}
	
	@Bean
	public JaxWsPortProxyFactoryBean serviceProxy() {
		JaxWsPortProxyFactoryBean proxyFactory = new JaxWsPortProxyFactoryBean();
		
		try {
			proxyFactory.setWsdlDocumentUrl(new URL("http://localhost:8081/soap-service/valoagent-service?wsdl"));
			proxyFactory.setServiceInterface(ValoAgent.class);
			
			proxyFactory.setServiceName("ValoAgentServiceImpl");
			proxyFactory.setPortName("orderPort");
			proxyFactory.setNamespaceUri("http://service.revature.com/");
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
		return proxyFactory;
	}
	
	
	

}
