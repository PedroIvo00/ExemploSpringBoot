package edu.bj.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bj.avaliacao.model.Aula;


public interface AulaRepository extends JpaRepository<Aula, Long>{
	
}