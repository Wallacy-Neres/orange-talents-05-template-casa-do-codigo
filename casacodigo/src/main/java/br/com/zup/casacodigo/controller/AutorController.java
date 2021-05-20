package br.com.zup.casacodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casacodigo.controller.form.AutorForm;
import br.com.zup.casacodigo.modelo.Autor;
import br.com.zup.casacodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	public ResponseEntity<AutorForm> cadastrar(@RequestBody @Valid AutorForm autorForm){
		Autor autor = autorForm.conveter(autorForm);
		autorRepository.save(autor);
		return ResponseEntity.ok().build();
	}
}
