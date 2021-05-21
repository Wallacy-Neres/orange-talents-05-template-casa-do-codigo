package br.com.zup.casacodigo.controller.dto;

import java.math.BigDecimal;

import br.com.zup.casacodigo.modelo.Livro;

public class LivroDetalhadoDto {
	
	private String titulo;
	private String isbn;
	private Integer paginas;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	private AutorDetalhadoDto autor;
	
	
	public LivroDetalhadoDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.isbn = livro.getIsbn();
		this.paginas = livro.getPaginas();
		this.preco = livro.getPreco();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.autor = new AutorDetalhadoDto(livro.getAutor());
	}


	public String getTitulo() {
		return titulo;
	}


	public String getIsbn() {
		return isbn;
	}


	public Integer getPaginas() {
		return paginas;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public String getResumo() {
		return resumo;
	}


	public String getSumario() {
		return sumario;
	}


	public AutorDetalhadoDto getAutor() {
		return autor;
	}

	
}
