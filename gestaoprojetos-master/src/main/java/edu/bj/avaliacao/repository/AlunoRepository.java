package edu.bj.avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bj.avaliacao.model.Aluno;


public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	List<Aluno> findByNome(String nome);
	Aluno findByMatricula(String matricula);
}