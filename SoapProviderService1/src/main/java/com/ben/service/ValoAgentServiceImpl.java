package com.ben.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ben.model.ValoAgent;
import com.ben.repository.ValoAgentRepository;

public class ValoAgentServiceImpl implements ValoAgentService{
	
	@Autowired
	private ValoAgentRepository valoAgentRepository;

	@Override
	public List<ValoAgent> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
