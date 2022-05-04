package com.ben.service;

import java.util.List;

import javax.jws.WebService;

import com.ben.model.ValoAgent;

/**
 * declarations of methods 
 * declare methods here then implement in ValoAgentServiceImpl
 */
@WebService
public interface ValoAgentService {
	
	public List<ValoAgent> findAllValoAgents();
	public ValoAgent saveValoAgent (ValoAgent valoAgent);
	public void deleteValoAgentById(Long Id);
	public ValoAgent updateValoAgent(ValoAgent valoAgent);
	public String test();

}
