package edu.bj.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bj.avaliacao.model.TipoMaterial;

public interface TipoMaterialRepository extends JpaRepository<TipoMaterial, Long>{
	
}