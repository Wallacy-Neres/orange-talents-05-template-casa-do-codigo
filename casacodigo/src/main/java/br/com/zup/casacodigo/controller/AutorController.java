package br.com.zup.casacodigo.controller;

<<<<<<< HEAD
=======
import java.net.URI;

>>>>>>> ceaff7cbb20a629e35fef03fb596991c7821ccc6
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
=======
>>>>>>> ceaff7cbb20a629e35fef03fb596991c7821ccc6
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< HEAD

import br.com.zup.casacodigo.config.validacao.ProibeEmeailDuplicadoValidator;
=======
import org.springframework.web.util.UriComponentsBuilder;

>>>>>>> ceaff7cbb20a629e35fef03fb596991c7821ccc6
import br.com.zup.casacodigo.controller.dto.AutorDto;
import br.com.zup.casacodigo.controller.form.AutorForm;
import br.com.zup.casacodigo.modelo.Autor;
import br.com.zup.casacodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
<<<<<<< HEAD
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
=======
	@PostMapping
	public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriBuilder){
		Autor autor = autorForm.conveter(autorForm);
		autorRepository.save(autor);
		URI uri = uriBuilder.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).body(new AutorDto(autor));
>>>>>>> ceaff7cbb20a629e35fef03fb596991c7821ccc6
	}
}
