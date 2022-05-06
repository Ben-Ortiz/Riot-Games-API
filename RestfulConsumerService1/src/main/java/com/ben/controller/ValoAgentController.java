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

/*
 * this class is used by soap service
 */
@RestController
@RequestMapping("/valoagent")
public class ValoAgentController {
	
	@Autowired
	private ValoAgentService valoAgentService;
	
	/*
	 * http://localhost:6060/valoagent/getall
	 */
	@GetMapping("/getall")
	public List<ValoAgent> getSoapMessage() {
		return this.valoAgentService.findAllValoAgents();
	}
	
	@PostMapping("/postAgent")
	public ValoAgent saveValoAgent (@RequestBody ValoAgent valoAgent) {
		return valoAgentService.saveValoAgent(valoAgent);
	}
	
	@PutMapping("/updateAgent")
	public ValoAgent updateValoAgent(@RequestBody ValoAgent valoAgent) {
		return valoAgentService.saveValoAgent(valoAgent);
	}
	
	@DeleteMapping("/deleteAgent")
	public void deleteValoAgentById(@RequestParam Long id) {
		valoAgentService.deleteValoAgentById(id);
	}
	
	/*
	 * test method 
	 */
	@GetMapping("/testsoap")
	public String test() {
		return this.valoAgentService.test();
	}

}
