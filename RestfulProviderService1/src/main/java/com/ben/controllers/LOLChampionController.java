package com.ben.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ben.model.LOLChampion;

@RestController
@RequestMapping("/leagueOfLegends")
public class LOLChampionController {
	
	//sanity check for my post to work
	@GetMapping("/championsTest")
	public String getChampion() {
		LOLChampion lolChampion = new LOLChampion(1, "Viktor");
		return lolChampion.getChampName();
	}

}
