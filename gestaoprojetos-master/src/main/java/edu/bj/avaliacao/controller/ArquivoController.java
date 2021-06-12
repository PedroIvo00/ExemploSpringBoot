package edu.bj.avaliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.bj.avaliacao.model.Arquivo;
import edu.bj.avaliacao.repository.ArquivoRepository;

@RestController
@RequestMapping("/api/arquivos")
public class ArquivoController {
	@Autowired ArquivoRepository arquivoRepository;

	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Arquivo> find() {
		return arquivoRepository.findAll();	
	}
				
}
