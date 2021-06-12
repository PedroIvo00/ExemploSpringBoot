package edu.bj.avaliacao.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Aula {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="titulo", nullable=false)
	private String titulo;
	@Column(name="descricao", nullable=false)
	private String descricao;
	@Column(name="data", nullable=false)
	private String data;
	
	public Aula() {
	}
	
	public Aula(String titulo, String descricao, String data) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
}
