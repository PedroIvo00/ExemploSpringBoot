package edu.bj.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bj.avaliacao.model.RegistroNota;


public interface RegistroNotaRepository extends JpaRepository<RegistroNota, Long>{
	
}