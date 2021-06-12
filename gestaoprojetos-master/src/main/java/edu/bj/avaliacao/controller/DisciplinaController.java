package edu.bj.avaliacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.bj.avaliacao.model.Disciplina;
import edu.bj.avaliacao.repository.DisciplinaRepository;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {
	@Autowired DisciplinaRepository disciplinaRepository;

	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Disciplina> find() {
		return disciplinaRepository.findAll();	
	}
		

	@RequestMapping(value="/{nome}", method=RequestMethod.GET)
	public String listarDisciplinas(@PathVariable("nome") String nome, Model model) {
		List<Disciplina> listaDisciplinas = disciplinaRepository.findByNome(nome);
		if (listaDisciplinas != null) {
			model.addAttribute("disciplinas", listaDisciplinas);
		}
		return "listaDisciplinas";
	}
	
	 @RequestMapping(value = "/{nome}", method = RequestMethod.POST)
     public String adicionarDisciplina(@PathVariable("nome") String nome, @PathVariable("descricao") String descricao,
    		 @PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim, Disciplina disciplina) {
		 disciplina.setNome(nome);
		 disciplina.setDescricao(descricao);
		 disciplina.setDataInicio(dataInicio);
		 disciplina.setDataFim(dataFim);
		 disciplinaRepository.save(disciplina);
           return "redirect:/{nome}";
     }
	
	 @DeleteMapping(value = "/{id}")
	  public String excluirDisciplina(@PathVariable("id") Long id, Model model) {
		 disciplinaRepository.deleteById(id);
	      List<Disciplina> listaDisciplinas = disciplinaRepository.findAll();
	      if (listaDisciplinas != null) {
				model.addAttribute("disciplinas", listaDisciplinas);
			}
	      return "listaDisciplinas";
	  }
	
	 @PutMapping(value = "/{id}")
	  public String atualizaDisciplina(@PathVariable("id") long id, @RequestBody Disciplina disciplina) {
	    Optional<Disciplina> disciplinaData = disciplinaRepository.findById(id);

	    if (disciplinaData.isPresent()) {
	      Disciplina _disciplina = disciplinaData.get();
	      	 _disciplina.setNome(disciplina.getNome());
			 _disciplina.setDescricao(disciplina.getDescricao());
			 _disciplina.setDataInicio(disciplina.getDataInicio());
			 _disciplina.setDataFim(disciplina.getDataFim());
	      disciplinaRepository.save(_disciplina);
	      return "redirect:/{nome}";
	    } else {
	    	return "redirect:/api/disciplinas";
	    }
	  }
}
