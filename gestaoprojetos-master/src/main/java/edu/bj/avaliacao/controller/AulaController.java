package edu.bj.avaliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.bj.avaliacao.model.Aula;
import edu.bj.avaliacao.repository.AulaRepository;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {
	@Autowired AulaRepository aulaRepository;

	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Aula> find() {
		return aulaRepository.findAll();	
	}
				
}
