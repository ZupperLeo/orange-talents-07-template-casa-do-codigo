package br.com.zupacademy.leonardo.casadocodigo.contoller;

import br.com.zupacademy.leonardo.casadocodigo.dto.AutorDTO;
import br.com.zupacademy.leonardo.casadocodigo.model.Autor;
import br.com.zupacademy.leonardo.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Autor> cadastrar(@RequestBody @Valid AutorDTO autorDTO) {

        Autor autor = autorDTO.converte();
        repository.save(autor);

        return ResponseEntity.ok().build();
    }
}
