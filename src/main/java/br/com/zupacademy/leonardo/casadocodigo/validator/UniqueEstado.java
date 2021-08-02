package br.com.zupacademy.leonardo.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEstadoValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEstado {

    String message() default "Esse estado já foi cadastrado nesse país";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
