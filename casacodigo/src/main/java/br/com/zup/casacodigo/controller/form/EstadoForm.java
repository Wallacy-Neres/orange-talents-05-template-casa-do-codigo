package br.com.zup.casacodigo.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casacodigo.config.validacao.ValidaSeTemIdValue;
import br.com.zup.casacodigo.modelo.Estado;
import br.com.zup.casacodigo.modelo.Pais;
import br.com.zup.casacodigo.repository.PaisRepository;

public class EstadoForm {
	
	@NotBlank
	private String nome;
	
	@NotNull
	@ValidaSeTemIdValue(domaiClass = Pais.class, message = "ID não pode ser nulo")
	private Long paisId;
	
	public Long getPaisId() {
		return paisId;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado converter(PaisRepository paisRepository) {
		Optional<Pais> pais = paisRepository.findById(paisId);
		return new Estado(nome, pais);
	}
	
	
}
