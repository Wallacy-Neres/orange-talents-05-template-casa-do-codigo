package br.com.zup.casacodigo.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.ISBN.Type;

import org.hibernate.validator.constraints.Length;



@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@NotNull
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
	@ISBN(type = Type.ANY)
	private String isbn;
	
	@Future
	private LocalDate dataPublicacao;
	
	@NotNull
	@ManyToOne
	private Categoria categoria;
	
	@NotNull
	@ManyToOne
	private Autor autor;
	
	public Livro() {
		
	}
	
	public Livro(String titulo, String resumo, BigDecimal preco, Integer paginas, 
			String isbn, LocalDate dataPublicacao, Autor autor, Categoria categoria) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.categoria = categoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}
	
	
	
}
