package com.ben.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ben.model.LOLChampion;
import com.ben.repository.LOLChampionRepository;

@Service
public class LOLChampionServiceImpl implements LOLChampionService {

	@Autowired
	private LOLChampionRepository lcRepository;

	/**
	 * calls the lcRepository to find all champions from the database
	 */
	@Override
	public List<LOLChampion> findAllLOLChampions() {
		return lcRepository.findAll();
	}

	/**
	 * saves 1 lol champion into the db by passing a LOLChampion object
	 */
	@Override
	public LOLChampion saveLOLChampion(LOLChampion lolChampion) {
		return lcRepository.save(lolChampion);
	}
	
	/**
	 * gets 1 lol champion from the db by its id
	 */
	@Override
	public LOLChampion getSingleChampion(Long id) {
		Optional<LOLChampion> lolChampion = lcRepository.findById(id);
		if(lolChampion.isPresent()) {
			return lolChampion.get();
		} 
		throw new RuntimeException("Lol Champion " + id + " does not exist");
	}

	/**
	 * deletes a lol champion by id
	 */
	@Override
	public void deleteChampion(Long id) {
		lcRepository.deleteById(id);
	}

	/**
	 * updates the lol champion by LOLChampion object, but also uses id in LOLChampionController.java
	 */
	@Override
	public LOLChampion updateLOLChampion(LOLChampion lolChampion) {
		return lcRepository.save(lolChampion);
	}

}
