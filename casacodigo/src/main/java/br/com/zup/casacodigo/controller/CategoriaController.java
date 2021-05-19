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

import br.com.zup.casacodigo.config.validacao.ProibeCategoriaDuplicadaValidator;
import br.com.zup.casacodigo.controller.form.CategoriaForm;
import br.com.zup.casacodigo.modelo.Categoria;
import br.com.zup.casacodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProibeCategoriaDuplicadaValidator proibeCategoriaDuplicada;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeCategoriaDuplicada);
	}
	
	@PostMapping
	public ResponseEntity<CategoriaForm> cadastrarCategoria(@RequestBody @Valid CategoriaForm categoriaForm){
		Categoria categoria = categoriaForm.converter();
		categoriaRepository.save(categoria);
		return ResponseEntity.ok().build();
	}
}
