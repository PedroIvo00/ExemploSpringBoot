package edu.bj;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.bj.avaliacao.model.Aluno;
import edu.bj.avaliacao.model.Arquivo;
import edu.bj.avaliacao.model.Aula;
import edu.bj.avaliacao.model.Disciplina;
import edu.bj.avaliacao.model.RegistroNota;
import edu.bj.avaliacao.model.TextoSimples;
import edu.bj.avaliacao.model.TipoMaterial;
import edu.bj.avaliacao.model.Tutor;
import edu.bj.avaliacao.repository.AlunoRepository;
import edu.bj.avaliacao.repository.ArquivoRepository;
import edu.bj.avaliacao.repository.AulaRepository;
import edu.bj.avaliacao.repository.DisciplinaRepository;
import edu.bj.avaliacao.repository.RegistroNotaRepository;
import edu.bj.avaliacao.repository.TextoSimplesRepository;
import edu.bj.avaliacao.repository.TipoMaterialRepository;
import edu.bj.avaliacao.repository.TutorRepository;

@SpringBootApplication
public class AvaliacaoApplication {
	


	//Dados iniciais da base de dados
	@Bean
	 CommandLineRunner runner(AlunoRepository alunoRepository, TipoMaterialRepository tipoMaterialRepository,
				TextoSimplesRepository textoSimplesRepository, RegistroNotaRepository registroNotaRepository,
				DisciplinaRepository disciplinaRepository, AulaRepository aulaRepository,
				ArquivoRepository arquivoRepository, TutorRepository tutorRepository){ return args ->
	 {
		 alunoRepository.save(new Aluno("Pedro Ivo", "pedro@email.com", "A0007", "1q2w3e4r"));
			tutorRepository.save(new Tutor("João  Silva", "profjoao@email.com", 987654, "4r3e2w1q"));
			disciplinaRepository.save(new Disciplina("Programação 1", "Curso de programação inicial", "01/01/2021", "01/02/2021", true));
			aulaRepository.save(new Aula("JAVA", "Aula sobre JAVA", "01/01/2021"));
			tipoMaterialRepository.save(new TipoMaterial("Projeto"));
			tipoMaterialRepository.save(new TipoMaterial("Livro sobre JAVA"));
			textoSimplesRepository.save(new TextoSimples("Livro sobre como programar em JAVA"));
			arquivoRepository.save(new Arquivo("projetoJava.rar"));
			registroNotaRepository.save(new RegistroNota("Programação 1", 7.0, 9.5, 10.0));
		 
	 };}
	 		
	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoApplication.class, args);
	}

}
