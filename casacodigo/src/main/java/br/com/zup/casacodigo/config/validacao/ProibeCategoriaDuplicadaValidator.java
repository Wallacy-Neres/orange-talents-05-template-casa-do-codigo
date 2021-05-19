package br.com.zup.casacodigo.config.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casacodigo.controller.form.CategoriaForm;
import br.com.zup.casacodigo.modelo.Categoria;
import br.com.zup.casacodigo.repository.CategoriaRepository;

@Component
public class ProibeCategoriaDuplicadaValidator implements Validator{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		CategoriaForm categoriaForm = (CategoriaForm) target;
		Optional<Categoria> categoria = categoriaRepository.findByNome(categoriaForm.getNome());
		if(categoria.isPresent()) {
			errors.rejectValue("Nome", null, "Já existe uma categoria com este nome " + categoriaForm.getNome());
		}
	}
}
