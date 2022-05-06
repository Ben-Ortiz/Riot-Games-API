package com.ben.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ben.model.ValoAgent;

@WebService(serviceName = "valoagent-service", targetNamespace = "http://service.revature.com/")
@Component
public interface ValoAgentService {
	
	@WebMethod
	public List<ValoAgent> findAll();

}
