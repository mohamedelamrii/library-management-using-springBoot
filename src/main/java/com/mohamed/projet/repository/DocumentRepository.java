package com.mohamed.projet.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mohamed.projet.entities.Adherent;
import com.mohamed.projet.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, String> {
	@Query("select d from Document d where d.id_doc like :x")
	public Page<Document> chercher(@Param("x") String id_doc ,Pageable pageable);
}
