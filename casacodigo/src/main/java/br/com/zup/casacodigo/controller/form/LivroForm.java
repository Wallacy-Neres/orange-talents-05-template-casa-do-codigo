package br.com.zup.casacodigo.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import org.hibernate.validator.constraints.ISBN.Type;

import br.com.zup.casacodigo.config.validacao.UniqueValue;
import br.com.zup.casacodigo.config.validacao.ValidaSeTemIdValue;
import br.com.zup.casacodigo.modelo.Autor;
import br.com.zup.casacodigo.modelo.Categoria;
import br.com.zup.casacodigo.modelo.Livro;

public class LivroForm {
	
	@NotBlank
	@UniqueValue(domaiClass = Livro.class, fieldName = "titulo", message = "Já existe um livro com este titulo")
	private String titulo;
	
	@NotBlank
	@Length(max = 500)
	private String resumo;
	
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
	@Future @JsonFormat(pattern="dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	
	@NotNull
	@ValidaSeTemIdValue(domaiClass = Categoria.class, message = "ID não pode ser nulo")
	private Long categoriaId;
	
	@NotNull
	@ValidaSeTemIdValue(domaiClass = Autor.class, message = "ID não pode ser nulo")
	private Long autorId;
	
	public LivroForm(String titulo, String resumo, BigDecimal preco, Integer paginas, 
			String isbn, Long autor, Long categoria) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.autorId = autor;
		this.categoriaId = categoria;
	}
	
	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}


	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}


	public Long getAutorId() {
		return autorId;
	}


	public void setAutorId(Long autorId) {
		this.autorId = autorId;
	}


	public Livro converter(EntityManager entityManager) {
		Autor autor = entityManager.find(Autor.class, autorId);
		Categoria categoria = entityManager.find(Categoria.class, categoriaId);
		return new Livro(titulo, resumo, preco, paginas, isbn, dataPublicacao, autor, categoria);
	}
	
}
