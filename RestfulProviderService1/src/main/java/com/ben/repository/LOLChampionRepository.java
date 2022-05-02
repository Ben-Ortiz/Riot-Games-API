package com.ben.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ben.model.LOLChampion;

@Repository
public interface LOLChampionRepository extends JpaRepository<LOLChampion, Long> {

}
