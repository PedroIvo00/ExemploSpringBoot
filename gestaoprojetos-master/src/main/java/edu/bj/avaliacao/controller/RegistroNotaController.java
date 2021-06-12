package edu.bj.avaliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.bj.avaliacao.model.RegistroNota;
import edu.bj.avaliacao.repository.RegistroNotaRepository;

@RestController
@RequestMapping("/api/registros")
public class RegistroNotaController {
	@Autowired RegistroNotaRepository registroNotaRepository;

	@RequestMapping(value="", method=RequestMethod.GET)
	public List<RegistroNota> find() {
		return registroNotaRepository.findAll();	
	}
				
}
