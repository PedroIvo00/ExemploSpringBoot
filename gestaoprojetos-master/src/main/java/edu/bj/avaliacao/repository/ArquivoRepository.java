package edu.bj.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bj.avaliacao.model.Arquivo;


public interface ArquivoRepository extends JpaRepository<Arquivo, Long>{
	
}