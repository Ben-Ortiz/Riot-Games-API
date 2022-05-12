package com.ben;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;


/**
 * This Rest Consumer API takes in the Rest API relating to League of Legends and Soap API relating to Valorant,
 * and allows the requests to also be made using this Rest Consumer API.
 * @author benor
 *
 */
@SpringBootApplication
/*	
 *  this component scan has to include com.ben.services or java.lang.IllegalArgumentException: 'serviceInterface' must be an interface error happens
 *  include com.ben.controller or rest consumer doesnt take rest provider
 *  
 *  had to remove this once I put messagecontroller.java in com.ben.soap.service
 */
//@ComponentScan(basePackages = {"com.ben.service", "com.ben.controller"}) 
public class RestfulConsumerService1Application {

	public static void main(String[] args) {
		SpringApplication.run(RestfulConsumerService1Application.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
//	@Bean
//	public RestTemplate restTemplateXML() {
//		final String BASE_URL = "http://localhost:8081/soap-service";
//		DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(BASE_URL);
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.setUriTemplateHandler(uriBuilderFactory);
//		return restTemplate;
//	}
	

}
