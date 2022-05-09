package com.ben.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ben.model.LOLChampion;

/**
 * This interface is needed to access JpaRepository methods with the annotation @Repository
 * @author benor
 *
 */
@Repository
public interface LOLChampionRepository extends JpaRepository<LOLChampion, Long> {

}
