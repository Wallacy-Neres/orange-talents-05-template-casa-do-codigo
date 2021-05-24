package br.com.zup.casacodigo.config.validacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = ValidaPaisEstadoValidator.class)
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidaPaisEstadoValue {
	
	String message() default "Mensagem de erro";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
}
