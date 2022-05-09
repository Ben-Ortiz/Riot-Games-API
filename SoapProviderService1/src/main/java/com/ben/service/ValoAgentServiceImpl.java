package com.ben.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.ben.model.ValoAgent;
import com.ben.repository.ValoAgentRepository;

/**
 * This class implements the ValoAgentService class and with the @WebService
 * annotation. Allows the SOAP service to operate and this is where all the SOAP
 * methods are made different from the REST Service. 
 * A SOAP service makes only POST requests and needs a body in XML formatted correctly to post to get the information needed using either 
 * SoapUI or Postman
 * 
 * @author benor
 */
@WebService(endpointInterface = "com.ben.service.ValoAgentService")
public class ValoAgentServiceImpl implements ValoAgentService {

	/**
	 * This autowired valoAgentRepository addes a ValoAgentRepository instance that can be managed by Spring, a bean.
	 */
	@Autowired
	private ValoAgentRepository valoAgentRepository;

	/**
	 * This method allows the soap service to find all valoagents from the database
	 */
	@WebMethod
	public List<ValoAgent> findAllValoAgents() {
		return this.valoAgentRepository.findAll();
	}

	/**
	 * this method allows the soap service to save valoagents to the database
	 */
	@WebMethod
	public ValoAgent saveValoAgent(ValoAgent valoAgent) {
		return valoAgentRepository.save(valoAgent);
	}

	/**
	 * this method allows the soap service to delete valoagents from the database
	 */
	@WebMethod
	public void deleteValoAgentById(Long Id) {
		valoAgentRepository.deleteById(Id);

	}

	/**
	 * this method allows the soap service to update valoagents from the database
	 */
	@WebMethod
	public ValoAgent updateValoAgent(ValoAgent valoAgent) {
		return valoAgentRepository.save(valoAgent);
	}

	/**
	 * this method just tests if the soap service is working with SoapUI or Postman
	 */
	@WebMethod
	public String test() {
		return "watch this!";
	}

}
