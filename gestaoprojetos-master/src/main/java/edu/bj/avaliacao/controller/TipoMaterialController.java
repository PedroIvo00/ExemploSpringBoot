package edu.bj.avaliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.bj.avaliacao.model.TipoMaterial;
import edu.bj.avaliacao.repository.TipoMaterialRepository;

@RestController
@RequestMapping("/api/tiposMateriais")
public class TipoMaterialController {
	@Autowired TipoMaterialRepository tipoMaterialRepository;

	@RequestMapping(value="", method=RequestMethod.GET)
	public List<TipoMaterial> find() {
		return tipoMaterialRepository.findAll();	
	}
				
}
