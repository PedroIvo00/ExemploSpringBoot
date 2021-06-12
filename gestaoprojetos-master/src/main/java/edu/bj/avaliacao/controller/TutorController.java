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

import edu.bj.avaliacao.model.Tutor;
import edu.bj.avaliacao.repository.TutorRepository;

@RestController
@RequestMapping("/api/tutores")
public class TutorController {
	@Autowired
	private TutorRepository tutorRepository;

	public TutorController (TutorRepository tutorRepository) {
		this.tutorRepository = tutorRepository;
	}
	
	 @RequestMapping(value="", method=RequestMethod.GET)
	List<Tutor> find() {
			return tutorRepository.findAll();	
		}
	 
	@RequestMapping(value="/{nome}", method=RequestMethod.GET)
	public String listarTutores(@PathVariable("nome") String nome, Model model) {
		List<Tutor> listaTutores = tutorRepository.findByNome(nome);
		if (listaTutores != null) {
			model.addAttribute("tutores", listaTutores);
		}
		return "listaTutores";
	}
	
	 @RequestMapping(value = "/{nome}", method = RequestMethod.POST)
     public String adicionarTutor(@PathVariable("nome") String nome, @PathVariable("email") String email,
    		 @PathVariable("codFunc") Integer codFunc, @PathVariable("senha") String senha, Tutor tutor) {
           tutor.setNome(nome);
           tutor.setEmail(email);
           tutor.setCodFunc(codFunc);
           tutor.setSenha(senha);
           tutorRepository.save(tutor);
           return "redirect:/{nome}";
     }
	
	 @DeleteMapping(value = "/{id}")
	  public String excluirTutor(@PathVariable("id") Long id, Model model) {
	      tutorRepository.deleteById(id);
	      List<Tutor> listaTutores = tutorRepository.findAll();
	      if (listaTutores != null) {
				model.addAttribute("tutores", listaTutores);
			}
	      return "listaTutores";
	  }
	
	 @PutMapping(value = "/{id}")
	  public String atualizaTutor(@PathVariable("id") long id, @RequestBody Tutor tutor) {
	    Optional<Tutor> tutorData = tutorRepository.findById(id);

	    if (tutorData.isPresent()) {
	      Tutor _tutor = tutorData.get();
	      tutor.setNome(tutor.getNome());
          _tutor.setEmail(tutor.getEmail());
          _tutor.setCodFunc(tutor.getCodFunc());
          _tutor.setSenha(tutor.getSenha());
	      tutorRepository.save(_tutor);
	      return "redirect:/{nome}";
	    } else {
	    	return "redirect:/api/tutores";
	    }
	  }			
}
