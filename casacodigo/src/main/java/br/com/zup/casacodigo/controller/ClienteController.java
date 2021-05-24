package br.com.zup.casacodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casacodigo.controller.dto.ClienteDto;
import br.com.zup.casacodigo.controller.form.ClienteForm;
import br.com.zup.casacodigo.modelo.Cliente;
import br.com.zup.casacodigo.repository.EstadoRepository;
import br.com.zup.casacodigo.repository.PaisRepository;
import br.com.zup.casacodigo.repository.ClienteRepository;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private EstadoRepository estadoRespository;
	
	@PostMapping
	public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody @Valid ClienteForm clienteForm){
		Cliente cliente = clienteForm.converter(paisRepository, estadoRespository);
		clienteRepository.save(cliente);
		ClienteDto dto = new ClienteDto(cliente);
		return ResponseEntity.ok(dto);
	}
}
