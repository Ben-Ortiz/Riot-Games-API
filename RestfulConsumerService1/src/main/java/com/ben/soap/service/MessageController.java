package com.ben.soap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ben.model.ValoAgent;
import com.ben.service.ValoAgentService;

/*
 * error of not finding the valoAgentService bean happening.
 * reason this wasnt working was it was in package com.ben.service. had to be com.ben.soap.service
 */
@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private ValoAgentService valoAgentService;
	
	/*
	 * 404 error cant call this for some reason
	 */
	@GetMapping("/soap-message")
	public Object getSoapMessage() {
		return this.valoAgentService.findAllValoAgents();
	}
	
	@GetMapping("/testsoap")
	public String test() {
		return this.valoAgentService.test();
	}

}
