package com.mohamed.projet.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mohamed.projet.entities.Adherent;
import com.mohamed.projet.entities.Emprunt;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
public Page<Emprunt> findByAdherent(Adherent a,Pageable pageable);
}
