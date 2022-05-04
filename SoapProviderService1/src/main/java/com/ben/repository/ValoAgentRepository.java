package com.ben.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ben.model.ValoAgent;

@Repository
public interface ValoAgentRepository extends JpaRepository<ValoAgent, Long>{

}
