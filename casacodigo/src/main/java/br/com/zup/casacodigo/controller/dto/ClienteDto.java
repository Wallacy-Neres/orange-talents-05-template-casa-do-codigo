package br.com.zup.casacodigo.controller.dto;


import br.com.zup.casacodigo.modelo.Cliente;


public class ClienteDto {
	private Long id;
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
	}

	public Long getId() {
		return id;
	}
	
}
