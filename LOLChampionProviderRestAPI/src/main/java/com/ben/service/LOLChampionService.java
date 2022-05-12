package com.ben.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ben.model.LOLChampion;

/**
 * This interface is needed to make the methods in LOLChampionServiceImpl with the annotation @Service
 * @author benor
 *
 */
@Service
public interface LOLChampionService {

	public List<LOLChampion> findAllLOLChampions();
	public LOLChampion saveLOLChampion(LOLChampion lolChampion);
	public LOLChampion getSingleChampion(Long id);
	public void deleteChampion(Long id);
	public LOLChampion updateLOLChampion(LOLChampion lolChampion);
}
