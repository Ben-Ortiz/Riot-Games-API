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

/**
 * This class is what you put on Postman to call this API and their implementations
 * @author benor
 *
 */
@RestController
@RequestMapping("/leagueOfLegends")
public class LOLChampionController {

	// http://localhost:8080/leagueOfLegends/...

	@Autowired
	private LOLChampionService lcService;

	/**
	 * This method allows postman to make a get request to get all champions from the database
	 * @return all the champions from the database
	 */
	// http://localhost:8080/leagueOfLegends/champions
	@GetMapping("/champions")
	public List<LOLChampion> getChampion() {
		return lcService.findAllLOLChampions();
	}
	
	/**
	 * This method allows postman to make a get request for 1 champion from the database
	 * @param id
	 * @return 1 champion from the database
	 */
	// http://localhost:8080/leagueOfLegends/champions/1
	@GetMapping("champions/{id}")
	public LOLChampion getLOLChampion(@PathVariable Long id) {
		return lcService.getSingleChampion(id);
	}
	
	/**
	 * This method allows postman to make a post request to add 1 champion to the database
	 * @param lolChampion
	 * @return 1 champion to the database
	 */
	// http://localhost:8080/leagueOfLegends/postChampion
	@PostMapping("/postChampion")
	public LOLChampion saveLOLChampion(@RequestBody LOLChampion lolChampion) {
		return lcService.saveLOLChampion(lolChampion);
	}
	
	/**
	 * This method allows postman to make a put request to update 1 champion from the database
	 * @param id
	 * @param lolChampion
	 * @return 1 champion to update to the database
	 */
	// http://localhost:8080/leagueOfLegends/champions/2
	// In Postman change body to raw and JSON 
	@PutMapping("/champions/{id}")
	public LOLChampion updateLOLChampion(@PathVariable Long id, @RequestBody LOLChampion lolChampion) {
		lolChampion.setId(id);
		return lcService.updateLOLChampion(lolChampion);
	}
	
	/**
	 * this method allows postman to make a delete request to delete 1 champion from the database
	 * @param id
	 */
	// http://localhost:8080/leagueOfLegends/champions?id=2
	// for delete use @RequestParam
	@DeleteMapping("/champions")
	public void deleteChampion(@RequestParam Long id) {
		lcService.deleteChampion(id);
	}
	
	/**
	 * this method is a test method to check if postman is working for requests
	 * @return
	 */
	// sanity check for my get request to work
	// http://localhost:8080/leagueOfLegends/championsTest
	@GetMapping("/championsTest")
	public String getChampionTest() {
		LOLChampion lolChampion = new LOLChampion(1, "Viktor");
		return lolChampion.getChampName();
	}

}
