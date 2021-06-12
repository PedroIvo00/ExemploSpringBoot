package edu.bj.avaliacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TextoSimples {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="textoMaterial", nullable=false)
	private String textoMaterial;
	
	public TextoSimples() {
	}
	
	public TextoSimples(String textoMaterial) {
		this.textoMaterial = textoMaterial;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTextoMaterial() {
		return textoMaterial;
	}

	public void setTextoMaterial(String textoMaterial) {
		this.textoMaterial = textoMaterial;
	}
}
