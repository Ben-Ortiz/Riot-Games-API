package com.ben.service;

import java.util.List;

import javax.jws.WebService;

import com.ben.model.ValoAgent;

/**
 * This interface is used to declare the methods needed to be implemented in the ValoAgentServiceImpl.java file
 */
@WebService
public interface ValoAgentService {
	
	public List<ValoAgent> findAllValoAgents();
	public ValoAgent saveValoAgent (ValoAgent valoAgent);
	public void deleteValoAgentById(Long Id);
	public ValoAgent updateValoAgent(ValoAgent valoAgent);
	public String test();

}
