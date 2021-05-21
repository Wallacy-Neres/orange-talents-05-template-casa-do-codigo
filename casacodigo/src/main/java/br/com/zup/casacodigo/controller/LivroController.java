
package br.com.zup.casacodigo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casacodigo.controller.dto.LivroDetalhadoDto;
import br.com.zup.casacodigo.controller.dto.LivroDto;
import br.com.zup.casacodigo.controller.form.LivroForm;
import br.com.zup.casacodigo.modelo.Livro;
import br.com.zup.casacodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	public ResponseEntity<LivroForm> cadastrarLivro(@RequestBody @Valid LivroForm livroForm) {
		Livro livro = livroForm.converter(entityManager);
		livroRepository.save(livro);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<LivroDto>> listarLivros(){
		List<Livro> livros = livroRepository.findAll();
		return ResponseEntity.ok(LivroDto.converter(livros));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarLivroPorId(@PathVariable Long id){
		Livro livroEncontrado = manager.find(Livro.class, id);
		if(livroEncontrado == null) {
			return ResponseEntity.notFound().build();
		}
		LivroDetalhadoDto livroDetalhadoDto = new LivroDetalhadoDto(livroEncontrado);
		return ResponseEntity.ok(livroDetalhadoDto);
	}
}
