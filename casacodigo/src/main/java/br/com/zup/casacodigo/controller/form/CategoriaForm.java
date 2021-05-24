package br.com.zup.casacodigo.controller.form;

import javax.validation.constraints.NotBlank;

import br.com.zup.casacodigo.config.validacao.UniqueValue;
import br.com.zup.casacodigo.modelo.Categoria;

public class CategoriaForm {
	
	@NotBlank
	@UniqueValue(domaiClass = Categoria.class, fieldName = "nome", message = "Já existe um categoria com este nome")
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
