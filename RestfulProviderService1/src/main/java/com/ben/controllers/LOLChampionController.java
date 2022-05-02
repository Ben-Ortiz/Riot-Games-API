package com.ben.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ben.model.LOLChampion;

@RestController
public class LOLChampionController {
	
	@GetMapping("/champions")
	public String getChampion() {
		LOLChampion lolChampion = new LOLChampion(1, "Viktor");
		return lolChampion.getChampName();
	}

}
