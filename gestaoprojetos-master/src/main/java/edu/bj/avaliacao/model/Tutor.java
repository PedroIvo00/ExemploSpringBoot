package edu.bj.avaliacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tutor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="nome", nullable=false)
	private String nome;
	@Column(name="email", nullable=false)
	private String email;
	@Column(name="codFunc", nullable=false, unique=true)
	private Integer codFunc;
	@Column(name="senha", nullable=false)
	private String senha;
	

	public Tutor(String nome, String email,
			Integer codFunc, String senha) {
		this.nome = nome;
		this.email = email;
		this.codFunc = codFunc;
		this.senha = senha;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCodFunc() {
		return codFunc;
	}

	public void setCodFunc(Integer codFunc) {
		this.codFunc = codFunc;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
