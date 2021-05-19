package br.com.zup.casacodigo.config.validacao;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casacodigo.controller.form.AutorForm;
import br.com.zup.casacodigo.modelo.Autor;
import br.com.zup.casacodigo.repository.AutorRepository;

@Component
public class ProibeEmailDuplicadoValidator implements Validator{
	
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		AutorForm autorForm = (AutorForm) target;
		Optional<Autor> autor = autorRepository.findByEmail(autorForm.getEmail());
		
		if(autor.isPresent()) {
			errors.rejectValue("Email", null, "Já existe um autor(a) com este email" + autorForm.getEmail());
		}
	}

}
