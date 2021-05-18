package br.com.zup.casacodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casacodigo.config.validacao.ProibeEmeailDuplicadoValidator;
import br.com.zup.casacodigo.controller.dto.AutorDto;
import br.com.zup.casacodigo.controller.form.AutorForm;
import br.com.zup.casacodigo.modelo.Autor;
import br.com.zup.casacodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private ProibeEmeailDuplicadoValidator proibeEmeailDuplicadoValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeEmeailDuplicadoValidator);
	}
	
	@PostMapping
	public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm autorForm){
		Autor autor = autorForm.conveter(autorForm);
		autorRepository.save(autor);
		return ResponseEntity.ok().build();
	}
}
