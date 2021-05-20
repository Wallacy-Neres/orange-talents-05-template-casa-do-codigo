
package br.com.zup.casacodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casacodigo.controller.form.LivroForm;
import br.com.zup.casacodigo.modelo.Livro;
import br.com.zup.casacodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@PostMapping
	public ResponseEntity<?> cadastrarLivro(@RequestBody @Valid LivroForm livroForm) {
		Livro livro = livroForm.converter();
		livroRepository.save(livro);
		return ResponseEntity.ok().body(livro);
	}
}
