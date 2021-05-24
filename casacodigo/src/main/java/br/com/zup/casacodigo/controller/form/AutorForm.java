package br.com.zup.casacodigo.controller.form;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.zup.casacodigo.config.validacao.UniqueValue;
import br.com.zup.casacodigo.modelo.Autor;


public class AutorForm {

	@NotBlank
	@Length(max = 30)
	private String nome;

	@NotBlank
	@Length(max = 30)
	@Email
	@UniqueValue(domaiClass = Autor.class, fieldName = "email", message = "Já existe este email cadastrado")
	private String email;

	@NotBlank
	@Length(max = 400)
	private String descricao;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Autor conveter(@Valid AutorForm autorForm) {
		return new Autor(nome, email, descricao);
	}

}
