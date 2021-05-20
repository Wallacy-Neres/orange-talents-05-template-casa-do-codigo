package br.com.zup.casacodigo.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;


import org.hibernate.validator.constraints.ISBN.Type;

import br.com.zup.casacodigo.config.validacao.UniqueValue;
import br.com.zup.casacodigo.config.validacao.ValidaSeTemIdValue;
import br.com.zup.casacodigo.modelo.Autor;
import br.com.zup.casacodigo.modelo.Categoria;
import br.com.zup.casacodigo.modelo.Livro;

public class LivroForm {
	
	@NotBlank
	@NotNull
	@UniqueValue(domaiClass = Livro.class, fieldName = "titulo", message = "Já existe um livro com este titulo")
	private String titulo;
	
	@NotBlank
	@NotNull
	@Length(max = 500)
	private String resumo;
	
	@Lob
	private String sumario;
	
	@NotNull
	@Min(20)
	private BigDecimal preco;
	
	@NotNull
	@Min(100)
	private Integer paginas;
	
	@NotBlank
	@NotNull
	@UniqueValue(domaiClass = Livro.class, fieldName = "isbn", message = "Já existe um livro com este isbn")
	@ISBN(type = Type.ANY)
	private String isbn;
	
	@Future
	private LocalDate dataPublicacao;
	
	@NotNull
	@ManyToOne
	@ValidaSeTemIdValue(domaiClass = Categoria.class)
	private Categoria categoria;
	
	@NotNull
	@ManyToOne
	@ValidaSeTemIdValue(domaiClass = Autor.class)
	private Autor autor;
	
	public LivroForm(String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas, 
			String isbn, LocalDate dataPublicacao, Autor autor, Categoria categoria) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.categoria = categoria;
	}
	
	
	
	public Livro converter() {
		return new Livro(titulo, resumo, sumario, preco, paginas, isbn, dataPublicacao, autor, categoria);
	}
	
}
