package br.com.zup.casacodigo.controller.dto;

import br.com.zup.casacodigo.modelo.Autor;

public class AutorDetalhadoDto {
	
	private String nome;
	private String descricao;
	
	public AutorDetalhadoDto(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
