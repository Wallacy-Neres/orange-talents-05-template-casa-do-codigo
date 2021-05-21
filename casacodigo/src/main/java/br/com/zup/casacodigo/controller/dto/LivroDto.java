package br.com.zup.casacodigo.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.casacodigo.modelo.Livro;

public class LivroDto {
	
	private Long id;
	private String titulo;
	
	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public static List<LivroDto> converter(List<Livro> livros) {
		return livros.stream().map(LivroDto::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

}
