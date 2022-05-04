package com.ben.service;

import java.util.List;

import javax.jws.WebService;

import com.ben.model.ValoAgent;

/**
 * declarations of methods 
 */
@WebService
public interface ValoAgentService {
	
	public List<ValoAgent> findAll();
	public ValoAgent save (ValoAgent valoAgent);
	public String test();

}
