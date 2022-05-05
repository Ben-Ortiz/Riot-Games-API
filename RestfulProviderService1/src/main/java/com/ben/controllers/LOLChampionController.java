package com.ben.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ben.model.LOLChampion;
import com.ben.service.LOLChampionService;

@RestController
@RequestMapping("/leagueOfLegends")
public class LOLChampionController {

	// http://localhost:8080/leagueOfLegends/...

	@Autowired
	private LOLChampionService lcService;

	// sanity check for my get request to work
	// http://localhost:8080/leagueOfLegends/championsTest
	@GetMapping("/championsTest")
	public String getChampionTest() {
		LOLChampion lolChampion = new LOLChampion(1, "Viktor");
		return lolChampion.getChampName();

	}

	// http://localhost:8080/leagueOfLegends/champions
	@GetMapping("/champions")
	public List<LOLChampion> getChampion() {
		return lcService.findAllLOLChampions();
	}
	
	// http://localhost:8080/leagueOfLegends/champions/1
	// for getting by single id use @PathVariable
	@GetMapping("champions/{id}")
	public LOLChampion getLOLChampion(@PathVariable Long id) {
		return lcService.getSingleChampion(id);
	}
	
	// http://localhost:8080/leagueOfLegends/postChampion
	// @RequestBody is for getting lists
//	@CrossOrigin(origins = "http://localhost:6060")
	@PostMapping("/postChampion")
	public LOLChampion saveLOLChampion(@RequestBody LOLChampion lolChampion) {
		return lcService.saveLOLChampion(lolChampion);
	}
	
	// http://localhost:8080/leagueOfLegends/champions/2
	// In Postman change body to raw and JSON 
	@PutMapping("/champions/{id}")
	public LOLChampion updateLOLChampion(@PathVariable Long id, @RequestBody LOLChampion lolChampion) {
		lolChampion.setId(id);
		return lcService.updateLOLChampion(lolChampion);
	}
	
	// http://localhost:8080/leagueOfLegends/champions?id=2
	// for delete use @RequestParam
	@DeleteMapping("/champions")
	public void deleteChampion(@RequestParam Long id) {
		lcService.deleteChampion(id);
	}
	
	

}
