package br.com.zup.casacodigo.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zup.casacodigo.modelo.Categoria;

public class CategoriaForm {
	
	@NotBlank
	@NotEmpty
	@NotNull
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria converter() {
		return new Categoria(nome);
	}
	
}
