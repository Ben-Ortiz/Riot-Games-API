package com.ben.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
		return lcService.getLOLChampions();
	}
	
	// http://localhost:8080/leagueOfLegends/postChampion
	@PostMapping("/postChampion")
	public LOLChampion saveLOLChampion(@RequestBody LOLChampion lolChampion) {
		return lcService.saveLOLChampion(lolChampion);
	}

}
