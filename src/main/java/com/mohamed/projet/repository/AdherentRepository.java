package com.mohamed.projet.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.mohamed.projet.entities.Adherent;

public interface AdherentRepository extends JpaRepository<Adherent, Long>{
	@Query("select a from Adherent a where a.cin like :x")
	public Page<Adherent> chercher(@Param("x") String cin ,Pageable pageable);
}
