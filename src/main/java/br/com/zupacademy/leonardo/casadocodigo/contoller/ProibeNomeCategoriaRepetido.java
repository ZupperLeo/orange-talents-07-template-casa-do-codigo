package br.com.zupacademy.leonardo.casadocodigo.contoller;

import br.com.zupacademy.leonardo.casadocodigo.dto.CategoriaDTO;
import br.com.zupacademy.leonardo.casadocodigo.model.Categoria;
import br.com.zupacademy.leonardo.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeNomeCategoriaRepetido implements Validator {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        CategoriaDTO categoriaDTO = (CategoriaDTO) target;
        Optional<Categoria> categoria = repository.findByNome(categoriaDTO.getNome());

        if(categoria.isPresent()) {
            errors.rejectValue("nome", null,
                    "Nome da categoria já existe " + categoriaDTO.getNome());
        }
    }
}
