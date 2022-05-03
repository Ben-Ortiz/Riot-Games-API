package com.ben.service;

import java.util.List;

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

}
