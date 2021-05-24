package br.com.zup.casacodigo.config.validacao;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import br.com.zup.casacodigo.controller.form.ClienteForm;
import br.com.zup.casacodigo.modelo.Estado;
import br.com.zup.casacodigo.repository.EstadoRepository;

@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class ValidaPaisEstadoValidator implements ConstraintValidator<ValidaPaisEstadoValue, ClienteForm>{

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Override
	public boolean isValid(ClienteForm value, ConstraintValidatorContext context) {
		Optional<Estado> talvezPaisTemEstado = estadoRepository.findByPaisId(value.getPaisId());
        Optional<Long> talvezEstadoid = Optional.ofNullable(value.getEstadoId());
        if (talvezPaisTemEstado.isPresent()) {
            if (talvezEstadoid.isPresent()) {
                Optional<Estado> talvezEstadoNoPais = estadoRepository.findByIdAndPaisId(value.getEstadoId(), value.getPaisId());
                return talvezEstadoNoPais.isPresent();
            }
            return false;
        }
        return talvezEstadoid.isEmpty();
	}
}
