package br.com.zupacademy.leonardo.casadocodigo.contoller;

import br.com.zupacademy.leonardo.casadocodigo.dto.AutorDTO;
import br.com.zupacademy.leonardo.casadocodigo.model.Autor;
import br.com.zupacademy.leonardo.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibiEmailDuplicadoAutorValidator implements Validator {

    @Autowired
    private AutorRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        AutorDTO autorDTO = (AutorDTO) target;
        Optional<Autor> autor =  repository.findByEmail(autorDTO.getEmail());

        if(autor.isPresent()) {
            errors.rejectValue("email", null,
    "O e-mail já está sendo utilizado por outra pessoa" + autorDTO.getEmail());
        }
    }
}
