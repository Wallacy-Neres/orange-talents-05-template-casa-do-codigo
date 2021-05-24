package br.com.zup.casacodigo.controller.form;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.zup.casacodigo.config.validacao.UniqueValue;
import br.com.zup.casacodigo.config.validacao.ValidaCPFouCNPJValue.CPFOrCNPJ;
import br.com.zup.casacodigo.config.validacao.ValidaSeTemIdValue;
import br.com.zup.casacodigo.modelo.Cliente;
import br.com.zup.casacodigo.modelo.Estado;
import br.com.zup.casacodigo.modelo.Pais;
import br.com.zup.casacodigo.repository.EstadoRepository;
import br.com.zup.casacodigo.repository.PaisRepository;

public class ClienteForm {
	
	@Email
	@NotBlank
	@UniqueValue(domaiClass = Cliente.class, fieldName = "email", message = "Já existe um cliente cadastrado com este email!")
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@NotBlank
	@CPFOrCNPJ
	@UniqueValue(domaiClass = Cliente.class, fieldName = "documento", message = "Já existe um cliente cadastrado com este documento")
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cep;
	
	@ValidaSeTemIdValue(domaiClass = Pais.class, message = "ID não pode ser nulo")
	private Long paisId;
	
	private Long estadoId;
	
	public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		Optional<Long> possivelEstadoId = Optional.ofNullable(estadoId);
		Estado estado = null;
		Pais pais = paisRepository.findById(paisId).get();
		if(possivelEstadoId.isPresent()) {
			estado = estadoRepository.findById(estadoId).get();
		}
		
		return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, telefone,cep, pais, estado);
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public Long getPaisId() {
		return paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}
	
}
