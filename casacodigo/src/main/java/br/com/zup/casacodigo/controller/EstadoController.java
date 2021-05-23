package br.com.zup.casacodigo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casacodigo.controller.form.EstadoForm;
import br.com.zup.casacodigo.modelo.Estado;
import br.com.zup.casacodigo.repository.EstadoRepository;
import br.com.zup.casacodigo.repository.PaisRepository;

@RestController
@RequestMapping("estado")
public class EstadoController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@PostMapping
	public ResponseEntity<EstadoForm> cadastrarEstado(@RequestBody @Valid EstadoForm estadoForm){
		String nome = estadoForm.getNome();
		Long idPais = estadoForm.getPaisId();
		Optional<Estado> verificaEstado = estadoRepository.findEstadoBanco(nome, idPais);
		Estado novoEstado = estadoForm.converter(paisRepository);
		
		if(!verificaEstado.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
			estadoRepository.save(novoEstado);
			return ResponseEntity.ok().build();
		}
}
