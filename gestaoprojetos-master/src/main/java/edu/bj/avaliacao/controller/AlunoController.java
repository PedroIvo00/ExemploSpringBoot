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

import edu.bj.avaliacao.model.Aluno;
import edu.bj.avaliacao.repository.AlunoRepository;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
	@Autowired AlunoRepository alunoRepository;

	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Aluno> find() {
		return alunoRepository.findAll();	
	}
	 
		@RequestMapping(value="/{nome}", method=RequestMethod.GET)
		public String listarAlunoes(@PathVariable("nome") String nome, Model model) {
			List<Aluno> listaAlunoes = alunoRepository.findByNome(nome);
			if (listaAlunoes != null) {
				model.addAttribute("alunos", listaAlunoes);
			}
			return "listaAlunoes";
		}
		
		 @RequestMapping(value = "/{nome}", method = RequestMethod.POST)
	     public String adicionarAluno(@PathVariable("nome") String nome, @PathVariable("email") String email,
	    		 @PathVariable("matricula") String matricula, @PathVariable("senha") String senha, Aluno aluno) {
	           aluno.setNome(nome);
	           aluno.setEmail(email);
	           aluno.setMatricula(matricula);
	           aluno.setSenha(senha);
	           alunoRepository.save(aluno);
	           return "redirect:/{nome}";
	     }
		
		 @DeleteMapping(value = "/{id}")
		  public String excluirAluno(@PathVariable("id") Long id, Model model) {
		      alunoRepository.deleteById(id);
		      List<Aluno> listaAlunos = alunoRepository.findAll();
		      if (listaAlunos != null) {
					model.addAttribute("alunos", listaAlunos);
				}
		      return "listaAlunos";
		  }
		
		 @PutMapping(value = "/{id}")
		  public String atualizaAluno(@PathVariable("id") long id, @RequestBody Aluno aluno) {
		    Optional<Aluno> alunoData = alunoRepository.findById(id);

		    if (alunoData.isPresent()) {
		      Aluno _aluno = alunoData.get();
		      aluno.setNome(aluno.getNome());
	          _aluno.setEmail(aluno.getEmail());
	          _aluno.setMatricula(aluno.getMatricula());
	          _aluno.setSenha(aluno.getSenha());
		      alunoRepository.save(_aluno);
		      return "redirect:/{nome}";
		    } else {
		    	return "redirect:/api/alunos";
		    }
		  }						
}
