package com.ben.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ben.model.LOLChampion;

@Service
public interface LOLChampionService {

	List<LOLChampion> getLOLChampions();
	LOLChampion saveLOLChampion(LOLChampion lolChampion);
}
