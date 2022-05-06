package com.ben.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.ben.model.ValoAgent;

@WebService(serviceName = "order-service", targetNamespace = "http://service.ben.com/")
@Component
public interface ValoAgentService {
	
	@WebMethod
	public List<ValoAgent> findAllValoAgents();
	@WebMethod
	public String test();

}
