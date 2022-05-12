package com.ben.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ben.model.ValoAgent;

/**
 * This interface is needed to access JpaRepository methods with the annotation @Repository and for automatic table creation through
 * the model class ValoAgent.java
 * @author benor
 *
 */
@Repository
public interface ValoAgentRepository extends JpaRepository<ValoAgent, Long>{

}
