package edu.bj.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bj.avaliacao.model.TextoSimples;


public interface TextoSimplesRepository extends JpaRepository<TextoSimples, Long>{
	
}