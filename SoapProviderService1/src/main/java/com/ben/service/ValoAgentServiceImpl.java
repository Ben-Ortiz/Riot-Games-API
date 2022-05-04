package com.ben.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.ben.model.ValoAgent;
import com.ben.repository.ValoAgentRepository;

/**
 * 
 * @author benor
 * method implementations from ValoAgentService
 * this is where methods are made for requests.
 */
@WebService(endpointInterface = "com.ben.service.ValoAgentService")
public class ValoAgentServiceImpl implements ValoAgentService{
	
	@Autowired
	private ValoAgentRepository valoAgentRepository;

	@WebMethod
	public List<ValoAgent> findAllValoAgents() {
		return this.valoAgentRepository.findAll();
	}

	@WebMethod
	public ValoAgent saveValoAgent(ValoAgent valoAgent) {
		return valoAgentRepository.save(valoAgent);
	}

	//Sanity check method my soap service works
	@WebMethod
	public String test() {
		return "a string";
	}

	@WebMethod
	public void deleteValoAgentById(Long Id) {
		valoAgentRepository.deleteById(Id);
		
	}

	@WebMethod
	public ValoAgent updateValoAgent(ValoAgent valoAgent) {
		return valoAgentRepository.save(valoAgent);
	}
	
	

}
