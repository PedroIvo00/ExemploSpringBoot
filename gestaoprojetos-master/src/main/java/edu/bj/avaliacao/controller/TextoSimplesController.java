package edu.bj.avaliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.bj.avaliacao.model.TextoSimples;
import edu.bj.avaliacao.repository.TextoSimplesRepository;

@RestController
@RequestMapping("/api/Textos")
public class TextoSimplesController {
	@Autowired TextoSimplesRepository textoSimplesRepository;

	@RequestMapping(value="", method=RequestMethod.GET)
	public List<TextoSimples> find() {
		return textoSimplesRepository.findAll();	
	}
				
}
