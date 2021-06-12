package edu.bj.avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.bj.avaliacao.model.Tutor;


public interface TutorRepository extends JpaRepository<Tutor, Long>{
	List<Tutor> findByNome(String nome);
}