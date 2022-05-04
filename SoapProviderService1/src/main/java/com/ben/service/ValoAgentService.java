package com.ben.service;

import java.util.List;

import javax.jws.WebService;

import com.ben.model.ValoAgent;

@WebService
public interface ValoAgentService {
	
	public List<ValoAgent> findAll();

}
