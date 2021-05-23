package br.com.zup.casacodigo.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casacodigo.config.validacao.UniqueValue;
import br.com.zup.casacodigo.modelo.Pais;

public class PaisForm {
	
	@NotBlank
	@NotNull
	@UniqueValue(domaiClass = Pais.class, fieldName = "nome", message = "Já  existe um país cadastrado com este nome")
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Pais converter() {
		return new Pais(nome);
	}
}
