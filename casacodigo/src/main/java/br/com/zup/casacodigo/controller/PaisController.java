package br.com.zup.casacodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casacodigo.controller.form.PaisForm;
import br.com.zup.casacodigo.modelo.Pais;
import br.com.zup.casacodigo.repository.PaisRepository;

@RestController
@RequestMapping("pais")
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	public ResponseEntity<?> cadastrarPais(@RequestBody @Valid PaisForm paisForm){
		Pais pais = paisForm.converter();
		paisRepository.save(pais);
		return ResponseEntity.ok().build();
	}
}
