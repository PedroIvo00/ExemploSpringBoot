package edu.bj.avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bj.avaliacao.model.Disciplina;


public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
	List<Disciplina> findByNome(String nome);
	List<Disciplina> findByDescricao(String descricao);
	
}