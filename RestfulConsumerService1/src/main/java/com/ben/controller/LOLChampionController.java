package com.ben.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ben.model.LOLChampion;

/**
 * This class controls the requests that can be made to the Rest API relating to League of Legends
 * An example url to make requests to this service using Postman is : http://localhost:6060/lolchampion/2 
 * @author benor
 *
 */
@RestController
public class LOLChampionController {
	
	/**
	 * This autowired restTemplate allows this Rest Consumer API to take in the Rest Provider API relating to League of Legends
	 * 
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * This method allows this Rest Consumer to call the Rest Provider API from the url to get a list of all champions from the database
	 * @return a list of all lol champions
	 */
	@GetMapping("/lolchampion/getall")
	public List<LOLChampion> getAllLOLChampion() {
		ResponseEntity<List> lolChampion = restTemplate.getForEntity("http://localhost:8080/leagueOfLegends/champions/", List.class);
		List<LOLChampion> lolChampionList = lolChampion.getBody();
		return lolChampionList;
		
	}
	
	/**
	 * This method allows this Rest Consumer service to call the Rest Provider API from the url to get a lol champion from their id.
	 * @param id
	 * @return the request body of the lol champion 
	 */
	@GetMapping("/lolchampion/get/{id}")
	public LOLChampion getLOLChampionById(@PathVariable Long id) {
		ResponseEntity<LOLChampion> lolChampion = restTemplate.getForEntity("http://localhost:8080/leagueOfLegends/champions/" + id, LOLChampion.class);
		return lolChampion.getBody();
		
	}
	
	/**
	 * This method allows this Rest Consumer service to call the Rest Provider API from the url to add a lol champion to the database.
	 * @param lolChampion
	 * @return the request body of the lol champion added to the database
	 */
	@PostMapping("/lolchampion/new")
	public LOLChampion saveLOLChampion(@RequestBody LOLChampion lolChampion) {
		ResponseEntity<LOLChampion> response = restTemplate.postForEntity("http://localhost:8080/leagueOfLegends/postChampion", lolChampion, LOLChampion.class);
		return response.getBody();
	}
	
	/**
	 * This method allows this Rest Consumer service to call the Rest Provider API from the url to update a lol champion in the database.
	 * @param id
	 * @param lolChampion
	 */
	@PutMapping("lolchampion/update/{id}")
	public void updateLOLChampionById(@PathVariable Long id, @RequestBody LOLChampion lolChampion) {
		restTemplate.put("http://localhost:8080/leagueOfLegends/champions/" + id, lolChampion);
	}
	
	/**
	 * This method allows this Rest Consumer service to call the Rest Provider API from the url to delete a lol champion from the database.
	 * @param id
	 */
	@DeleteMapping("/lolchampion/delete")
	public void deleteLOLChampionById(@RequestParam Long id) {
		restTemplate.delete("http://localhost:8080/leagueOfLegends/champions?id=" + id);
	}
	
	/**
	 * This method is just a test method to see if this Rest Consumer API is communicating with the Rest Provider API
	 * @return
	 */
	@GetMapping("/test")
	public String test() {
		return "test";
		
	}

}
