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

@RestController
public class LOLChampionController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/lolchampion/getall")
	public List<LOLChampion> getAllLOLChampion() {
		ResponseEntity<List> lolChampion = restTemplate.getForEntity("http://localhost:8080/leagueOfLegends/champions/", List.class);
		List<LOLChampion> lolChampionList = lolChampion.getBody();
		return lolChampionList;
		
	}
	
	/* Use this in Postman 
	 * http://localhost:6060/lolchampion/2
	 */
	@GetMapping("/lolchampion/get/{id}")
	public LOLChampion getLOLChampionById(@PathVariable Long id) {
		ResponseEntity<LOLChampion> lolChampion = restTemplate.getForEntity("http://localhost:8080/leagueOfLegends/champions/" + id, LOLChampion.class);
		return lolChampion.getBody();
		
	}
	
	@PostMapping("/lolchampion/new")
	public LOLChampion saveLOLChampion(@RequestBody LOLChampion lolChampion) {
		ResponseEntity<LOLChampion> response = restTemplate.postForEntity("http://localhost:8080/leagueOfLegends/postChampion", lolChampion, LOLChampion.class);
		return response.getBody();
	}
	
	@PutMapping("lolchampion/update/{id}")
	public void updateLOLChampionById(@PathVariable Long id, @RequestBody LOLChampion lolChampion) {
		restTemplate.put("http://localhost:8080/leagueOfLegends/champions/" + id, lolChampion);
	}
	
	@DeleteMapping("/lolchampion/delete")
	public void deleteLOLChampionById(@RequestParam Long id) {
		restTemplate.delete("http://localhost:8080/leagueOfLegends/champions?id=" + id);
	}

}
