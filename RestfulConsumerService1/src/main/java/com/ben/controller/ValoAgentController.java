package com.ben.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ben.model.ValoAgent;
import com.ben.service.ValoAgentService;

@RestController
@RequestMapping("/message")
public class ValoAgentController {
//	
//	@Autowired
//	private RestTemplate restTemplate;
//	@Autowired
//	private RestTemplate restTemplateXML;
	
	@Autowired
	private ValoAgentService valoAgentService;
	
//	@GetMapping(value = "/valoagent/{id}", produces = MediaType.APPLICATION_XML_VALUE)
//	public ValoAgent getValoAgent(@PathVariable Long id) {
//		ResponseEntity<ValoAgent> response = restTemplateXML.getForEntity("/cupcake-service?wsdl" + id, ValoAgent.class);
//		return response.getBody();
//	}
	
	/*
	 * Postman doesn't like this url 404
	 * GET http://localhost:6060/message/soap-message
	 * 
	 */
	@GetMapping("/soap-message")
	public Object getSoapMessage() {
		return this.valoAgentService.findAll();
	}

}
