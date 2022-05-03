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

	@Override
	public List<LOLChampion> getLOLChampions() {
		return lcRepository.findAll();
	}

	@Override
	public LOLChampion saveLOLChampion(LOLChampion lolChampion) {
		return lcRepository.save(lolChampion);
	}

	@Override
	public LOLChampion getSingleChampion(Long id) {
		Optional<LOLChampion> lolChampion = lcRepository.findById(id);
		if(lolChampion.isPresent()) {
			return lolChampion.get();
		} 
		throw new RuntimeException("Lol Champion " + id + " does not exist");
	}

	@Override
	public void deleteChampion(Long id) {
		lcRepository.deleteById(id);
	}

	@Override
	public LOLChampion updateLOLChampion(LOLChampion lolChampion) {
		return lcRepository.save(lolChampion);
	}

}
