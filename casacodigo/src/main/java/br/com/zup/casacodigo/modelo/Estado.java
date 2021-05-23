package br.com.zup.casacodigo.modelo;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@NotNull
	private String nome;
	
	@NotNull
	@ManyToOne
	private Pais pais;
	
	@Deprecated
	public Estado() {
	}
	
	public Estado(String nome, Optional<Pais> pais) {
		this.nome = nome;
		this.pais = pais.get();
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}

	public Pais getPais() {
		return pais;
	}
}
