package br.com.zup.casacodigo.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Autor {
	
	@Column(name = "ID_AUTOR")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NM_NOME", nullable = false, length = 30)
	@NotNull
	@NotEmpty
	@Length(max = 30)
	private String nome;
	
	@Column(name = "NM_EMAIL", nullable = false, length = 30, unique = true)
	@NotNull
	@NotEmpty
	@Length(max = 30)
	@Email
	private String email;
	
	@Column(name = "NM_DESCRICAO", length = 400)
	@NotNull
	@NotEmpty
	@Length(max = 400)
	private String descricao;
	
	@NotNull
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	public Autor() {
	}
	
	public Autor(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
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

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}
