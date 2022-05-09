package com.ben.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ben.model.ValoAgent;
import com.ben.service.ValoAgentService;

/**
 * This class is where the Soap Service is connected and allowed to be treated as a Rest API.
 * In other words, this class allows this Rest Consumer Service API to communicate to the Soap Provider Service API.
 * An example URL to use in Postman or Soap UI is: http://localhost:6060/valoagent/getall
 * @author benor
 *
 */
@RestController
@RequestMapping("/valoagent")
public class ValoAgentController {
	
	/**
	 * This autowired ValoAgentService instance is being managed by Spring
	 */
	@Autowired
	private ValoAgentService valoAgentService;

	/**
	 * This method allows this Rest Consumer API to call the Soap API and make a get request to the Soap API and get all valoagents from the databse
	 * @return a list of all the valoagents from the database
	 */
	@GetMapping("/getall")
	public List<ValoAgent> getSoapMessage() {
		return this.valoAgentService.findAllValoAgents();
	}
	
	/**
	 * This method allows this Rest Consumer API to call the Soap API to make a post request and add a valoagent to the database
	 * @param valoAgent
	 * @return the valo agent that is added to the database
	 */
	@PostMapping("/postAgent")
	public ValoAgent saveValoAgent (@RequestBody ValoAgent valoAgent) {
		return valoAgentService.saveValoAgent(valoAgent);
	}
	
	/**
	 * This method allows this Rest Consumer API to call the Soap API to make a put request and update a valoagent from the database
	 * @param valoAgent
	 * @return the valo agent that is updated from the database
	 */
	@PutMapping("/updateAgent")
	public ValoAgent updateValoAgent(@RequestBody ValoAgent valoAgent) {
		return valoAgentService.saveValoAgent(valoAgent);
	}
	
	/**
	 * This method allows this Rest Consumer API to call the Soap APU to make a delete request and delete a valoagent from the database
	 * @param id
	 */
	@DeleteMapping("/deleteAgent")
	public void deleteValoAgentById(@RequestParam Long id) {
		valoAgentService.deleteValoAgentById(id);
	}
	
	/**
	 * this is a test method to check if this Rest Consumer API is able to communicate with my Soap API
	 * @return
	 */
	@GetMapping("/testsoap")
	public String test() {
		return this.valoAgentService.test();
	}

}
